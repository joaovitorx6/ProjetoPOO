package model;

public class Informacao {
	/* tipos 1: exames medicos 2: doencas, 3: medicacao*/;
	private int tipo;
	private String descricao;
	
	public Informacao (int tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public void setTipo (int tipo) {
		this.tipo = tipo;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
