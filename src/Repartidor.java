import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidos;
    private Random random = new Random();

    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        System.out.println("🚴 Repartidor " + nombre + " inicia su ruta...");

        for (Pedido pedido : pedidos) {
            System.out.println("📦 " + nombre + " entregando pedido #" + pedido.idPedido);
            pedido.mostrarResumen();
            pedido.rastrear();

            try {
                int tiempo = random.nextInt(3000) + 2000;
                System.out.println("⏳ " + nombre + " tardará " + tiempo / 1000 + " segundos...");
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                System.out.println("❌ " + nombre + " fue interrumpido.");
            }

            System.out.println("✅ " + nombre + " entregó pedido #" + pedido.idPedido);
            System.out.println("----------------------------------");
        }

        System.out.println("🏁 Repartidor " + nombre + " terminó su ruta.");
    }
}