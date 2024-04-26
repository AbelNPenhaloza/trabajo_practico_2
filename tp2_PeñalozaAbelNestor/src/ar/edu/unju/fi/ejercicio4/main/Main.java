package ar.edu.unju.fi.ejercicio4.main;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcionValida();
            switch (opcion) {
                case 1:
                    altaJugador(jugadores);
                    break;
                case 2:
                    mostrarTodosLosJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicionDeJugador(jugadores);
                    break;
                case 4:
                    eliminarJugador(jugadores);
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un opción válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("Menú de opciones.");
        System.out.println();
        System.out.println("1 - Alta de Jugador");
        System.out.println("2 - Mostrar los datos del Jugador Requerido");
        System.out.println("3 - Modificar la posición de un Jugador");
        System.out.println("4 - Eliminar un Jugador");
        System.out.println("5 - Salir");
    }

    private static int obtenerOpcionValida() {
        int opcion = 0;
        boolean opcionValida = false;
        do {
            try {
                System.out.print("Ingrese una opción: ");
                opcion = sc.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next(); // Limpia el buffer del scanner
            }
        } while (!opcionValida);
        return opcion;
    }

    private static void altaJugador(ArrayList<Jugador> jugadores) {
        System.out.print("Ingrese el Nombre: ");
        String nombre = sc.next();
        System.out.print("Ingrese el Apellido: ");
        String apellido = sc.next();
        LocalDate fechaNacimiento = obtenerFechaNacimientoValida();
        System.out.print("Ingrese la Nacionalidad: ");
        String nacionalidad = sc.next();
        System.out.print("Ingrese la Estatura: ");
        double estatura = leerDoubleValido();
        System.out.print("Ingrese la Peso: ");
        double peso = sc.nextDouble();
        Posicion posicion = obtenerPosicionValida();

        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado correctamente.");
    }

    private static void mostrarTodosLosJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("Datos de todos los jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.printf("Nombre: %s\n", jugador.getNombre());
                System.out.printf("Apellido: %s\n", jugador.getApellido());
                System.out.printf("Fecha de Nacimiento: %s\n", jugador.getFechaNacimiento().format(formatter));
                System.out.printf("Nacionalidad: %s\n", jugador.getNacionalidad());
                System.out.printf("Estatura: %.2f mts\n", jugador.getEstatura());
                System.out.printf("Peso: %.2f Kg\n", jugador.getPeso());
                System.out.println("Posición: " + jugador.getPosicion());
                System.out.println();
            }
        }
    }

    private static void modificarPosicionDeJugador(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.print("Ingrese el Nombre del jugador a modificar: ");
        String nombre = sc.next();
        System.out.print("Ingrese el Apellido del jugador a modificar: ");
        String apellido = sc.next();

        boolean encontrado = false;

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                encontrado = true;

                System.out.print("Ingrese la nueva posición para el jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
                String posicionCadena = sc.next().toUpperCase();
                try {
                    Posicion nuevaPosicion = Posicion.valueOf(posicionCadena);
                    jugador.setPosicion(nuevaPosicion);
                    System.out.println("Posición modificada correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Por favor, ingrese una posición válida.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.print("Ingrese el Nombre del Jugador a eliminar: ");
        String nombre = sc.next();
        System.out.print("Ingrese el Apellido del Jugador a eliminar: ");
        String apellido = sc.next();

        Iterator<Jugador> iterador = jugadores.iterator();
        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                iterador.remove();
                System.out.println("Jugador eliminado correctamente.");
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    private static LocalDate obtenerFechaNacimientoValida() {
        LocalDate fechaNacimiento = null;
        boolean fechaValida = false;
        do {
            System.out.print("Ingrese la fecha de Nacimiento (dd/MM/yyyy): ");
            String fechaCadena = sc.next();
            try {
                fechaNacimiento = LocalDate.parse(fechaCadena, formatter);
                fechaValida = true;

            } catch (DateTimeParseException e) {
                System.out.println("Por favor, ingrese una fecha válida en el formato (dd/MM/yyyy)");
            }
        } while (!fechaValida);
        return fechaNacimiento;
    }

    private static Posicion obtenerPosicionValida() {
        Posicion posicion = null;
        boolean posicionValida = false;
        do {
            System.out.print("Ingrese la posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
            String posicionCadena = sc.next().toUpperCase();

            try {
                posicion = Posicion.valueOf(posicionCadena);
                posicionValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Por favor, ingrese una posición válida.");
            }
        } while (!posicionValida);
        return posicion;
    }
    private static double leerDoubleValido() {
        double valor;
        while (true) {
            try {
                String input = sc.next();
                // Comprobamos si el valor tiene exactamente dos decimales después del punto
                if (input.matches("\\d+\\.\\d{2}")) {
                    valor = Double.parseDouble(input);
                    break;
                } else {
                    System.out.println("Por favor, ingrese un número válido con dos decimales después del punto.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        return valor;
    }
}