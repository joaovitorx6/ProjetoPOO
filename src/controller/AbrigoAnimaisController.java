package controller;
import java.util.*;

import model.Adotante;
import model.Animal;
import model.Doador;
import model.Voluntario;
import model.Doacao;
import exception.AnimalNaoEncontradoException;
import exception.CPFInvalidoException;
import exception.DoadorNaoEncontradoException;
import exception.VoluntarioNaoEncontradoException;
import exception.AdotanteNaoEncontradoException;
import exception.CPFExistenteException;
import exception.DoacaoNaoEncontradaException;

public class AbrigoAnimaisController {
	
	Animal [] arrAnimais = new Animal[100];
    Adotante [] arrAdotantes = new Adotante[100];
    Doador [] arrDoadores = new Doador[100];
    Voluntario [] arrVoluntarios = new Voluntario[100];
    Doacao [] arrDoacoes = new Doacao [100];
    ArrayList<Animal> arrAnimaisAux = new ArrayList<Animal>();
    Adotante adotante;
    ArrayList<Doacao> arrDoacoesAux = new ArrayList<Doacao>();
    
    int indiceAnimais=0, iDoador=0, iVoluntario=0, iDoacao=0, iAdotante;
    
    //BUSCAR ANIMAL CADASTRADO POR ID
    public Animal buscarAnimalporID(int id) throws AnimalNaoEncontradoException {
    	for(int i=0; i<arrAnimais.length; i++) {
    		if (arrAnimais[i]!=null && arrAnimais[i].getidAnimal()==id) {
    			return arrAnimais[i];
    		}
    	}
    	
    	throw new AnimalNaoEncontradoException("Animal nao encontrado!");	   	
    	
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
    
    //CADASTRAR ADOTANTE NO ARRAY
    public void cadastrarAdotante(Adotante adotante) {
    	arrAdotantes[iAdotante] = adotante;
    	iAdotante++;
    }
    
    //BUSCANDO ADOTANTE NO ARRAY
    public Adotante buscarAdotante(String cpf) throws CPFInvalidoException, AdotanteNaoEncontradoException{
    	if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
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
    		throw new AnimalNaoEncontradoException("Adotante nao possui animais adotados.");
    	}
    	
    	return arrAnimaisAux;
    	
    }
    
    public void cadastrarDoador (Doador doador) {
    	arrDoadores[iDoador]=doador;
    	iDoador++;
    }
    
    public void cadastrarVoluntario (Voluntario voluntario) {
    	arrVoluntarios[iVoluntario]=voluntario;
    	iVoluntario++;
    }
    
    public Doador buscarDoador (String cpf) throws DoadorNaoEncontradoException {
    	for (int i=0; i<arrDoadores.length;i++) {
    		if (arrDoadores[i]!=null) {
	    		if (arrDoadores[i].getCpf().equals(cpf)) 
	    			return arrDoadores[i];	
    		}
    	}
    	throw new DoadorNaoEncontradoException("Doador não encontrado!!");
    }
    
    public Voluntario buscarVoluntario (String cpf) throws VoluntarioNaoEncontradoException {
    	for (int i=0; i<arrVoluntarios.length;i++) {
    		if (arrVoluntarios[i]!=null) {
	    		if (arrVoluntarios[i].getCpf().equals(cpf)) 
	    			return arrVoluntarios[i];	
    		}
    	}
    	throw new VoluntarioNaoEncontradoException("Voluntario não encontrado!!");
    }
    
    public void verificarCPFDoador (String cpf) throws CPFExistenteException {
    	for (int i=0; i<arrDoadores.length;i++) {
    		if (arrDoadores[i]!=null) {
	    		if (arrDoadores[i].getCpf().equals(cpf)) 
	    			throw new CPFExistenteException("CPF já existente no sistema!!");	
    		}
    	}
    }
    
    public void verificarCPFVoluntario (String cpf) throws CPFExistenteException {
    	for (int i=0; i<arrVoluntarios.length;i++) {
    		if (arrVoluntarios[i]!=null) {
	    		if (arrVoluntarios[i].getCpf().equals(cpf)) 
	    			throw new CPFExistenteException("CPF já existente no sistema!!");	
    		}
    	}
    }
    
    public int desvincularDoador (String cpf) {
    	for (int i=0; i<arrDoadores.length;i++) {
    		if(arrDoadores[i]!=null) {
    			if (arrDoadores[i].getCpf().equals(cpf)) 
    				arrDoadores[i]=null;
    			return 1;
    		}
    	}
    	return 0;
    }
    
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
    
    public Doador [] buscarArrDoadores() {
    	return arrDoadores;
    }
    
    public Voluntario [] buscarArrVoluntarios() {
    	return arrVoluntarios;
    }
    
    public void cadastrarDoacoes(Doacao doacao) {
    	arrDoacoes[iDoacao] = doacao;
    	iDoacao++;
    }
    
    public ArrayList<Doacao> listarDoacoes() throws DoacaoNaoEncontradaException{
    	arrDoacoesAux.clear();
    	for (int i=0; i<arrDoacoes.length; i++) {
    		if(arrDoacoes[i]!=null) {
    			arrDoacoesAux.add(arrDoacoes[i]);
    		}
    	}
    	
    	if(arrDoacoesAux.isEmpty()) {
    		throw new DoacaoNaoEncontradaException("NAO HA DOACOES CADASTRADAS");
    	}
    	
    	return arrDoacoesAux;
    }
    
    public ArrayList<Doacao> listarDoacoesPorDoador(String cpf) throws DoacaoNaoEncontradaException{
    	arrDoacoesAux.clear();
    	for (int i=0; i<arrDoacoes.length; i++) {
    		if(arrDoacoes[i]!=null && arrDoacoes[i].getDoador().getCpf().equals(cpf)) {
    			arrDoacoesAux.add(arrDoacoes[i]);
    		}
    	}
    	
    	if(arrDoacoesAux.isEmpty()) {
    		throw new DoacaoNaoEncontradaException("DOADOR NAO REALIZOU NENHUMA DOACAO");
    	}
    	
    	return arrDoacoesAux;
    }
}
