package ar.edu.unju.fi.ejercicio3.constantes;

import java.text.DecimalFormat;

public enum Provincia {
	JUJUY(811611, 53219.76),//datos 2022
    SALTA(1333365, 155488.65),
    TUCUMAN(1687305, 22524.8),
    CATAMARCA(367828, 102602.1),
    LA_RIOJA(384607, 89680.6),
    SANTIAGO_DEL_ESTERO(988245, 136351.81);
	
	private Integer cantidadPoblacion;
	private Double superficie;
	/**
	 * Constructor Provincia
	 * @param cantidadPoblacion
	 * @param superficie
	 */
	private Provincia(Integer cantidadPoblacion, Double superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }
	//Metodo para calcular la densidad Poblacional de una Provincia.
	public double calcularDensidadPoblacional() {
		if(cantidadPoblacion != null && superficie != null && superficie !=0) {
			double densidad = (double)cantidadPoblacion / superficie;
			DecimalFormat df = new DecimalFormat ("#,##");
			
			return Double.parseDouble(df.format(densidad));
		}else {
			return 0.0;//Manejo cuando los valores no estan definidos
		}
	}
	//Metodos accesores
	
	public Integer getCantidadPoblacion() {
		return cantidadPoblacion;
	}
	public void setCantidadPoblacion(Integer cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}
	public Double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

	
}
