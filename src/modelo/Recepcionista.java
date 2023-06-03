package modelo;

import java.util.List;

public class Recepcionista extends UsuarioDelSistema {

	public String login;
	public String contrasena;

	public Recepcionista(String PLogin, String PContrasena) {
		login = PLogin;
		contrasena = PContrasena;
	}

	public Reserva hacerReserva() {
		return null;
	}

	public void realizarRegistroEntrada() {

	}

	public void realizarRegistroSalida() {

	}
	public String getLogin() {
		return login;
	}
	public String getContrasena() {
		return contrasena;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}

}
