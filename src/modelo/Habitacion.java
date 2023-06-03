package modelo;

import java.util.ArrayList;

public class Habitacion {

	// ************************************************************************
	// Atributos
	// ************************************************************************

	private String identificador;
	private String ubicacion;
	private TipoHabitacion tipo;
	private boolean balcon;
	private boolean vista;
	private boolean cocina;
	private ArrayList<Cama> camas;
	private Tarifa tarifa;
	private boolean ocupacion;
	private int capacidadTotal;
	private int capacidadNiños;

	// ************************************************************************
	// Constructores
	// ************************************************************************
	public Habitacion(String id, String ubi, TipoHabitacion tipohabitacion, boolean tienebalcon, boolean tienevista,
			boolean tienecocina, boolean ocupada) {
		this.identificador = id;
		this.ubicacion = ubi;
		this.tipo = tipohabitacion;
		this.balcon = tienebalcon;
		this.vista = tienevista;
		this.cocina = tienecocina;
		this.ocupacion = ocupada;
		camas = new ArrayList<Cama>();
	}

	public Habitacion(String id, String ubi, TipoHabitacion tipohabitacion, boolean tienebalcon, boolean tienevista,
			boolean tienecocina, boolean ocupada, int tarifa) {
		this.identificador = id;
		this.ubicacion = ubi;
		this.tipo = tipohabitacion;
		this.balcon = tienebalcon;
		this.vista = tienevista;
		this.cocina = tienecocina;
		this.ocupacion = ocupada;
		camas = new ArrayList<Cama>();

	}

	public String getIdentificador() {
		return identificador;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public boolean getBalcon() {
		return balcon;
	}

	public boolean getVista() {
		return vista;
	}

	public boolean getCocina() {
		return cocina;
	}

	public ArrayList<Cama> getCamas() {
		return camas;
	}

	public void setCamas(ArrayList<Cama> camas) {
		this.camas = camas;
	}

	public ArrayList<Cama> addCama(Cama nuevaCama) {
		camas.add(nuevaCama);
		return camas;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public boolean getocupacion() {
		return ocupacion;
	}

	public void setOcupacion(boolean ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getCapacidadTotal() {
		return capacidadTotal;
	}

	public int getCapacidadNiños() {
		return capacidadNiños;
	}

	public int calculoCapacidadTotal() {
		int calculo = 0;
		for (int i = 0; i <= camas.size(); i++) {
			if (camas.get(i).getNumeroAdultos() != 0) {
				calculo = calculo + camas.get(i).getNumeroAdultos();
			}
		}
		return calculo;
	}

	public int calculoCapacidadNiños() {
		int calculo = 0;
		for (int i = 0; i <= camas.size(); i++) {
			if (camas.get(i).getNumeroNiños() != 0) {
				calculo = calculo + camas.get(i).getNumeroNiños();
			}
		}
		return calculo;
	}

	public String toString() {
		return "Identificador: " + this.identificador + ", Ubicacion: " + this.ubicacion + ", Tipo de Ubicacion: "
				+ this.tipo + ", Tiene balcon?: " + this.balcon + ", Tiene vista?: " + this.vista + ", Tiene cocina?: "
				+ this.cocina + ", Numero de camas: " + this.camas + ", Tarifa: " + this.tarifa + ", Ocupada?: "
				+ this.ocupacion;

	}

}
