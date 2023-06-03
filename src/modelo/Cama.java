package modelo;

public class Cama {

	private String tamaño;
	private TipoHuesped tipoHuesped;
	private int numeroNiños;
	private int numeroAdultos;

	public Cama(String elTamaño, TipoHuesped huespedTipo, int niños, int adulto) {
		this.tamaño = elTamaño;
		this.tipoHuesped = huespedTipo;
		this.numeroNiños = niños;
		this.numeroAdultos = adulto;
	}

	public String getTamaño() {
		return tamaño;
	}

	public TipoHuesped getTipoHuesped() {
		return tipoHuesped;
	}

	public int getNumeroNiños() {
		return numeroNiños;
	}

	public int getNumeroAdultos() {
		return numeroAdultos;
	}

}
