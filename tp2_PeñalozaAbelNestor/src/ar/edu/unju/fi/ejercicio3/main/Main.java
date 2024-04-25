package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		//Mostrar informacion de las provincias
		mostrarInformacionProvincias();
      
	}
	
	//Metodo para mostrar informacion de las provincias
	private static void mostrarInformacionProvincias() {
		Provincia [] provincias = Provincia.values();
		
		System.out.println("Informacion de las Provincias");
		
		for(Provincia provincia : provincias) {
			System.out.println("Provincia: " + provincia);
			System.out.println("Cantidad de poblacion: " + provincia.getCantidadPoblacion()+ " hab.");
			System.out.println("Superficie: " + provincia.getSuperficie()+ " km\u00B2");
			System.out.println("Densidad Poblacional: " + provincia.calcularDensidadPoblacional()+ " hab./km\u00B2");
			System.out.println();
		}
		
	}
}
