package ejercicioBomba;

public class Bomba implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 10; i >= 0; i--) {
				Thread.sleep(1000);
				System.out.println("Cuentra atras: " + i);
			}

			System.out.println("BOOOOOOOOOOOOMMMMMMMMMMM");
		} catch (InterruptedException e) {

			System.out.println("DEFUSE!");

		}
	}
}
