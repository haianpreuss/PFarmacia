package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Estoque;

public class EstoqueDAO {

    private ConnectionFactory connection;

    public EstoqueDAO() {
        connection = new ConnectionFactory();
    }

    public void create(Estoque estoque) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into estoque(quantidade_estoque,data_estoque,lote_estoque,produto_cod_produto)"
                    + " values(?,?,?,?)");
            stmt.setInt(1, estoque.getQuantidade_estoque());
            stmt.setString(2, estoque.getData_lote());
            stmt.setString(3, estoque.getLote_estoque());
            stmt.setInt(4, estoque.getProduto_cod_produto());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public List<Estoque> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Estoque> estoques = new ArrayList<>();

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select cod_estoque, quantidade_estoque, data_estoque, lote_estoque, descricao_produto, produto_cod_produto from estoque "
                    + "inner join produto "
                    + "on estoque.produto_cod_produto = produto.cod_produto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setCod_estoque(rs.getInt("cod_estoque"));
                estoque.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                estoque.setData_lote(rs.getString("data_estoque"));
                estoque.setLote_estoque(rs.getString("lote_estoque"));
                estoque.setProduto_cod_produto(rs.getInt("produto_cod_produto"));
                estoque.setDescricao_produto_estoque(rs.getString("descricao_produto"));
                estoques.add(estoque);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return estoques;
    }

    public Estoque readWhere(Estoque estoque) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select descricao_produto from produto where cod_produto = ?");
            stmt.setInt(1, estoque.getProduto_cod_produto());
            rs = stmt.executeQuery();
            rs.next();
            estoque.setDescricao_produto_estoque(rs.getString("descricao_produto"));
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return estoque;
    }

    public void update(Estoque estoque) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update estoque set quantidade_estoque = ?,data_estoque = ?,lote_estoque = ?,produto_cod_produto = ? where cod_estoque = ?");
            stmt.setInt(1, estoque.getQuantidade_estoque());
            stmt.setString(2, estoque.getData_lote());
            stmt.setString(3, estoque.getLote_estoque());
            stmt.setInt(4, estoque.getProduto_cod_produto());
            stmt.setInt(5, estoque.getCod_estoque());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
    
    public void updateQnt(Integer cod, Integer qnt) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update estoque set quantidade_estoque = quantidade_estoque - ? where produto_cod_produto = ? and data_estoque = (select *from (select min(data_estoque) from estoque where produto_cod_produto = ?) t)");
            stmt.setInt(1, qnt);
            stmt.setInt(2, cod);
            stmt.setInt(3, cod);
            stmt.executeUpdate();
            connection.confirm();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
    
    public void deleteZero(){
        PreparedStatement stmt = null;
        
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("delete from estoque where quantidade_estoque <= 0");
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public void delete(Estoque estoque) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update estoque set deletado_estoque = ? where cod_estoque = ?");
            stmt.setString(1, "d");
            stmt.setInt(2, estoque.getCod_estoque());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
    
    public Integer getQnt(Integer Codigo){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer qnt = 0;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select sum(quantidade_estoque) as 'Quantidade' from estoque where produto_cod_produto = ?");
            stmt.setInt(1, Codigo);
            rs = stmt.executeQuery();
            rs.next();
            qnt = rs.getInt("Quantidade");
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return qnt;
    }
}
