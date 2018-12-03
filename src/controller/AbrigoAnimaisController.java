package controller;

import model.Adotante;
import model.Animal;
import model.Doador;
import model.Voluntario;
import exception.AnimalNaoEncontradoException;
import exception.CPFInvalidoException;
import exception.DoadorNaoEncontradoException;
import exception.VoluntarioNaoEncontradoException;
import exception.AdotanteNaoEncontradoException;
import exception.CPFExistenteException;

public class AbrigoAnimaisController {
	
	Animal [] arrAnimais = new Animal[100];
    Adotante [] arrAdotantes = new Adotante[100];
    Doador [] arrDoadores = new Doador[100];
    Voluntario [] arrVoluntarios = new Voluntario[100];
    Animal [] arrAnimaisAux;
    Adotante adotante;
    
    int indiceAnimais=0, iDoador=0, iVoluntario=0;
    
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
    public Animal [] listarAnimaisDiponiveis(int tipo) throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
    		if(tipo==3) {
    			arrAnimaisAux = arrAnimais;
    		}else {
    			if(arrAnimais[i]!=null && arrAnimais[i].getTipo()==tipo && arrAnimais[i].getDisponivelAdocao()==true) {
    				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
    				indiceAnimaisAux++;
    			}
    		}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Não há animais cadastrados com esse parâmetros");
    	}
    		
    	return arrAnimaisAux;
    }
    
    //CADASTRANDO ANIMAIS NO ARRAY
    public void cadastrarAnimal(Animal animal) {
    	arrAnimais[indiceAnimais] = animal;
    	indiceAnimais++;
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
    
    public Doador [] buscarArrDoadores() {
    	return arrDoadores;
    }
    
    
}
