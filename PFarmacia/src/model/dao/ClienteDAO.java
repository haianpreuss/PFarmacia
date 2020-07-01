/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cliente;

public class ClienteDAO {

    private ConnectionFactory connection;

    public ClienteDAO() {
        connection = new ConnectionFactory();
    }

    public Integer create(Cliente cliente) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int chave = 0;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into cliente(nome_cliente, cpf_cliente, telefone_cliente, sexo_cliente, data_nascimento_cliente, endereco_cod_endereco)"
                    + " values (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getSexo_cliente());
            stmt.setString(5, cliente.getDataNascimento());
            stmt.setInt(6, cliente.getEndereco_cod_endereco());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt,rs);
        }
        return chave;
    }

    public List<Cliente> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from cliente where deletado_cliente is null");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCod_cliente(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setCpf(rs.getString("cpf_cliente"));
                cliente.setTelefone(rs.getString("telefone_cliente"));
                cliente.setSexo_cliente(rs.getString("sexo_cliente"));
                cliente.setDataNascimento(rs.getString("data_nascimento_cliente"));
                cliente.setEndereco_cod_endereco(rs.getInt("endereco_cod_endereco"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return clientes;
    }

    public void update(Cliente cliente) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update cliente set nome_cliente = ?, cpf_cliente = ?, telefone_cliente = ?, sexo_cliente = ?, data_nascimento_cliente = ? where cod_cliente = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getSexo_cliente());
            stmt.setString(5, cliente.getDataNascimento());
            stmt.setInt(6, cliente.getCod_cliente());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public void delete(Cliente cliente) {
        PreparedStatement stmt = null;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update cliente set deletado_cliente = ? where cod_cliente = ?");
            stmt.setString(1, "d");
            stmt.setInt(2, cliente.getCod_cliente());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
}
