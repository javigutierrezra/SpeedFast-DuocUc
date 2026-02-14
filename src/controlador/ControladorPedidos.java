package controlador;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ControladorPedidos {

    private List<Pedido> listaPedidos;

    public ControladorPedidos() {
        listaPedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}