package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Usuario;

public class UsuarioJDBC implements UsuarioDao {

    private static final String INSERT = "INSERT INTO pi_user (nome, sobrenome, email, senha, criadoEm, status) VALUES (?, ?, ?, ?, ?, ?)";

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean excluir(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Usuario buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
