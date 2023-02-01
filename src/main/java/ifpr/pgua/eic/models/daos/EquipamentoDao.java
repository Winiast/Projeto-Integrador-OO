package ifpr.pgua.eic.models.daos;

import java.util.List;

import ifpr.pgua.eic.models.entity.Equipamento;

public interface EquipamentoDao {

    boolean cadastrar(Equipamento equipamento);

    boolean atualizar(Equipamento equipamento);

    boolean excluir(long id);

    List<Equipamento> buscarTodos();

    List<Equipamento> buscarPorNome(String nome);

    Equipamento buscarPorId(long id);
}
