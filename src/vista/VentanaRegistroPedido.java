package vista;

import controlador.ControladorPedidos;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> comboTipo;

    public VentanaRegistroPedido(ControladorPedidos controlador) {

        setTitle("Registrar Pedido");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});
        add(comboTipo);

        JButton btnGuardar = new JButton("Guardar");
        add(new JLabel());
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {

            String id = txtId.getText();
            String direccion = txtDireccion.getText();
            String tipo = comboTipo.getSelectedItem().toString();

            if (id.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Todos los campos son obligatorios",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                Pedido pedido = new Pedido(id, direccion, tipo);
                controlador.agregarPedido(pedido);

                JOptionPane.showMessageDialog(this,
                        "Pedido registrado correctamente");

                dispose();
            }
        });

        setVisible(true);
    }
}