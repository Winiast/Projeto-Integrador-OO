package ifpr.pgua.eic.models.daos;

import java.util.List;

import ifpr.pgua.eic.models.entity.Esporte;

public interface EsporteDao {

    Boolean cadastrar(Esporte esporte);

    Boolean atualizar(Esporte esporte);

    Boolean excluir(long id);

    List<Esporte> buscarAtivos();

    List<Esporte> buscarTodos();

    List<Esporte> buscarPorNome(String nome);

    Esporte buscarPorId(long id);
}
