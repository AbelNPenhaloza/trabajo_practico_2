package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Efemeride> listaEfemerides = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcion;
        do {
            mostrarMenu();
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
        } while (opcion != 5);
    }
	

}


