package vista;

import controlador.ControladorPedidos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private ControladorPedidos controlador;

    public VentanaPrincipal() {

        // Inicializamos el controlador (lista en memoria compartida)
        controlador = new ControladorPedidos();

        // Configuración básica de la ventana
        setTitle("SpeedFast - Sistema de Gestión");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(3, 1, 10, 10));

        // Botones
        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        // Agregar botones a la ventana
        add(btnRegistrar);
        add(btnListar);
        add(btnAsignar);

        // Acción botón Registrar
        btnRegistrar.addActionListener(e ->
                new VentanaRegistroPedido(controlador)
        );

        // Acción botón Listar
        btnListar.addActionListener(e ->
                new VentanaListaPedidos(controlador)
        );

        // Acción botón Asignar / Iniciar entrega
        btnAsignar.addActionListener(e ->
                new VentanaAsignarRepartidor(controlador)
        );

        setVisible(true);
    }
}