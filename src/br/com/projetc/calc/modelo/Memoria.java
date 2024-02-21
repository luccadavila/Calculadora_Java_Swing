package br.com.projetc.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private enum Comando{
		SUB,MULTI,SOMA,DIVI,ZERAR,IGUAL,SINAL,NUM,VIRGULA
	}

	private final static Memoria istancia = new Memoria();
	
	List<MemoriaObserver> observer = new ArrayList<>();
	
	private Comando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = ""; 
	private String textobuffer = "";
	
	
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
		Comando tipocomando = Processarcomando(valor);
	    System.out.println(tipocomando);
	    
	  if(tipocomando == null) {
		  return;
	  }else if(tipocomando == Comando.ZERAR) {
		  ultimaOperacao = null;
		  substituir = false;
		  textoAtual = ""; 
		  textobuffer = "";
	  }else if(tipocomando == Comando.SINAL && textoAtual.contains("-")) {
		  textoAtual = textoAtual.substring(1);
	  }
	  else if(tipocomando == Comando.SINAL && !textoAtual.contains("-")) {
		  textoAtual = "-" + textoAtual;
	  }
	  
	  else if(tipocomando == Comando.NUM || tipocomando == Comando.VIRGULA  ) {
		
		  textoAtual = substituir ? valor : textoAtual +valor;
		  substituir = false;
		  
	  }else {
		   substituir = true;
		   textoAtual = obterResultado();
		   textobuffer = textoAtual;
		   ultimaOperacao = tipocomando;
	  }
			observer.forEach(o -> o.alteracaoValor(getTextoAtual()));
		
	}

	private String obterResultado() {
		if(ultimaOperacao == null || ultimaOperacao == Comando.IGUAL) {
			return textoAtual;
		}
		double resultbuffer = Double.parseDouble(textobuffer.replace(",", "."));
		double resultAtual = Double.parseDouble(textoAtual.replace(",", "."));
		double resultado = 0.0;
		
		if(ultimaOperacao == Comando.SOMA) {
			resultado = resultbuffer + resultAtual;
		}
		
		if(ultimaOperacao == Comando.DIVI) {
			resultado = resultbuffer / resultAtual;
		}
		
		if(ultimaOperacao == Comando.MULTI) {
			resultado = resultbuffer * resultAtual;
		}
		
		if(ultimaOperacao == Comando.SUB) {
			resultado = resultbuffer - resultAtual;
		}
		
		String resultado1 = Double.toString(resultado).replace(".", ",");
		boolean inteiro = resultado1.endsWith(",0");
		return inteiro ? resultado1.replace(",0", "") :resultado1 ;
	}

	private Comando Processarcomando(String valor) {
		if(textoAtual.isEmpty() && textoAtual == "0") {
			return null;
			
		}
		try {
			Integer.parseInt(valor);
			return Comando.NUM;
		} catch (NumberFormatException e) {
			if("AC".equals(valor)) {
				return Comando.ZERAR;	
		}
			else if("*".equals(valor)) {
				return Comando.MULTI;	
		}
			else if("/".equals(valor)) {
				return Comando.DIVI;	
		}
			else if("-".equals(valor)) {
				return Comando.SUB;	
		}
			else if("+".equals(valor)) {
				return Comando.SOMA;	
		}
			else if("=".equals(valor)) {
				return Comando.IGUAL;	
		}
			else if("±".equals(valor)) {
				return Comando.SINAL;	
		}
			else if(",".equals(valor) && !textoAtual.contains(",")) {
				return Comando.VIRGULA;	
		}
		
		return null;
	}
	}
}
	

