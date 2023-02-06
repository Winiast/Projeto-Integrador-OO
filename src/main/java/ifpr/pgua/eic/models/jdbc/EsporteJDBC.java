package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.entity.Esporte;

public class EsporteJDBC implements EsporteDao {

    private static final String INSERT = "INSERT INTO pi_esporte (nome, descricao, criadoEm, status) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE pi_esporte SET nome = ?, descricao = ?, atualizadoEm = ?, status = ? WHERE idEsporte = ?;";
    private static final String DELETE = "UPDATE pi_esporte SET status = ?, atualizadoEm = ? WHERE idEsporte = ?;";
    private static final String SELECT_ALL = "SELECT * FROM pi_esporte;";
    private static final String SELECT_BY_NAME = "SELECT * FROM pi_esporte WHERE nome LIKE ?;";
    private static final String SELECT_BY_ID = "SELECT * FROM pi_esporte WHERE idEsporte = ?;";

    private FabricaConexoes fabricaConexoes;

    public EsporteJDBC(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Boolean cadastrar(Esporte esporte) {
        try {
            Connection con = fabricaConexoes.getConnection();

            App.conexoes++;
            System.out.println(App.conexoes);

            PreparedStatement statement = con.prepareStatement(INSERT);
            statement.setString(1, esporte.getNome());
            statement.setString(2, esporte.getDescricao());
            statement.setTimestamp(3, Timestamp.valueOf(esporte.getCriadoEm()));
            statement.setBoolean(4, esporte.isStatus());

            statement.execute();

            statement.close();
            con.close();
            App.conexoes--;
            System.out.println(App.conexoes);

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

            App.conexoes++;
            System.out.println(App.conexoes);

            PreparedStatement statement = con.prepareStatement(UPDATE);
            statement.setString(1, esporte.getNome());
            statement.setString(2, esporte.getDescricao());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(4, esporte.isStatus());
            statement.setLong(5, esporte.getId());

            statement.execute();

            statement.close();
            con.close();
            App.conexoes--;
            System.out.println(App.conexoes);

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
            
            App.conexoes++;
            System.out.println(App.conexoes);


            PreparedStatement statement = con.prepareStatement(DELETE);
            statement.setBoolean(1, false);
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setLong(3, id);

            statement.execute();

            statement.close();
            con.close();
            App.conexoes--;
            System.out.println(App.conexoes);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Esporte> buscarTodos() {
        try {
            Connection con = fabricaConexoes.getConnection();
            App.conexoes++;
            System.out.println(App.conexoes);

            PreparedStatement statement = con.prepareStatement(SELECT_ALL);

            ResultSet resultSet = statement.executeQuery();

            List<Esporte> esportes = new ArrayList<>();
            while (resultSet.next()) {
                esportes.add(buildObject(resultSet));
            }

            resultSet.close();
            statement.close();
            con.close();
            App.conexoes--;
            System.out.println(App.conexoes);

            return esportes;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Esporte> buscarPorNome(String nome) {
        try {
            Connection con = fabricaConexoes.getConnection();
            App.conexoes++;
            System.out.println(App.conexoes);

            PreparedStatement statement = con.prepareStatement(SELECT_BY_NAME);
            statement.setString(1, nome + "%");

            ResultSet resultSet = statement.executeQuery();

            List<Esporte> esportes = new ArrayList<>();
            while (resultSet.next()) {
                esportes.add(buildObject(resultSet));
            }

            resultSet.close();
            statement.close();
            con.close();
            App.conexoes--;
            System.out.println(App.conexoes);

            return esportes;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Esporte buscarPorId(long id) {
        try {
            Connection con = fabricaConexoes.getConnection();
            App.conexoes++;
            System.out.println(App.conexoes);

            PreparedStatement statement = con.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            Esporte esporte = new Esporte();
            if (resultSet.next()) {
                esporte = buildObject(resultSet);
            }

            resultSet.close();
            statement.close();
            con.close();

            App.conexoes--;
            System.out.println(App.conexoes);

            return esporte;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Esporte buildObject(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("idEsporte");
        String nome = resultSet.getString("nome");
        String descricao = resultSet.getString("descricao");
        LocalDateTime criadoEm = resultSet.getTimestamp("criadoEm").toLocalDateTime();
        if (resultSet.getTimestamp("atualizadoEm") != null) {
            LocalDateTime alteradoEm = resultSet.getTimestamp("atualizadoEm").toLocalDateTime();
            boolean status = resultSet.getBoolean("status");
            return new Esporte(id, nome, descricao, criadoEm, alteradoEm, status);
        } else {
            boolean status = resultSet.getBoolean("status");
            return new Esporte(id, nome, descricao, criadoEm, null, status);
        }
    }

}
