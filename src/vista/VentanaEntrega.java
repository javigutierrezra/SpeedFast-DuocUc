package vista;

import dao.EntregaDAO;
import dao.PedidoDAO;
import dao.RepartidorDAO;
import modelo.Entrega;
import modelo.Pedido;
import modelo.Repartidor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VentanaEntrega extends JFrame {

    private JComboBox<String> comboPedido;
    private JComboBox<String> comboRepartidor;
    private JButton btnGuardar, btnEliminar;
    private JTable tabla;
    private DefaultTableModel modelo;

    private EntregaDAO entregaDAO;
    private PedidoDAO pedidoDAO;
    private RepartidorDAO repartidorDAO;

    public VentanaEntrega() {

        entregaDAO = new EntregaDAO();
        pedidoDAO = new PedidoDAO();
        repartidorDAO = new RepartidorDAO();

        setTitle("Gestión de Entregas");
        setSize(650, 450);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblPedido = new JLabel("Pedido:");
        lblPedido.setBounds(30, 20, 100, 25);
        add(lblPedido);

        comboPedido = new JComboBox<>();
        comboPedido.setBounds(100, 20, 250, 25);
        add(comboPedido);

        JLabel lblRepartidor = new JLabel("Repartidor:");
        lblRepartidor.setBounds(30, 60, 100, 25);
        add(lblRepartidor);

        comboRepartidor = new JComboBox<>();
        comboRepartidor.setBounds(100, 60, 250, 25);
        add(comboRepartidor);

        btnGuardar = new JButton("Registrar Entrega");
        btnGuardar.setBounds(400, 20, 200, 30);
        add(btnGuardar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(400, 60, 200, 30);
        add(btnEliminar);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Pedido");
        modelo.addColumn("Repartidor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 120, 580, 250);
        add(scroll);

        cargarCombos();
        cargarTabla();

        btnGuardar.addActionListener(e -> {

            if (comboPedido.getSelectedIndex() == -1 ||
                    comboRepartidor.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione pedido y repartidor");
                return;
            }

            int idPedido = Integer.parseInt(comboPedido.getSelectedItem().toString().split(" - ")[0]);
            int idRepartidor = Integer.parseInt(comboRepartidor.getSelectedItem().toString().split(" - ")[0]);

            Date fecha = Date.valueOf(LocalDate.now());
            Time hora = Time.valueOf(LocalTime.now());

            Entrega entrega = new Entrega(idPedido, idRepartidor, fecha, hora);
            entregaDAO.guardar(entrega);

            JOptionPane.showMessageDialog(this, "Entrega registrada");
            cargarTabla();
        });

        btnEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una entrega");
                return;
            }

            int id = (int) modelo.getValueAt(fila, 0);
            entregaDAO.eliminar(id);

            JOptionPane.showMessageDialog(this, "Entrega eliminada");
            cargarTabla();
        });
    }

    private void cargarCombos() {

        comboPedido.removeAllItems();
        comboRepartidor.removeAllItems();

        List<Pedido> pedidos = pedidoDAO.listarTodos();
        for (Pedido p : pedidos) {
            comboPedido.addItem(p.getId() + " - " + p.getDireccion());
        }

        List<Repartidor> repartidores = repartidorDAO.listarTodos();
        for (Repartidor r : repartidores) {
            comboRepartidor.addItem(r.getId() + " - " + r.getNombre());
        }
    }

    private void cargarTabla() {

        modelo.setRowCount(0);

        List<Entrega> lista = entregaDAO.listarTodas();

        for (Entrega e : lista) {
            modelo.addRow(new Object[]{
                    e.getId(),
                    e.getIdPedido(),
                    e.getIdRepartidor(),
                    e.getFecha(),
                    e.getHora()
            });
        }
    }
}