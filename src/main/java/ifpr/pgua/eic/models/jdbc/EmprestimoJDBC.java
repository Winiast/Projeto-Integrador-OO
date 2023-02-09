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
import ifpr.pgua.eic.models.daos.EmprestimoDao;
import ifpr.pgua.eic.models.daos.EquipamentoDao;
import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Emprestimo;
import ifpr.pgua.eic.models.entity.Equipamento;

public class EmprestimoJDBC implements EmprestimoDao {

    private FabricaConexoes fabricaConexoes;
    private EquipamentoDao equipamentoDao;
    private UsuarioDao usuarioDao;

    private static final String INSERT = "INSERT INTO pi_emprestimo (idUsuario, nomeAluno, turmaAluno, observacao, criadoEm) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_EQUIPS = "INSERT INTO pi_equip_emprestimo (idEquipamento, idEmprestimo) VALUES (?, ?)";

    private static final String FINISH_EMPR = "UPDATE pi_emprestimo SET dataDevolucaoEmprestimo = ?, atualizadoEm = ? WHERE idEmprestimo = ?";

    private static final String UPDATE = "UPDATE pi_emprestimo SET idUsuario = ?, nomeAluno = ?, turmaAluno = ?, observacao = ?, atualizadoEm = ? WHERE idEmprestimo = ?";

    private static final String SELECT = "SELECT * FROM pi_emprestimo";
    private static final String SELECT_EQUIPS = "SELECT * FROM pi_equip_emprestimo WHERE idEmprestimo = ?";

    public EmprestimoJDBC(FabricaConexoes fabricaConexoes, EquipamentoDao equipamentoDao, UsuarioDao usuarioDao) {
        this.fabricaConexoes = fabricaConexoes;
        this.equipamentoDao = equipamentoDao;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public boolean cadastrar(Emprestimo emprestimo) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, emprestimo.getUsuario().getId());
            statement.setString(2, emprestimo.getNomeAluno());
            statement.setString(3, emprestimo.getTurma());
            statement.setString(4, emprestimo.getObservacoes());
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            statement.execute();

            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                emprestimo.setId(keys.getInt(1));
            }

            statement = con.prepareStatement(INSERT_EQUIPS);
            for (int i = 0; i < emprestimo.getEquipamento().size(); i++) {
                statement.setLong(1, emprestimo.getEquipamento().get(i).getId());
                statement.setLong(2, emprestimo.getId());
                statement.execute();
            }

            statement.close();
            con.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Emprestimo emprestimo) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(UPDATE);
            statement.setLong(1, emprestimo.getUsuario().getId());
            statement.setString(2, emprestimo.getNomeAluno());
            statement.setString(3, emprestimo.getTurma());
            statement.setString(4, emprestimo.getObservacoes());
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            statement.setLong(6, emprestimo.getId());

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
    public boolean finalizarEmprestimo(long id) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(FINISH_EMPR);
            statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
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
    public List<Emprestimo> buscarTodos() {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(SELECT);

            ResultSet resultSet = statement.executeQuery();

            List<Emprestimo> emprestimos = new ArrayList<>();
            while (resultSet.next()) {
                emprestimos.add(buildObject(resultSet));
            }

            resultSet.close();
            statement.close();
            con.close();

            return emprestimos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Equipamento> buscarEquipamentos(long id) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement statement = con.prepareStatement(SELECT_EQUIPS);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            List<Equipamento> equipamentos = new ArrayList<>();
            while (resultSet.next()) {
                equipamentos.add(equipamentoDao.buscarPorId(resultSet.getLong("idEquipamento")));
            }

            resultSet.close();
            statement.close();
            con.close();

            return equipamentos;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Emprestimo buildObject(ResultSet resultSet) throws SQLException {
        long id = resultSet.getInt("idEmprestimo");
        long idUsuario = resultSet.getInt("idUsuario");
        String nomeAluno = resultSet.getString("nomeAluno");
        String turma = resultSet.getString("turmaAluno");
        String observacoes = resultSet.getString("observacao");
        LocalDateTime criadoEm = resultSet.getTimestamp("criadoEm").toLocalDateTime();

        LocalDateTime dataDevolucao = null;
        LocalDateTime atualizadoEm = null;
        if (resultSet.getTimestamp("dataDevolucaoEmprestimo") != null) {
            dataDevolucao = resultSet.getTimestamp("dataDevolucaoEmprestimo").toLocalDateTime();
        }
        if (resultSet.getTimestamp("atualizadoEm") != null) {
            atualizadoEm = resultSet.getTimestamp("atualizadoEm").toLocalDateTime();
        }

        return new Emprestimo(id, dataDevolucao, buscarEquipamentos(id), nomeAluno, turma, observacoes,
                usuarioDao.buscarPorId(idUsuario), criadoEm, atualizadoEm);
    }

}