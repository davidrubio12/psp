package ejercicio_cadena_montaje;

public class Main {

	public static void main(String[] args) {
		
		Cadena cadena = new Cadena();
		
		Colocador colocador = new Colocador(cadena);
		
		Empaquetador tipo1 = new Empaquetador(cadena,1);
		Empaquetador tipo2 = new Empaquetador(cadena,2);
		Empaquetador tipo3 = new Empaquetador(cadena,3);
		
		colocador.start();
		
		tipo1.start();
		tipo2.start();
		tipo3.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
		}
		
		colocador.interrupt();
		
		tipo1.interrupt();
		tipo2.interrupt();
		tipo3.interrupt();
		
        try {
            colocador.join();
            tipo1.join();
            tipo2.join();
            tipo3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
		
		System.out.print("Posicion final de la cadena: ");
		cadena.mostrar();
		cadena.colocacionFinal();
		cadena.cantidadTiposRecogidos();
	}

}
