package parser_libros;

import java.util.ArrayList;

public class Libro {
	private String titulo, editor;
	private ArrayList<String> autores;
	private int nPaginas, anyo;
	
	public Libro(String t, String e, ArrayList<String> a, int p, int an) {
		this.titulo = t;
		this.editor = e;
		this.autores = a;
		this.nPaginas = p;
		this.anyo = an;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	public void print() {
		StringBuffer sb = new StringBuffer();
		sb.append("Titulo: "+this.titulo+"\n");
		sb.append("Autores: \n");
		for(String autor: this.autores) {
			sb.append("\t"+autor+"\n");
		}
		sb.append("Editor: "+this.editor+"\n");
		sb.append("Nº Paginas: "+this.nPaginas+"\n");
		sb.append("Año: "+this.anyo+"\n");
		sb.append("\n");
		System.out.println(sb);
		
		
	}
	
	
}
