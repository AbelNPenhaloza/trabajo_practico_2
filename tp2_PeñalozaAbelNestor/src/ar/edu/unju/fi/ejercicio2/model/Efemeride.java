package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private Integer codigo;
	private Mes mes;
	private Byte dia;
	private String detalle;
	/**
	 * Constructor por defecto
	 */
	public Efemeride() {}
	
	/**
	 * Constructor Parametrizado
	 * @param codigo
	 * @param mes
	 * @param dia
	 * @param detalle
	 */
	public Efemeride(Integer codigo, Mes mes, Byte dia, String detalle) {
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}
	/**
	 * Metodos accesores de la clase Efemerides
	 */

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Byte getDia() {
		return dia;
	}

	public void setDia(Byte dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	/**
	 * Metodo toString
	 */

	@Override
	public String toString() {
		return "Efemeride codigo= " + codigo + ", mes= " + mes + ", dia= " + dia + ", detalle= " + detalle;
	}
	
	
	
}
