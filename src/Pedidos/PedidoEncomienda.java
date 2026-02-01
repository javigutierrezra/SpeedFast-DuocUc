public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int id, String direccion, double distancia) {
        super(id, direccion, distancia);
    }

    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm * 3;
    }
}