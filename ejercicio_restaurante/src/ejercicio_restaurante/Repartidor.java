package ejercicio_restaurante;

public class Repartidor extends Thread {

	private Restaurante restaurante;
	private String nombre;
	private String tipo;
	private int contPizzas;
	private int contHamburguesas;
	private int totalRepartidas;
	public Repartidor(Restaurante restaurante, String nombre, String tipo) {
		super();
		this.restaurante = restaurante;
		this.nombre = nombre;
		this.tipo = tipo;
		this.contPizzas = 0;
		this.contHamburguesas = 0;
		this.setTotalRepartidas(0);
	}
	
	public void run() {
		   while (totalRepartidas < 15) { // Hasta un máximo de 15 repartos
	            restaurante.recoger(tipo, nombre);
	            try {
	                Thread.sleep((int) (Math.random() * 600));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            switch (tipo) {
	                case "pizza":
	                    contPizzas++;
	                    break;
	                case "hamburguesa":
	                    contHamburguesas++;
	                    break;
	            }
	            totalRepartidas++;
	        }
	        totalRepartido();
	        if (totalRepartidas == 15) {
	            System.out.println("El repartidor " + nombre + " ha terminado su turno.");
	        }
	    }
	
	public void totalRepartido() {
		if (tipo == "cualquiera") {
			restaurante.repartoTotalMix(nombre);
		}else {
			System.out.println("El repartidor " + nombre + " ha repartido " + contPizzas + " pizzas" );
			System.out.println("El repartidor " + nombre + " ha repartido " + contHamburguesas + " hamburguesas" );
		}
		
	}

	public int getTotalRepartidas() {
		return totalRepartidas;
	}

	public void setTotalRepartidas(int totalRepartidas) {
		this.totalRepartidas = totalRepartidas;
	} 
}
