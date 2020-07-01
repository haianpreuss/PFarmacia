package model.bean;

public class Venda_produto {
    private Integer venda_cod_venda;
    private Integer produto_cod_produto;
    private Integer quantidade_produto;
    private String descricao_produto;
    private Double valor_produto;

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Double getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(Double valor_produto) {
        this.valor_produto = valor_produto;
    }

    public Integer getVenda_cod_venda() {
        return venda_cod_venda;
    }

    public void setVenda_cod_venda(Integer venda_cod_venda) {
        this.venda_cod_venda = venda_cod_venda;
    }

    public Integer getProduto_cod_produto() {
        return produto_cod_produto;
    }

    public void setProduto_cod_produto(Integer produto_cod_produto) {
        this.produto_cod_produto = produto_cod_produto;
    }

    public Integer getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(Integer quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }
    
    
}
