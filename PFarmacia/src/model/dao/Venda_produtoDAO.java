package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Venda_produto;

public class Venda_produtoDAO {

    private ConnectionFactory connection;

    public Venda_produtoDAO() {
        connection = new ConnectionFactory();
    }

    public void create(Venda_produto venda_produto) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into venda_produto(venda_cod_venda, produto_cod_produto, quantidade_produto)"
                    + " values(?,?,?)");
            stmt.setInt(1, venda_produto.getVenda_cod_venda());
            stmt.setInt(2, venda_produto.getProduto_cod_produto());
            stmt.setInt(3, venda_produto.getQuantidade_produto());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(Venda_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public List<Venda_produto> readVenda(Integer cod) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda_produto> tabela = new ArrayList<>();
        

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select produto_cod_produto, descricao_produto, quantidade_produto, valor_produto from venda_produto "
                    + "inner join produto "
                    + "on produto.cod_produto = venda_produto.produto_cod_produto "
                    + "where venda_cod_venda = ?");
            stmt.setInt(1, cod);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda_produto venda_produto = new Venda_produto();
                venda_produto.setProduto_cod_produto(rs.getInt("produto_cod_produto"));
                venda_produto.setDescricao_produto(rs.getString("descricao_produto"));
                venda_produto.setQuantidade_produto(rs.getInt("quantidade_produto"));
                venda_produto.setValor_produto(rs.getDouble("valor_produto"));
                tabela.add(venda_produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_produtoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return tabela;
    }
}
