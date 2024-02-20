package br.com.projetc.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private final static Memoria istancia = new Memoria();
	
	List<MemoriaObserver> observer = new ArrayList<>();
	
	private String textoAtual = ""; 
	
	private Memoria() {
		
	}

	public static Memoria getIstancia() {
		return istancia;
	}

	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
			
	public void resitrarOberserves(MemoriaObserver a) {
	 observer.add(a);
		
	}
	
	public void processartexto(String valor){
		if("AC".equals(valor)) {
			textoAtual = "";
			
		}else {
			textoAtual += valor;
		}
		
		
			observer.forEach(o -> o.alteracaoValor(getTextoAtual()));
		
	}
	
}
