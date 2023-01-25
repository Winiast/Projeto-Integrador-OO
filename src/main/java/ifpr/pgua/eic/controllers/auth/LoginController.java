package ifpr.pgua.eic.controllers.auth;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.*;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private MFXTextField tfUsuario;

    @FXML
    private MFXPasswordField tfSenha;

    public LoginController() {
    }

    @FXML
    public void telaAlterarSenha() {
        App.pushScreen("ALTERAR_SENHA");
    }

}
