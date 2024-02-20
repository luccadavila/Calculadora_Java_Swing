package br.com.projetc.calc.modelo;

@FunctionalInterface
public interface MemoriaObserver {

	void alteracaoValor(String valor);
}
