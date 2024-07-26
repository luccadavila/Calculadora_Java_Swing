package br.com.projetc.calc.visao;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;



@SuppressWarnings("serial")
public class Calculadora extends JFrame {

	public Calculadora() {
		
		orgazinarLayout();
	
	    
		setTitle("calculadora");
		setSize(232, 322);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
	
	private void orgazinarLayout() {
		
		setLayout(new BorderLayout());
		Display display = new Display();
		Teclado teclado = new Teclado();
		
		display.setPreferredSize(new Dimension(233,60));
		
		
		add(display, BorderLayout.NORTH);
		add(teclado , BorderLayout.CENTER);
		
		
		
		
	}
//execução do programa 
	public static void main(String[] args) {
		new Calculadora();
	}
}
