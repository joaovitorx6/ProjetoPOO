package model;

public class Animal {
	
	int id, tipo; /*TIPO 1: CACHORRO / TIPO 2: GATO */
	private String nome, descricao, data_chegada, data_saida, idade;
	boolean castrado, vermifugado, disponivelParaAdocao, adotado;
	
	public Animal (int id, int tipo, String nome, String idade, String descricao, String data_chegada) {
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
		this.tipo = tipo;
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
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	
	public void setVermifugado(boolean vermifugado) {
		this.vermifugado = vermifugado;
	}
	
	public void setDisponivelParaAdocao(boolean disponivelParaAdocao) {
		this.disponivelParaAdocao = disponivelParaAdocao;
	}
	
}
