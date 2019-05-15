package exmenT10T11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
	
	private static Scanner scan;

	static int pedirDatos(int n) throws InputMismatchException { //Esta es una forma mas directa, ya que trata directamente la introducción de algo por
															//teclado y si lo que se introduce por teclado no es del tipo que se esperaba lanza la excepcion.
		
		scan = new Scanner(System.in);
		
		try {
			System.out.println("Introduzca operador "+n);
			int ope1 = scan.nextInt();
			System.out.println("Operador Introducido correctamente.");
			return ope1;
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("Has introducido un valor no numerico.");
			return 0;
		}
		
	}
	
	static void rango(int op1, int op2) throws ExcepcionIntervalo{
		
		if (op2>op1) {
			throw new ExcepcionIntervalo("El operador 2 no puede ser mayor que el operador 1 para la resta,"
					+ "introduzca de nuevo los operadores y despues realice de nuevo la resta.");
		}
		
	}
	
	static int negativo1(int op1) throws ExcepcionNegativo{
		
		if (op1<0) {
			
			op1 = Math.abs(op1);
			return op1;
		}
		else {
			return op1;
		}
		
	
		
	}
	
	static int multi(int op2) throws Multi{
		
		if (op2==30) {
			
			System.out.println("El operador 2 no puede ser 30.");
			System.out.println("Por favor introduzca de nuevo el operador 2");
			op2 = pedirDatos(2);
			multi(op2);
			return op2;
		}
		else {
			return op2;
		}
		
	}
	
	static int Dividir(int op2 , int n) throws Multi{
		
		try {
			
			op2 = pedirDatos(n);
			op2 = multi(op2);
			op2 = negativo1(op2);
			
		} catch (ExcepcionNegativo nn) {
			
			System.out.println(nn.getMessage());
		}
		return op2;
	}
	
	public static void main(String[] args) throws ExcepcionNegativo, Multi {
		
		Scanner scanner = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		
		//Esto es un comentario de prueba para github
		//Esto es otro comentario de prueba para github
		
		int op1 = 0, op2 = 0;
		int opcion = 0;
		int suma = 0;

		while (opcion != 6) {

			System.out.println("1.Introducir operadores.\n2.Suma\n3.Resta\n4.Multiplicación\n5.División\n6.Salir");
			opcion = scan.nextInt();
			
			switch (opcion) {
			case 1:
				
				/* Esto es una forma de poderlo hacer indirectamente haciendo conversiones utilizando la excepcion NumberFormatException
				 * Que utiliza el parse para comprobar si es de tipo numerico o no, si no lo es lanza la excepción y la capturamos.
				try {
					System.out.println("Introduzca operador 1");
					operador1 = scanner.nextLine();
					op1 = Integer.parseInt(operador1);
					
					System.out.println("Introduzca operador 2");
					operador2 = scanner.nextLine();
					op2 = Integer.parseInt(operador2);
					
				} catch (NumberFormatException ex) {
					System.out.println("\nHas introducido un valor no numerico.");
				}
				*/
				
				
				try {
					op1 = pedirDatos(1);
					op2 = pedirDatos(2);
					op2 = multi(op2);
					op1 = negativo1(op1);
					op2 = negativo1(op2);
				} catch (ExcepcionNegativo n) {
					
					System.out.println(n.getMessage());
				}
				
				
				break;
			case 2:
				
				suma = op1+ op2;
				System.out.println("La suma de "+op1+" + "+op2+" es: "+suma);
				
				break;
			case 3:
				
				try {
					rango(op1, op2);
					System.out.println("La resta de "+op1+" - "+op2+" es: "+(op1-op2));
				} catch (ExcepcionIntervalo e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 4:
				System.out.println("La multiplicacion de "+op1+" * "+op2+" es: "+(op1*op2));
				break;
			case 5:
				try {
					
					if ((op1+op2) > 100) {
						System.out.println("No se puede dividir si la suma de los dos operadores"
								+ " es > que 100.");
						int n = 1;
						op1 = Dividir(op1,n);
						n = 2;
						op2 = Dividir(op2,n);
					}
					
					System.out.println("La division de "+op1+" / "+op2+" es: "+(op1/op2));
				} catch (ArithmeticException e) {
					System.out.println(e.getMessage());
					System.out.println("No se puede dividir entre 0, por favor introduzca de nuevo los operadores.");
				}
				break;
				
			case 6:
				opcion = 6;
				System.out.println("Hasta luego!");
				break;
			default:
				break;
			}
		}

		scan.close();
		scanner.close();
	}

}

