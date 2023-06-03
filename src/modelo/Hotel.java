package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Hotel {

	private String nombre;
	// private TipoHabitacion tipos;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Reserva> reservas;
	private ArrayList<Servicio> servicios;
	private Menu restaurante;
	private Map<String, ArrayList<Tarifa>> tarifas;
	private Map<String, String> diaDelMes;
	private Map<String, ArrayList<Habitacion>> habitacionesDisponible;

	public Hotel(String elNombre, Menu menu) {
		this.nombre = elNombre;
		this.restaurante = menu;
		habitaciones = new ArrayList<Habitacion>();
		reservas = new ArrayList<Reserva>();
		servicios = new ArrayList<Servicio>();
		tarifas = new HashMap<String, ArrayList<Tarifa>>();
	}

	public Hotel(String elNombre) {
		this.nombre = elNombre;
		this.restaurante = null;
		habitaciones = new ArrayList<Habitacion>();
		reservas = new ArrayList<Reserva>();
		servicios = new ArrayList<Servicio>();
		tarifas = new HashMap<String, ArrayList<Tarifa>>();
	}

	public String getNombre() {
		return nombre;
	}

	// public TipoHabitacion getTipos() {
	// return tipos;
	// }
	public ArrayList<Habitacion> getHabitaciones() {

		return habitaciones;
	}

	public ArrayList<Reserva> getReservas() {

		return reservas;
	}

	public ArrayList<Servicio> getServicios() {

		return servicios;
	}

	public void addHabitacion(Habitacion nuevaHabitacion) {
		habitaciones.add(nuevaHabitacion);

	}

	public void replaceHabitacion(Habitacion nuevaHabitacion) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).getIdentificador().equals(nuevaHabitacion.getIdentificador())) {
				habitaciones.set(i, nuevaHabitacion);
			}
		}
	}

	public void addReservas(Reserva nuevaReserva) {
		reservas.add(nuevaReserva);

	}

	public void addServicios(Servicio nuevoServicio) {
		servicios.add(nuevoServicio);

	}

	public Menu getRestaurante() {
		return restaurante;
	}

	public Menu addRestaurante(Menu menu) {
		return this.restaurante = menu;
	}

	public Map<String, ArrayList<Tarifa>> getTarifas() {
		return tarifas;
	}

	public Map<String, ArrayList<Habitacion>> getHabitacionesDisponible() {
		return habitacionesDisponible;
	}

	public void llenarTarifas(String fecha, Tarifa tarifa) {
		// formato fecha debe ser DD-MM-AAAA
		// si el mes o dia solo tiene 1 numero poner solo ese numero 1/4/2023 1 de abril
		// de 2023
		// para buscar un mes de 2024 toca poner el numero del mes -12 o modulo 12 por
		// ejemplo el mes 14 seria febrero de 2024
		// pedir al usuario que solo ponga maximo fechas del 2024 si pone 2025 que le
		// diga que no
		// asegurarse de poner los dias que hay en el mes, es decir,enero no poner 32 o
		// en febrero no poner 30, si es 2023 febrero va hasta 28 y en 2024 febrero va
		// hasta 29
		String[] partesFecha = fecha.split("-");
		ArrayList<Tarifa> listaTarifas;

		if (partesFecha[2].equals("2024")) {
			int mes = Integer.parseInt(partesFecha[1]) + 12;
			String elMes = Integer.toString(mes);
			String formatoMesDia = elMes + "-" + partesFecha[0];
			if (tarifas.get(formatoMesDia).size() != 0) {
				listaTarifas = tarifas.get(formatoMesDia);
			} else {
				listaTarifas = new ArrayList<Tarifa>();
			}

			listaTarifas.add(tarifa);
			tarifas.put(formatoMesDia, listaTarifas);
		} else {
			String formatoMesDia = partesFecha[1] + "-" + partesFecha[0];
			if (tarifas.get(formatoMesDia).size() != 0) {
				listaTarifas = tarifas.get(formatoMesDia);
			} else {
				listaTarifas = new ArrayList<Tarifa>();
			}

			listaTarifas.add(tarifa);
			tarifas.put(formatoMesDia, listaTarifas);
		}
	}

	public List<Reserva> obtenerReservasDelDia(String fechaSeleccionada, List<Reserva> listaReservas) {
		ArrayList<Reserva> reservasDelDia = new ArrayList<Reserva>();
		for (Reserva reserva : listaReservas) {
			// se compara la fecha de inicio de la reserva con la fecha seleccionada
			if (reserva.getFechaI().equals(fechaSeleccionada)) {
				reservasDelDia.add(reserva);
			}
			// si la fecha de inicio y la fecha de fin son diferentes, se verifica también
			// la fecha de fin
			else if (!reserva.getFechaF().equals(reserva.getFechaI())
					&& reserva.getFechaF().equals(fechaSeleccionada)) {
				reservasDelDia.add(reserva);
			}
		}
		return reservasDelDia;
	}

	public void llenarDiaDelMes() {
		String fecha = null;
		int diaDeLaSemana;
		int contadorMeses = 1;
		int contadorDias = 0;
		int contadorAños = 2023;
		for (diaDeLaSemana = 0; contadorMeses <= 0 % 12 && contadorDias <= 31
				&& contadorAños <= 2024; diaDeLaSemana++) {

			if ((contadorMeses == 1 % 12 || contadorMeses == 3 % 12 || contadorMeses == 5 % 12
					|| contadorMeses == 7 % 12 ||
					contadorMeses == 8 % 12 || contadorMeses == 10 % 12 || contadorMeses == 0 % 12)
					&& contadorDias == 31) {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);
				String textoDia = saberDiaDeLaSemana(diaDeLaSemana);
				diaDelMes.put(fecha, textoDia);
				contadorDias = 1;
				contadorMeses = contadorMeses + 1;

			} else if ((contadorMeses == 4 % 12 || contadorMeses == 6 % 12 || contadorMeses == 9 % 12
					|| contadorMeses == 11 % 12) && contadorDias == 30) {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);
				String textoDia = saberDiaDeLaSemana(diaDeLaSemana);
				diaDelMes.put(fecha, textoDia);
				contadorDias = 1;
				contadorMeses = contadorMeses + 1;
			} else if (((contadorMeses == 2 % 12) && contadorDias == 28 && contadorAños == 2023)
					|| ((contadorMeses == 2 % 12) && contadorDias == 29 && contadorAños == 2024)) {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);
				String textoDia = saberDiaDeLaSemana(diaDeLaSemana);
				diaDelMes.put(fecha, textoDia);
				contadorDias = 1;
				contadorMeses = contadorMeses + 1;
			} else {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);
				String textoDia = saberDiaDeLaSemana(diaDeLaSemana);
				diaDelMes.put(fecha, textoDia);
				contadorDias++;
			}
		}
		if (contadorMeses == 0 % 12 && contadorDias == 31) {
			contadorDias = 1;
			contadorMeses = 1;
			contadorAños = 2024;
		}
	}

	public String saberDiaDeLaSemana(int identificadorDia) {
		String dia = null;
		if (identificadorDia == 0 % 7) {
			dia = "Domingo";
		} else if (identificadorDia == 1 % 7) {
			dia = "Lunes";
		} else if (identificadorDia == 2 % 7) {
			dia = "Martes";
		} else if (identificadorDia == 3 % 7) {
			dia = "Miercoles";
		} else if (identificadorDia == 4 % 7) {
			dia = "Jueves";
		} else if (identificadorDia == 5 % 7) {
			dia = "Viernes";
		} else {
			dia = "Sabado";
		}
		return dia;
	}

	public void llenarHabitacionesDisponibles() {
		int contadorMeses = 1;
		int contadorDias = 0;
		int contadorAños = 2023;
		String fecha = null;
		for (int i = 0; contadorMeses <= 0 % 12 && contadorDias <= 31 && contadorAños <= 2024; i++) {

			if ((contadorMeses == 1 % 12 || contadorMeses == 3 % 12 || contadorMeses == 5 % 12
					|| contadorMeses == 7 % 12 ||
					contadorMeses == 8 % 12 || contadorMeses == 10 % 12 || contadorMeses == 0 % 12)
					&& contadorDias == 31) {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);

				habitacionesDisponible.put(fecha, habitaciones);
				contadorDias = 1;
				contadorMeses = contadorMeses + 1;

			} else if ((contadorMeses == 4 % 12 || contadorMeses == 6 % 12 || contadorMeses == 9 % 12
					|| contadorMeses == 11 % 12) && contadorDias == 30) {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);

				habitacionesDisponible.put(fecha, habitaciones);
				contadorDias = 1;
				contadorMeses = contadorMeses + 1;
			} else if (((contadorMeses == 2 % 12) && contadorDias == 28 && contadorAños == 2023)
					|| ((contadorMeses == 2 % 12) && contadorDias == 29 && contadorAños == 2024)) {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);
				habitacionesDisponible.put(fecha, habitaciones);
				contadorDias = 1;
				contadorMeses = contadorMeses + 1;
			} else {
				fecha = Integer.toString(contadorDias) + "-" + Integer.toString(contadorMeses) + "-"
						+ Integer.toString(contadorAños);
				habitacionesDisponible.put(fecha, habitaciones);
				contadorDias++;
			}
		}
		if (contadorMeses == 0 % 12 && contadorDias == 31) {
			contadorDias = 1;
			contadorMeses = 1;
			contadorAños = 2024;
		}
		for (Reserva laReserva : reservas) {
			String fechaInicial = laReserva.getFechaI();
			String fechaActual = fechaInicial;
			String fechaFinal = laReserva.getFechaF();
			ArrayList<Habitacion> lasHabitaciones = laReserva.getHabitaciones();
			while (fechaActual.equals(fechaFinal) == false) {
				ArrayList<Habitacion> listaHabitacionesEnReserva = habitacionesDisponible.get(fechaActual);
				for (Habitacion laHabitacion : lasHabitaciones) {
					listaHabitacionesEnReserva.remove(laHabitacion);
				}
				String[] partesFecha = fechaActual.split("-");
				int elDia = Integer.parseInt(partesFecha[0]);
				int elMes = Integer.parseInt(partesFecha[1]);
				int elAño = Integer.parseInt(partesFecha[2]);
				if ((elMes == 1 % 12 || elMes == 3 % 12 || elMes == 5 % 12 || elMes == 7 % 12 ||
						elMes == 8 % 12 || elMes == 10 % 12 || elMes == 0 % 12) && elDia == 31) {
					elDia = 1;
					elMes = elMes + 1;

				} else if ((elMes == 4 % 12 || elMes == 6 % 12 || elMes == 9 % 12 || elMes == 11 % 12) && elDia == 30) {
					elDia = 1;
					elMes = elMes + 1;
				} else if (((elMes == 2 % 12) && elMes == 28 && elAño == 2023)
						|| ((elMes == 2 % 12) && elMes == 29 && elAño == 2024)) {
					elDia = 1;
					elMes = elMes + 1;
				} else {
					elDia++;
				}
				fechaActual = Integer.toString(elDia) + "-" + Integer.toString(elMes) + "-" + Integer.toString(elAño);

			}

		}

	}

	public void actualizarHabitacionesDisponibles(Reserva laReserva) {
		String fechaInicial = laReserva.getFechaI();
		String fechaActual = fechaInicial;
		String fechaFinal = laReserva.getFechaF();
		ArrayList<Habitacion> lasHabitaciones = laReserva.getHabitaciones();
		while (fechaActual.equals(fechaFinal) == false) {
			ArrayList<Habitacion> listaHabitacionesEnReserva = habitacionesDisponible.get(fechaActual);
			for (Habitacion laHabitacion : lasHabitaciones) {
				listaHabitacionesEnReserva.remove(laHabitacion);
			}
			String[] partesFecha = fechaActual.split("-");
			int elDia = Integer.parseInt(partesFecha[0]);
			int elMes = Integer.parseInt(partesFecha[1]);
			int elAño = Integer.parseInt(partesFecha[2]);
			if ((elMes == 1 % 12 || elMes == 3 % 12 || elMes == 5 % 12 || elMes == 7 % 12 ||
					elMes == 8 % 12 || elMes == 10 % 12 || elMes == 0 % 12) && elDia == 31) {
				elDia = 1;
				elMes = elMes + 1;

			} else if ((elMes == 4 % 12 || elMes == 6 % 12 || elMes == 9 % 12 || elMes == 11 % 12) && elDia == 30) {
				elDia = 1;
				elMes = elMes + 1;
			} else if (((elMes == 2 % 12) && elMes == 28 && elAño == 2023)
					|| ((elMes == 2 % 12) && elMes == 29 && elAño == 2024)) {
				elDia = 1;
				elMes = elMes + 1;
			} else {
				elDia++;
			}
			fechaActual = Integer.toString(elDia) + "-" + Integer.toString(elMes) + "-" + Integer.toString(elAño);

		}

	}
}
