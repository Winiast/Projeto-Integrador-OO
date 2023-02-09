package ifpr.pgua.eic.models.repositories;

import java.util.List;
import java.util.Properties;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Usuario;
import ifpr.pgua.eic.utils.Utils;

import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class UsuarioRepository {

    private UsuarioDao usuarioDao;

    public UsuarioRepository(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario autenticar(String email, String senha) {
        App.usuarioLogado = usuarioDao.autenticar(email, Utils.gerarHash(senha));

        return App.usuarioLogado;
    }

    public boolean cadastrar(String nome, String sobrenome, String email) {
        String senha = Utils.gerarSenha(8);

        if (!enviarEmail(email, senha)) {
            return false;
        } else {
            return usuarioDao.cadastrar(new Usuario(nome, sobrenome, email, Utils.gerarHash(senha)));
        }
    }

    public boolean atualizar(Usuario usuario) {
        return usuarioDao.atualizar(usuario);
    }

    public boolean excluir(Usuario usuario) {
        return usuarioDao.excluir(usuario);
    }

    public List<Usuario> buscarAtivos() {
        return usuarioDao.buscarAtivos();
    }

    public List<Usuario> buscarTodos() {
        return usuarioDao.buscarTodos();
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioDao.buscarPorNome(nome);
    }

    private boolean enviarEmail(String email, String senha) {
        try {

            String msg = "Cadastro quase concluído, para finalizar o cadastro, insira está senha: " + senha
                    + " na primeira vez em que for efetuar o login.";
            String assunto = "Cadastro IFPR Emprestimos";

            String remetente = "ifpr.emprestimos@gmail.com";
            Message message = new MimeMessage(criarSessionMail());
            message.setFrom(new InternetAddress(remetente)); // Remetente

            Address[] toUser = InternetAddress // Destinatário(s)
                    .parse(email.trim().toLowerCase());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);// Assunto
            message.setContent(msg, "text/html");
            /** Método para enviar a mensagem criada */
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Session criarSessionMail() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.port", 465);

        Session session = Session.getDefaultInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ifpr.emprestimos@gmail.com", "shmbgbhpwmcfnquf");
            }
        });

        session.setDebug(true);

        return session;
    }
}
