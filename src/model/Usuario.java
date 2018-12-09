package model;

import controller.AbrigoAnimaisController;
import exception.CPFInvalidoException;
import exception.LoginExcedidoException;
import exception.LoginInvalidoException;
import exception.SenhaExcedidaException;
import exception.TelefoneInvalidoException;
import exception.CPFExistenteException;

public class Usuario {
	
	private String login, senha, nome, cpf, telefone;
	private int retorno;
	boolean eAdmin;
	Usuario [] arrUsuarios;
	AbrigoAnimaisController controller = new AbrigoAnimaisController();
	
	public Usuario(String login, String senha, String nome, String cpf, String telefone, boolean eAdmin) throws CPFInvalidoException, LoginExcedidoException, SenhaExcedidaException, CPFExistenteException {
		
		
		retorno = controller.verificarCPFUsuario(cpf);
		if(retorno == 1)
			throw new CPFExistenteException("CPF já existe");
		
		if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
			}	
		}
		if (login.length()>6)
			throw new LoginExcedidoException("N�mero m�ximo de digitos do login foi excedido");
		if (senha.length()>6)
			throw new SenhaExcedidaException("N�mero m�ximo de digitos da senha foi excedido");
		
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
	
	public String getSenha() {
		return senha;
	}
	
	public String getLogin() {
		return login;
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
				throw new CPFInvalidoException("CPF deve conter apenas digitos");
			}	
		}
		this.cpf = cpf;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void atualizarSenha (String senha) throws SenhaExcedidaException{
		if (senha.length()>6) {
			throw new SenhaExcedidaException ("N�mero m�ximo de digitos da senha foi excedido");
		} else {
			this.senha = senha;
		}
	}
	
	public void atualizarLogin (String login) throws LoginExcedidoException{
		if (login.length()>6) {
			throw new LoginExcedidoException ("N�mero m�ximo de digitos do login foi excedido");
		} else {
			this.login = login;
		}
	}
	
}