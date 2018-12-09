package controller;
import java.util.*;

import model.Adotante;
import model.Animal;
import model.Doador;
import model.Voluntario;
import model.Doacao;
import model.Usuario;
import exception.AnimalNaoEncontradoException;
import exception.CPFInvalidoException;
import exception.DoadorNaoEncontradoException;
import exception.LoginExcedidoException;
import exception.SenhaExcedidaException;
import exception.VoluntarioNaoEncontradoException;
import exception.AdotanteNaoEncontradoException;
import exception.CPFExistenteException;
import exception.DoacaoNaoEncontradaException;
import exception.UsuarioNaoEncontradoException;

public class AbrigoAnimaisController {
	
	Usuario [] arrUsuarios = new Usuario[100];
	Animal [] arrAnimais = new Animal[100];
    Adotante [] arrAdotantes = new Adotante[100];
    Doador [] arrDoadores = new Doador[100];
    Voluntario [] arrVoluntarios = new Voluntario[100];
    Doacao [] arrDoacoes = new Doacao [100];
    ArrayList<Animal> arrAnimaisAux = new ArrayList<Animal>();
    Adotante adotante;
    ArrayList<Doacao> arrDoacoesAux = new ArrayList<Doacao>();
    
    int indiceAnimais=0, iDoador=0, iVoluntario=0, iDoacao=0, iAdotante, iUsuario=0;
    
    
    ////////////ANIMAL/////////////////////
    
    
    ////////////ANIMAL/////////////////////
    
    //BUSCAR ANIMAL CADASTRADO POR ID
    public Animal buscarAnimalporID(int id) throws AnimalNaoEncontradoException {
    	for(int i=0; i<arrAnimais.length; i++) {
    		if (arrAnimais[i]!=null && arrAnimais[i].getidAnimal()==id) {
    			return arrAnimais[i];
    		}
    	}
    	
    	throw new AnimalNaoEncontradoException("ANIMAL NAO ENCONTRADO!");	   	
    	
    }
    
    //LISTAR ANIMAIS DISPONIVEIS PARA ADOCAO FILTRADOS POR TIPO
    public ArrayList<Animal> listarAnimaisDiponiveis(int tipo) throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	if(tipo==3) {
    		for (int i=0; i<arrAnimais.length; i++) {
	    		if(arrAnimais[i]!=null && arrAnimais[i].getDisponivelAdocao()==true) {
	    			arrAnimaisAux.add(arrAnimais[i]);
	    		}
	    	}
		}else {
    	
	    	for (int i=0; i<arrAnimais.length; i++) {
	    		if(arrAnimais[i]!=null && arrAnimais[i].getTipo()==tipo && arrAnimais[i].getDisponivelAdocao()==true) {
	    			arrAnimaisAux.add(arrAnimais[i]);
	    		}
	    	}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS CADASTRADOS");
    	}
    		
