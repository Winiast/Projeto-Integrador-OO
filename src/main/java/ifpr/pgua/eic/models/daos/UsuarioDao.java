package ifpr.pgua.eic.models.daos;

import ifpr.pgua.eic.models.entity.Usuario;

public interface UsuarioDao {
    boolean cadastrar(Usuario usuario);

    boolean atualizar(Usuario usuario);

    boolean excluir(Usuario usuario);

    Usuario buscarPorNome(String nome);
}
