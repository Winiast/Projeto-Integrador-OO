package ifpr.pgua.eic.controllers.users;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Usuario;
import ifpr.pgua.eic.models.repositories.UsuarioRepository;


import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CadastroUsuarioController implements Initializable {

    public static Usuario usuario;

    private UsuarioRepository usuarioRepository;

    @FXML
    private Label lbTitle;

    @FXML
    private MFXTextField tfEmail;

    @FXML
    private MFXTextField tfNome;

    @FXML
    private MFXTextField tfSobrenome;

    public CadastroUsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @FXML
    public void usuarioLista() {
        App.pushScreen("LISTA_USUARIO");
    }

    @FXML
    public void emprestimoLista() {
        App.pushScreen("LISTA_EMPRESTIMO");
    }

    @FXML
    public void equipamentosLista() {
        App.pushScreen("LISTA_EQUIPAMENTO");
    }

    @FXML
    public void esporteLista() {
        App.pushScreen("LISTA_ESPORTE");
    }

    @FXML
    public void sair() {
        App.pushScreen("LOGIN");
    }

    @FXML
    private void cadastrarUsuario() {

        String email = tfEmail.getText();
        String nome = tfNome.getText();
        String sobrenome = tfSobrenome.getText();
        
        if(usuario == null) {
            Thread thread = new Thread(() -> {
                usuarioRepository.cadastrar(nome, sobrenome, email);
            });
            thread.start();
        } else {
            usuario.setEmail(email);
            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
            usuarioRepository.atualizar(usuario);
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        if (usuario != null) {
            tfEmail.setText(usuario.getEmail());
            tfNome.setText(usuario.getNome());
            tfSobrenome.setText(usuario.getSobrenome());
            lbTitle.setText("Atualizar Usuário");
        } else {
            tfEmail.setText("");
            tfNome.setText("");
            tfSobrenome.setText("");
            lbTitle.setText("Cadastrar Usuário");
        }
    }
}
