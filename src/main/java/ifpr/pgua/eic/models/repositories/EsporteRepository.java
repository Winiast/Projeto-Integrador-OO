package ifpr.pgua.eic.models.repositories;

import java.util.List;

import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.entity.Esporte;

public class EsporteRepository {
    private EsporteDao esporteDao;

    public EsporteRepository(EsporteDao esporteDao) {
        this.esporteDao = esporteDao;
    }

    public boolean cadastrar(Esporte esporte) {
        return esporteDao.cadastrar(esporte);
    }

    public boolean atualizar(Esporte esporte) {
        return esporteDao.atualizar(esporte);
    }

    public boolean excluir(long id) {
        return esporteDao.excluir(id);
    }

    public List<Esporte> buscarPorNome(String nome) {
        return esporteDao.buscarPorNome(nome);
    }

    public Esporte buscarPorId(long id) {
        return esporteDao.buscarPorId(id);
    }

    public List<Esporte> lista() {
        return esporteDao.buscarTodos();
    }
}
