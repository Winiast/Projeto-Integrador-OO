package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Usuario;

public class UsuarioJDBC implements UsuarioDao {

    private static final String INSERT = "INSERT INTO pi_user (nome, sobrenome, email, senha, criadoEm, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pi_user SET nome = ?, sobrenome = ?, email = ?, senha = ?, atualizadoEm = ?, status = ? WHERE idUser = ?";
    private static final String DELETE = "UPDATE pi_user SET atualizadoEm = ?, status = ? WHERE idUser = ?";
    private static final String AUTH = "SELECT * FROM pi_user WHERE email = ? AND senha = ?";

    private FabricaConexoes fabricaConexoes;

    public UsuarioJDBC(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    public boolean cadastrar(Usuario usuario) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSobrenome());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getSenha());
            statement.setTimestamp(5, Timestamp.valueOf(usuario.getCriadoEm()));
            statement.setBoolean(6, usuario.isStatus());

            statement.execute();

            statement.close();
            con.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(AUTH);
            statement.setString(1, email);
            statement.setString(2, senha);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = buildObject(resultSet);
                return usuario;
            }

            statement.close();
            con.close();

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(UPDATE);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSobrenome());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getSenha());
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(6, usuario.isStatus());
            statement.setLong(7, usuario.getId());

            statement.execute();

            statement.close();
            con.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluir(Usuario usuario) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(DELETE);
            statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(2, false);
            statement.setLong(3, usuario.getId());

            statement.execute();

            statement.close();
            con.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    private Usuario buildObject(ResultSet resultSet) throws SQLException {

        long id = resultSet.getInt("idUser");
        String nome = resultSet.getString("nome");
        String sobrenome = resultSet.getString("sobrenome");
        String email = resultSet.getString("email");
        String senha = resultSet.getString("senha");
        LocalDateTime criadoEm = resultSet.getTimestamp("criadoEm").toLocalDateTime();
        if (resultSet.getTimestamp("atualizadoEm") == null) {
            return new Usuario(id, nome, sobrenome, email, senha, criadoEm, null, true);
        } else {
            LocalDateTime alteradoEm = resultSet.getTimestamp("atualizadoEm").toLocalDateTime();
            boolean status = resultSet.getBoolean("status");

            return new Usuario(id, nome, sobrenome, email, senha, criadoEm, alteradoEm, status);
        }
    }

}
