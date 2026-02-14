package vista;

import controlador.ControladorPedidos;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class VentanaAsignarRepartidor extends JFrame {

    public VentanaAsignarRepartidor(ControladorPedidos controlador) {

        setTitle("Asignar Repartidor");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String id = JOptionPane.showInputDialog(this,
                "Ingrese ID del pedido a iniciar:");

        if (id != null) {

            boolean encontrado = false;

            for (Pedido p : controlador.getListaPedidos()) {
                if (p.getId().equals(id)) {
                    p.setEstado("En camino");
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(this,
                        "Entrega iniciada correctamente");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Pedido no encontrado",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        dispose();
    }
}