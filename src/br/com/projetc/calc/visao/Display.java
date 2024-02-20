package br.com.projetc.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.projetc.calc.modelo.Memoria;
import br.com.projetc.calc.modelo.MemoriaObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObserver{

	JLabel label;
	
	public Display() {
		
	Memoria.getIstancia().resitrarOberserves(this);
	setBackground(new Color(13, 9, 3));
	
	label = new JLabel(Memoria.getIstancia().getTextoAtual());
    
	label.setForeground(new Color(166, 159, 138));
	label.setFont(new Font("courier", Font.PLAIN, 30));
	setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
    
	add(label);

	}
	
	@Override
	public void alteracaoValor(String valor) {
	  label.setText(valor);
		
	}
	
}
