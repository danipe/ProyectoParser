package parser_acciones;

public class Operacion {
	private float precio;
	private int cantidad;
	
	public Operacion(float p, int c) {
		this.precio=p;
		this.cantidad=c;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
