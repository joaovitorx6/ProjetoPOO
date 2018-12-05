package controller;

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
    Animal [] arrAnimaisAux;
    Adotante adotante;
    Doacao [] arrDoacoesAux;
    
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
    
    public Animal [] listarAnimaisPorTipo (int tipo) throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
    		if(tipo==3) {
    			arrAnimaisAux = arrAnimais;
    		}else {
    			if(arrAnimais[i]!=null && arrAnimais[i].getTipo()==tipo) {
    				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
    				indiceAnimaisAux++;
    			}
    		}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
    }
    
    public Animal [] listarAnimaisCastrados() throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getCastrado()==true) {
				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
				indiceAnimaisAux++;
			}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
    }
    
    public Animal [] listarAnimaisNaoCastrados() throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getCastrado()==false) {
				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
				indiceAnimaisAux++;
			}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
    }
    
    public Animal [] listarAnimaisVermifugados() throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getVermifugado()==true) {
				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
				indiceAnimaisAux++;
			}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
    }
    
    public Animal [] listarAnimaisNaoVermifugados() throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getVermifugado()==false) {
				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
				indiceAnimaisAux++;
			}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
    }
    
    public Animal [] listarAnimaisAdotados() throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getAdotado()==true) {
				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
				indiceAnimaisAux++;
			}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
    }
    
    public Animal [] listarAnimaisNaoAdotados() throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	arrAnimaisAux=null;
    	
    	for (int i=0; i<arrAnimais.length; i++) {
			if(arrAnimais[i]!=null && arrAnimais[i].getAdotado()==false) {
				arrAnimaisAux[indiceAnimaisAux] = arrAnimais[i];
				indiceAnimaisAux++;
			}
    	}
    	
    	if(arrAnimais==null) {
    		throw new AnimalNaoEncontradoException("Nao ha animais cadastrados desse tipo");
    	}
    	
    	return arrAnimais;
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
    public Animal[] listarAnimaisAdotadosPorAdotante(String cpf) throws AnimalNaoEncontradoException {
    	int indiceAnimaisAux=0;
    	for (int i=0;i<arrAdotantes.length; i++) {
			if(arrAdotantes[i]!=null && arrAdotantes[i].getCpf().equals(cpf)) {
				arrAnimaisAux[indiceAnimaisAux] = null;
				indiceAnimaisAux++;
			}
		}
    	
    	if(arrAnimaisAux==null) {
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
    
    public Doacao [] listarDoacoes() {
    	return arrDoacoes;
    }
    
    public Doacao [] listarDoacoesPorDoador(Doador doador) throws DoacaoNaoEncontradaException{
    	int indiceDoacoesAux=0;
    	for (int i=0; i<arrDoacoes.length; i++) {
    		if(arrDoacoes[i]!=null && arrDoacoes[i].getDoador().getCpf().equals(doador.getCpf())) {
    			arrDoacoesAux[indiceDoacoesAux]=arrDoacoes[i];
    			indiceDoacoesAux++;
    		}
    	}
    	
    	if(arrDoacoesAux==null) {
    		throw new DoacaoNaoEncontradaException("Doador nao possue doacoes");
    	}
    	
    	return arrDoacoesAux;
    }
}
