package modelo;

public class Tarifa {

	// public String rangoFecha;
	private String fechaInicio;
	private String fechaFin;
	private String diasSemana;
	private double precio;
	private TipoHabitacion tipoHabitacion;

	public Tarifa(String inicio, String fin, String PdiasSemana, double Pprecio, TipoHabitacion tipo) {
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.diasSemana = PdiasSemana;
		this.precio = Pprecio;
		this.tipoHabitacion = tipo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public String getDiasSemana() {
		return diasSemana;
	}

	public double getPrecio() {
		return precio;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

}
