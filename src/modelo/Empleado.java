package modelo;

public class Empleado extends UsuarioDelSistema {

	public String login;
	public String contrasena;

	public Empleado(String PLogin, String PContrasena) {
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

}

