package speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Agregar pedidos
        zonaDeCarga.agregarPedido(new Pedido(1, "Calle A"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Calle B"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Calle C"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Calle D"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Calle E"));

        // Crear repartidores
        Repartidor r1 = new Repartidor("Juan", zonaDeCarga);
        Repartidor r2 = new Repartidor("Ana", zonaDeCarga);
        Repartidor r3 = new Repartidor("Pedro", zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();

        while (!executor.isTerminated()) {
            // espera
        }

        System.out.println("\n🎉 Todos los pedidos han sido entregados correctamente");
    }
}