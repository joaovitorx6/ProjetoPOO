package model;

import exception.CPFInvalidoException;
import exception.LoginExcedidoException;
import exception.LoginInvalidoException;
import exception.SenhaExcedidaException;
import exception.TelefoneInvalidoException;

public class Usuario {
	private String login, senha, nome, cpf, telefone;
	boolean eAdmin;
	
	public Usuario(String login, String senha, String nome, String cpf, String telefone, boolean eAdmin) throws CPFInvalidoException, LoginExcedidoException, SenhaExcedidaException {
		if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
			}	
		}
		if (login.length()>6)
			throw new LoginExcedidoException("Número máximo de digitos do login foi excedido");
		if (senha.length()>6)
			throw new SenhaExcedidaException("Número máximo de digitos da senha foi excedido");
		
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone=telefone;
		this.eAdmin = eAdmin;
		
	}
	
	public boolean loginAdmin (String login, String senha) throws LoginInvalidoException{
		if (this.login.equals(login) && this.senha.equals(senha)) {
			return true;
		}else {
			throw new LoginInvalidoException("Login nao autorizado");
		}
	}
	
	public void tornarAdmin () {
		this.eAdmin = true;
	}
	
	public void removerAdmin () {
		this.eAdmin  = false;
	}
	
	public boolean geteAdmin() {
		return eAdmin;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public String getTelefone() {
		return telefone;
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
	
	public void atualizarSenha (String senha) throws SenhaExcedidaException{
		if (senha.length()>6) {
			throw new SenhaExcedidaException ("Número máximo de digitos da senha foi excedido");
		} else {
			this.senha = senha;
		}
	}
	
	public void atualizarLogin (String login) throws LoginExcedidoException{
		if (login.length()>6) {
			throw new LoginExcedidoException ("Número máximo de digitos do login foi excedido");
		} else {
			this.login = login;
		}
	}
	
	
}