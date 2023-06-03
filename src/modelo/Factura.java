package modelo;

import java.util.ArrayList;

public class Factura {
	private int numero;
	private String fecha;
	// private Huesped huesped;
	// private Habitacion habitacion;
	// private ArrayList<Consumo> consumos;
	// private double impuestos=0;
	private Reserva reserva;
	private double total = 0;

	public Factura(int num, String laFecha, Reserva laReserva) {
		this.numero = num;
		this.fecha = laFecha;
		this.reserva = laReserva;
	}

	public int getNumero() {
		return numero;
	}

	public String getFecha() {
		return fecha;
	}

	/**
	 * public Huesped getHuesped() {
	 * return huesped;
	 * }
	 * public Habitacion getHabitacion() {
	 * return habitacion;
	 * }
	 * 
	 * }
	 * public double getImpuestos() {
	 * for (Consumo consumo : consumos)
	 * {
	 * double ip= consumo.getImpuestos();
	 * impuestos=impuestos+ip;
	 * }
	 * return impuestos;
	 * }
	 */

	public double getTotal() {
		ArrayList<Consumo> consumos = reserva.getConsumos();
		for (Consumo consumo : consumos) {
			double valor = consumo.getValor();
			total = total + valor;
		}
		return total;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	/**
	 * public ArrayList<Consumo> addConsumos(Consumo nuevoConsumo){
	 * consumos.add(nuevoConsumo);
	 * return consumos;
	 * }
	 * public ArrayList<Consumo> getConsumos(){
	 * return consumos;
	 * }
	 */
}
