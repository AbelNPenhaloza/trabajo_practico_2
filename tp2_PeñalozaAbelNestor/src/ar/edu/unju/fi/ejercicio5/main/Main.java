package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Producto> productos = new ArrayList<>();
	
	public static void main(String[] args) {
		//Precargar el ArrayList de productos
		cargarProductos();
		// Mostar el menu de opciones al usuario
		int opcion;
        
		do {
			
        	mostrarMenu();
        	opcion = sc.nextInt();
        	sc.nextLine();//Consumir el salto de linea
        	
        	switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    realizarCompra();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }
	
	private static void cargarProductos() {
        productos.add(new Producto(1, "Teléfono móvil", 300000.0, true, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA));
        productos.add(new Producto(2, "Laptop", 1200000.0, true, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA));
        productos.add(new Producto(3, "Licuadora", 150000.0, true, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(4, "Heladera", 1000000.0, true, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(5, "Lavarropa", 7000000.0, false, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(6, "Taladro Inalambrico", 400000.0, true, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS));
        productos.add(new Producto(7, "Termo", 50000.0, true, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(8, "Smart TV 32", 750000.0, false, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(9, "Estufa", 100000.0, true, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(10, "Tablet", 250000.0, true, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA));
        productos.add(new Producto(11, "Router", 80000.0, true, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA));
        productos.add(new Producto(12, "Switch", 150000.0, true, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.INFORMATICA));
        productos.add(new Producto(13, "Teléfono Inalambrico", 45000.0, true, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA));
        productos.add(new Producto(14, "Amoladora", 90000.0, false, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS));
        productos.add(new Producto(15, "Llave Francesa", 30000.0, false, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS));
        
    }
	private static void mostrarMenu() {
		System.out.println("Menu de opciones.");
		System.out.println("1 - Mostrar productos.");
		System.out.println("2 - Realizar compra.");
		System.out.println("3 - Salir.");
		System.out.print("Seleccione una opcion: ");
	}
	private static void mostrarProductos() {
		System.out.println("Listado de productos disponibles.");
		for(Producto p : productos) {
			
			if(p.isActivo()) {
				System.out.println(p);
			}
			
		}
	}
	private static void realizarCompra() {
		ArrayList<Producto> productosSeleccionados = new ArrayList<>();
		double totalCompra = 0.0;
		
		//Mostrar los productos disponibles y permitir seleccionar al usuario.
		System.out.println("Seleccione los productos que desea comprar.");
		mostrarProductos();
		
		System.out.print("Ingrese el codigo del producto (0 para terminar): ");
		int codigoProducto;
				
		while(true) {
			try {
				codigoProducto = sc.nextInt();
				sc.nextLine();
				
				if(codigoProducto ==0) {
					break;
				}
			
				Producto producto = buscarProductoPorCodigo(codigoProducto);
				if(producto != null && producto.isActivo()) {
					productosSeleccionados.add(producto);
					totalCompra += producto.getPrecioUnitario();
					System.out.print("Ingrese el codigo del proximo producto (0 para terminar): ");
					//sc.nextLine();
				}else {
					System.out.println("El producto seleccionado no esta disponible o no existe.");
					System.out.print("Ingrese un codigo de producto valido (0 para terminar): ");
					//sc.nextLine();
				}
			}catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un número entero.");
	            sc.next(); // Limpiar el buffer del scanner
	            System.out.print("Ingrese un código de producto válido (0 para terminar): ");
			}
		}
		//Mostrar opciones de pago
		System.out.println("Seleccione una opcionde pago.");
		System.out.println("1 - Pago efectivo.");
		System.out.println("2 - Pago con tarjeta");
		System.out.print("Seleccione una opcion: ");
		
		int opcionPago;
		try {
			opcionPago= sc.nextInt();
			sc.nextLine();
		}catch(InputMismatchException e) {
			System.err.println("Error: La opcion de pago ingresada no es valida.");
			return;
		}
		//Realizar pago y mostrar recibo
		switch(opcionPago) {
		case 1: 
			PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
			pagoEfectivo.realizarPago(totalCompra);
			pagoEfectivo.imprimirRecibo();
			break;
		case 2:
	        System.out.print("Ingrese el número de tarjeta: ");
	        String numeroTarjeta = sc.nextLine();
	        PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), totalCompra);
	        pagoTarjeta.realizarPago(totalCompra);
	        pagoTarjeta.imprimirRecibo();
	        break;
	        default:
	            System.out.println("Opción de pago inválida.");
	            break;
	    }
		
		
	}
	private static Producto buscarProductoPorCodigo(int codigo) {
		try {
			for(Producto p : productos) {
				if(p.getCodigo()==codigo) {
					return p;
				}
			}
			System.err.println("Error: No se encontro ningun producto con el codigo especificado");
		}catch (IndexOutOfBoundsException e) {
			System.err.println("Error: Ingrese un indice correcto");
		}
		return null;
	}
}


