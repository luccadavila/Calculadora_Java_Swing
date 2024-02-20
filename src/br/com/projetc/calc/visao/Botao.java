package br.com.projetc.calc.visao;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton {
	
	public Botao(String text, Color cor) {
		setText(text);
		setBackground(cor);
		setFont(new Font("courier", Font.PLAIN, 30));
		setOpaque(true);
		setForeground(Color.WHITE);
		setBorder( BorderFactory.createLineBorder(Color.BLACK));
		
	}

}
