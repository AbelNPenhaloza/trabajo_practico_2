package ar.edu.unju.ejercicio6.main;

import ar.edu.unju.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		//Crear un felino domestico
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
		
		//Definicion de la expresion lambda que define el convertidor de FD a FS.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje
				(x.getNombre(), x.getEdad(), x.getPeso());
		
		//Mostrar la conversion de Garfield de domestico a salvaje
		convertirYMostrar(gato, converter, "domestico", "salvaje");
		
		//Crearun felino salvaje Tanner
		FelinoSalvaje felinoSalvajeTanner = new FelinoSalvaje("Tanner", (byte)20,186f);
		//Verificar si el felino salvaje Tanner no es nulo antes de la conversion.
		if(Converter.isNotNull(felinoSalvajeTanner)) {
			
			//Definir un nuevo convertidor para convertir de FS a FD
			Converter<FelinoSalvaje, FelinoDomestico> reverseConverter = x -> new FelinoDomestico
					(x.getNombre(), x.getEdad(), x.getPeso());
			//Realizar la conversion de Tanner de salvaje a domestico
			convertirYMostrar(felinoSalvajeTanner, reverseConverter, "salvaje", "domestico");
		}else {
			System.out.println("El felino salvaje Tanner es nulo.");
		}
		
		
	}	
		
	private static <T, T1> void convertirYMostrar(T felino, Converter<T, T1> converter, String origen, String destino) {
	    if (Converter.isNotNull(felino)) {
	        System.out.println("Estado original del felino " + origen + ":");
	        System.out.println(felino.toString());
	        System.out.println();
	        T1 felinoConvertido = converter.converter(felino);
	        System.out.println("Estado después de la conversión del felino " + origen + " a " + destino + ":");
	        converter.mostrarObjeto(felinoConvertido);
	        System.out.println();
	    } else {
	        System.out.println("El felino " + origen + " es nulo.");
	    }
	}
}
