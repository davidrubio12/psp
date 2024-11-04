package ejercicioRelevos;

public class Ejercicio3_relevos implements Runnable {

	private String nombre;

	private double velocidad;

	public Ejercicio3_relevos(String nombre) {

		super();

		this.nombre = nombre;

		this.velocidad = carrera();

	}

	private double carrera() {

		double num = Math.round(Math.random() * (1050 + 1 - 950) + 950);

		return num / 100;

	}

	@Override

	public void run() {

		System.out.println("España: " + nombre + " Comienza su relevo");

		try {

			Thread.sleep((int) velocidad * 1000);

		} catch (InterruptedException e) {

// TODO Auto-generated catch block 

			e.printStackTrace();

		}

		System.out.println("España: " + nombre + " ha acabado su relevo -"

				+ "	ha tardado: " + velocidad + " segundos.");

	}

	public static void main(String[] args) {

		Ejercicio3_relevos pepe = new Ejercicio3_relevos("Pepe");

		Ejercicio3_relevos maria = new Ejercicio3_relevos("Maria");

		Ejercicio3_relevos juan = new Ejercicio3_relevos("Juan");

		Ejercicio3_relevos marta = new Ejercicio3_relevos("Marta");

		Thread th = new Thread();

		try {

			th = new Thread(pepe);

			th.start();

			th.join();

			th = new Thread(maria);

			th.start();

			th.join();

			th = new Thread(juan);

			th.start();

			th.join();

			th = new Thread(marta);

			th.start();

			th.join();

		} catch (InterruptedException e) {

// TODO Auto-generated catch block 

			e.printStackTrace();

		}

	}

}