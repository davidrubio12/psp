package ejercicio_restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        // Crear cocineros
        Cocinero cocineroPizza = new Cocinero(restaurante, "pizza");
        Cocinero cocineroHamburguesa = new Cocinero(restaurante, "hamburguesa");

        // Crear repartidores
        Repartidor repartidorPizza = new Repartidor(restaurante, "Repartidor1", "pizza");
        Repartidor repartidorHamburguesa = new Repartidor(restaurante, "Repartidor2", "hamburguesa");
        Repartidor repartidorMix1 = new Repartidor(restaurante, "Repartidor3", "cualquiera");
        Repartidor repartidorMix2 = new Repartidor(restaurante, "Repartidor4", "cualquiera");

        // Iniciar hilos
        cocineroPizza.start();
        cocineroHamburguesa.start();
        repartidorPizza.start();
        repartidorHamburguesa.start();
        repartidorMix1.start();
        repartidorMix2.start();

        // Esperar a que los repartidores terminen
        try {
            repartidorPizza.join();
            repartidorHamburguesa.join();
            repartidorMix1.join();
            repartidorMix2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Parar los cocineros
        restaurante.pararCocineros();
        cocineroPizza.interrupt();
        cocineroHamburguesa.interrupt();

        // Mostrar totales
        restaurante.totalCocinadas();
        restaurante.totalRepartor();
    }
}