    	return arrAnimaisAux;
    }
    
    //CADASTRANDO ANIMAIS NO ARRAY
    public void cadastrarAnimal(Animal animal) {
    	arrAnimais[indiceAnimais] = animal;
    	indiceAnimais++;
    }
    
    //LISTAR ANIMAIS POR TIPO
    public ArrayList<Animal> listarAnimaisPorTipo (int tipo) throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
 
		if(tipo==3) {
			for (int i=0; i<arrAnimais.length; i++) {
	    		if(arrAnimais[i]!=null) {
	    			arrAnimaisAux.add(arrAnimais[i]);
	    		}
	    	}
		}else {
			for (int j=0; j<arrAnimais.length; j++) {
	    		if(arrAnimais[j]!=null && arrAnimais[j].getTipo()==tipo) {
	    			arrAnimaisAux.add(arrAnimais[j]);
	    		}
	    	}
		}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    //LISTAR ANIMAIS CASTRADOS
    public ArrayList<Animal> listarAnimaisCastrados() throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getCastrado()==true) {
				arrAnimaisAux.add(arrAnimais[i]);
			}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS CASTRADOS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    //LISTAR ANIMAIS NAO CASTRADOS
    public ArrayList<Animal> listarAnimaisNaoCastrados() throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getCastrado()==false) {
				arrAnimaisAux.add(arrAnimais[i]);
			}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS NAO CASTRADOS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    //LISTAR ANIMAIS VERMIFUGADOS
    public ArrayList<Animal> listarAnimaisVermifugados() throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getVermifugado()==true) {
				arrAnimaisAux.add(arrAnimais[i]);
			}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS VERMIFUGADOS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    //LISTAR ANIMAIS NAO VERMIFUGADOS
    public ArrayList<Animal> listarAnimaisNaoVermifugados() throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getVermifugado()==false) {
				arrAnimaisAux.add(arrAnimais[i]);
			}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS NAO VERMIFUGADOS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    //LISTAR ANIMAIS ADOTADOS
    public ArrayList<Animal> listarAnimaisAdotados() throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getAdotado()==true) {
				arrAnimaisAux.add(arrAnimais[i]);
			}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS ADOTADOS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    //LISTAR ANIMAIS NAO ADOTADOS
    public ArrayList<Animal> listarAnimaisNaoAdotados() throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getAdotado()==false) {
				arrAnimaisAux.add(arrAnimais[i]);
			}
    	}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("NAO HA ANIMAIS NAO ADOTADOS CADASTRADOS");
    	}
    	
    	return arrAnimaisAux;
    }
    
    ////////////ADOTANTE/////////////////////
    
    //CADASTRAR ADOTANTE NO ARRAY
    public void cadastrarAdotante(Adotante adotante) {
    	arrAdotantes[iAdotante] = adotante;
    	iAdotante++;
    }
    
    //BUSCANDO ADOTANTE NO ARRAY
    public Adotante buscarAdotante(String cpf) throws CPFInvalidoException, AdotanteNaoEncontradoException{
    	if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF DEVE CONTER 11 DIGITOS");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF DEVE CONTER APENAS DIGITOS");
			}	
		}
		
		for (int i=0;i<arrAdotantes.length; i++) {
			if(arrAdotantes[i]!=null && arrAdotantes[i].getCpf().equals(cpf)) {
				return arrAdotantes[i];
			}
		}
		
		throw new AdotanteNaoEncontradoException("Adotante nao cadastrado");
		
    }
    
    //REMOVER ADOTANTE
    public void removerAdotante(String cpf) {
		for (int i=0;i<arrAdotantes.length; i++) {
			if(arrAdotantes[i]!=null && arrAdotantes[i].getCpf().equals(cpf)) {
				arrAdotantes[i] = null;
			}
		}
    }
    
    //LISTAR ADOTANTES
    public Adotante [] listarAdotantes(){
    	return arrAdotantes;
    }
    
    //LISTAR ANIMAIS ADOTADOS POR ADOTANTE
    public ArrayList<Animal> listarAnimaisAdotadosPorAdotante(String cpf) throws AnimalNaoEncontradoException {
    	arrAnimaisAux.clear();
    	
    	for (int i=0;i<arrAdotantes.length; i++) {
			if(arrAdotantes[i]!=null && arrAdotantes[i].getCpf().equals(cpf)) {
				arrAnimaisAux = arrAdotantes[i].listarAnimais();
				break;
			}
		}
    	
    	if(arrAnimaisAux.isEmpty()) {
    		throw new AnimalNaoEncontradoException("ADOTANTE NAO POSSUI ANIMAIS ADOTADOS!");
    	}
    	
    	return arrAnimaisAux;
    	
    }
    
    ////////////DOADOR/////////////////////
    
    //CADASTRAR DOADOR NO ARRAY
    public void cadastrarDoador (Doador doador) {
    	arrDoadores[iDoador]=doador;
    	iDoador++;
    }
    
    //BUSCAR DOADOR POR CPF
    public Doador buscarDoador (String cpf) throws DoadorNaoEncontradoException {
    	for (int i=0; i<arrDoadores.length;i++) {
    		if (arrDoadores[i]!=null) {
	    		if (arrDoadores[i].getCpf().equals(cpf)) 
	    			return arrDoadores[i];	
    		}
    	}
    	throw new DoadorNaoEncontradoException("DOADOR NAO ENCONTRADO!");
    }
    
    //VERIFICAR SE CPF DE DOADOR JA ESTA CADASTRADO
    public void verificarCPFDoador (String cpf) throws CPFExistenteException {
    	for (int i=0; i<arrDoadores.length;i++) {
    		if (arrDoadores[i]!=null) {
	    		if (arrDoadores[i].getCpf().equals(cpf)) 
	    			throw new CPFExistenteException("CPF JA EXISTENTE NO SISTEMA!");	
    		}
    	}
<<<<<<< HEAD
    }
    
