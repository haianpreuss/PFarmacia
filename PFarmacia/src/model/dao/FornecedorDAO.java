package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Fornecedor;

public class FornecedorDAO {
    private ConnectionFactory connection;
    
    public FornecedorDAO(){
        connection = new ConnectionFactory();
    }
    
    public Integer create(Fornecedor fornecedor){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int chave = 0;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into fornecedor(nome_fornecedor, cnpj_fornecedor, telefone_fornecedor, endereco_cod_endereco) "
                    + " values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, fornecedor.getNome_fornecedor());
            stmt.setString(2, fornecedor.getCnpj_fornecedor());
            stmt.setString(3, fornecedor.getTelefone_fornecedor());
            stmt.setInt(4, fornecedor.getEndereco_cod_endereco());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return chave;
    }
    
    public List<Fornecedor> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from fornecedor where deletado_fornecedor is null");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCod_fornecedor(rs.getInt("cod_fornecedor"));
                fornecedor.setNome_fornecedor(rs.getString("nome_fornecedor"));
                fornecedor.setCnpj_fornecedor(rs.getString("cnpj_fornecedor"));
                fornecedor.setTelefone_fornecedor(rs.getString("telefone_fornecedor"));
                fornecedor.setEndereco_cod_endereco(rs.getInt("endereco_cod_endereco"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return fornecedores;
    }
    
    public void update(Fornecedor fornecedor){
        PreparedStatement stmt = null;
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update fornecedor set nome_fornecedor = ?, cnpj_fornecedor = ?, telefone_fornecedor = ?, endereco_cod_endereco = ? where cod_fornecedor = ?");
            stmt.setString(1, fornecedor.getNome_fornecedor());
            stmt.setString(2, fornecedor.getCnpj_fornecedor());
            stmt.setString(3, fornecedor.getTelefone_fornecedor());
            stmt.setInt(4, fornecedor.getEndereco_cod_endereco());
            stmt.setInt(5, fornecedor.getCod_fornecedor());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
    
    public void delete(Fornecedor fornecedor){
        PreparedStatement stmt = null;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update fornecedor set deletado_fornecedor = ? where cod_fornecedor = ?");
            stmt.setString(1, "d");
            stmt.setInt(2, fornecedor.getCod_fornecedor());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
        
    }
}
