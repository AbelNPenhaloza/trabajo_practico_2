package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		//Precarga de los valores para las Provincias
		cargarValoresAProvincias();
		
		//Mostrar informacion de las provincias
		mostrarInformacionProvincias();
      
	}
	//Metodo para cargar los valores de las provincias
	private static void cargarValoresAProvincias() {
// Precarga de valores para las provincias
		
        Provincia.JUJUY.setCantidadPoblacion(811611);//datos 2022
        Provincia.JUJUY.setSuperficie(53219.76);

        Provincia.SALTA.setCantidadPoblacion(1333365);
        Provincia.SALTA.setSuperficie(155488.65);

        Provincia.TUCUMAN.setCantidadPoblacion(1687305);
        Provincia.TUCUMAN.setSuperficie(22524.8);

        Provincia.CATAMARCA.setCantidadPoblacion(367828);
        Provincia.CATAMARCA.setSuperficie(102602.1);

        Provincia.LA_RIOJA.setCantidadPoblacion(384607);
        Provincia.LA_RIOJA.setSuperficie(89680.6);

        Provincia.SANTIAGO_DEL_ESTERO.setCantidadPoblacion(988245);
        Provincia.SANTIAGO_DEL_ESTERO.setSuperficie(136351.81);
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
