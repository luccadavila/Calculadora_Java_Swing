package br.com.projetc.calc.visao;



import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.projetc.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {
	
	private Color CINZA_ESCURO = new Color(68,68,68); 
	private Color CINZA_CLARO = new Color(97,100,99);
	private Color LARANJA = new Color(242,163,60);
	
	public Teclado() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx=1;
		c.weighty=1;
		c.fill = GridBagConstraints.BOTH;
		
		
		setLayout(layout);
		c.gridwidth=3;
		adicionarbotao("AC", CINZA_ESCURO,c,0,0);
		c.gridwidth =1;
		adicionarbotao("/", LARANJA,c,0,3);
		
		adicionarbotao("7", CINZA_CLARO,c,1,0);
		adicionarbotao("8", CINZA_CLARO,c,1,1);
		adicionarbotao("9", CINZA_CLARO,c,1,2);
		adicionarbotao("*", LARANJA,c,1,3);
 
		adicionarbotao("6", CINZA_CLARO,c,2,0);
		adicionarbotao("5", CINZA_CLARO,c,2,1);
		adicionarbotao("4", CINZA_CLARO,c,2,2);
		adicionarbotao("-", LARANJA,c,2,3);
		
		adicionarbotao("3", CINZA_CLARO,c,3,0);
		adicionarbotao("2", CINZA_CLARO,c,3,1);
		adicionarbotao("1", CINZA_CLARO,c,3,2);
		adicionarbotao("+", LARANJA,c,3,3);
		c.gridwidth=2;
		adicionarbotao("0", CINZA_CLARO,c,4,0);
	   c.gridwidth=1;
		adicionarbotao(",", CINZA_CLARO,c,4,2);
		adicionarbotao("=", LARANJA,c,4,3);
		
		
	}

	private void adicionarbotao(String text, Color cor, GridBagConstraints c,int y, int x) {
		Botao botao = new Botao(text, cor);
		c.gridx = x;
		c.gridy = y;
        botao.addActionListener(this);
		add(botao,c);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
		JButton buton = (JButton) e.getSource(); 
		Memoria.getIstancia().processartexto(buton.getText());
		}
	}
	
}
