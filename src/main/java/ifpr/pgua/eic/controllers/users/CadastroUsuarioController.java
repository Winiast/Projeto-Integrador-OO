package ifpr.pgua.eic.controllers.users;

import java.util.Properties;

import com.google.protobuf.Message;
import com.mysql.cj.Session;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class CadastroUsuarioController {

    @FXML
    private MFXTextField tfEmail;

    @FXML
    private MFXTextField tfNome;

    @FXML
    private MFXTextField tfSobrenome;

    public CadastroUsuarioController() {
    }

}
