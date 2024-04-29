package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	private int codigo;
	private String Descripcion;
	private double precioUnitario;
	private boolean activo;
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
	 * Constructor parametrizado
	 * @param codigo
	 * @param descripcion
	 * @param precioUnitario
	 * @param activo
	 * @param origenFabricacion
	 * @param categoria
	 */
	public Producto(int codigo, String descripcion, double precioUnitario, boolean activo,
			OrigenFabricacion origenFabricacion, Categoria categoria) {
		this.codigo = codigo;
		Descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.activo = activo;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	
	
	
}
