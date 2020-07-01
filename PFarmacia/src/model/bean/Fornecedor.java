package model.bean;

public class Fornecedor {
    private Integer cod_fornecedor;
    private String nome_fornecedor;
    private String cnpj_fornecedor;
    private String telefone_fornecedor;
    private Integer endereco_cod_endereco;

    public Integer getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(Integer cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }
    
    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getCnpj_fornecedor() {
        return cnpj_fornecedor;
    }

    public void setCnpj_fornecedor(String cnpj_fornecedor) {
        this.cnpj_fornecedor = cnpj_fornecedor;
    }

    public String getTelefone_fornecedor() {
        return telefone_fornecedor;
    }

    public void setTelefone_fornecedor(String telefone_fornecedor) {
        this.telefone_fornecedor = telefone_fornecedor;
    }

    public Integer getEndereco_cod_endereco() {
        return endereco_cod_endereco;
    }

    public void setEndereco_cod_endereco(Integer endereco_cod_endereco) {
        this.endereco_cod_endereco = endereco_cod_endereco;
    }

    @Override
    public String toString() {
        return cod_fornecedor + "   - " + nome_fornecedor;
    }

    
    
    
}
