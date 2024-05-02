package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	private static ArrayList<Producto> productos = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		cargarProductos();
		
		while (true) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    mostrarProductosDisponibles();
                    break;
                case 2:
                    mostrarProductosNodisponibles();
                    break;
                case 3:
                    incrementarPrecios();
                    break;
                case 4:
                    mostrarProductosElectrohogarDisponibles();
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente();
                    break;
                case 6:
                    mostrarNombresEnMayusculas();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción del menú.");
            }
        }
	}
	private static void cargarProductos() {
        
		if(productos.isEmpty()) {
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
    }
	
	private static void mostrarMenu() {
        System.out.println("---------------------Menu-----------------------------");
        System.out.println("1 - Mostrar productos disponibles");
        System.out.println("2 - Mostrar productos no disponibles");
        System.out.println("3 - Incrementar precios de productos en un 20 %");
        System.out.println("4 - Mostrar productos de categoría Electrohogar disponibles");
        System.out.println("5 - Ordenar productos por precio descendente");
        System.out.println("6 - Mostrar nombres de productos en mayúsculas");
        System.out.println("7 - Salir");
        System.out.print("Seleccione una opción:");
    }
	//Opcion 1 del Menu
	private static void mostrarProductosDisponibles() {
		
        System.out.println("....... Productos Disponibles .......");
        Consumer<Producto> consumer = p -> System.out.println(p);
        productos.stream().filter(Producto::isActivo).forEach(consumer);
    }
	//Opcion 2 del menu
}
