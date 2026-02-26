package vista;

import dao.RepartidorDAO;
import modelo.Repartidor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaRepartidores extends JFrame {

    private JTextField txtNombre;
    private JButton btnGuardar, btnEliminar, btnActualizar;
    private JTable tabla;
    private DefaultTableModel modelo;
    private RepartidorDAO dao;

    public VentanaRepartidores() {

        dao = new RepartidorDAO();

        setTitle("Gestión de Repartidores");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 20, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 200, 25);
        add(txtNombre);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(320, 20, 100, 25);
        add(btnGuardar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(320, 60, 100, 25);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(320, 100, 100, 25);
        add(btnEliminar);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 140, 420, 200);
        add(scroll);

        cargarTabla();

        // Cuando selecciona fila → cargar datos al txt
        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                txtNombre.setText(modelo.getValueAt(fila, 1).toString());
            }
        });

        // GUARDAR
        btnGuardar.addActionListener(e -> {

            if (txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                return;
            }

            Repartidor r = new Repartidor(txtNombre.getText());
            dao.guardar(r);

            JOptionPane.showMessageDialog(this, "Repartidor guardado");
            txtNombre.setText("");
            cargarTabla();
        });

        // ACTUALIZAR
        btnActualizar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un repartidor");
                return;
            }

            if (txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                return;
            }

            int id = (int) modelo.getValueAt(fila, 0);

            Repartidor r = new Repartidor(id, txtNombre.getText());
            dao.actualizar(r);

            JOptionPane.showMessageDialog(this, "Repartidor actualizado");
            txtNombre.setText("");
            cargarTabla();
        });

        // ELIMINAR
        btnEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un repartidor");
                return;
            }

            int id = (int) modelo.getValueAt(fila, 0);
            dao.eliminar(id);

            JOptionPane.showMessageDialog(this, "Repartidor eliminado");
            txtNombre.setText("");
            cargarTabla();
        });
    }

    private void cargarTabla() {

        modelo.setRowCount(0);

        List<Repartidor> lista = dao.listarTodos();

        for (Repartidor r : lista) {
            modelo.addRow(new Object[]{
                    r.getId(),
                    r.getNombre()
            });
        }
    }
}