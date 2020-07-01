package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Endereco;

public class EnderecoDAO {

    private ConnectionFactory connection;

    public EnderecoDAO() {
        connection = new ConnectionFactory();
    }

    public Integer create(Endereco endereco) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer chave = 0;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into endereco(rua_endereco, numero_endereco, complemento_endereco, cep_endereco, cidade_endereco, uf_endereco, bairro_endereco)"
                    + " values (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getRua_endereco());
            stmt.setString(2, endereco.getNumero_endereco());
            stmt.setString(3, endereco.getComplemento_endereco());
            stmt.setString(4, endereco.getCep_endereco());
            stmt.setString(5, endereco.getCidade_endereco());
            stmt.setString(6, endereco.getUf_endereco());
            stmt.setString(7, endereco.getBairro_endereco());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
        return chave;
    }

    public List<Endereco> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Endereco> enderecos = new ArrayList<>();

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from endereco where deletado_endereco is null");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setRua_endereco(rs.getString("rua_endereco"));
                endereco.setBairro_endereco(rs.getString("bairro_endereco"));
                endereco.setCep_endereco(rs.getString("cep_endereco"));
                endereco.setCidade_endereco(rs.getString("cidade_endereco"));
                endereco.setComplemento_endereco(rs.getString("complemento_endereco"));
                endereco.setNumero_endereco(rs.getString("numero_endereco"));
                endereco.setUf_endereco(rs.getString("uf_endereco"));
                enderecos.add(endereco);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return enderecos;
    }

    public Endereco readWhere(Endereco endereco) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from endereco where cod_endereco = ?");
            stmt.setInt(1, endereco.getCod_endereco());
            rs = stmt.executeQuery();
            rs.next();
            endereco.setRua_endereco(rs.getString("rua_endereco"));
            endereco.setBairro_endereco(rs.getString("bairro_endereco"));
            endereco.setCep_endereco(rs.getString("cep_endereco"));
            endereco.setCidade_endereco(rs.getString("cidade_endereco"));
            endereco.setComplemento_endereco(rs.getString("complemento_endereco"));
            endereco.setNumero_endereco(rs.getString("numero_endereco"));
            endereco.setUf_endereco(rs.getString("uf_endereco"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return endereco;
    }

    public void update(Endereco endereco) {
        PreparedStatement stmt = null;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update endereco set rua_endereco = ?, numero_endereco = ?, complemento_endereco = ?, cep_endereco = ?, cidade_endereco = ?, uf_endereco = ?, bairro_endereco = ?  where cod_endereco = ?");
            stmt.setString(1, endereco.getRua_endereco());
            stmt.setString(2, endereco.getNumero_endereco());
            stmt.setString(3, endereco.getComplemento_endereco());
            stmt.setString(4, endereco.getCep_endereco());
            stmt.setString(5, endereco.getCidade_endereco());
            stmt.setString(6, endereco.getUf_endereco());
            stmt.setString(7, endereco.getBairro_endereco());
            stmt.setInt(8, endereco.getCod_endereco());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public void delete(Endereco endereco) {
        PreparedStatement stmt = null;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update endereco set deletado_endereco = ? where cod_endereco = ?");
            stmt.setString(1, "d");
            stmt.setInt(2, endereco.getCod_endereco());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
}
