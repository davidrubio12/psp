package leerFicheroTransferencias;

public class Saldo {
    private double monto;

    public Saldo(double monto) {
        this.monto = monto;
    }

    public synchronized double getMonto() {
        return monto;
    }

    public synchronized boolean restar(double cantidad) {
    	 if (monto >= cantidad) {
             monto -= cantidad;
             return true; 
         } else {
             System.out.println("Saldo insuficiente. No se puede realizar la transferencia de: " + cantidad);
             return false; 
         }
    }
}

