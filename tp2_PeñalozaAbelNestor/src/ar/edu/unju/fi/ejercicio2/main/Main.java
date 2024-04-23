package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Efemeride> listaEfemerides = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcion;
        do {
            mostrarMenu();
            try {
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    crearEfemeride();
                    break;
                case 2:
                    mostrarEfemerides();
                    break;
                case 3:
                    eliminarEfemeride();
                    break;
                case 4:
                    modificarEfemeride();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            	}
            }catch(InputMismatchException e) {
            	System.out.println("Error: ingrese un numero valido.");
            	sc.nextLine();//Limpiar buffer
            	opcion = 0;
            }
        } while (opcion != 5);
    }
	//Metodo del menu principal del ejercicio 2
	private static void mostrarMenu() {
		System.out.println("\nMenu de opciones.");
		System.out.println("1- Crear Efeméride");
		System.out.println("2- Mostrar Efemérides");
		System.out.println("3- Elimnar Efeméride");
		System.out.println("4- Modificar Efeméride");
		System.out.println("5- Salir");
		System.out.print("Elija una opción: ");
		
	}
	//Metodo para crear una Efemeride.
	private static void crearEfemeride() {
		System.out.println("\nCreación de una Efeméride.");
		try {
		System.out.print("Ingrese el codigo: ");
		Integer codigo = sc.nextInt();
		System.out.print("Ingrese el numero del mes (1 - 12): ");
		int numMes = sc.nextInt();
		Mes mes = obtenerMes(numMes);
		System.out.print("Ingrese el dia: ");
		Byte dia = sc.nextByte();
		sc.nextLine();//Limpiar buffer
		System.out.print("Ingrese el detalle: ");
		String detalle = sc.nextLine();
		Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
		listaEfemerides.add(efemeride);
		System.out.println("Efemeride creada correctamente.");
		}catch (InputMismatchException e) {
		System.out.println("Error: al ingresar los datos. Asegurese de introducir valores validos.");
		sc.nextLine();//Limpiar buffer
		}
	}
	//Metodo para obtener el mes
	private static Mes obtenerMes(int numMes) {
        Mes[] meses = Mes.values();
        if (numMes >= 1 && numMes <= 12) {
            return meses[numMes - 1];
        } else {
            System.out.println("Número de mes inválido. Seleccionando enero por defecto.");
            return Mes.ENERO;
        }
    }
	
		
}


