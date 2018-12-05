package model;

public class Animal {
	
	int id, tipo, idade; /*tipo: 1 cachorro, 2-gato */
	private String nome, descricao, data_chegada, data_saida;
	boolean castrado, vermifugado, disponivelParaAdocao, adotado;
	
	Informacao [] informacoes = new Informacao[10]; //DE REMEDIOS, CONSULTAS, ETC
	
	public Animal (int id, int tipo, String nome, int idade, String descricao, String data_chegada) {
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
	
	public int getIdade() {
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
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public void animalCastrado() {
		this.castrado = true;
	}
	
	public void animalVermifugado() {
		this.vermifugado = true;
	}
	
	public void animalDisponivelParaAdocao() {
		this.disponivelParaAdocao = true;
	}
	
}
