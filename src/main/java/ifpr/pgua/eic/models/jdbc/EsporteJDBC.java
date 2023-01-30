package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.entity.Esporte;

public class EsporteJDBC implements EsporteDao {

    private static final String INSERT = "INSERT INTO pi_esporte (nome, descricao, criadoEm, status) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE pi_esporte SET nome = ?, descricao = ?, atualizadoEm = ?, status = ? WHERE idEsporte = ?;";
    private static final String DELETE = "UPDATE pi_esporte SET status = ?, atualizadoEm = ? WHERE idEsporte = ?;";

    private FabricaConexoes fabricaConexoes;

    public EsporteJDBC(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Boolean cadastrar(Esporte esporte) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT);
            statement.setString(1, esporte.getNome());
            statement.setString(2, esporte.getDescricao());
            statement.setTimestamp(3, Timestamp.valueOf(esporte.getCriadoEm()));
            statement.setBoolean(4, esporte.isStatus());

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
    public Boolean atualizar(Esporte esporte) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(UPDATE);
            statement.setString(1, esporte.getNome());
            statement.setString(2, esporte.getDescricao());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(4, esporte.isStatus());
            statement.setLong(5, esporte.getId());

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
    public Boolean excluir(long id) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(DELETE);
            statement.setBoolean(1, false);
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setLong(3, id);

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
    public List<Esporte> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Esporte> buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
