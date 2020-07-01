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
import model.bean.Funcionario;

public class FuncionarioDAO {

    private ConnectionFactory connection;

    public FuncionarioDAO() {
        connection = new ConnectionFactory();
    }

    public Integer create(Funcionario funcionario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer chave = 0;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("insert into funcionario(nome_funcionario,cpf_funcionario,senha_pessoal_funcionario,salario_funcionario,telefone_funcionario,data_nascimento_funcionario,endereco_cod_endereco)"
                    + " values (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getSenha());
            stmt.setFloat(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getDataNascimento());
            stmt.setInt(7, funcionario.getEndereco_cod_endereco());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return chave;
    }

    public List<Funcionario> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from funcionario where deletado_funcionario is null");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
                funcionario.setNome(rs.getString("nome_funcionario"));
                funcionario.setCpf(rs.getString("cpf_funcionario"));
                funcionario.setSenha(rs.getString("senha_pessoal_funcionario"));
                funcionario.setSalario(rs.getFloat("salario_funcionario"));
                funcionario.setTelefone(rs.getString("telefone_funcionario"));
                funcionario.setDataNascimento(rs.getString("data_nascimento_funcionario"));
                funcionario.setEndereco_cod_endereco(rs.getInt("endereco_cod_endereco"));
                funcionario.setNivel(rs.getInt("nivel_funcionario"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return funcionarios;
    }

    public Funcionario readWhere(Funcionario funcionario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("select *from funcionario where cod_funcionario = ?");
            stmt.setInt(1, funcionario.getCod_funcionario());
            rs = stmt.executeQuery();
            rs.next();
            funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
            funcionario.setNome(rs.getString("nome_funcionario"));
            funcionario.setCpf(rs.getString("cpf_funcionario"));
            funcionario.setSenha(rs.getString("senha_pessoal_funcionario"));
            funcionario.setSalario(rs.getFloat("salario_funcionario"));
            funcionario.setTelefone(rs.getString("telefone_funcionario"));
            funcionario.setDataNascimento(rs.getString("data_nascimento_funcionario"));
            funcionario.setEndereco_cod_endereco(rs.getInt("endereco_cod_endereco"));
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt, rs);
        }
        return funcionario;
    }

    public void update(Funcionario funcionario) {
        PreparedStatement stmt = null;

        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update funcionario set nome_funcionario = ?, cpf_funcionario = ?, senha_pessoal_funcionario = ?, salario_funcionario = ?, telefone_funcionario = ?,  data_nascimento_funcionario = ? where cod_funcionario = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getSenha());
            stmt.setFloat(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getDataNascimento());
            stmt.setInt(7, funcionario.getCod_funcionario());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }

    public void delete(Funcionario funcionario) {
        PreparedStatement stmt = null;
        try {
            connection.openConnection();
            stmt = connection.getConection().prepareStatement("update funcionario set deletado_funcionario = ? where cod_funcionario = ?");
            stmt.setString(1, "d");
            stmt.setInt(2, funcionario.getCod_funcionario());
            stmt.executeUpdate();
            connection.confirm();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection(stmt);
        }
    }
}
