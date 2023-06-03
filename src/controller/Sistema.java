package controller;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Administrador;
import modelo.Recepcionista;
import modelo.Bebida;
import modelo.Cama;
import modelo.DisponibilidadComidas;
import modelo.DisponibilidadLugar;
import modelo.Empleado;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Plato;
import modelo.Servicio;
import modelo.Tarifa;
import modelo.TipoHabitacion;
import modelo.TipoHuesped;

public class Sistema {
	private Hotel hotel;
	private List<Administrador> administradores;
	private List<Recepcionista> recepcionista;
	private List<Empleado> empleado;

	public static void main(String[] args) {
		Sistema sistema = new Sistema();

		try {
			List<Bebida> bebidas = sistema.cargarBebidas();
			for (Bebida bebida : bebidas) {
				System.out.println(bebida);
			}
			System.out.println("Success 1");

			List<Habitacion> habitaciones = sistema.cargarHabitaciones();
			for (Habitacion habitacion : habitaciones) {
				System.out.println(habitacion);
			}
			System.out.println("Success 2");

			List<Plato> platos = sistema.cargarPlatos();
			for (Plato plato : platos) {
				System.out.println(plato);
			}
			System.out.println("Success 3");

			List<Servicio> servicios = sistema.cargarServicios();
			for (Servicio servicio : servicios) {
				System.out.println(servicio);
			}
			System.out.println("Success 4");

			sistema.crearHotel(sistema.cargarNombreHotel());
			System.out.println(sistema.hotel.getNombre());

		} catch (IOException e) {
			System.err.println("Error cargando datos: " + e.getMessage());
		}
	}

	public Sistema() {
		administradores = new ArrayList<Administrador>();
		recepcionista = new ArrayList<Recepcionista>();
		empleado = new ArrayList<Empleado>();

		cargarUsuarios();
	}

	private void cargarUsuarios() {
		// TODO Auto-generated method stub
		Administrador admin = new Administrador("Administrador1", "Uniandes");
		administradores.add(admin);

		Recepcionista receptcionist = new Recepcionista("Recepcionista1", "Huniandes");
		recepcionista.add(receptcionist);

		Empleado Vempleado = new Empleado("EmpleadoS", "Serviuniandes");
		empleado.add(Vempleado);

	}

	public Hotel getHotel() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Data/Hotel.txt"));
			String linea = br.readLine();

			Hotel hotelito = crearHotel(linea);
			return hotelito;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Hotel crearHotel(String elNombre) {
		hotel = new Hotel(elNombre);

		return hotel;
	}

