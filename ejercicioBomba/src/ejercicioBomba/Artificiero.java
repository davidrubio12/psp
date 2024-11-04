package ejercicioBomba;

public class Artificiero implements Runnable {

    

    public Artificiero() {
        
    }

    @Override
    public void run() {
    	
		
		
		try {
			System.out.println("El artificiero empieza ha desactivar la bomba");
			int tiempo = (int) (Math.random() * (10500 - 9500) + 9500);
			
			
			Thread.sleep(tiempo);
			System.out.println("El artificiero ha desactivado la bomba en: " + ( tiempo / 1000 ) + " segundo");
		} catch (InterruptedException e) {
			
			System.out.println("DEFUSE!! ");
			
		}
    }
}
