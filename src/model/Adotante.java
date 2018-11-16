
package model;

public class Adotante {
    
    public String nome, dataNascimento, cpf, sexo, email, telefoneCelular, telefoneFixo;
    public String rua, cidade, bairro, CEP, UF, nacionalidade, zona;
    //maior de 18 anos
    
    int contadorAnimal=0;

    Animal [] arrAnimal = new Animal [100]; 

    public Adotante () {
        this.nome=null;
        this.dataNascimento=null;
        this.cpf=null;
        this.sexo=null;
        this.email=null;
        this.telefoneCelular=null;
        this.telefoneFixo=null;
        this.rua=null;
        this.cidade=null;
        this.bairro=null;
        this.CEP=null;
        this.UF=null;
        this.nacionalidade=null;
        this.zona=null;
    }
    
    public Adotante (String nome, String dataNascimento, String cpf, String sexo, String email, String telefoneCelular, String telefoneFixo, String rua, String cidade, String bairro, String CEP, String UF, String nacionalidade, String zona) {
 
        this.nome=nome;
        this.dataNascimento=dataNascimento;
        this.cpf=cpf;
        this.sexo=sexo;
        this.email=email;
        this.telefoneCelular=telefoneCelular;
        this.telefoneFixo=telefoneFixo;
        this.rua=rua;
        this.cidade=cidade;
        this.bairro=bairro;
        this.CEP=CEP;
        this.UF=UF;
        this.nacionalidade=nacionalidade;
        this.zona=zona;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getRua() {
        return rua;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getUF() {
        return UF;
    }

    public String getZona() {
        return zona;
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

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void addAnimal (Animal animal) {
        arrAnimal[contadorAnimal]=animal;
        contadorAnimal++;
    }

    public Animal buscarAnimal (int idAnimal) throws AnimalNaoEncontradoException {
        
        for (int i=0; i<arrAnimal.length; i++){
            if (arrAnimal[i].getidAnimal==idAnimal){
                return arrAnimal[i];
            } 
        }
        
        throw new AnimalNaoEncontradoException ("Animal não encontrado");
    }

    //remover animal, seria colocar nulo no arr, ou tirar a ligação dele com o adotante??
    //feedback de animal removido seria uma exceção? 
    
    public void removerAnimal (int idAnimal){
        for (int i=0; i<arrAnimal.lenght; i++){
            if (arrAnimal[i].getidAnimal==idAnimal){
                arrAnimal[i]=null;
            } 
        }
    }
    
    public Animal [] listarAnimais (){
        return arrAnimal;
    }
    

}
