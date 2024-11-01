package leerFicheroTransferencias;

import java.io.FileWriter;
import java.io.IOException;

public class Gestor extends Thread {
	
	private LectorTransferencias lectorTransferencias; 
	private Saldo saldo;
	private double totalProcesado = 0.0;
	

	
public Gestor(LectorTransferencias lectorTransferencias, Saldo saldo) {
		super();
		this.lectorTransferencias = lectorTransferencias;
		this.saldo = saldo;
	}



public void run() {
	
	
	
	try {
		String lineaTransferencia;
		while ((lineaTransferencia = lectorTransferencias.leerTransferencia())!= null) {
			String[] datos = lineaTransferencia.split(",");
			
			String cuentaEmpleado = datos[0];
			double importe = Double.parseDouble(datos[1]);
			
			String tipoCuenta;
			
			if(cuentaEmpleado.startsWith("1")) {
				 tipoCuenta = "interna";
				 
			}else
				 tipoCuenta = "externa";
			
			
			if (saldo.getMonto() >= importe) {
				if(tipoCuenta.equalsIgnoreCase("interna")) {
					Thread.sleep(1000);
				}
			    saldo.restar(importe);
			    totalProcesado += importe;
			    System.out.println("Cuenta " + cuentaEmpleado + " - Actualizamos el saldo de la cuenta con el importe " + importe);
			    System.out.println("Grabamos transferencia " + tipoCuenta + ". Cuenta " + cuentaEmpleado );
			    escribirTransferencia(tipoCuenta, cuentaEmpleado, importe);
			} else {
				System.out.println("No hay saldo suficiente para realizar la transferencia de: " + importe);
			    escribirTransferencia("sin_saldo", cuentaEmpleado, importe);
			}
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
private void escribirTransferencia(String tipo, String cuenta, double importe) {
    String fileName = tipo + "_transferencias.txt";
    try (FileWriter writer = new FileWriter(fileName, true)) {
        writer.write(cuenta + "," + importe + "\n");
    } catch (IOException e) {
        System.out.println("Error escribiendo transferencia: " + e.getMessage());
    }
}


public double getTotalProcesado() {
    return totalProcesado;
}

}
