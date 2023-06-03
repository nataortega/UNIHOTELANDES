package modelo;

public class Administrador extends UsuarioDelSistema {

	public String login;
	public String contrasena;

	public Administrador(String PLogin, String PContrasena) {
		login = PLogin;
		contrasena = PContrasena;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Habitacion crearHabitacion() {
		return null;
	}

	public Habitacion archivoCrearHabitaciones() {
		return null;

	}

	public Tarifa cargarTarifas() {
		return null;
	}

	public Tarifa cambiarTarifas() {
		return null;
	}

	public Menu cargarMenu() {
		return null;
	}

	public int registraPagos() {
		return 0;
	}

}
