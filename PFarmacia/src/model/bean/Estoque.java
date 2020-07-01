package model.bean;

public class Estoque {  
    private Integer cod_estoque;
    private Integer quantidade_estoque;
    private String data_lote;
    private String lote_estoque;
    private Integer produto_cod_produto;
    private String descricao_produto_estoque;

    public String getDescricao_produto_estoque() {
        return descricao_produto_estoque;
    }

    public void setDescricao_produto_estoque(String descricao_produto_estoque) {
        this.descricao_produto_estoque = descricao_produto_estoque;
    }
    
    public Integer getCod_estoque() {
        return cod_estoque;
    }

    public void setCod_estoque(Integer cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    public Integer getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(Integer quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public String getLote_estoque() {
        return lote_estoque;
    }

    public void setLote_estoque(String lote_estoque) {
        this.lote_estoque = lote_estoque;
    }

    public String getData_lote() {
        return data_lote;
    }

    public void setData_lote(String data_lote) {
        this.data_lote = data_lote;
    }

    public Integer getProduto_cod_produto() {
        return produto_cod_produto;
    }

    public void setProduto_cod_produto(Integer produto_cod_produto) {
        this.produto_cod_produto = produto_cod_produto;
    }   
    
    
}
