package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.CalculadoraRF;
import controller.Sistema;
import modelo.Hotel;
import modelo.TipoHabitacion;

public class Consola {
	private static Sistema sistema;
	private static CalculadoraRF calculadora;

	public static String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {

		sistema = new Sistema();
		calculadora = new CalculadoraRF();

		System.out.println("Bienvenido al sistema de Hoteles");
		Hotel hotelito = sistema.getHotel();

		if (hotelito.getNombre() == null) {

			String nombreHotel = input("Por favor ingrese el nombre de su hotel");
			// hotelito=sistema.crearHotel(nombreHotel);

			hotelito = sistema.persistirHotel(nombreHotel);

		}

		System.out.println("Bienvenido al sistema del Hotel " + hotelito.getNombre());
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Oprime 1 si eres administrador");
		System.out.println("2. Oprime 2 si eres recepcionista");
		System.out.println("3. Oprime 3 si eres empleado");
		String selecion = input("Ingrese su rol");
		String login = input("Ingrese su login");
		String contrasena = input("Ingrese su contraseña");

		if (selecion.equals("1")) {
			System.out.println(login);
			boolean verificar = sistema.validarCedencialesAdmin(login, contrasena);
			if (verificar == true) {
				boolean working = true;
				System.out.println("Contraseña correcta");
				while (working == true) {

					System.out.println("Bienvenido administrador");
					System.out.println("\nOpciones de la aplicación\n");
					System.out.println("1. Cargar menu");
					System.out.println("2. Cargar nueva Bebidas");
					System.out.println("3. Cargar nuevo Plato");
					System.out.println("4. Crear habitación");
					System.out.println("5. Actualizar habitación");
					System.out.println("6. Actualizar tarifa de servicio");
					System.out.println("7. Actualizar habitación (archivo)");
					System.out.println("8. Actualizar menu (archivo)");
					System.out.println("9. presione e para terminar el menu");
					String opcion = input("Ingrese opcion para continuar");

					if (opcion.equals("1")) {
						String ubicacion = input("Ingrese ubicacion del restaurante");
						String diasDisponibles = input("Ingrese dias disponible");
						String horarios = input("Ingrese horarios de disponibilidad");
						calculadora.agregarMenu(ubicacion, diasDisponibles, horarios);
					} else if (opcion.equals("2")) {
						String nombreBebida = input("Ingrese nombre de la bebida");
						String tarifaBebida = input("Ingrese la tarifa");
						String tipoBebida = input("Ingrese tipo de comida (desayuno,almuerzo o comida)");
						String lugarBebida = input("Ingrese donde se puede comer (comedor o habitacion)");
						calculadora.cargarBebidaAlMenu(nombreBebida, tarifaBebida, tipoBebida, lugarBebida);
					} else if (opcion.equals("3")) {
						String nombrePlato = input("Ingrese nombre del plato");
						String tarifaPlato = input("Ingrese la tarifa");
						String tipoPlato = input("Ingrese tipo de comida (desayuno,almuerzo o comida)");
						String lugarPlato = input("Ingrese donde se puede comer (comedor/ habitacion/ SR)");
						calculadora.cargarBebidaAlMenu(nombrePlato, tarifaPlato, tipoPlato, lugarPlato);
					} else if (opcion.equals("4")) {
						String identificador = input("Ingrese identificador de la habitacion");
						String ubicacionHabi = input("Ingrese la ubicacion de la habitacion");
						String tipohabitacion = input(
								"Ingrese tipo de habitacion (1. Estandar,2. Suite o 3. suite doble)");
						String balcon = input("Ingrese si tiene balcon (true o false)");
						String vista = input("Ingrese si tiene vista (true o false)");
						String cocina = input("Ingrese si tiene cocina (true o false)");
						TipoHabitacion tipo = null;
						if (tipohabitacion.equals("1")) {
							tipo = TipoHabitacion.ESTANDAR;
						} else if (tipohabitacion.equals("2")) {
							tipo = TipoHabitacion.SUITE;
						} else {
							tipo = TipoHabitacion.SUITEDOBLE;
						}
						boolean balcontf = Boolean.parseBoolean(balcon);
						boolean vistatf = Boolean.parseBoolean(vista);
						boolean cocinatf = Boolean.parseBoolean(cocina);
						calculadora.agregarHabitacionIndividual(identificador, ubicacionHabi, tipo, balcontf, vistatf,
								cocinatf);
					} else if (opcion.equals("5")) {
						String identificador = input("Ingrese identificador de la habitacion");
						String ubicacionHabi = input("Ingrese la ubicacion de la habitacion");
						String tipohabitacion = input(
								"Ingrese tipo de habitacion (1. Estandar,2. Suite o 3. suite doble)");
						String balcon = input("Ingrese si tiene balcon (true o false)");
						String vista = input("Ingrese si tiene vista (true o false)");
						String cocina = input("Ingrese si tiene cocina (true o false)");
						String tipo = null;
						if (tipohabitacion.equals("1")) {
							tipo = "ESTANDAR";
						} else if (tipohabitacion.equals("2")) {
							tipo = "SUITE";
						} else {
							tipo = "SUITEDOBLE";
						}
						boolean balcontf = Boolean.parseBoolean(balcon);
						boolean vistatf = Boolean.parseBoolean(vista);
						boolean cocinatf = Boolean.parseBoolean(cocina);
						calculadora.actualizarHabitaciones(identificador, ubicacionHabi, tipo, balcon, vista, cocina);

					} else if (opcion.equals("6")) {
						String nombreServicio = input("Ingrese nombre del servicio");
						String tarifaServicio = input("Ingrese la tarifa");
						int nuevaTarifa = Integer.parseInt(tarifaServicio);
						calculadora.actualizarTarifaServicio(nombreServicio, nuevaTarifa);

					} else if (opcion.equals("7")) {
						String newInfo = input("Ingrese ubicacion del archivo actualizado");
						String oldInfo = "Data/Habitacion.txt";

						//calculadora.actualizarHabitacionesArchivo(oldInfo, newInfo);

					} else if (opcion.equals("8")) {
						String newInfoPlato = input("Ingrese ubicacion del archivo de platos actualizado");
						String oldInfoPlato = "Data/Plato.txt";
						String newInfoBebida = input("Ingrese ubicacion del archivo de bebidas actualizado");
						String oldInfoBebida = "Data/Bebida.txt";

						calculadora.actualizarPlatoArchivo(oldInfoPlato, newInfoPlato);
						calculadora.actualizarBebidaArchivo(oldInfoBebida, newInfoBebida);

					} else if (opcion.equals("e")) {
						working = false;
					}
				}

			} else {
				System.out.println("Contraseña incorrecta");
			}

		}
		if (selecion.equals("2")) {
			System.out.println(login);
			boolean verificar = sistema.validarCedencialesRecp(login, contrasena);
			if (verificar == true) {
				boolean working = true;
				System.out.println("Contraseña correcta");
				while (working == true) {

					System.out.println("Bienvenido Recepcionista");
					System.out.println("\nOpciones de la aplicación\n");
					System.out.println("1. Crear Reserva");
					System.out.println("2. Cancelar Reserva");
					System.out.println("3. REGISTRO DE ENTRADA");
					System.out.println("4. REGISTRO DE SALIDA");
					String opcion = input("Ingrese opcion para continuar");

					if (opcion.equals("1")) {
						String nombre = input("Ingrese el nombre del huesped");
						String IDH = input("Ingrese el ID del huesped");
						String email = input("Ingrese el correo electronico del huesped");
						String celular = input("Ingrese el numero de contacto del huesped");
						String Cpersonas = input("Ingrese el numero de personas adicionales");
						String Chabitaciones = input("Ingrese el numero de habitaciones deseadas");
						// como poner las habitaciones disponibles

						calculadora.crearReserva(nombre, IDH, email, celular, Cpersonas, Chabitaciones);

					} else if (opcion.equals("2")) {
						String nombre = input("Ingrese el nombre del huesped");
						String IDH = input("Ingrese el ID del huesped");
						String email = input("Ingrese el correo electronico del huesped");
						String celular = input("Ingrese el numero de contacto del huesped");
						String Cpersonas = input("Ingrese el numero de personas adicionales");
						String Chabitaciones = input("Ingrese el numero de habitaciones reservadas anteriormente");
						// no es necesario poner las habitaciones disponibles

						calculadora.cancelarReserva(nombre, IDH, email, celular, Cpersonas, Chabitaciones);

					} else if (opcion.equals("3")) {
						String nombre = input("Ingrese el nombre del huesped");
						String IDH = input("Ingrese el ID del huesped");
						String email = input("Ingrese el correo electronico del huesped");
						String celular = input("Ingrese el numero de contacto del huesped");
						String Cpersonas = input("Ingrese el numero de personas adicionales");
						int numP = Integer.parseInt(Cpersonas);

						if (numP > 0) {

							while (numP > 0) {

								String nombrePersonax = input("Ingrese el nombre del huesped");
								String IDHPersonax = input("Ingrese el ID del huesped");
								String emailPersonax = input("Ingrese el correo electronico del huesped");
								String celularPersonax = input("Ingrese el numero de contacto del huesped");

								numP--;

							}
						}

						calculadora.registrarEntrada(nombre, IDH, email, celular, Cpersonas);

					} else if (opcion.equals("4")) {

						String nombre = input("Ingrese el nombre del huesped");
						String IDH = input("Ingrese el ID del huesped");
						String email = input("Ingrese el correo electronico del huesped");
						String celular = input("Ingrese el numero de contacto del huesped");
						String identificador = input("Ingrese el ID de las habitaciones");
						String Cpersonas = input("Ingrese el numero de personas adicionales");
						String pago = input("Si/No realizo el pago total de inmediato en los servicios");

						if (calculadora.revisarConsumos(nombre, identificador) == true) {

							calculadora.crearFactura(nombre, identificador);
							calculadora.registrarSalida(nombre, IDH, email, celular, identificador, Cpersonas);
						} else {

							calculadora.registrarpago(nombre, identificador);

						}
					}
				}
			}
		}

		if (selecion.equals("3")) {
			System.out.println(login);
			boolean verificar = sistema.validarCedencialesEmp(login, contrasena);
			if (verificar == true) {
				boolean working = true;
				System.out.println("Contraseña correcta");
				while (working == true) {

					System.out.println("Bienvenido");
					System.out.println("\nRegistra un consumo\n");

					String nombre = input("Ingrese el nombre del huesped");
					String identificador = input("Ingrese el ID de las habitaciones");
					String consumo = input("Ingrese el tipo de consumo");
					String Nconsumo = input("Ingrese el nombre del consumo");
					String Pconsumo = input("Ingrese el precio de consumo");
					String pago = input("Ingrese True(si)/False(No) si se" + "\n"
							+ " realizo el pago total de inmediato en los servicios");

					String fileConsumo = "Data/ArchivodeconsumosRegistrados.txt";

					calculadora.registrarConsumo(fileConsumo, nombre, identificador, consumo, Nconsumo, Pconsumo, pago);

				}
			}
		}

	}

}

