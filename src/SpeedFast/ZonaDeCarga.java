package speedfast;

import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {

    private Queue<Pedido> pedidos;

    public ZonaDeCarga() {
        pedidos = new LinkedList<>();
    }

    public synchronized void agregarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println("📦 Pedido agregado a zona de carga: " + p.getId());
    }

    public synchronized Pedido retirarPedido() {
        if (pedidos.isEmpty()) {
            return null;
        }
        return pedidos.poll();
    }
}