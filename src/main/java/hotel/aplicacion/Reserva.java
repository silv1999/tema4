/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Silvia
 */
public class Reserva {
	private static int contadorReservas = 0;
	private int codigoReserva;
	private Cliente cliente;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private TipoHabitacion tipoHabitacion;
	private boolean camaSupletoria;
	private double costeTotal;

	// Constantes fijas para el precio
	private static final double PRECIO_DOBLE = 50.0;
	private static final double PRECIO_SUITE = 100.0;
	private static final double RECARGO_CAMA_SUPLETORIA = 20.0;

	public Reserva(Cliente cliente, LocalDate fechaEntrada, LocalDate fechaSalida, TipoHabitacion tipoHabitacion,
			boolean camaSupletoria) throws Exception {
		if (!fechaSalida.isAfter(fechaEntrada)) {
			throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
		}
		this.codigoReserva = obtenerCodigoReserva();
		this.cliente = cliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.tipoHabitacion = tipoHabitacion;
		this.camaSupletoria = camaSupletoria;
		this.costeTotal = calcularCosteTotal();
	}

	private static int obtenerCodigoReserva() {
		contadorReservas++;
		return contadorReservas;
	}
	/**
	 *Calcula el coste total de la reserva en función del número de noches
	 *tipo de habitación y si se solicita cama supletoria
	 *
	 *-Habitación doble= 50€
	 *-Habitación suite= 100€
	 *-Cama supletoria= 20€
	 *
	 * Si la estancia supera los 7 días se aplica un 10% de descuento
	 * @return Coste total 
	 */

	public double calcularCosteTotal() {
		long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		double precioNoche = (tipoHabitacion == TipoHabitacion.DOBLE) ? PRECIO_DOBLE : PRECIO_SUITE;

		if (camaSupletoria) {
			precioNoche += RECARGO_CAMA_SUPLETORIA;
		}
		double total = noches * precioNoche;
		if (noches > 7) {
			total *= 0.9; // Aplica un descuento del 10%
		}
		return total;
	}

	public String mostrarDetalles() {
		String detalles = "Código Reserva: " + codigoReserva + "\n" + "Cliente: " + cliente.mostrarInformacion() + "\n"
				+ "Fecha de Entrada: " + fechaEntrada + "\n" + "Fecha de Salida: " + fechaSalida + "\n"
				+ "Tipo de Habitación: " + tipoHabitacion + "\n" + "Cama Supletoria: " + (camaSupletoria ? "Sí" : "No")
				+ "\n" + "Coste Total: " + costeTotal + "Euros";
		return detalles;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public boolean isCamaSupletoria() {
		return camaSupletoria;
	}

	public double getCosteTotal() {
		return costeTotal;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) throws Exception {
		if (fechaSalida != null && !fechaSalida.isAfter(fechaEntrada)) {
			throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
		}
		this.fechaEntrada = fechaEntrada;
		this.costeTotal = calcularCosteTotal();
	}

	public void setFechaSalida(LocalDate fechaSalida) throws Exception {
		if (fechaEntrada != null && !fechaSalida.isAfter(fechaEntrada)) {
			throw new Exception("La fecha de salida debe ser posterior a la de entrada.");
		}
		this.fechaSalida = fechaSalida;
		this.costeTotal = calcularCosteTotal();
	}
}