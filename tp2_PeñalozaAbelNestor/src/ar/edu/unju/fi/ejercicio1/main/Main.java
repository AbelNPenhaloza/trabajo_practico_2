package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Producto> listaProductos = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcion;
				
		do {
			mostrarMenu();
			opcion = obtenerOpcion();
			try {
				
				switch (opcion) {
				case 1: 
					crearProducto();
					break;
				case 2:
					mostrarProductos();
					break;
				case 3:
					modificarProducto();
					break;
				case 4:
					System.out.println("Saliendo del Programa...");
					break;
					default:
						System.out.println("Opcion Invalida. Elija una opcion valida.");
				}
				
			}catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			
		}while (opcion != 4);
	}
	//Metodo para mostrar el Menu
	private static void mostrarMenu() {
		System.out.println("Menu de opciones.");
		System.out.println("1 - Crear Producto.");
		System.out.println("2 - Mostrar Productos.");
		System.out.println("3 - Modificar Producto.");
		System.out.println("4 - Salir.");
		System.out.print("Elija una opcion: ");
	}
	//Metodo que controla la entrada de la Opcion
	private static int obtenerOpcion() {
		int opcion=0;
		boolean opcionValida = false;
		do {
			try {
				opcion= sc.nextInt();
				sc.nextLine();//Limpiar el buffer
				opcionValida = true;
			}catch (InputMismatchException e) {
				System.out.println("Por favor, ingrese un numero valido.");
				sc.nextLine();//Limpiar buffer
			}
		}while(!opcionValida);
		return opcion;
	}
	//1. metodo para crear un Producto
	private static void crearProducto() {
		try {
			System.out.println("\nCreacion de Producto.");
			System.out.print("Ingrese el codigo del Producto: ");
			int codigo = sc.nextInt();
			sc.nextLine();//Limpiar el buffer
			System.out.print("Ingrese la Descripcion del Producto: ");
			String descripcion = sc.nextLine();
			System.out.print("Ingrese el precio Unitario del Producto: ");
			double precioUnitario = sc.nextDouble();
			sc.nextLine();//Limpiar el buffer
			
			//Mostrar las opciones para el Origen de Fabricacion
			System.out.println("----------Origen de Fabricacion-----------");
			mostrarOpcionesEnum(OrigenFabricacion.values());
			System.out.print("Elija una opcion:");
			int opcionOrigen = sc.nextInt();
			sc.nextLine();//Limpiar el buffer 
			OrigenFabricacion origenFabricacion = OrigenFabricacion.values()[opcionOrigen -1];
			
			//Mostrar las opciones para la categoria
			System.out.println("----------Categorias--------------");
			mostrarOpcionesEnum(Categoria.values());
			System.out.print("Elija una opcion: ");
			int opcionCategoria = sc.nextInt();
			sc.nextLine();//Limpiar el buffer
			Categoria categoria = Categoria.values()[opcionCategoria -1];
			//Crear el objeto Producto y agregarlo a la lista
			Producto producto = new Producto(codigo, descripcion, precioUnitario,origenFabricacion, categoria );
			listaProductos.add(producto);
			System.out.println("Producto creado correctamente.");
		}catch (InputMismatchException e) {
			System.out.println("Error: Por favor, ingrese un valor numerico para el precio.");
			sc.nextLine();// Limpiar el buffer
		}
		
	}
	// 2. Metodo para mostrar los productos
	private static void mostrarProductos() {
		System.out.println("Lista de Productos.");
		for(Producto producto : listaProductos) {
			System.out.println(producto);
		}
	}
	// 3. Metodo para modificar un producto
	private static void modificarProducto() {
		try {
			System.out.println("Modificar Producto.");
			System.out.print("Ingrese el codigo del producto a modificar: ");
			int codigoAModificar = sc.nextInt();
			sc.nextLine();//Limpiar el buffer
			Producto productoAModificar = null;
			for(Producto p : listaProductos) {
				if(p.getCodigo()==codigoAModificar) {
					productoAModificar = p;
					break;
				}
			}
			if(productoAModificar != null) {
				System.out.println("Que desea modificar?");
				System.out.println("1- Descripcion");
				System.out.println("2- Precio Unitario");
				System.out.println("3- Origen de Fabricacion");
				System.out.println("4- Categoria");
				System.out.print("Elija una opcion: ");
				int opcionDeModificacion = sc.nextInt();
				sc.nextLine();//Limpiar buffer
				
				switch(opcionDeModificacion) {
				case 1:
					System.out.print("Ingrese la nueva descripcion: ");
					String nuevaDescripcion = sc.nextLine();
					productoAModificar.setDescripcion(nuevaDescripcion);
					break;
				case 2:
					System.out.print("Ingrese el nuevo precio Unitario: ");
					double nuevoPrecioUnitario = sc.nextDouble();
					sc.nextLine();
					productoAModificar.setPrecioUnitario(nuevoPrecioUnitario);;
					break;
				case 3: 
					System.out.println("-------------Origen de Fabricacion--------------");
					mostrarOpcionesEnum(OrigenFabricacion.values());
					System.out.print("Elija una opcion: ");
					int opcionOrigen = sc.nextInt();
					sc.nextLine();//Limpiar el buffer
					
					productoAModificar.setOrigenFabricacion(OrigenFabricacion.values()[opcionOrigen -1]);
					break;
				case 4:
					System.out.println("------------Categoria-------------");
					mostrarOpcionesEnum(Categoria.values());
					System.out.print("Elija una opcion: ");
					int opcionCategoria = sc.nextInt();
					sc.nextLine();//Limpiar el buffer
					productoAModificar.setCategoria(Categoria.values()[opcionCategoria -1]);
					break;
				default:
						System.out.println("Opcion invalida.");
				}
				System.out.println("Producto modificado correctamente");
				
			}else {
				System.out.println("Producto no encontrado.");
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Error: Por favor ingrese un valor numerico para el codigo o precio.");
			sc.nextLine();
		}
	}
	//Metodo para mostrar las opciones de los Enum
	private static void mostrarOpcionesEnum(Enum<?> [] opciones) {
		int i = 1;
		for(Enum<?> opcion : opciones) {
			System.out.println(i + " - " + opcion);
			i++;
		}
	}
}
