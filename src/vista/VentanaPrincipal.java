package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JButton btnRepartidores;
    private JButton btnPedidos;
    private JButton btnEntregas;

    public VentanaPrincipal() {

        setTitle("SpeedFast - Menú Principal");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnRepartidores = new JButton("Gestionar Repartidores");
        btnRepartidores.setBounds(80, 50, 220, 40);
        add(btnRepartidores);

        btnPedidos = new JButton("Gestionar Pedidos");
        btnPedidos.setBounds(80, 110, 220, 40);
        add(btnPedidos);

        btnEntregas = new JButton("Gestionar Entregas");
        btnEntregas.setBounds(80, 170, 220, 40);
        add(btnEntregas);

        // Abrir Repartidores
        btnRepartidores.addActionListener(e -> {
            new VentanaRepartidores().setVisible(true);
        });

        // Abrir Pedidos
        btnPedidos.addActionListener(e -> {
            new VentanaPedidos().setVisible(true);
        });

        // Abrir Entregas
        btnEntregas.addActionListener(e -> {
            new VentanaEntrega().setVisible(true);
        });
    }

    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }
}