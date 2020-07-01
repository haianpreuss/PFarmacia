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
import model.bean.Venda;

public class VendaDAO {

    private ConnectionFactory connection;

    public VendaDAO() {
        connection = new ConnectionFactory();
    }

    public Integer create(Venda venda) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer chave = 0;

        try {
            connection.openConnection();

            stmt = connection.getConection().prepareStatement("insert into venda(data_venda, hora_venda, cliente_cod_cliente, funcionario_cod_funcionario)"
                    + " values (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, venda.getData_venda());
            stmt.setString(2, venda.getHora_venda());
            stmt.setInt(3, venda.getCliente_cod_cliente());
            stmt.setInt(4, venda.getFuncionario_cod_funcionario());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            connection.confirm();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            connection.closeConnection(stmt, rs);

        }

        return chave;
    }

    public List<Venda> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select cod_venda, cliente_cod_cliente, nome_cliente, funcionario_cod_funcionario, nome_funcionario, data_venda, hora_venda from venda "
                    + "inner join cliente "
                    + "on cliente_cod_cliente = cod_cliente "
                    + "inner join funcionario "
                    + "on funcionario_cod_funcionario = cod_funcionario;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda Venda = new Venda();
                Venda.setCod_venda(rs.getInt("cod_venda"));
                Venda.setCliente_cod_cliente(rs.getInt("cliente_cod_cliente"));
                Venda.setNome_cliente(rs.getString("nome_cliente"));
                Venda.setFuncionario_cod_funcionario(rs.getInt("funcionario_cod_funcionario"));
                Venda.setNome_funcionario(rs.getString("nome_funcionario"));
                Venda.setData_venda(rs.getString("data_venda"));
                Venda.setHora_venda(rs.getString("hora_venda"));
                vendas.add(Venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return vendas;
    }
}
