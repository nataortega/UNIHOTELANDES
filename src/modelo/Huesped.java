package modelo;

public class Huesped {

	private String nombre;
	private String documento;
	private int edad;
	private String correo;
	private int celular;

	public Huesped(String elNombre, String documentoID, int laEdad, String elCorreo, int elCelular) {
		this.nombre = elNombre;
		this.documento = documentoID;
		this.edad = laEdad;
		this.correo = elCorreo;
		this.celular = elCelular;
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
