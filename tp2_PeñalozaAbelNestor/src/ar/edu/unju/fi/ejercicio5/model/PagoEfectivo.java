package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	
	private double montoPagado;
	private LocalDate fechaPago;
	
	/**
	 * Constructor parametrizado
	 * @param montoPagado
	 * @param fechaPago
	 */
	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	@Override
	public void realizarPago(double monto) {
		DecimalFormat df = new DecimalFormat("#.##");
		this.montoPagado = Double.parseDouble(df.format(monto * 0.9));//aplica descuento del 10% 

	}

	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Pago con efectivo:");
        System.out.println("Fecha de pago: " + fechaPago.format(formatter));
        System.out.println("Monto pagado: " + montoPagado);

	}
	//Metodos accesores

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	

}
