package leerFicheroTransferencias;



import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LeerFicheroTransferencias {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime el path del fichero");
		
		String path = sc.nextLine();
		
		System.out.println("Dime nombre del fichero");
		
		String nombre = sc.nextLine();
		
		System.out.println("Numero de transferencias a generar");
		
		int num = Integer.parseInt(sc.nextLine());
		
		sc.close();
		
		File file = new File("D:\\DA2D1E\\generacionFicheroTransferencia\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","generacionFicheroTransferencia.GeneracionFicheroTransferencia" );
		
		pb.directory(file);
		
		try {
			
			
			Process p  = pb.start();
			
			OutputStream os = p.getOutputStream();
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
			
			writer.write(path);
			 writer.newLine();
			writer.write(nombre);
			 writer.newLine();
			writer.write(Integer.toString(num));
			 writer.newLine();
			writer.flush();
			writer.close();
			
			int ev = p.waitFor();
		

			
			switch (ev) {
			case -2:
					System.out.println("valor de salida: " + ev);
					System.out.println("No ha llegado el fichero de transferencias");
				break;
			case -1:
				System.out.println("valor de salida: " + ev);
				System.out.println("Error al generar el fichero");
			break;
			case 0:
				System.out.println("Proceso realizado con exito");
			break;
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
