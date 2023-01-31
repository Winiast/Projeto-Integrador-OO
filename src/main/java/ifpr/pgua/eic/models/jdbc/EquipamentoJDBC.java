package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EquipamentoDao;
import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.entity.Estado;

public class EquipamentoJDBC implements EquipamentoDao {

    private static final String INSERT = "INSERT INTO pi_equipamento (nomeEquipamento, idEsporte, quantidade, estado, criadoEm, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pi_equipamento SET nomeEquipamento = ?, idEsporte = ?, quantidade = ?, estado = ?, atualizadoEm = ?, status = ? WHERE idEquipamento = ?";
    private static final String DELETE = "UPDATE pi_equipamento SET status = false WHERE idEquipamento = ?";
    private static final String SELECT_ALL = "SELECT * FROM pi_equipamento";

    private FabricaConexoes fabricaConexoes;
    private EsporteDao esporteDao;

    public EquipamentoJDBC(FabricaConexoes fabricaConexoes, EsporteDao esporteDao) {
        this.fabricaConexoes = fabricaConexoes;
        this.esporteDao = esporteDao;
    }

    @Override
    public boolean cadastrar(Equipamento equipamento) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT);

            statement.setString(1, equipamento.getNome());
            statement.setLong(2, equipamento.getEsporte().getId());
            statement.setInt(3, equipamento.getQuantidade());
            statement.setString(4, equipamento.getEstado().toString());
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(6, equipamento.isStatus());

            statement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Equipamento equipamento) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(UPDATE);

            statement.setString(1, equipamento.getNome());
            statement.setLong(2, equipamento.getEsporte().getId());
            statement.setInt(3, equipamento.getQuantidade());
            statement.setString(4, equipamento.getEstado().toString());
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBoolean(6, equipamento.isStatus());
            statement.setLong(7, equipamento.getId());

            statement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluir(long id) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(DELETE);

            statement.setLong(1, id);

            statement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Equipamento> buscarTodos() {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(SELECT_ALL);

            ResultSet resultSet = statement.executeQuery();

            List<Equipamento> equipamentos = new ArrayList<>();
            while (resultSet.next()) {
                equipamentos.add(buildObject(resultSet));
            }

            return equipamentos;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Equipamento> buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    private Equipamento buildObject(ResultSet resultSet) throws SQLException {

        long id = resultSet.getLong("idEquipamento");
        String nome = resultSet.getString("nomeEquipamento");
        Esporte esporte = esporteDao.buscarPorId(resultSet.getLong("idEsporte"));
        int quantidade = resultSet.getInt("quantidade");
        Estado estado = Estado.valueOf(resultSet.getString("estado"));
        LocalDateTime criadoEm = resultSet.getTimestamp("criadoEm").toLocalDateTime();
        if (resultSet.getTimestamp("atualizadoEm") != null) {
            LocalDateTime atualizadoEm = resultSet.getTimestamp("atualizadoEm").toLocalDateTime();
            boolean status = resultSet.getBoolean("status");

            return new Equipamento(id, nome, esporte, quantidade, estado, criadoEm, atualizadoEm, status);
        } else {
            boolean status = resultSet.getBoolean("status");

            return new Equipamento(id, nome, esporte, quantidade, estado, criadoEm, null, status);
        }
    }

}
