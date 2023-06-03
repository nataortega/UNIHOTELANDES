package modelo;

import java.util.ArrayList;

public class Menu {

	private String ubicacion;
	private String dias;
	private String horarios;
	private ArrayList<Plato> platos;
	private ArrayList<Bebida> bebidas;

	public Menu(String ubi, String numerodias, String horas) {
		this.ubicacion = ubi;
		this.dias = numerodias;
		this.horarios = horas;
		platos = new ArrayList<Plato>();
		bebidas = new ArrayList<Bebida>();
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDias() {
		return dias;
	}

	public String getHorarios() {
		return horarios;
	}

	public ArrayList<Plato> addPlato(Plato nuevoPlato) {
		platos.add(nuevoPlato);
		return platos;
	}

	public ArrayList<Bebida> addBebida(Bebida nuevaBebida) {
		bebidas.add(nuevaBebida);
		return bebidas;
	}

	public ArrayList<Plato> getPlatos() {
		return platos;
	}

	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

}
