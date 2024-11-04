package ejercicio_restaurante;

public class Cocinero extends Thread{

	
	private Restaurante restaurante;
	private String tipo;
	
	public Cocinero(Restaurante restaurante, String tipo) {
		super();
		this.restaurante = restaurante;
		this.tipo = tipo;
	}
	
	   public void run() {
	        while (true) {
	            restaurante.poner(tipo);
	            if (!restaurante.areCocinerosActivos()) {
	                break; // Salir si los cocineros no están activos
	            }
	        }
	    }
	
}
