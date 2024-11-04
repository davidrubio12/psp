package ejercicio_cadena_montaje;

public class Empaquetador extends Thread {

	private Cadena cadena;
	private int tipo;
	public Empaquetador(Cadena cadena, int tipo) {
		super();
		this.cadena = cadena;
		this.tipo = tipo;
	}
	
	public void run() {
		while(!isInterrupted()) {
			
		
		cadena.retirar(this.tipo);
		
		try {
			sleep((int) ((Math.random() * 500) + 1));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			break; // Termina el bucle al ser interrumpido
			
		}
		
		}
		
	}
}
