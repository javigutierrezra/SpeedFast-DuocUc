package vista;

import dao.PedidoDAO;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaPedidos extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> comboTipo;
    private JComboBox<String> comboEstado;
    private JButton btnGuardar, btnActualizar, btnEliminar;
    private JTable tabla;
    private DefaultTableModel modelo;
    private PedidoDAO dao;

    public VentanaPedidos() {

        dao = new PedidoDAO();

        setTitle("Gestión de Pedidos");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(null);

        // Dirección
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 20, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 20, 200, 25);
        add(txtDireccion);

        // Tipo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 60, 100, 25);
        add(lblTipo);

        comboTipo = new JComboBox<>();
        comboTipo.addItem("COMIDA");
        comboTipo.addItem("ENCOMIENDA");
        comboTipo.addItem("EXPRESS");
        comboTipo.setBounds(100, 60, 200, 25);
        add(comboTipo);

        // Estado
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 100, 100, 25);
        add(lblEstado);

        comboEstado = new JComboBox<>();
        comboEstado.addItem("PENDIENTE");
        comboEstado.addItem("EN_REPARTO");
        comboEstado.addItem("ENTREGADO");
        comboEstado.setBounds(100, 100, 200, 25);
        add(comboEstado);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(350, 20, 120, 30);
        add(btnGuardar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(350, 60, 120, 30);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(350, 100, 120, 30);
        add(btnEliminar);

        // Tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Dirección");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 160, 520, 220);
        add(scroll);

        cargarTabla();

        // Cuando selecciona fila
        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                txtDireccion.setText(modelo.getValueAt(fila, 1).toString());
                comboTipo.setSelectedItem(modelo.getValueAt(fila, 2).toString());
                comboEstado.setSelectedItem(modelo.getValueAt(fila, 3).toString());
            }
        });

        // GUARDAR
        btnGuardar.addActionListener(e -> {

            if (txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese dirección");
                return;
            }

            Pedido p = new Pedido(
                    txtDireccion.getText(),
                    comboTipo.getSelectedItem().toString(),
                    comboEstado.getSelectedItem().toString()
            );

            dao.guardar(p);

            JOptionPane.showMessageDialog(this, "Pedido guardado");
            limpiarCampos();
            cargarTabla();
        });

        // ACTUALIZAR
        btnActualizar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un pedido");
                return;
            }

            int id = (int) modelo.getValueAt(fila, 0);

            Pedido p = new Pedido(
                    id,
                    txtDireccion.getText(),
                    comboTipo.getSelectedItem().toString(),
                    comboEstado.getSelectedItem().toString()
            );

            dao.actualizar(p);

            JOptionPane.showMessageDialog(this, "Pedido actualizado");
            limpiarCampos();
            cargarTabla();
        });

        // ELIMINAR
        btnEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un pedido");
                return;
            }

            int id = (int) modelo.getValueAt(fila, 0);

            dao.eliminar(id);

            JOptionPane.showMessageDialog(this, "Pedido eliminado");
            limpiarCampos();
            cargarTabla();
        });
    }

    private void cargarTabla() {

        modelo.setRowCount(0);

        List<Pedido> lista = dao.listarTodos();

        for (Pedido p : lista) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado()
            });
        }
    }

    private void limpiarCampos() {
        txtDireccion.setText("");
        comboTipo.setSelectedIndex(0);
        comboEstado.setSelectedIndex(0);
    }
}