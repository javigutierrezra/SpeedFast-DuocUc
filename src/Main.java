import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        List<Pedido> pedidos1 = Arrays.asList(
                new PedidoComida(1, "Calle 10", 2.5),
                new PedidoExpress(2, "Avenida 5", 1.2)
        );

        List<Pedido> pedidos2 = Arrays.asList(
                new PedidoEncomienda(3, "Carrera 8", 4.0),
                new PedidoComida(4, "Calle 20", 3.1)
        );

        List<Pedido> pedidos3 = Arrays.asList(
                new PedidoExpress(5, "Zona Centro", 0.8),
                new PedidoEncomienda(6, "Barrio Norte", 5.5)
        );

        Repartidor r1 = new Repartidor("Carlos", pedidos1);
        Repartidor r2 = new Repartidor("Ana", pedidos2);
        Repartidor r3 = new Repartidor("Luis", pedidos3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();
    }
}