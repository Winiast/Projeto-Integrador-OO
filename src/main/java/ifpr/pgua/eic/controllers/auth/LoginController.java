package ifpr.pgua.eic.controllers.auth;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Usuario;
import ifpr.pgua.eic.models.repositories.UsuarioRepository;
import io.github.palexdev.materialfx.controls.*;
import javafx.fxml.FXML;

public class LoginController {

    private UsuarioRepository usuarioRepository;

    @FXML
    private MFXTextField tfUsuario;

    @FXML
    private MFXPasswordField tfSenha;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @FXML
    public void telaAlterarSenha() {
        App.pushScreen("ALTERAR_SENHA");
    }

    @FXML
    public void autenticar() {

        String email = tfUsuario.getText();
        String senha = tfSenha.getText();

        if(email.isBlank() || senha.isBlank()){
            return;
        } else {
            Usuario usuario = usuarioRepository.autenticar(email, senha);
    
            if(usuario != null){
                App.pushScreen("LISTA_EMPRESTIMO");
            }
        }
    }

}
