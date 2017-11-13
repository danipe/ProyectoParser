package serializer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Ventana {

	private JFrame frame;
	private JTextField textFieldTitulo;
	private JTextField textFieldEditor;
	private JTextField textFieldPags;
	private JButton btnParsearObjetos, btnAnadir;
	private JTextField textFieldFichero;
	private JTextArea textAreaAutores;
	private JTextField textFieldAnyo;
	private JTextPane textPane ;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	public JTextArea getTextAreaAutores() {
		return textAreaAutores;
	}

	public void setTextAreaAutores(JTextArea textAreaAutores) {
		this.textAreaAutores = textAreaAutores;
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ventana window = new Ventana();
//					window.getFrame().setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(Color.DARK_GRAY);
		getFrame().setBounds(100, 100, 438, 381);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(16, 14, 46, 14);
		getFrame().getContentPane().add(lblTitulo);
		
		JLabel lblAutores = new JLabel("Autor/es");
		lblAutores.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutores.setForeground(Color.WHITE);
		lblAutores.setBounds(10, 39, 52, 14);
		getFrame().getContentPane().add(lblAutores);
		
		JLabel lblEditor = new JLabel("Editor");
		lblEditor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditor.setForeground(Color.WHITE);
		lblEditor.setBounds(16, 201, 46, 14);
		getFrame().getContentPane().add(lblEditor);
		
		JLabel lblNPginas = new JLabel("N\u00BA Pags");
		lblNPginas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNPginas.setForeground(Color.WHITE);
		lblNPginas.setBounds(10, 226, 52, 14);
		getFrame().getContentPane().add(lblNPginas);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(72, 11, 86, 20);
		textFieldTitulo.setBorder(null);
		getFrame().getContentPane().add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		textFieldEditor = new JTextField();
		textFieldEditor.setBounds(72, 198, 86, 20);
		textFieldEditor.setBorder(null);
		getFrame().getContentPane().add(textFieldEditor);
		textFieldEditor.setColumns(10);
		
		textFieldPags = new JTextField();
		textFieldPags.setBounds(72, 223, 86, 20);
		textFieldPags.setBorder(null);
		getFrame().getContentPane().add(textFieldPags);
		textFieldPags.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 34, 86, 97);
		frame.getContentPane().add(scrollPane);
		
		textAreaAutores = new JTextArea();
		scrollPane.setViewportView(textAreaAutores);
		textAreaAutores.setText("Autor1\nAutor2");
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(168, 11, 205, 193);
		frame.getContentPane().add(scrollPane_1);
		
		textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textPane.setEditable(false);
		
		JTextPane txtpnIntroduceAutoresSeparados = new JTextPane();
		txtpnIntroduceAutoresSeparados.setBackground(Color.DARK_GRAY);
		txtpnIntroduceAutoresSeparados.setForeground(Color.LIGHT_GRAY);
		txtpnIntroduceAutoresSeparados.setText("Introduce autores separados por saltos de linea");
		txtpnIntroduceAutoresSeparados.setBounds(16, 142, 142, 50);
		getFrame().getContentPane().add(txtpnIntroduceAutoresSeparados);
		
		btnParsearObjetos = new JButton("Guardar");
		btnParsearObjetos.setBounds(275, 222, 97, 23);
		frame.getContentPane().add(btnParsearObjetos);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setBounds(20, 283, 138, 23);
		frame.getContentPane().add(btnAnadir);
		
		JLabel lblFichero = new JLabel("Fichero");
		lblFichero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFichero.setForeground(Color.WHITE);
		lblFichero.setBounds(168, 256, 97, 14);
		frame.getContentPane().add(lblFichero);
		
		textFieldFichero = new JTextField();
		textFieldFichero.setBorder(null);
		textFieldFichero.setBounds(275, 253, 97, 20);
		frame.getContentPane().add(textFieldFichero);
		textFieldFichero.setColumns(10);
		
		JLabel lblAnyo = new JLabel("A\u00F1o");
		lblAnyo.setForeground(Color.WHITE);
		lblAnyo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnyo.setBounds(16, 251, 46, 14);
		frame.getContentPane().add(lblAnyo);
		
		textFieldAnyo = new JTextField();
		textFieldAnyo.setBounds(72, 248, 86, 20);
		textFieldAnyo.setBorder(null);
		frame.getContentPane().add(textFieldAnyo);
		textFieldAnyo.setColumns(10);
	}

	public JTextField getTextFieldAnyo() {
		return textFieldAnyo;
	}

	public void setTextFieldAnyo(JTextField textFieldAnyo) {
		this.textFieldAnyo = textFieldAnyo;
	}

	public JTextField getTextFieldFichero() {
		return textFieldFichero;
	}

	public void setTextFieldFichero(JTextField textFieldFichero) {
		this.textFieldFichero = textFieldFichero;
	}

	public JButton getBtnParsearObjetos() {
		return btnParsearObjetos;
	}

	public void setBtnParsearObjetos(JButton btnParsearObjetos) {
		this.btnParsearObjetos = btnParsearObjetos;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JTextField getTextFieldTitulo() {
		return textFieldTitulo;
	}

	public void setTextFieldTitulo(JTextField textFieldTitulo) {
		this.textFieldTitulo = textFieldTitulo;
	}

	public JTextField getTextFieldEditor() {
		return textFieldEditor;
	}

	public void setTextFieldEditor(JTextField textFieldEditor) {
		this.textFieldEditor = textFieldEditor;
	}

	public JTextField getTextFieldPags() {
		return textFieldPags;
	}

	public void setTextFieldPags(JTextField textFieldPags) {
		this.textFieldPags = textFieldPags;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void showError(String m){
		JOptionPane.showMessageDialog(this.frame,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void showMessage(String m) {
		JOptionPane.showMessageDialog(this.frame,
			    m,
			    "Error",
			    JOptionPane.PLAIN_MESSAGE);
	}

}
