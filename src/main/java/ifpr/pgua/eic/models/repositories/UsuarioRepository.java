package ifpr.pgua.eic.models.repositories;

import java.security.MessageDigest;
import java.util.List;

import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Usuario;

public class UsuarioRepository {

    private UsuarioDao usuarioDao;

    public UsuarioRepository(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario autenticar(String email, String senha) {
        return usuarioDao.autenticar(email, gerarHash(senha));
    }

    public boolean cadastrar(Usuario usuario) {
        usuario.setSenha(gerarHash(usuario.getSenha()));

        return usuarioDao.cadastrar(usuario);
    }

    public boolean atualizar(Usuario usuario) {
        return usuarioDao.atualizar(usuario);
    }

    public boolean excluir(Usuario usuario) {
        return usuarioDao.excluir(usuario);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioDao.buscarPorNome(nome);
    }

    private String gerarHash(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }

            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
