package model;

public class Animal {
	
	int id, tipo; /*tipo: 1 cachorro, 2-gato */
	private String nome, idade, descricao, data_chegada, data_saida;	
	boolean castrado, vermifugado, disponivelParaAdocao, adotado;
	
	Informacao [] informacoes = new Informacao[10]; //DE REMEDIOS, CONSULTAS, ETC
	
	public Animal (int id, String nome, String idade, String descricao, String data_chegada) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.descricao = descricao;
		this.data_chegada = data_chegada;
		this.data_saida = null;
		this.castrado = false;
		this.vermifugado = false;
		this.disponivelParaAdocao = false;
		this.adotado = false;
	}
	
	public void realizarAdocao(String data_saida) {
		this.adotado = true;
		this.data_saida=data_saida;
		this.disponivelParaAdocao=false;
	}
	
	public int getidAnimal() {
		return id;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getIdade() {
		return idade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getDataChegada() {
		return data_chegada;
	}
	
	public String getDataSaida() {
		return data_saida;
	}
	
	public boolean getCastrado() {
		return castrado;
	}
	
	public boolean getVermifugado() {
		return vermifugado;
	}
	
	public boolean getAdotado() {
		return adotado;
	}
	
	public boolean getDisponivelAdocao () {
		return disponivelParaAdocao;
	}
	
}
