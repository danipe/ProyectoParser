package parser_libros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Libro> personas = null;

	public Parser() {
		personas = new ArrayList<Libro>();
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
		Element docEle = dom.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				
				Element el = (Element) nl.item(i);

				
				Libro p = getLibro(el);

				
				personas.add(p);
			}
		}
	}
	
	private Libro getLibro(Element libroEle){
		
		ArrayList<String> as = new ArrayList<String>();
		Element el = (Element) libroEle.getElementsByTagName("autor").item(0);
		NodeList autores = el.getElementsByTagName("nombre");
		for(int i = 0; i<autores.getLength(); i++) {
			Element e = (Element) autores.item(i);
			as.add(e.getFirstChild().getNodeValue());
		}
		
		String titulo = getTextValue(libroEle,"titulo");
		String editor = getTextValue(libroEle,"editor");
		int paginas = getIntValue(libroEle,"paginas");
		
		Element an = (Element) libroEle.getElementsByTagName("titulo").item(0);
		int anyo = Integer.parseInt(an.getAttribute("anyo"));
		
		Libro l = new Libro(titulo,editor,as,paginas,anyo);

		return l;		
		
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
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	public void print(){

		Iterator it = personas.iterator();
		while(it.hasNext()) {
			Libro p=(Libro) it.next();
			p.print();
		}
	}
	
}
