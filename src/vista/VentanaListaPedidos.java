package vista;

import controlador.ControladorPedidos;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {

    private DefaultTableModel modeloTabla;

    public VentanaListaPedidos(ControladorPedidos controlador) {

        setTitle("Lista de Pedidos");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");

        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);

        cargarPedidos(controlador);

        setVisible(true);
    }

    private void cargarPedidos(ControladorPedidos controlador) {

        modeloTabla.setRowCount(0);

        for (Pedido p : controlador.getListaPedidos()) {
            modeloTabla.addRow(new Object[]{
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado()
            });
        }
    }
}