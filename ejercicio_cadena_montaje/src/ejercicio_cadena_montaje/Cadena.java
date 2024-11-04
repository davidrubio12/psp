package ejercicio_cadena_montaje;

import java.util.Arrays;

public class Cadena {

	private int[] cadena = { 0, 0, 0 };
	private int totalColocados;
	private int totalTipo1;
	private int totalTipo2;
	private int totalTipo3;

	public Cadena() {
		super();
		this.totalColocados = 0;
		this.totalTipo1 = 0;
		this.totalTipo2 = 0;
		this.totalTipo3 = 0;
	}

	public synchronized void colorcar(int valor) {
		

		while (!posicionVacia()) {
			try {
				wait();
			} catch (InterruptedException e) {

				 Thread.currentThread().interrupt();
				 
				 return; // Salir del método si el hilo fue interrumpido
			}
		}
			for (int i = 0; i < cadena.length; i++) {
				if (cadena[i] == 0) {
					try {
						Thread.sleep((int) (Math.random() * 250));
					} catch (InterruptedException e) {

						 Thread.currentThread().interrupt();
		                    return; // Salir si se interrumpe durante el sleep
					}
					System.out.println("Produciendo tipo: " + valor);
					System.out.println("Colocando un producto " + valor + " en la posición " + i);
		
					
					cadena[i] = valor;
					this.totalColocados++;
					mostrar();
					notifyAll();
					break;
				}
			}

		
	}

	public synchronized void retirar(int valor) {
		
		while (!posicionEncontrada(valor) ) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
			
		}

			for (int i = 0; i < cadena.length; i++) {

				if (cadena[i] == valor) {

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

					    Thread.currentThread().interrupt();
	                    return; // Salir si se interrumpe durante el sleep
					}
					System.out.println("Recogido el producto " + valor);

					cadena[i] = 0;

					switch (valor) {
					case 1:
						totalTipo1++;
						break;
					case 2:
						totalTipo2++;
						break;
					case 3:
						totalTipo3++;
						break;

					}
					
					notifyAll();
					break;
				}
			}

		

	}

	private boolean posicionEncontrada(int valor) {

		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i] == valor) {
				return true;
			}
		}
		return false;
	}

	private boolean posicionVacia() {

		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i] == 0) {
				return true;
			}
		}
		return false;
	}

	public void mostrar() {
		System.out.println(Arrays.toString(cadena));
	}

	public void cantidadTiposRecogidos() {
		int recogido[] = { totalTipo1, totalTipo2, totalTipo3 };

		System.out.println("Recogidos por tipo: " + Arrays.toString(recogido));

	}

	public void colocacionFinal() {
		System.out.println("Puestos en total: " + totalColocados);
	}

}
