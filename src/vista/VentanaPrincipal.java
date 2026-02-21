package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JButton btnNuevoPedido;

    public VentanaPrincipal() {

        setTitle("SpeedFast - Menú Principal");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnNuevoPedido = new JButton("Registrar Pedido");
        btnNuevoPedido.setBounds(60, 50, 180, 40);
        add(btnNuevoPedido);

        btnNuevoPedido.addActionListener(e -> {
            FormPedido form = new FormPedido();
            form.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }
}