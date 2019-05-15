package exmenT10T11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		//Comentario agregado para el manul de GIT / GITHUB para prueba de modificacion de archivo
		//Comentario primera modificacion rama pruebas
		//Comentario segunda modificacion rama pruebas
		ArrayList<String> txt = new ArrayList<>();
		
		String linea2 = "";
		boolean encontrado = false;
		
		try {
			BufferedReader bf1 = new BufferedReader(new FileReader("C:\\Users\\todomovil\\Google Drive\\1º DAW\\Programacion\\2ºTrimestre\\exmenT10T11\\src\\agendaDuplicada.txt"));

			String linea1 = "";
			
			while ((linea1 != null)) {

				
				
				if (linea1 != null && linea1 != "") { //Para evitar que introduzca valores nulos, lo he condicionado con un if para la linea 1
					
					for (String texto : txt) {
						
						if (texto.startsWith(linea2)) {
							
							encontrado = true;
							
						}
						
					}
					if (encontrado==false) {
						txt.add(linea1);
					}
					encontrado = false;
				}
				linea1 = bf1.readLine();
				if (linea1 != null) {
					linea2 = linea1.substring(0, linea1.indexOf("/"));
				}
				
			}
				
				for (String texto : txt) {
					
					System.out.println(texto);
				}
				
			bf1.close();
		
			
			
			System.out.println("El programa se ha ejecutado correctamente, compruebe el archivo.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
