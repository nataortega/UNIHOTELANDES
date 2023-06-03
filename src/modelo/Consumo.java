package modelo;

public class Consumo {

	private String fecha;
	private TipoConsumo tipo;
	private double valor;
	private double impuestos;
	private boolean pagado;
	private Plato plato;
	private Bebida bebida;
	private Servicio servicio;
	private Habitacion habitacion;

	public Consumo(String laFecha, TipoConsumo elTipo, double elValor, double elImpuesto, boolean siPago,
			double impuesto, Plato elPlato) {
		this.fecha = laFecha;
		this.tipo = elTipo;
		this.valor = elValor;
		this.impuestos = impuesto;
		this.plato = elPlato;
	}

	public Consumo(String laFecha, TipoConsumo elTipo, double elValor, double elImpuesto, boolean siPago,
			double impuesto, Bebida laBebida) {
		this.fecha = laFecha;
		this.tipo = elTipo;
		this.valor = elValor;
		this.impuestos = impuesto;
		this.bebida = laBebida;
	}

	public Consumo(String laFecha, TipoConsumo elTipo, double elValor, double elImpuesto, boolean siPago,
			double impuesto, Servicio elServicio) {
		this.fecha = laFecha;
		this.tipo = elTipo;
		this.valor = elValor;
		this.impuestos = impuesto;
		this.servicio = elServicio;
	}

	public Consumo(String laFecha, TipoConsumo elTipo, double elValor, double elImpuesto, boolean siPago,
			double impuesto, Habitacion laHabitacion) {
		this.fecha = laFecha;
		this.tipo = elTipo;
		this.valor = elValor;
		this.impuestos = impuesto;
		this.habitacion = laHabitacion;
	}

	public String getFecha() {
		return fecha;
	}

	public TipoConsumo getTipoConsumo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public boolean getPagado() {
		return pagado;
	}

	public Plato getPlato() {
		return plato;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

}
