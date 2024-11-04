package ejercicio_restaurante;

public class Restaurante {

	private String armario[];
	private boolean fullPizza ;
	private boolean fullHamburguesa  ;
	private int contPizza ;
	private int contHamburguesa ;
	private int pizzasRepartidas ;
	private int hamburguesasRepartidas ;
	private int pizzasCocinadas;
	private int hamburguesasCocinadas;
	private int repartidorMixPizza;
	private int repartidorMixHamburguesa;
	private boolean cocinerosActivos = true;
	public Restaurante() {
		super();
		this.armario = new String[] { "hueco", "hueco", "hueco", "hueco", "hueco" };
		this.fullPizza = false;
		this.fullHamburguesa = false;
		this.contPizza = 0;
		this.contHamburguesa = 0;
		this.pizzasRepartidas = 0;
		this.hamburguesasRepartidas = 0;
		this.pizzasCocinadas = 0;
		this.hamburguesasCocinadas = 0 ;
		this.repartidorMixPizza = 0 ;
		this.repartidorMixHamburguesa = 0 ;
	}

	 public synchronized boolean areCocinerosActivos() {
	        return cocinerosActivos;
	    }

	public synchronized void poner(String comida) {
		  while (!cocinerosActivos) {
	            return; // Salir si los cocineros no están activos
	        }
	
		switch (comida) {
		case "pizza":
			
				while (fullPizza) {
					try {
						wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
                        return; // Salir si se interrumpe
					}
				}

				System.out.println("Preparando una pizza...");
				try {

					Thread.sleep((int) (Math.random() * 200));

				} catch (InterruptedException e) {
					  Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
	                    return; // Salir si se interrumpe
				}
				
				
				for (int i = 0; i < armario.length; i++) {
					if (armario[i].equals("hueco")) {
						armario[i] = comida;
						contPizza++;
						System.out.println("Pizza preparada para repartir.Pizzas pendientes de entrega: " + contPizza);
						
						pizzasCocinadas++;
						if (contPizza == 2) fullPizza = true;
						notifyAll();
						break;
					}
				}

			

			break;
		case "hamburguesa":
			
				while (fullHamburguesa) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

				System.out.println("Preparando una hamburguesa...");
				try {

					Thread.sleep((int) (Math.random() * 300));

				} catch (InterruptedException e) {
					  Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
	                    return; // Salir si se interrumpe
				}
				
				
				for (int i = 0; i < armario.length; i++) {
					if (armario[i].equals("hueco")) {
						armario[i] = comida;
						contHamburguesa++;
						System.out.println("Hamburguesa preparada para repartir.Hamburguesa pendientes de entrega: "
								+ contHamburguesa);
						hamburguesasCocinadas++;
						if (contHamburguesa == 3) fullHamburguesa = true;
						notifyAll();
						break;
					}
				}
				break;
			

		}

	}
	
	public synchronized void recoger(String tipo, String repartidor) {

		switch (tipo) {
		case "pizza":
			
				for (int i = 0; i < armario.length; i++) {
					if (armario[i].equals(tipo)) {
						armario[i] = "hueco";
						contPizza--;
						System.out.println(
								repartidor + "va a repartir una pizza.Pizzas pendientes de entrega: " + contPizza);
						pizzasRepartidas++;
						fullPizza = false;
						notifyAll();
					
						
						break;
					}
				}
				break;
			

		case "hamburguesa":
		
			
				for (int i = 0; i < armario.length; i++) {
					if (armario[i].equals(tipo)) {
						armario[i] = "hueco";
						contHamburguesa--;
						System.out.println(
								repartidor + "va a repartir una hamburguesa.Hamburguesas pendientes de entrega: " + contHamburguesa);
						hamburguesasRepartidas++;
						fullHamburguesa = false;
						notifyAll();
				
						break;
					}
				}
				break;
			
			
		case "cualquiera":
			
			
				for (int i = 0; i < armario.length; i++) {
					if (armario[i].equals("hamburguesa")) {
						armario[i] = "hueco";
						contHamburguesa--;
						System.out.println(
								repartidor + "va a repartir una hamburguesa.Hamburguesas pendientes de entrega: " + contHamburguesa);
						hamburguesasRepartidas++;
						repartidorMixHamburguesa++;
						fullHamburguesa = false;
						notifyAll();
					

						return;
					}
				}
				
				for (int i = 0; i < armario.length; i++) {
					if (armario[i].equals("pizza")) {
						armario[i] = "hueco";
						contPizza--;
						System.out.println(
								repartidor + "va a repartir una pizza.Pizzas pendientes de entrega: " + contPizza);
						pizzasRepartidas++;
						repartidorMixPizza++;
						fullHamburguesa = false;
						notifyAll();
					
						return;
					}
				}
				
				break;
			
			
			
		}

	}
	
	public void totalRepartor() {
		System.out.println("==============================================");
		System.out.println("Pizzas entregadas en total: " + pizzasRepartidas);
		System.out.println("Hamburguesas entregadas en total: " + hamburguesasRepartidas);
	}
	
	public void totalCocinadas() {
		System.out.println("==============================================");
		System.out.println("Pizzas cocinadas en total: " + pizzasCocinadas);
		System.out.println("Hamburguesas cocinadas en total: " + hamburguesasCocinadas);
	}



	public void repartoTotalMix(String nombre) {
		
		System.out.println("El repartidor " + nombre + " ha repartido " + repartidorMixHamburguesa + " pizzas" );
		System.out.println("El repartidor " + nombre + " ha repartido " + repartidorMixPizza + " hamburguesas" );
	}
	
	 public void pararCocineros() {
	        cocinerosActivos = false;
	        System.out.println("Cocineros han parado de trabajar.");
	    }



	public boolean cocinerosActivos() {
		// TODO Auto-generated method stub
		return cocinerosActivos;
	}

}
