package controller;

import model.Adotante;
import model.Animal;
import exception.AnimalNaoEncontradoException;
import exception.CPFInvalidoException;
import exception.AdotanteNaoEncontradoException;

public class AbrigoAnimaisController {
	
	Animal [] arrAnimais = new Animal[100];
    Adotante [] arrAdotantes = new Adotante[100];
    Animal [] arrAnimaisAux;
    Adotante adotante;
    
    int indiceAnimais=0;
    
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
}