	public Hotel persistirHotel(String nombreHotelito) {
		Hotel hotelito = crearHotel(nombreHotelito);

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("Data/Hotel.txt"));
			writer.write(nombreHotelito);
			writer.close();
			System.out.println("Success");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return hotelito;
	}

	public boolean validarCedencialesAdmin(String login, String contrasena) {
		System.out.println(administradores.size());
		boolean encontre = false;
		for (int i = 0; i < administradores.size(); i++) {
			System.out.println(login);
			System.out.println(administradores.get(i).getLogin());
			if (administradores.get(i).getLogin().equals(login)) {
				if (administradores.get(i).getContrasena().equals(contrasena)) {
					encontre = true;
				}
			}
		}
		return encontre;
	}

	public boolean validarCedencialesRecp(String login, String contrasena) {
		System.out.println(recepcionista.size());
		boolean encontre = false;
		for (int i = 0; i < recepcionista.size(); i++) {
			System.out.println(login);
			System.out.println(recepcionista.get(i).getLogin());
			if (recepcionista.get(i).getLogin().equals(login)) {
				if (recepcionista.get(i).getContrasena().equals(contrasena)) {
					encontre = true;
				}
			}
		}
		return encontre;
	}

	public boolean validarCedencialesEmp(String login, String contrasena) {
		System.out.println(empleado.size());
		boolean encontre = false;
		for (int i = 0; i < empleado.size(); i++) {
			System.out.println(login);
			System.out.println(empleado.get(i).getLogin());
			if (empleado.get(i).getLogin().equals(login)) {
				if (empleado.get(i).getContrasena().equals(contrasena)) {
					encontre = true;
				}
			}
		}
		return encontre;
	}

	public List<Habitacion> cargarHabitaciones() throws IOException {
		String nombreArchivo = "Data/Habitacion.txt";
		BufferedReader br1 = new BufferedReader(new FileReader(nombreArchivo));
		String lineaHabitacion = br1.readLine();
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		while (lineaHabitacion != null && !lineaHabitacion.equals("")) {
			System.out.println(1);
			System.out.println(lineaHabitacion);
			System.out.println("enter");
			TipoHabitacion tipo = null;
			String[] partes = lineaHabitacion.split(";");
			String id = partes[0];
			String ubi = partes[1];
			if (partes[2].equals("ESTANDAR")) {
				tipo = TipoHabitacion.ESTANDAR;
			} else if (partes[2].equals("SUITE")) {
				tipo = TipoHabitacion.SUITE;
			} else if (partes[2].equals("SUITEDOBLE")) {
				tipo = TipoHabitacion.SUITEDOBLE;
			}
			boolean balcon = Boolean.parseBoolean(partes[3]);
			boolean vista = Boolean.parseBoolean(partes[4]);
			boolean cocina = Boolean.parseBoolean(partes[5]);
			boolean ocupada = Boolean.parseBoolean(partes[6]);
			int tarifa = Integer.parseInt(partes[7]);
			Habitacion laHabitacion = new Habitacion(id, ubi, tipo, balcon, vista, cocina, ocupada, tarifa);
			String[] camas = partes[8].split("/");
			for (String elemento : camas) {
				String[] parteCama = elemento.split(",");
				String tamaño = parteCama[0];
				TipoHuesped tipoHuesped = parteCama[1].equals("niños") ? TipoHuesped.niños : TipoHuesped.adultos;
				int niños = Integer.parseInt(parteCama[2]);
				int adultos = Integer.parseInt(parteCama[3]);
				Cama nuevaCama = new Cama(tamaño, tipoHuesped, niños, adultos);
				laHabitacion.addCama(nuevaCama);
			}
			habitaciones.add(laHabitacion);
			lineaHabitacion = br1.readLine();

		}
		br1.close();
		return habitaciones;

	}

	// Load data from file Bebidas.txt and create a list of Bebida objects
	// Return the list of Bebida objects
	public List<Bebida> cargarBebidas() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Data/Bebida.txt"));
		DisponibilidadLugar lugar;
		DisponibilidadComidas comida;
		List<Bebida> bebidas = new ArrayList<Bebida>();
		String linea = br.readLine();
		while (linea != null && !linea.equals("")) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String tarifa = partes[1];
			String tipo = partes[2];
			if (tipo.equals("comida"))
				comida = DisponibilidadComidas.comida;
			else if (tipo.equals("almuerzo"))
				comida = DisponibilidadComidas.almuerzo;
			else if (tipo.equals("desayuno"))
				comida = DisponibilidadComidas.desayuno;
			else
				comida = DisponibilidadComidas.permanente;

			String dispoLugar = partes[3];
			if (dispoLugar.equals("comedor"))
				lugar = DisponibilidadLugar.comedor;
			else
				lugar = DisponibilidadLugar.habitacion;

			int precio = Integer.parseInt(tarifa);
			Bebida bebida = new Bebida(nombre, precio, comida, lugar);
			bebidas.add(bebida);
			linea = br.readLine();
		}
		br.close();

		return bebidas;
	}

	// Load data from Plato.txt and create a list of Plato objects
	// Return the list of Plato objects
	public List<Plato> cargarPlatos() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Data/Plato.txt"));
		DisponibilidadLugar lugar;
		DisponibilidadComidas comida;
		List<Plato> platos = new ArrayList<Plato>();
		String linea = br.readLine();
		while (linea != null && !linea.equals("")) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String tarifa = partes[1];
			String tipo = partes[2];
			if (tipo.equals("comida"))
				comida = DisponibilidadComidas.comida;
			else if (tipo.equals("almuerzo"))
				comida = DisponibilidadComidas.almuerzo;
			else if (tipo.equals("desayuno"))
				comida = DisponibilidadComidas.desayuno;
			else
				comida = DisponibilidadComidas.permanente;

			String dispoLugar = partes[3];
			if (dispoLugar.equals("comedor"))
				lugar = DisponibilidadLugar.comedor;
			else
				lugar = DisponibilidadLugar.habitacion;

			int precio = Integer.parseInt(tarifa);
			Plato plato = new Plato(nombre, precio, comida, lugar);
			platos.add(plato);
			linea = br.readLine();
		}
		br.close();

		return platos;
	}

	// Load data from Servicio.txt and create a list of Servicio objects
	// Return the list of Servicio objects
	public List<Servicio> cargarServicios() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Data/Servicio.txt"));
		List<Servicio> servicios = new ArrayList<Servicio>();
		String linea = br.readLine();
		while (linea != null && !linea.equals("")) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String ubi = partes[1];
			String tarifa = partes[2];
			String dias = partes[3];
			String horario = partes[4];

			int precio = Integer.parseInt(tarifa);
			Servicio servicio = new Servicio(nombre, ubi, precio, dias, horario);
			servicios.add(servicio);
			linea = br.readLine();
		}
		br.close();

		return servicios;
	}

	// Load the name of the hotel from the file Hotel.txt
	// Return the name of the hotel
	public String cargarNombreHotel() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Data/Hotel.txt"));
		String nombre = br.readLine();
		br.close();
		return nombre;
	}

}
