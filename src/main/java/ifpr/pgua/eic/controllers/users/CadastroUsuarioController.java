package ifpr.pgua.eic.controllers.users;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.repositories.UsuarioRepository;


import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class CadastroUsuarioController {

    private UsuarioRepository usuarioRepository;

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

        Thread thread = new Thread(() -> {
            usuarioRepository.cadastrar(nome, sobrenome, email);
        });

        thread.start();
    }
}
