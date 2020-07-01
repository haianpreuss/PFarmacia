package model.bean;

public class Cliente extends Pessoa{
    private Integer cod_cliente;
    private String sexo_cliente;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    public String getSexo_cliente() {
        return sexo_cliente;
    }

    public void setSexo_cliente(String sexo_cliente) {
        this.sexo_cliente = sexo_cliente;
    }

    @Override
    public String toString() {
        return cod_cliente + "    - " + nome + " | CPF: " + getCpf();
    }
    
    
}
