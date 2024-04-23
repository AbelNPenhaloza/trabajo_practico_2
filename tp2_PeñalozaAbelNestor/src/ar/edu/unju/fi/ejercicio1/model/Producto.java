package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private int codigo;
	private String Descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	
	
	
	public enum OrigenFabricacion{
		ARGENTINA,
		CHINA,
		BRASIL,
		URUGUAY
	}
	public enum Categoria{
		TELEFONIA,
		INFORMATICA,
		ELECTROHOGAR,
		HERRAMIENTAS
	}
	
	/**
	 * 
	 */
	public Producto() {}

	/**
	 * @param codigo
	 * @param descripcion
	 * @param precioUnitario
	 * @param origenFabricacion
	 * @param categoria
	 */
	public Producto(int codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		this.codigo = codigo;
		Descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	
	//Metodos accesores
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto codigo= " + codigo + ", Descripcion= " + Descripcion + ", precioUnitario= " + precioUnitario
				+ ", origenFabricacion= " + origenFabricacion + ", categoria= " + categoria;
	}
	
	
}
