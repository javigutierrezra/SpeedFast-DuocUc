public class PedidoComida extends Pedido {

    public PedidoComida(int id, String direccion, double distancia) {
        super(id, direccion, distancia);
    }

    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm * 2; // más rápido
    }
}