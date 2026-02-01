public class PedidoExpress extends Pedido {

    public PedidoExpress(int id, String direccion, double distancia) {
        super(id, direccion, distancia);
    }

    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm * 1.5;
    }
}