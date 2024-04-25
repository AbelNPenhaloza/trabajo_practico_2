package ar.edu.unju.fi.ejercicio3.constantes;

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
	 * @param cantidadPoblacion
	 * @param superficie
	 */
	private Provincia() {
		this.cantidadPoblacion = null;
		this.superficie = null;
	}
	//Metodo para calcular la densidad Poblacional de una Provincia.
	public Double calcularDensidadPoblacional() {
		if(cantidadPoblacion != null && superficie != null && superficie !=0) {
			return cantidadPoblacion / superficie;
		}else {
			return 0.0;
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
