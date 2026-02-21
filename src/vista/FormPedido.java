package vista;

import dao.PedidoDAO;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class FormPedido extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> comboTipo;
    private JComboBox<String> comboEstado;
    private JButton btnGuardar;
    private JButton btnLimpiar;

    public FormPedido() {

        setTitle("Registro de Pedido - SpeedFast");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Dirección
        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        // Tipo
        add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"COMIDA", "ENCOMIENDA", "EXPRESS"});
        add(comboTipo);

        // Estado
        add(new JLabel("Estado:"));
        comboEstado = new JComboBox<>(new String[]{"PENDIENTE", "EN_REPARTO", "ENTREGADO"});
        add(comboEstado);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");

        add(btnGuardar);
        add(btnLimpiar);

        // Evento botón guardar
        btnGuardar.addActionListener(e -> guardarPedido());

        // Evento botón limpiar
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void guardarPedido() {

        String direccion = txtDireccion.getText().trim();

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La dirección no puede estar vacía");
            return;
        }

        String tipo = comboTipo.getSelectedItem().toString();
        String estado = comboEstado.getSelectedItem().toString();

        Pedido pedido = new Pedido(direccion, tipo, estado);
        PedidoDAO dao = new PedidoDAO();
        dao.guardar(pedido);

        JOptionPane.showMessageDialog(this, "Pedido registrado correctamente");

        limpiarCampos();
    }

    private void limpiarCampos() {
        txtDireccion.setText("");
        comboTipo.setSelectedIndex(0);
        comboEstado.setSelectedIndex(0);
    }
}