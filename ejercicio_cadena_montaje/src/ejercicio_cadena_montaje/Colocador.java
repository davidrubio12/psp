package ejercicio_cadena_montaje;

public class Colocador extends Thread{

	private Cadena cadena;

	public Colocador(Cadena cadena) {
		super();
		this.cadena = cadena;
	}
	
	public void run() {
		while(!isInterrupted()) {
			
		
		int num = (int) ((Math.random() * 3) + 1);
		
		cadena.colorcar(num);
		 try {
             Thread.sleep((int) (Math.random() * 250)); // Simula tiempo de colocación
         } catch (InterruptedException e) {
        	 Thread.currentThread().interrupt();
             break; // Termina el bucle al ser interrumpido
         }
		
		}
	}
}
