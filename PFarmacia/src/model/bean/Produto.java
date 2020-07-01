package model.bean;

public class Produto {
    private Integer cod_produto;
    private String descricao_produto;
    private Float valor_produto;
    private Integer endereco_cod_endereco;

    public Integer getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(Integer cod_produto) {
        this.cod_produto = cod_produto;
    }
    
    public Integer getEndereco_cod_endereco() {
        return endereco_cod_endereco;
    }

    public void setEndereco_cod_endereco(Integer endereco_cod_endereco) {
        this.endereco_cod_endereco = endereco_cod_endereco;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Float getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(Float valor_produto) {
        this.valor_produto = valor_produto;
    }

    @Override
    public String toString() {
        return cod_produto + "    - " + descricao_produto;
    }
    
    
}
