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
		Scanner sc = new Scanner(System.in);
		int num = 31 ;//(int) (Math.random() * 100) + 1;

		if (num < 30) {

			System.exit(-2);

		} else {

			File path = new File("D:\\DA2D1E\\leerFicheroTransferencias\\bin");

			ProcessBuilder pb1 = new ProcessBuilder("java", "leerFicheroTransferencias.LeerFicheroTransferencias");

			pb1.directory(path);

			try {

				Process p1 = pb1.start();

				InputStream is = p1.getInputStream();

				BufferedReader reader = new BufferedReader(new InputStreamReader(is));

				String pathFichero = reader.readLine();

				String nombreFichero = reader.readLine();

				int numeroTransferencias = Integer.parseInt(reader.readLine());
				
				System.out.println("Datos recibidos:");
	            System.out.println("Path: " + pathFichero);
	            System.out.println("Nombre del fichero: " + nombreFichero);
	            System.out.println("Numero de transferencias: " + numeroTransferencias);
				
				reader.close();

				FileWriter fichero = new FileWriter(pathFichero + "" + nombreFichero);

				for (int i = 0; i < numeroTransferencias; i++) {

					int primerDigito = (int) ((Math.random() + 1) * 2);

					primerDigito = primerDigito * 100000000;

					int restantes = (int) (Math.random() * 10000000);

					int digitoEntero = primerDigito + restantes;

					int importeNomina = (int) (Math.random() + 1500 * (3000 - 1500));

					importeNomina = Math.round(importeNomina * 100) / 100;

					fichero.write(digitoEntero + ";" + importeNomina + "\n");

					

				}
				fichero.close();
				
				p1.waitFor();
				
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
