package ar.edu.unju.fi.ejercicio3.constantes;

import java.text.DecimalFormat;

public enum Provincia {
	JUJUY,
	SALTA,
	TUCUMAN,
	CATAMARCA,
	LA_RIOJA,
	SANTIAGO_DEL_ESTERO;
	
	private Integer cantidadPoblacion;
	private Double superficie;
	/**
	 * Constructor Provincia
	 * @param cantidadPoblacion
	 * @param superficie
	 */
	private Provincia() {
		this.cantidadPoblacion = null;
		this.superficie = null;
	}
	//Metodo para calcular la densidad Poblacional de una Provincia.
	public double calcularDensidadPoblacional() {
		if(cantidadPoblacion != null && superficie != null && superficie !=0) {
			double densidad = (double)cantidadPoblacion / superficie;
			DecimalFormat df = new DecimalFormat ("#,##");
			
			return Double.parseDouble(df.format(densidad));
		}else {
			return 0.0;//Menejo cuando los valores no estan definidos
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
