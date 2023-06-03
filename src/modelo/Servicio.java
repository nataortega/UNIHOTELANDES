package modelo;

public class Servicio {

	private String nombre;
	private String ubicacion;
	private int tarifa;
	private String dias;
	private String horario;

	public Servicio(String elNombre, String laUbicacion, int laTarifa, String losDias, String elHorario) {
		this.nombre = elNombre;
		this.ubicacion = laUbicacion;
		this.tarifa = laTarifa;
		this.dias = losDias;
		this.horario = elHorario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public String getDias() {
		return dias;
	}

	public String getHorario() {
		return horario;
	}

	public String toString() {
		return this.nombre + this.ubicacion + this.tarifa + this.dias + this.horario;

	}

}
