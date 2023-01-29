package ifpr.pgua.eic.models.repositories;

import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Usuario;

public class UsuarioRepository {

    private UsuarioDao usuarioDao;

    public UsuarioRepository(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario autenticar(String email, String senha) {
        return usuarioDao.autenticar(email, senha);
    }

    public boolean cadastrar(Usuario usuario) {
        return usuarioDao.cadastrar(usuario);
    }

    public boolean atualizar(Usuario usuario) {
        return usuarioDao.atualizar(usuario);
    }

    public boolean excluir(Usuario usuario) {
        return usuarioDao.excluir(usuario);
    }

    public Usuario buscarPorNome(String nome) {
        return usuarioDao.buscarPorNome(nome);
    }
}
