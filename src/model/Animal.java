package model;

public class Animal {
	
	int id, tipo; /*tipo: 1 cachorro, 2-gato */
	private String nome, idade, descricao, data_chegada, data_saida;	
	boolean castrado, vacinado, vermifugado, disponivelParaAdocao;
	
	Informacao [] informacoes = new Informacao[10];
}
