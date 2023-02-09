package ifpr.pgua.eic.models.daos;

import java.util.List;

import ifpr.pgua.eic.models.entity.Usuario;

public interface UsuarioDao {

    Usuario autenticar(String email, String senha);

    boolean cadastrar(Usuario usuario);

    boolean atualizar(Usuario usuario);

    boolean excluir(Usuario usuario);

    List<Usuario> buscarAtivos();

    List<Usuario> buscarPorNome(String nome);

    List<Usuario> buscarTodos();

    Usuario buscarPorId(long id);
}
