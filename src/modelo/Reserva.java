package modelo;

import java.util.ArrayList;

public class Reserva {

	private String fechaI;
	private String fechaF;
	private Huesped huespedEncargado;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Huesped> huespedes;
	private ArrayList<Consumo> consumos;
	private Factura factura;

	public Reserva(String fechaInicio, String fechaFin, Huesped encargado, Factura lafactura) {
		habitaciones = new ArrayList<Habitacion>();
		huespedes = new ArrayList<Huesped>();
		consumos = new ArrayList<Consumo>();
		this.fechaI = fechaInicio;
		this.fechaF = fechaFin;
		this.huespedEncargado = encargado;
		this.factura = lafactura;

	}

	public String getFechaI() {
		return fechaI;
	}

	public String getFechaF() {
		return fechaF;
	}

	public Huesped getHuesped() {
		return huespedEncargado;
	}

	public ArrayList<Habitacion> addHabitaciones(Habitacion nuevoHabitacion) {
		habitaciones.add(nuevoHabitacion);
		return habitaciones;
	}

	public ArrayList<Huesped> addHuespedes(Huesped nuevoHuesped) {
		huespedes.add(nuevoHuesped);
		return huespedes;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public ArrayList<Huesped> getHuespedes() {
		return huespedes;
	}

	public ArrayList<Consumo> addConsumos(Consumo nuevoConsumo) {
		consumos.add(nuevoConsumo);
		return consumos;
	}

	public ArrayList<Consumo> getConsumos() {
		return consumos;
	}

	public Factura getFacturas() {
		return factura;
	}

	

}