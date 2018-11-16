package model;
import exception.CPFInvalidoException;
import exception.TelefoneInvalidoException;

public class Voluntario {
	private String nome, cpf, telefone, diasSemana, horario;
	private int idade;
	private boolean ativo;
	
	public Voluntario (String nome, String cpf, int idade, String telefone, String diasSemana, String horario) throws CPFInvalidoException, TelefoneInvalidoException {
		
		if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
			}	
		}
		
		for(int i=0;i<telefone.length();i++) {
			char c = telefone.charAt(i);
			if(!Character.isDigit(c)) {
				throw new TelefoneInvalidoException("Telefone deve contar apenas digitos");
			}
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.telefone = telefone;
		this.diasSemana = diasSemana;
		this.horario = horario;
		this.ativo = true;
		
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setCpf(String cpf) throws CPFInvalidoException{
		if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
			}	
		}
		
		this.cpf = cpf;
	}
	
	public void setTelefone(String telefone) throws TelefoneInvalidoException {
		for(int i=0;i<telefone.length();i++) {
			char c = telefone.charAt(i);
			if(!Character.isDigit(c)) {
				throw new TelefoneInvalidoException("Telefone deve contar apenas digitos");
			}
		}
		
		this.telefone = telefone;
		
	}
	
	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}
	
	public void setHorario (String horario) {
		this.horario = horario;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void desativarVoluntario() {
		this.ativo = false;
	}
	
}