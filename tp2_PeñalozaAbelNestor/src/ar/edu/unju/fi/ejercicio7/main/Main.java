package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	private static ArrayList<Producto> productos = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static Consumer<Producto> imprimirProducto = p -> System.out.println(p);
	
	public static void main(String[] args) {
		cargarProductos();
		int opcion;
		
		do{
            mostrarMenu();
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
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
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción del menú.");
                    break;
            }
        }while(opcion !=7);
	
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
        productos.stream().filter(Producto::isActivo).forEach(imprimirProducto);
        System.out.println();
    }
	//Opcion 2 del menu
	private static void mostrarProductosNodisponibles() {
		System.out.println("..........Productos No Disponibles ............");
		Predicate<Producto> filterEstadoFalse = p -> !p.isActivo();
		productos.stream().filter(filterEstadoFalse).forEach(imprimirProducto);
		System.out.println();
	}
	//Opcion 3
	private static void incrementarPrecios(){
		System.out.println("Incrementando precios en un 20%.");
		Function <Producto, Producto> funcionIncrementar= (p)->{
			p.setPrecioUnitario(p.getPrecioUnitario()* 1.20);
		return p;
		};
		List<Producto> productosIncrementados = new ArrayList<>();
		productosIncrementados = productos.stream()
				.map(funcionIncrementar).collect(Collectors.toList());
			productosIncrementados.forEach(imprimirProducto);
			System.out.println();
	}
	//opcion 4
	private static void mostrarProductosElectrohogarDisponibles(){
		System.out.println("....... Productos de la categoría Electrohogar disponibles .......");
        Predicate<Producto> filterCategoriaElectrohogar = p -> p.getCategoria() == Producto.Categoria.ELECTROHOGAR && p.isActivo();
        productos.stream().filter(filterCategoriaElectrohogar).forEach(imprimirProducto);
        System.out.println();
	}
	//opcion 5
	private static void ordenarProductosPorPrecioDescendente() {
        System.out.println("....... Productos ordenados por precio de forma descendente .......");
        productos.stream().sorted((p1, p2) -> Double.compare(p2.getPrecioUnitario(), p1.getPrecioUnitario())).forEach(imprimirProducto);
        System.out.println();
    }
	//opcion 6
	private static void mostrarNombresEnMayusculas() {
        System.out.println("....... Nombres de productos en mayúsculas .......");
        productos.stream().map(p -> {
            p.setDescripcion(p.getDescripcion().toUpperCase());
            return p;
        }).forEach(imprimirProducto);
        System.out.println();
    }
}
