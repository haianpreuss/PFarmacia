package model.bean;

public class Pessoa {
    private String cpf;
    private String telefone;
    private String dataNascimento;
    private Integer endereco_cod_endereco;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getEndereco_cod_endereco() {
        return endereco_cod_endereco;
    }

    public void setEndereco_cod_endereco(Integer endereco_cod_endereco) {
        this.endereco_cod_endereco = endereco_cod_endereco;
    }
    
}
