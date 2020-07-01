package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Venda {
    private Integer cod_venda;
    private Integer cliente_cod_cliente;
    private String nome_cliente;
    private Integer funcionario_cod_funcionario;
    private String nome_funcionario;
    private String data_venda = actualDate();
    private String hora_venda = actualTime();

    public Integer getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(Integer cod_venda) {
        this.cod_venda = cod_venda;
    }
    
    public String actualDate(){
        Date dateHourActual = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(dateHourActual);
        return date;
    }
    
    public String actualTime(){
        Date dateHourActual = new Date();
        String hour = new SimpleDateFormat("HH:mm:ss").format(dateHourActual);
        return hour;
    }
    
    public Integer getCliente_cod_cliente() {
        return cliente_cod_cliente;
    }

    public void setCliente_cod_cliente(Integer cliente_cod_cliente) {
        this.cliente_cod_cliente = cliente_cod_cliente;
    }

    public Integer getFuncionario_cod_funcionario() {
        return funcionario_cod_funcionario;
    }

    public void setFuncionario_cod_funcionario(Integer funcionario_cod_funcionario) {
        this.funcionario_cod_funcionario = funcionario_cod_funcionario;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }
    
    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public String getHora_venda() {
        return hora_venda;
    }

    public void setHora_venda(String hora_venda) {
        this.hora_venda = hora_venda;
    }
    
    
}
