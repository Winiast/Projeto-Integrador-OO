package ifpr.pgua.eic.controllers.users;

import java.util.Properties;

import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class CadastroUsuarioController {

    @FXML
    private MFXTextField tfEmail;

    @FXML
    private MFXTextField tfNome;

    @FXML
    private MFXTextField tfSobrenome;

    public CadastroUsuarioController() {
    }

    @FXML
    private void cadastrar() {

        String email = tfEmail.getText();
        String nome = tfNome.getText();
        String sobrenome = tfSobrenome.getText();

        Thread thread = new Thread(() -> {
            enviarEmail(email);
        });

        thread.start();
    }

    private boolean enviarEmail(String email) {
        try {

            String msg = "Cadastro quase concluído, para finalizar o cadastro, insira está senha: ***** na primeira vez em que for efetuar o login.";
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