<<<<<<< HEAD
    public Usuario buscarUsuario (String login, String senha) throws UsuarioNaoEncontradoException {
    	for (int i=0; i<arrUsuarios.length;i++) {
    		if (arrUsuarios[i]!=null) {
	    		if (arrUsuarios[i].getLogin().equals(login) && arrUsuarios[i].getSenha().equals(senha)) 
	    			return arrUsuarios[i];	
    		}
    	}
    	throw new UsuarioNaoEncontradoException("Usuario não encontrado!!");
    }
    
    public void verificarCPFDoador (String cpf) throws CPFExistenteException {
=======
    //DESVINCULAR DOADOR
    public int desvincularDoador (String cpf) {
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
=======
    }
    
    //DESVINCULAR DOADOR
    public int desvincularDoador (String cpf) {
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
    	for (int i=0; i<arrDoadores.length;i++) {
    		if(arrDoadores[i]!=null) {
    			if (arrDoadores[i].getCpf().equals(cpf)) 
    				arrDoadores[i]=null;
    			return 1;
    		}
    	}
    	return 0;
    }
    
    //BUSCAR DOADORES
    public Doador [] buscarArrDoadores() {
    	return arrDoadores;
    }
    
    ////////////VOLUNTARIO/////////////////////
    
    //CADASTRAR VOLUNTARIO
    public void cadastrarVoluntario (Voluntario voluntario) {
    	arrVoluntarios[iVoluntario]=voluntario;
    	iVoluntario++;
    }
    
    //BUSCAR VOLUNTARIO POR CPF
    public Voluntario buscarVoluntario (String cpf) throws VoluntarioNaoEncontradoException {
    	for (int i=0; i<arrVoluntarios.length;i++) {
    		if (arrVoluntarios[i]!=null) {
	    		if (arrVoluntarios[i].getCpf().equals(cpf)) 
	    			return arrVoluntarios[i];	
    		}
    	}
    	throw new VoluntarioNaoEncontradoException("VOLUNTARIO NAO ENCONTRADO!");
<<<<<<< HEAD
    }
    
<<<<<<< HEAD
    
    public int verificarCPFUsuario (String cpf) {
    	for(int i=0; i<arrUsuarios.length;i++) {
    		if (arrUsuarios[i]!=null) {
    			if (arrUsuarios[i].getCPF().equals(cpf)) {
    				return 1;
    			}
    		}
     	}
    	return 0;
    }
    
    public int desvincularDoador (String cpf) {
    	for (int i=0; i<arrDoadores.length;i++) {
    		if(arrDoadores[i]!=null) {
    			if (arrDoadores[i].getCpf().equals(cpf)) 
    				arrDoadores[i]=null;
    			return 1;
=======
=======
    }
    
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
    //VERIFICAR SE CPF DE VOLUNTARIO JA EXISTE
    public void verificarCPFVoluntario (String cpf) throws CPFExistenteException {
    	for (int i=0; i<arrVoluntarios.length;i++) {
    		if (arrVoluntarios[i]!=null) {
	    		if (arrVoluntarios[i].getCpf().equals(cpf)) 
	    			throw new CPFExistenteException("CPF JA EXISTENTE NO SISTEMA!");	
<<<<<<< HEAD
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
=======
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
    		}
    	}
    }
    
    //DESVINCULAR VOUNTARIO
    public int desvincularVoluntario (String cpf) {
    	for (int i=0; i<arrVoluntarios.length;i++) {
    		if(arrVoluntarios[i]!=null) {
    			if (arrVoluntarios[i].getCpf().equals(cpf)) 
    				arrVoluntarios[i]=null;
    			return 1;
    		}
    	}
    	return 0;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    public int desativarUsuario (String cpf) {
    	for (int i=0; i<arrUsuarios.length;i++) {
    		if(arrUsuarios[i]!=null) {
    			if (arrUsuarios[i].getCPF().equals(cpf)) 
    				arrUsuarios[i]=null;
    			return 1;
    		}
    	}
    	return 0;
    }
    
    public Doador [] buscarArrDoadores() {
    	return arrDoadores;
    }
    
    public Voluntario [] buscarArrVoluntarios() {
    	return arrVoluntarios;
    }
    
    public Usuario [] buscarArrUsuarios() {
    	return arrUsuarios;
    }
    
=======
    //BUSCAR VOLUNTARIO
    public Voluntario [] buscarArrVoluntarios(){
    	return arrVoluntarios;
    }
    
    ////////////DOACAO/////////////////////
    
    //CADASTRAR DOACOES NO ARRAY
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
=======
    //BUSCAR VOLUNTARIO
    public Voluntario [] buscarArrVoluntarios(){
    	return arrVoluntarios;
    }
    
    ////////////DOACAO/////////////////////
    
    //CADASTRAR DOACOES NO ARRAY
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
    public void cadastrarDoacoes(Doacao doacao) {
    	arrDoacoes[iDoacao] = doacao;
    	iDoacao++;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    public void cadastrarUsuario(Usuario usuario) {
    	arrUsuarios[iUsuario] = usuario;
    	iUsuario++;
    }
    
=======
    //LISTAR DOACOES
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
=======
    //LISTAR DOACOES
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
    public ArrayList<Doacao> listarDoacoes() throws DoacaoNaoEncontradaException{
    	arrDoacoesAux.clear();
    	for (int i=0; i<arrDoacoes.length; i++) {
    		if(arrDoacoes[i]!=null) {
    			arrDoacoesAux.add(arrDoacoes[i]);
    		}
    	}
    	
    	if(arrDoacoesAux.isEmpty()) {
    		throw new DoacaoNaoEncontradaException("NAO HA DOACOES CADASTRADAS!");
    	}
    	
    	return arrDoacoesAux;
    }
    
    //LISTAR DOACOES POR DOADOR
    public ArrayList<Doacao> listarDoacoesPorDoador(String cpf, Doador doador) throws DoacaoNaoEncontradaException{
    	arrDoacoesAux.clear();
    	
    	for (int i=0; i<arrDoacoes.length; i++) {
    		if(arrDoacoes[i]!=null && arrDoacoes[i].getDoador().equals(doador)) {
    			arrDoacoesAux.add(arrDoacoes[i]);
    		}
    	}
    	
    	if(arrDoacoesAux.isEmpty()) {
    		throw new DoacaoNaoEncontradaException("DOADOR NAO REALIZOU NENHUMA DOACAO!");
    	}
    	
    	return arrDoacoesAux;
    }
<<<<<<< HEAD
<<<<<<< HEAD
     
	
}
=======
}
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
=======
}
>>>>>>> f173d806b03f11c863f2a29bb1bfe7b3111af19b
