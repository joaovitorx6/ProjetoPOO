
package model;
import java.util.ArrayList;

import exception.AnimalNaoEncontradoException;
import exception.CPFInvalidoException;

public class Adotante {
    
    private String nome, cpf, email, telefone, rua, cidade, bairro, CEP, UF;
    private int [] dataNascimento;

    ArrayList<Animal> arrAnimal = new ArrayList<Animal>();

    public Adotante () {
        this.nome=null;
        this.dataNascimento=null;
        this.cpf=null;
        this.email=null;
        this.telefone=null;
        this.rua=null;
        this.cidade=null;
        this.bairro=null;
        this.CEP=null;
        this.UF=null;
    }
    
    public Adotante (String nome, int [] dataNascimento, String cpf, String email, String telefone, String rua, String cidade, String bairro, String CEP, String UF) throws CPFInvalidoException {
    	if(cpf.length()!=11)
			throw new CPFInvalidoException("CPF deve conter 11 digitos");
		for (int i=0; i<cpf.length();i++) {
			char c = cpf.charAt(i);
			if (!Character.isDigit(c)) {
				throw new CPFInvalidoException("CPF deve contar apenas digitos");
			}	
		}
        this.nome=nome;
        this.dataNascimento=dataNascimento;
        this.cpf=cpf;
        this.email=email;
        this.telefone=telefone;
        this.rua=rua;
        this.cidade=cidade;
        this.bairro=bairro;
        this.CEP=CEP;
        this.UF=UF;
    }

    public String getNome() {
        return nome;
    }

    public int [] getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getUF() {
        return UF;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public void setUF (String UF){
        this.UF=UF;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(int [] dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setTelefoneCelular(String telefone) {
        this.telefone = telefone;
    }

    public void addAnimal (Animal animal) {
        arrAnimal.add(animal);
    }

    public Animal buscarAnimal (int idAnimal) throws AnimalNaoEncontradoException {
        
        for (int i=0; i<arrAnimal.size(); i++){
            if (arrAnimal.get(i).getidAnimal()==idAnimal){
                return arrAnimal.get(i);
            } 
        }
        
        throw new AnimalNaoEncontradoException ("ANIMAL NAO ENCONTRADO");
    }
    
    public void removerAnimal (int idAnimal){
        for (int i=0; i<arrAnimal.size(); i++){
            if (arrAnimal.get(i).getidAnimal()==idAnimal){
                arrAnimal.remove(i);
            } 
        }
    }
    
    public ArrayList<Animal> listarAnimais (){
        return arrAnimal;
    }
    
    public void realizarAdocao (Animal animal){
    	arrAnimal.add(animal);
    }
 
}
