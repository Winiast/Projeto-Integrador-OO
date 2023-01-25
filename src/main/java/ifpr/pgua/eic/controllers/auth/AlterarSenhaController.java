package ifpr.pgua.eic.controllers.auth;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.*;
import javafx.fxml.FXML;

public class AlterarSenhaController {

    @FXML
    private MFXTextField tfUsuario;

    @FXML
    private MFXPasswordField tfSenha;

    public AlterarSenhaController() {
    }

    @FXML
    public void voltar() {
        App.popScreen();
    }
}
