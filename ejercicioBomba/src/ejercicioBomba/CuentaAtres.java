package ejercicioBomba;

public class CuentaAtres {

		
		
	

	
	

	public static void main(String[] args) {
		
		Bomba bomba = new Bomba();
		
		Artificiero artificiero = new Artificiero();
		
		Thread t1 = new Thread(bomba);
		
		Thread t2 = new Thread(artificiero);
		
		t1.start();
		
		t2.start();
		
		
			
			do {
				
			} while (t1.isAlive() && t2.isAlive());
			
				if(t1.isAlive()) {
					t1.interrupt();
				}else {
					t2.interrupt();
				}
					
			
	
		

	}

}
