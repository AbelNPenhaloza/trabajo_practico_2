package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	
	/**
	 * Constructor parametrizado.
	 * @param numeroTarjeta
	 * @param fechaPago
	 * @param montoPagado
	 */
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public void realizarPago(double monto){
		DecimalFormat df = new DecimalFormat("#.##");
		this.montoPagado = Double.parseDouble(df.format(monto * 1.15));//Agrega el 15% al monto por la recarga.
	}
	@Override
	public void imprimirRecibo(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Pago con tarjeta:");
        System.out.println("Número de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago.format(formatter));
        System.out.println("Monto pagado: " + montoPagado);
	}
	
	//Metodos accesores
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
}