/*
 *
 *
 *
 *
 *
 * import javax.swing.*;
 * import javax.swing.table.*;
 * import java.awt.*;
 * import java.util.*;
 *
 * public class GithubCalendar {
 * public static void main(String[] args) {
 * JFrame frame = new JFrame("Github Calendar");
 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 *
 * JPanel panel = new JPanel(new BorderLayout());
 * panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
 *
 * JTable table = new JTable(new DefaultTableModel(7, 7));
 * table.setRowHeight(25);
 * table.setShowGrid(true);
 * table.setGridColor(Color.LIGHT_GRAY);
 *
 * Calendar calendar = Calendar.getInstance();
 * calendar.set(Calendar.DAY_OF_MONTH, 1);
 * int offset = calendar.get(Calendar.DAY_OF_WEEK) - 1;
 * int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
 *
 * for (int day = 1; day <= daysInMonth; day++) {
 * int row = (day + offset - 1) / 7;
 * int col = (day + offset - 1) % 7;
 * table.setValueAt(day, row, col);
 * }
 *
 * panel.add(table.getTableHeader(), BorderLayout.NORTH);
 * panel.add(table, BorderLayout.CENTER);
 *
 * frame.getContentPane().add(panel);
 * frame.pack();
 * frame.setVisible(true);
 * }
 * }
 */