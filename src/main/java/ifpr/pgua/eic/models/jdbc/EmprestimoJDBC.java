package ifpr.pgua.eic.models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EmprestimoDao;
import ifpr.pgua.eic.models.daos.EquipamentoDao;
import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Emprestimo;

public class EmprestimoJDBC implements EmprestimoDao {

    private FabricaConexoes fabricaConexoes;
    private EquipamentoDao equipamentoDao;
    private UsuarioDao usuarioDao;

    private static final String INSERT = "INSERT INTO pi_emprestimo (idUsuario, nomeAluno, turmaAluno, observacao, criadoEm) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_EQUIPS = "INSERT INTO pi_equip_emprestimo (idEquipamento, idEmprestimo) VALUES (?, ?)";


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

            if(keys.next()){
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean excluir(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<EmprestimoDao> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
