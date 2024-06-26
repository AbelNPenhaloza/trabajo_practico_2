package ar.edu.unju.ejercicio6.model;

public class FelinoSalvaje {
	private String nombre;
	private byte edad;
	private float peso;
	
	
	/**
	 * Constructor por defecto
	 */
	public FelinoSalvaje() {}


	/**
	 * Constructor parametrizado
	 * @param nombre
	 * @param edad
	 * @param peso
	 */
	public FelinoSalvaje(String nombre, byte edad, float peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}
	//Metodos accesores


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public byte getEdad() {
		return edad;
	}


	public void setEdad(byte edad) {
		this.edad = edad;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	@Override
	public String toString() {
		return "FelinoSalvaje nombre= " + nombre + ", edad= " + edad + ", peso= " + peso;
	}
	
	
}
