package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private Double estatura;
	private Double peso;
	private Posicion posicion;
	/**
	 * Constructor por defecto
	 */
	public Jugador() {}
	/**
	 * Constructor parametrizado
	 * @param nombre del Jugador
	 * @param apellido del Jugador
	 * @param fechaNacimiento del Jugador
	 * @param nacionalidad del Jugador
	 * @param estatura del Jugador
	 * @param peso del Jugador
	 * @param posicion del jugador
	 */
	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, Double estatura,
			Double peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}
	
	// Metodos para calcular la edad del Jugador
	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, fechaActual);
		return periodo.getYears();
	}
		
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
}
