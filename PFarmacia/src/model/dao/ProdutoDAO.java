package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Produto;

public class ProdutoDAO {

    private ConnectionFactory connection;

    public ProdutoDAO() {
        connection = new ConnectionFactory();
    }

    public void create(Produto produto) {
        PreparedStatement stmt = null;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into produto(descricao_produto, valor_produto, fornecedor_cod_fornecedor)"
                    + " values (?,?,?)");
            stmt.setString(1, produto.getDescricao_produto());
            stmt.setFloat(2, produto.getValor_produto());
            stmt.setInt(3, produto.getEndereco_cod_endereco());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public List<Produto> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from produto where deletado_produto is null");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCod_produto(rs.getInt("cod_produto"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setValor_produto(rs.getFloat("valor_produto"));
                produto.setEndereco_cod_endereco(rs.getInt("fornecedor_cod_fornecedor"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return produtos;
    }
    
    public Double readUnit(Integer cod){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Double preco = null;
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select valor_produto from produto where cod_produto = ?");
            stmt.setInt(1, cod);
            rs = stmt.executeQuery();
            rs.next();
            preco = rs.getDouble(1);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.closeConnection(stmt, rs);
        }
        return preco;
    }
    
    public String readDesc(Integer cod){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String desc = null;
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select descricao_produto from produto where cod_produto = ?");
            stmt.setInt(1, cod);
            rs = stmt.executeQuery();
            rs.next();
            desc = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.closeConnection(stmt, rs);
        }
        return desc;
    }

    public void update(Produto produto) {
        PreparedStatement stmt = null;
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update produto set descricao_produto = ?, valor_produto = ?, fornecedor_cod_fornecedor = ? where cod_produto = ?");
            stmt.setString(1, produto.getDescricao_produto());
            stmt.setFloat(2, produto.getValor_produto());
            stmt.setInt(3, produto.getEndereco_cod_endereco());
            stmt.setInt(4, produto.getCod_produto());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
    
    public void delete(Produto produto){
        PreparedStatement stmt = null;
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update produto set deletado_produto = ? where cod_produto = ?");
            stmt.setString(1, "d");
            stmt.setInt(2, produto.getCod_produto());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
}
