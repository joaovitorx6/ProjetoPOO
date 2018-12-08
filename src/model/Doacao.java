package model;

public class Doacao {
    
    public String descricao;
    public int idDoacao;
    public String dataDoacao;
    public Doador doador;
    
    public Doacao (){
        this.descricao=null;       
        this.dataDoacao=null;
        this.doador=null;
        this.idDoacao=0;
    }
    
    public Doacao (String descricao, String dataDoacao, Doador doador, int idDoacao){
        this.descricao=descricao;
        this.dataDoacao=dataDoacao;
        this.doador=doador;
        this.idDoacao=idDoacao;
    }
    
    public String getDescricao(){
        return descricao;
    }

    public String getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(String dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public Doador getDoador (){
        return doador;
    }
    
    public void setDoador (Doador doador){
        this.doador=doador;
    }

    public int getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(int idDoacao) {
        this.idDoacao = idDoacao;
    }
    
}