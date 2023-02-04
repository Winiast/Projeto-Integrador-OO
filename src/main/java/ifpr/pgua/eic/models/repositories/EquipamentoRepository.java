package ifpr.pgua.eic.models.repositories;

import java.util.List;

import ifpr.pgua.eic.models.daos.EquipamentoDao;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.entity.Estado;

public class EquipamentoRepository {

    public EquipamentoRepository(EquipamentoDao equipamentoDao) {
        this.equipamentoDao = equipamentoDao;
    }

    private EquipamentoDao equipamentoDao;

    public boolean cadastrar(String nome, Esporte esporte, Integer quantidade, Estado estado) {
        return equipamentoDao.cadastrar(new Equipamento(nome, esporte, quantidade, estado));
    }

    public boolean atualizar(Equipamento equipamento) {
        return equipamentoDao.atualizar(equipamento);
    }

    public boolean excluir(Equipamento equipamento) {
        return equipamentoDao.excluir(equipamento.getId());
    }

    public List<Equipamento> listarTodos() {
        return equipamentoDao.buscarTodos();
    }

    public List<Equipamento> buscarEquipamento(Equipamento equipamento) {
        return equipamentoDao.buscarPorNome(equipamento.getNome());
    }

}
