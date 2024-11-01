package generacionFicheroTransferencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GeneracionFicheroTransferencia {

	public static void main(String[] args) throws InterruptedException {
		
		int num =(int) (Math.random() * 100) + 1;

		if (num < 30) {

			System.exit(-2);

		} else {

	 try {

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				String pathFichero = reader.readLine();

				String nombreFichero = reader.readLine();

				int numeroTransferencias = Integer.parseInt(reader.readLine());
				
				
				
				System.out.println("Datos recibidos:");
	            System.out.println("Path: " + pathFichero);
	            System.out.println("Nombre del fichero: " + nombreFichero);
	            System.out.println("Numero de transferencias: " + numeroTransferencias);
				
				reader.close();
				//meter en un metodo todolo lo despues a lectura de datos
				FileWriter fichero = new FileWriter(pathFichero + "" + nombreFichero);

				for (int i = 0; i < numeroTransferencias; i++) {

					int primerDigito = (int) (1 +(Math.random()) * 2);

					primerDigito = primerDigito * 100000000;

					int restantes = (int) (Math.random() * 10000000);

					int digitoEntero = primerDigito + restantes;

					double importeNomina = 1500 + (Math.random() * (3000 - 1500));
					
					importeNomina = Math.round(importeNomina * 100.0) / 100.0;

					fichero.write(digitoEntero + "," + importeNomina + "\n");

					

				}
				fichero.close();
				
				

				
		
				
				System.out.println("Fichero generado con éxito.");
				System.exit(0);

			} catch (IOException e) {
				System.out.println("Error al generar el fichero.");
				System.exit(-1);
				e.printStackTrace();
			}

		}

	}

}
