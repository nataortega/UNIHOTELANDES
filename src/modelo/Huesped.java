package modelo;

public class Huesped extends UsuarioDelSistema{

	private String nombre;
	private String documento;
	private int edad;
	private String correo;
	private int celular;
	public String login;
	public String contrasena;
	

	public Huesped(String elNombre, String documentoID, int laEdad, String elCorreo, int elCelular) {
		this.nombre = elNombre;
		this.documento = documentoID;
		this.edad = laEdad;
		this.correo = elCorreo;
		this.celular = elCelular;
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

	public String getNombre() {
		return nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public int getEdad() {
		return edad;
	}

	public String getCorreo() {
		return correo;
	}

	public int getCelular() {
		return celular;
	}

}
