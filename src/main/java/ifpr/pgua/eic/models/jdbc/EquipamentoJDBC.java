package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EquipamentoDao;
import ifpr.pgua.eic.models.entity.Equipamento;

public class EquipamentoJDBC implements EquipamentoDao {

    private static final String INSERT = "INSERT INTO pi_equipamento (nomeEquipamento, idEsporte, quantidade, estado, criadoEm, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pi_equipamento SET nomeEquipamento = ?, idEsporte = ?, quantidade = ?, estado = ?, atualizadoEm = ?, status = ? WHERE idEquipamento = ?";

    private FabricaConexoes fabricaConexoes;

    public EquipamentoJDBC(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Equipamento> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Equipamento> buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
