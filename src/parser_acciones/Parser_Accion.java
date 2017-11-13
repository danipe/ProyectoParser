package parser_acciones;

public class Parser_Accion {

	public static void main(String[] args) {
		Parser p = new Parser();
		p.parseFicheroXml("fichero2.xml");
		p.parseDocument();
		p.print();

	}

}
