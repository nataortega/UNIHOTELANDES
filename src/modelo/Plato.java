package modelo;

public class Plato {

	private String nombre;
	private int tarifa;
	private DisponibilidadComidas tipoComida;
	private DisponibilidadLugar tipoLugar;

	public Plato(String elNombre, int laTarifa, DisponibilidadComidas comidaTipo, DisponibilidadLugar lugarTipo) {
		this.nombre = elNombre;
		this.tarifa = laTarifa;
		this.tipoComida = comidaTipo;
		this.tipoLugar = lugarTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public DisponibilidadComidas getDisponibilidad() {
		return tipoComida;
	}

	public DisponibilidadLugar getLugar() {
		return tipoLugar;
	}

	public void setTipoComida(DisponibilidadComidas tipoComida) {
		this.tipoComida = tipoComida;
	}

	public void setTipoLugar(DisponibilidadLugar tipoLugar) {
		this.tipoLugar = tipoLugar;
	}

	public String toString() {
		return this.nombre + this.tarifa + this.tipoComida + this.tipoLugar;

	}
}
