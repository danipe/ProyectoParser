package serializer;

public class Main {

	public static void main(String[] args) {
		try {
			Ventana window = new Ventana();
			window.getFrame().setVisible(true);
			Marshaller m = new Marshaller(window);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
