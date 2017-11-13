package parser_acciones;

import java.util.ArrayList;

public class Accion {
	private String nombre;
	private ArrayList<Operacion> compras, ventas;
	
	public Accion(String n, ArrayList<Operacion> c, ArrayList<Operacion> v) {
		this.nombre=n;
		this.compras=c;
		this.ventas=v;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Operacion> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Operacion> compras) {
		this.compras = compras;
	}

	public ArrayList<Operacion> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Operacion> ventas) {
		this.ventas = ventas;
	}

	public void print() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.nombre+"\n");
		sb.append("\t Compras:\n");
		for(Operacion op: this.compras) {
			sb.append("\t \t Cantidad: "+op.getCantidad()+"\n");
			sb.append("\t \t Precio: "+op.getPrecio()+"\n");
			sb.append("\n");
		}
		sb.append("\t Ventas:\n");
		for(Operacion op: this.ventas) {
			sb.append("\t \t Cantidad: "+op.getCantidad()+"\n");
			sb.append("\t \t Precio: "+op.getPrecio()+"\n");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	
}
