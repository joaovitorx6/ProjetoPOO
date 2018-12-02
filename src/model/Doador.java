
package model;
import exception.TelefoneInvalidoException;
import exception.CPFInvalidoException;
import exception.DoacaoNaoEncontradaException;
import exception.IdadeMaximaAtingidaException;

public class Doador {
    
    public String nome, cpf, telefone, endereco;
    public int [] dataNascimento;
    
    int contadorDoacoes;
    public Doacao [] arrDoacoes = new Doacao [100];
    
    public Doador () {
        this.nome=null;
        this.dataNascimento=null;
        this.cpf=null;
        this.telefone=null;
        this.endereco=null;
    }
    
    public Doador (String nome, int dataNascimento [], String cpf, String telefone, String endereco) throws IdadeMaximaAtingidaException, CPFInvalidoException, TelefoneInvalidoException {
    	
    	if (dataNascimento[2]>1999)
    		throw new IdadeMaximaAtingidaException("Idade não permitida, só cadastramos maiores de 18 anos.");
    	if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
			}	
		}
		
		if(telefone.length()!=11)
			throw new TelefoneInvalidoException("Telefone deve conter 11 digitos.");
		
        this.nome=nome;
        this.dataNascimento = new int [3];
        this.cpf=cpf;
        this.telefone=telefone;
        this.endereco=endereco;
    }
    
     public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getTelefone() {
		return telefone;
	}
    
    public String getEndereco() {
		return endereco;
	}
    
    public int [] getDataNascimento() {
		return dataNascimento;
	}
    
    public void setCpf(String cpf) throws CPFInvalidoException {
    	
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
    	if(telefone.length()!=11)
			throw new TelefoneInvalidoException("Telefone deve conter 11 digitos.");
    	this.telefone = telefone;
	}
    
    public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addDoacao (Doacao doacao){
        arrDoacoes[contadorDoacoes]=doacao;
        contadorDoacoes++;
    }
    
    public Doacao [] listarDoacoes (){
        return arrDoacoes;
    }
    
    public Doacao buscarDoacao (int idDoacao) throws DoacaoNaoEncontradaException {
        
        for (int i=0; i<arrDoacoes.length; i++){
            if (arrDoacoes[i].getIdDoacao()==idDoacao){
                return arrDoacoes[i];
            } 
        }
        
        throw new DoacaoNaoEncontradaException ("Doa�ao n�o encontrada!");
    }
    
}
