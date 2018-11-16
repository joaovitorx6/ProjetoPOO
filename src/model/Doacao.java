package model;

public class Doacao {
    
    public String descricao;
    public int codigo;
    public int idDoacao;
    public int quantidade;
    public String dataValidade;
    public String dataDoacao;
    public Doador doador;
    
    public Doacao (){
        this.descricao=null;
        this.codigo=0;
        this.quantidade=0;
        this.dataValidade=null;
        this.dataDoacao=null;
        this.doador=null;
        this.idDoacao=0;
    }
    
    public Doacao (String descricao, int codigo, int quantidade, String dataValidade, String dataDoacao, Doador doador, int idDoacao){
        this.descricao=descricao;
        this.codigo=codigo;
        this.quantidade=quantidade;
        this.dataValidade=dataValidade;
        this.dataDoacao=dataDoacao;
        this.doador=doador;
        this.idDoacao=idDoacao;
    }
    
    public String getDescricao(){
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDataDoacao() {
        return dataDoacao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDataDoacao(String dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
