package speedfast;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("🚴 " + nombre +
                    " retiró pedido #" + pedido.getId() +
                    " | Estado: " + pedido.getEstado());

            try {
                Thread.sleep(2000); // simula entrega
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("✅ " + nombre +
                    " entregó pedido #" + pedido.getId() +
                    " | Estado: " + pedido.getEstado());
        }
    }
}