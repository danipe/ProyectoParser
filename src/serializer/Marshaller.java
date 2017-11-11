package serializer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import parser_libros.Libro;

public class Marshaller {
	Ventana v;
	ArrayList<Libro> libros;
	
	public Marshaller(Ventana v) {
		this.v = v;
		libros = new ArrayList<Libro>();
		this.listeners();
	}
	
	public void listeners() {
		
		this.v.getBtnParsearObjetos().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(libros.size()>0) {
						guardarLibros();
						v.showMessage("Libros guardados en "+v.getTextFieldFichero().getText());
					} else {
						v.showError("Añade al menos un libro");
					}
					
				} catch (ParserConfigurationException | SAXException | IOException
						| TransformerFactoryConfigurationError | TransformerException e1) {
					// TODO Auto-generated catch block
					v.showError("Hubo un problema al guardar en el fichero");
				}
			}
		});
		
		this.v.getBtnAnadir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					anadirLibro();
				} catch (Exception e2) {
					v.showError("Hubo un error al añadir el libro, comprueba que los campos esten correctamente introducidos");
				}
				
			}
		});
	}
	
	public void borrarCampos() {
		this.v.getTextAreaAutores().setText("");
		this.v.getTextFieldAnyo().setText("");
		this.v.getTextFieldEditor().setText("");
		this.v.getTextFieldPags().setText("");
		this.v.getTextFieldTitulo().setText("");
	}
	
	public void anadirLibro() {
		Libro l = new Libro(this.v.getTextFieldTitulo().getText(),
				this.v.getTextFieldEditor().getText(),this.splitAutores(),
				Integer.parseInt(this.v.getTextFieldPags().getText()),
				Integer.parseInt(this.v.getTextFieldAnyo().getText()));
		this.libros.add(l);
		this.v.getTextPane().setText(this.v.getTextPane().getText()+"- "+l.getTitulo()+"\n");
		this.borrarCampos();
	}
	
	public void guardarLibros() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		
		Document dom = null;
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = bdf.newDocumentBuilder();
		dom = db.newDocument();
		
		Element biblioteca = dom.createElement("biblioteca");
		dom.appendChild(biblioteca);
		for(Libro l: this.libros) {
			Element libro = marshLibro(dom, l);
			biblioteca.appendChild(libro);
		}
		
		
		parseToFile(dom);
	}
	
	public Element marshLibro(Document dom, Libro l) {
		Element libro = dom.createElement("libro");
		
		//Titulo con año
		Element titulo = dom.createElement("titulo");
		titulo.setTextContent(l.getTitulo());
		titulo.setAttribute("anyo", ""+l.getAnyo());
		libro.appendChild(titulo);
		
		//Autores
		Element autor = dom.createElement("autor");
		ArrayList<String> autores = l.getAutores();
		for(String a: autores) {
			Element nombre = dom.createElement("nombre");
			nombre.setTextContent(a);
			autor.appendChild(nombre);
		}
		libro.appendChild(autor);
		
		//Editor
		Element editor = dom.createElement("editor");
		editor.setTextContent(l.getEditor());
		libro.appendChild(editor);
		
		//Paginas
		Element paginas = dom.createElement("paginas");
		paginas.setTextContent(""+l.getnPaginas());
		libro.appendChild(paginas);
	
		return libro;
	}
	
	public ArrayList<String> splitAutores() {
		ArrayList<String> autores = new ArrayList<String>();
		for(String s: this.v.getTextAreaAutores().getText().split("\n")) {
			autores.add(s);
		}
		return autores;
	}
	
	public void parseToFile(Document dom) throws IOException, TransformerFactoryConfigurationError, TransformerException {
		File f = new File(this.v.getTextFieldFichero().getText());
		f.createNewFile();
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		
		StreamResult result = new StreamResult(f);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);
	}
	
	
}
