package model;
import exception.CPFInvalidoException;
import exception.HorarioExcedidoException;
import exception.IdadeMaximaAtingidaException;
import exception.TelefoneInvalidoException;

public class Voluntario {
	
	private String nome, cpf, telefone;
	private int idade, diasVoluntario[], horarioInicial, horarioFinal;
	private boolean ativo;
	
	public Voluntario (String nome, String cpf, int idade, String telefone, int diasVoluntario [], int horarioInicial, int horarioFinal) throws CPFInvalidoException, TelefoneInvalidoException, IdadeMaximaAtingidaException, HorarioExcedidoException {
		
		if (horarioInicial<8 || horarioInicial>20) {
			throw new HorarioExcedidoException("Horario não permitido");
		}
		
		if (horarioFinal<8 || horarioFinal>20) {
			throw new HorarioExcedidoException("Horario não permitido");
		}
		
		if(idade>18) {
			throw new IdadeMaximaAtingidaException("Idade m�xima para ser volunt�rio � a partir dos 18 anos");
		}
		
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
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		this.ativo = true;
		this.diasVoluntario = new int [6];
		for (int i = 0; i < diasVoluntario.length; i++) {
			diasVoluntario[i] = 0;
		}
		
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
	
	public String getCpf () {
		return cpf;
	}
	
	public void setDias (int [] diasVoluntario) {
		this.diasVoluntario=diasVoluntario;
	}
	
	public void setHorarioFinal (int horarioFinal) throws HorarioExcedidoException{
		if (horarioFinal<8 || horarioFinal>20) {
			throw new HorarioExcedidoException("Horario não permitido");
		} else {
			this.horarioFinal = horarioFinal;
		}
	}
	
	public void setHorarioInicial (int horarioInicial) throws HorarioExcedidoException{
		if (horarioInicial<8 || horarioInicial>20) {
			throw new HorarioExcedidoException("Horario não permitido");
		} else {
			this.horarioInicial = horarioInicial;
		}
	}
	
	public void setIdade(int idade) throws IdadeMaximaAtingidaException {
		if (idade<18) {
			this.idade = idade;
		} else {
			throw new IdadeMaximaAtingidaException ("Idade não permitida!");
		}
	}
	
	public void desativarVoluntario() {
		this.ativo = false;
	}
	
}