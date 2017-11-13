package parser_acciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Accion> acciones = null;

	public Parser() {
		acciones = new ArrayList<>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void parseDocument() {
		/*
		 * TEMA 2
		 * 
		 * Obtenemos un NodeList con todas las acciones del fichero
		 * */
		Element docEle = dom.getDocumentElement();
		
		NodeList nl = docEle.getElementsByTagName("accion");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				
				Element el = (Element) nl.item(i);

				/*
				 * Capturamos los posibles errores que nos pueda lanzar la función getAccion y mostramos un mensaje
				 * indicando que ha ocurrido
				 * */
				try {
					Accion p = getAccion(el);
					acciones.add(p);
				} catch (NullPointerException e) {
					System.out.println("Hubo un error parseando la acción, la estructura del codigo no es correcta o está dañada");
				} catch (NumberFormatException e) {
					System.out.println("Hubo un error al parsear un numero");
				} catch (Exception e) {
					System.out.println("Hubo un error parseando una acción");
				}

				
				
			}
		}
	}
	
	private Accion getAccion(Element AccionEle) throws NullPointerException, NumberFormatException{
		
		/*
		 * Creamos dos arrays de operaciones, uno para ventas y otro para compras.
		 * 
		 * Guardamos el nombre de la accion
		 * */
		ArrayList<Operacion> arrayCompras, arrayVentas;
		String nombre = getTextValue(AccionEle, "nombre");
		Element op = (Element) AccionEle.getElementsByTagName("operaciones").item(0);
		
		Element elCompras = (Element) op.getElementsByTagName("compras").item(0);
		
		Element elVentas = (Element) op.getElementsByTagName("ventas").item(0);
		/*
		 * Llamamos a la funcion getOperaciones para inicializar nuestras operaciones
		 * */
		arrayCompras = getOperaciones(elCompras,"compra");
		arrayVentas = getOperaciones(elVentas,"venta");
		
		Accion a = new Accion(nombre,arrayCompras,arrayVentas);

		return a;		
		
	}
	
	private ArrayList<Operacion> getOperaciones(Element padre, String tag) throws NumberFormatException {
		/*
		 * Comprobamos que el elemento padre existe, si no, significa que no tenemos que guardar ninguna
		 * operacion, si es al contrario vamos guardando las diferentes operaciones.
		 * 
		 * Esta funcion existe porque tanto las compras como las ventas tienen los mismos atributos, solo varian
		 * el array en el que se encuentran
		 * */
		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		if(padre!=null) {
			NodeList nodeOps = padre.getElementsByTagName(tag);
			for(int i = 0; i<nodeOps.getLength(); i++) {
				Element op = (Element) nodeOps.item(i);
				float precio = Float.parseFloat(getTextValue(op,"precio"));
				int cantidad = Integer.parseInt(getTextValue(op,"cantidad"));
				operaciones.add(new Operacion(precio,cantidad));
			}
		}
		/*
		 * Si no existe el elemento padre devolvemos un ArrayList vacio;
		 * 
		 * */
		return operaciones;
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
			
		}		
		return textVal;
	}
	
	public void print(){

		Iterator it = acciones.iterator();
		while(it.hasNext()) {
			Accion p=(Accion) it.next();
			p.print();
		}
	}
	
}

