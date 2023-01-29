package ifpr.pgua.eic.models.jdbc;

import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.entity.Esporte;

public class EsporteJDBC implements EsporteDao {

    private FabricaConexoes fabricaConexoes;

    public EsporteJDBC(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Boolean cadastrar(Esporte esporte) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean atualizar(Esporte esporte) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean excluir(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Esporte> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Esporte> buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
