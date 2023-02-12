package ifpr.pgua.eic.controllers.auth;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.repositories.UsuarioRepository;
import ifpr.pgua.eic.utils.Utils;
import io.github.palexdev.materialfx.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

public class AlterarSenhaController implements Initializable {

    @FXML
    private MFXTextField tfUsuario;

    @FXML
    private MFXPasswordField tfSenha;

    @FXML
    private MFXTextField tfConfirmarSenha;

    private UsuarioRepository usuarioRepository;

    public AlterarSenhaController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @FXML
    public void alterarSenha() {
        if(tfSenha.getText().isBlank() || tfConfirmarSenha.getText().isBlank()) {
            Utils.exibeAlert(AlertType.ERROR, "Preencha os dois campos corretamente!!").showAndWait();
        } else {
            if(tfSenha.getText().equals(tfConfirmarSenha.getText())) {
                String senha = tfSenha.getText();
                App.usuarioLogado.setSenha(senha);
                App.usuarioLogado.setStatus(true);
                if(usuarioRepository.atualizar(App.usuarioLogado)) {
                    Utils.exibeAlert(AlertType.CONFIRMATION, "Senha alterada com sucesso!!").showAndWait();
                    App.popScreen();
                } else {
                    Utils.exibeAlert(AlertType.ERROR, "Ocorreu um erro ao alterar a senha, tente novamente!!").showAndWait();
                }
            } else {
                Utils.exibeAlert(AlertType.ERROR, "As senhas não coincidem!!").showAndWait();
            }
        }
    } 

    @FXML
    public void voltar() {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tfUsuario.setText(App.usuarioLogado.getEmail());
    }
}
