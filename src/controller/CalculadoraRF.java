package controller;

import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Hotel;
import modelo.Menu;
import modelo.TipoHabitacion;
import modelo.Habitacion;
import modelo.Bebida;
import modelo.DisponibilidadComidas;
import modelo.DisponibilidadLugar;
import modelo.Plato;
import modelo.Servicio;

public class CalculadoraRF {
	private Hotel hotel = new Hotel("Sommersprossen");
	private Sistema sistema;
	private Menu menu;

	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

	}

	public CalculadoraRF() {

	}

	public void agregarHabitacionIndividual(String id, String ubi, TipoHabitacion tipoHabi, boolean balcon,
			boolean vista, boolean cocina) throws IOException {

		if (!checkifHabitacionExists(id)) {
			Habitacion habi = new Habitacion(id, ubi, tipoHabi, balcon, vista, cocina, false);
			hotel.addHabitacion(habi);
		}
		BufferedWriter writer;
		String laHabitacion = id + ";" + ubi + ";" + String.valueOf(tipoHabi) + ";" + String.valueOf(balcon) + ";"
				+ String.valueOf(vista)
				+ ";" + String.valueOf(cocina) + ";" + "false";
		BufferedReader reader = new BufferedReader(new FileReader("Data/Habitacion.txt"));

		// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
		// lista.
		String line;

		List<String> lines = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {

			lines.add(line);

		}
		lines.add(laHabitacion);
		try {
			writer = new BufferedWriter(new FileWriter("Data/Habitacion.txt"));
			for (int i = 0; i < lines.size(); i++) {
				writer.write(lines.get(i));
				writer.newLine();
			}

			writer.close();
			System.out.println("Success");
			reader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public boolean checkifHabitacionExists(String id) {

		List<Habitacion> habitaciones = hotel.getHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getIdentificador().equals(id)) {
				System.out.println("Ya existe una habitacion con ese identificador");
				return true;
			}
		}

		return false;
	}

	public void actualizarHabitaciones(String id, String ubi, String tipoHabi, String balcon,
			String vista, String cocina) throws IOException {

		String archivo = "Data/Habitacion.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesHabitacion = line.split(";");
				if (partesHabitacion[0].equals(id)) {
					String ocupacion = partesHabitacion[6];
					String newLineContent = id + ";" + ubi + ";" + tipoHabi + ";" + balcon + ";" + vista + ";" + cocina
							+ ";" + ocupacion;

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();

			}
			writer.close();

			System.out.println("La habitación ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarHabitaciones(List<Habitacion> habitaciones) {
		try {
			File archivo = new File("Data/Habitaciones.txt");
			boolean existe = archivo.exists();
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			if (!existe) {
				bw.write("Numero;Tipo;Precio;Estado");
				bw.newLine();
			}
			for (Habitacion habitacion : habitaciones) {
				String linea = habitacion.getIdentificador() + ";" + habitacion.getTipo() + ";"
						+ habitacion.getUbicacion() + ";"
						+ habitacion.getBalcon();
				bw.write(linea);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// quitar esta

	public void cargarHabitaciones(String id, String ubi, TipoHabitacion tipoHabi, boolean balcon,
			boolean vista, boolean cocina) throws IOException {
		List<Habitacion> habitaciones = sistema.cargarHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			if (!checkifHabitacionExists(habitacion.getIdentificador())) {
				hotel.addHabitacion(habitacion);
			}
		}
	}

	public void agregarMenu(String ubi, String numerodias, String horas) throws IOException {
		sistema = new Sistema();
		hotel = new Hotel("Sommersprossen");
		List<Bebida> bebidas = sistema.cargarBebidas();
		List<Plato> platos = sistema.cargarPlatos();

		Menu menu = new Menu(ubi, numerodias, horas);

		for (Bebida bebida : bebidas) {
			menu.addBebida(bebida);
		}

		for (Plato plato : platos) {
			menu.addPlato(plato);
		}

		hotel.addRestaurante(menu);
	}

	public String consultarInfoHabitacion(String id) {
		List<Habitacion> habitaciones = hotel.getHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getIdentificador().equals(id)) {
				return habitacion.toString();
			}
		}

		return "No se encontro la habitacion";
	}

	public void actualizarTarifaServicio(String nombreServicio, int nuevaTarifa) {
		List<Servicio> servicios = hotel.getServicios();
		for (Servicio servicio : servicios) {
			if (servicio.getNombre().equals(nombreServicio)) {
				servicio.setTarifa(nuevaTarifa);
			}
		}
		String archivo = "Data/Servicio.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombreServicio)) {
					String precio = String.valueOf(nuevaTarifa);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + precio + ";"
							+ partesServicio[3] + ";" + partesServicio[4];

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}
			}
			for (int i = 0; i < 2; i++) {
				System.out.println(lines.get(i));
			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();

			}
			writer.close();

			System.out.println("La tarifa del servicio ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarPlatoAlMenu(String elNombre, String laTarifa, String comida, String lugar) throws IOException {
		BufferedWriter writer;
		String nombre = elNombre + ";" + laTarifa + ";" + comida + ";" + lugar;
		BufferedReader reader = new BufferedReader(new FileReader("Data/Plato.txt"));

		// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
		// lista.
		String line;

		List<String> lines = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {

			lines.add(line);

		}
		lines.add(nombre);
		try {
			writer = new BufferedWriter(new FileWriter("Data/Plato.txt"));
			for (int i = 0; i < lines.size(); i++) {
				writer.write(lines.get(i));
				writer.newLine();

			}
			writer.close();
			System.out.println("Success");
			reader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void cargarBebidaAlMenu(String elNombre, String laTarifa, String comida, String lugar) throws IOException {
		BufferedWriter writer;
		String nombre = elNombre + ";" + laTarifa + ";" + comida + ";" + lugar;
		BufferedReader reader = new BufferedReader(new FileReader("Data/Bebida.txt"));

		// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
		// lista.
		String line;

		List<String> lines = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {

			lines.add(line);

		}
		lines.add(nombre);
		try {
			writer = new BufferedWriter(new FileWriter("Data/Bebida.txt"));
			for (int i = 0; i < lines.size(); i++) {
				writer.write(lines.get(i));
				writer.newLine();

			}
			writer.close();
			System.out.println("Success");
			reader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void actualizarTarifaPlato(String nombrePlato, int nuevaTarifa) {
		List<Plato> platos = menu.getPlatos();
		for (Plato plato : platos) {
			if (plato.getNombre().equals(nombrePlato)) {
				plato.setTarifa(nuevaTarifa);
			}
		}
		String archivo = "Data/Plato.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombrePlato)) {
					String precio = String.valueOf(nuevaTarifa);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + precio + ";"
							+ partesServicio[3] + ";" + partesServicio[4];

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();
			}
			writer.close();

			System.out.println("La tarifa del plato ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarTipoComidaPlato(String nombrePlato, DisponibilidadComidas nuevoTipo) {
		List<Plato> platos = menu.getPlatos();
		for (Plato plato : platos) {
			if (plato.getNombre().equals(nombrePlato)) {
				plato.setTipoComida(nuevoTipo);
			}
		}
		String archivo = "Data/Plato.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombrePlato)) {
					String tipo = String.valueOf(nuevoTipo);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + partesServicio[2] + ";"
							+ tipo + ";" + partesServicio[4];

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();
			}
			writer.close();

			System.out.println("El tipo de la bebida ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarLugarPlato(String nombrePlato, DisponibilidadLugar nuevoLugar) {
		List<Plato> platos = menu.getPlatos();
		for (Plato plato : platos) {
			if (plato.getNombre().equals(nombrePlato)) {
				plato.setTipoLugar(nuevoLugar);
			}
		}
		String archivo = "Data/Plato.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombrePlato)) {
					String tipo = String.valueOf(nuevoLugar);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + partesServicio[2] + ";"
							+ partesServicio[3] + ";" + tipo;

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();
			}
			writer.close();

			System.out.println("El tipo de la bebida ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarTarifaBebida(String nombreBebida, int nuevaTarifa) {
		List<Bebida> bebidas = menu.getBebidas();
		for (Bebida bebida : bebidas) {
			if (bebida.getNombre().equals(nombreBebida)) {
				bebida.setTarifa(nuevaTarifa);
			}
		}
		String archivo = "Data/Bebida.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombreBebida)) {
					String precio = String.valueOf(nuevaTarifa);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + precio + ";"
							+ partesServicio[3] + ";" + partesServicio[4];

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();
			}
			writer.close();

			System.out.println("La tarifa de la bebida ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarTipoComidaBebida(String nombreBebida, DisponibilidadComidas nuevoTipo) {
		List<Bebida> bebidas = menu.getBebidas();
		for (Bebida bebida : bebidas) {
			if (bebida.getNombre().equals(nombreBebida)) {
				bebida.setTipoComida(nuevoTipo);
			}
		}
		String archivo = "Data/Bebida.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombreBebida)) {
					String tipo = String.valueOf(nuevoTipo);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + partesServicio[2] + ";"
							+ tipo + ";" + partesServicio[4];

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();
			}
			writer.close();

			System.out.println("El tipo de la bebida ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarLugarBebida(String nombreBebida, DisponibilidadLugar nuevoLugar) {
		List<Bebida> bebidas = menu.getBebidas();
		for (Bebida bebida : bebidas) {
			if (bebida.getNombre().equals(nombreBebida)) {
				bebida.setTipoLugar(nuevoLugar);
			}
		}
		String archivo = "Data/Bebida.txt";

		try {
			// Paso 1: Leer el archivo de texto en un objeto BufferedReader.
			BufferedReader reader = new BufferedReader(new FileReader(archivo));

			// Paso 2: Leer línea por línea el archivo de texto y guardar cada línea en una
			// lista.
			String line;

			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				String[] partesServicio = line.split(";");
				if (partesServicio[0].equals(nombreBebida)) {
					String tipo = String.valueOf(nuevoLugar);

					String newLineContent = partesServicio[0] + ";" + partesServicio[1] + ";" + partesServicio[2] + ";"
							+ partesServicio[3] + ";" + tipo;

					// Paso 3: Modificar la línea deseada en la lista.
					lines.add(newLineContent);
				} else {
					lines.add(line);
				}

			}

			// Paso 4: Cerrar el objeto BufferedReader.
			reader.close();

			// Paso 5: Escribir la lista actualizada en el archivo de texto usando un objeto
			// PrintWriter.
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			for (String updatedLine : lines) {
				writer.write(updatedLine);
				writer.newLine();
			}
			writer.close();

			System.out.println("El tipo de la bebida ha sido actualizada.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarTrifaDeHabitacion(String inicio, String fin, String PdiasSemana, String Pprecio, String tipo) {
		BufferedWriter writer;
		String nombre = inicio + ";" + fin + ";" + PdiasSemana + ";" + Pprecio + ";" + tipo;
		try {
			writer = new BufferedWriter(new FileWriter("Data/Tarifa.txt"));
			writer.write(nombre);
			writer.close();
			System.out.println("Success");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void crearReserva(String nombre, String iDH, String email, String celular, String cpersonas,
			String chabitaciones) {
		// TODO Auto-generated method stub

	}

	public void cancelarReserva(String nombre, String iDH, String email, String celular, String cpersonas,
			String chabitaciones) {
		// TODO Auto-generated method stub

	}

	public void registrarEntrada(String nombre, String iDH, String email, String celular, String cpersonas) {
		// TODO Auto-generated method stub

	}

	public boolean revisarConsumos(String nombre, String identificador) {
		// TODO Auto-generated method stub
		return true;
	}

	public void crearFactura(String nombre, String identificador) {
		// TODO Auto-generated method stub

	}

	public void registrarSalida(String nombre, String iDH, String email, String celular, String identificador,
			String cpersonas) {
		// TODO Auto-generated method stub

	}

	public void registrarpago(String nombre, String identificador) {
		// TODO Auto-generated method stub

	}

	public void registrarConsumo(String fileConsumo, String nombre, String identificador, String consumo,
			String nconsumo, String pconsumo,
			String pago) {

		String text = nombre + ";" + identificador + ";" + consumo + ";" + nconsumo + ";" + pconsumo + ";" + pago
				+ "\n";
		try {
			FileWriter writer = new FileWriter(fileConsumo, true);
			writer.write(text);
			writer.close();
			System.out.println("Se registro el consumo con exito.");

		} catch (IOException e) {
			System.out.println("A ocurrido un error al leer el archivo");
			e.printStackTrace();
		}
	}

	public void actualizarHabitacionesArchivo(String oldFileName, File file) throws IOException {
		oldFileName = "Data/" + oldFileName;
		// newInfoFileName = "Data/" + newInfoFileName;

		try {
			// Open the file with the old information
			File oldFile = new File(oldFileName);
			BufferedReader br = new BufferedReader(new FileReader(oldFile));

			// Read the existing content from the file
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String oldInfo = sb.toString();
			br.close();

			// Open the file with the new information
			File newFile = file;
			br = new BufferedReader(new FileReader(newFile));

			// Read the new content from the file
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String newInfo = sb.toString();
			br.close();

			// Compare the new and old content
			if (!newInfo.equals(oldInfo)) {
				// Write the new content to the file
				FileWriter fw = new FileWriter(oldFile);
				fw.write(newInfo);
				fw.close();
				System.out.println("La informacion de las habitaciones ha sido actualizada.");
			} else {
				System.out.println("No se ha detectado cambios en el nuevo archivo de informacion.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarMenuArchivo(String oldFileName, File file) throws IOException {

		try {
			// Open the file with the old information
			File oldFile = new File(oldFileName);
			BufferedReader br = new BufferedReader(new FileReader(oldFile));

			// Read the existing content from the file
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String oldInfo = sb.toString();
			br.close();

			// Open the file with the new information
			File newFile = file;
			br = new BufferedReader(new FileReader(newFile));

			// Read the new content from the file
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String newInfo = sb.toString();
			br.close();

			// Compare the new and old content
			if (!newInfo.equals(oldInfo)) {
				// Write the new content to the file
				FileWriter fw = new FileWriter(oldFile);
				fw.write(newInfo);
				fw.close();
				System.out.println("La informacion de las habitaciones ha sido actualizada.");
			} else {
				System.out.println("No se ha detectado cambios en el nuevo archivo de informacion.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarPlatoArchivo(String oldInfoPlato, String newInfoPlato) {
		try {
			// Open the file with the old information
			File oldFile = new File(oldInfoPlato);
			BufferedReader br = new BufferedReader(new FileReader(oldFile));

			// Read the existing content from the file
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String oldInfo = sb.toString();
			br.close();

			// Open the file with the new information
			File newFile = new File(newInfoPlato);
			br = new BufferedReader(new FileReader(newFile));

			// Read the new content from the file
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String newInfo = sb.toString();
			br.close();

			// Compare the new and old content
			if (!newInfo.equals(oldInfo)) {
				// Write the new content to the file
				FileWriter fw = new FileWriter(oldFile);
				fw.write(newInfo);
				fw.close();
				System.out.println("Completado");
			} else {
				System.out.println("No se ha detectado cambios en el nuevo archivo de informacion.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actualizarBebidaArchivo(String oldInfoBebida, String newInfoBebida) {
		try {
			// Open the file with the old information
			File oldFile = new File(oldInfoBebida);
			BufferedReader br = new BufferedReader(new FileReader(oldFile));

			// Read the existing content from the file
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String oldInfo = sb.toString();
			br.close();

			// Open the file with the new information
			File newFile = new File(newInfoBebida);
			br = new BufferedReader(new FileReader(newFile));

			// Read the new content from the file
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String newInfo = sb.toString();
			br.close();

			// Compare the new and old content
			if (!newInfo.equals(oldInfo)) {
				// Write the new content to the file
				FileWriter fw = new FileWriter(oldFile);
				fw.write(newInfo);
				fw.close();
				System.out.println("La informacion del menu ha sido actualizada.");
			} else {
				System.out.println("No se ha detectado cambios en el nuevo archivo de informacion.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
