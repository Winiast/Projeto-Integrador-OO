package ifpr.pgua.eic;

import ifpr.pgua.eic.controllers.auth.*;
import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

    @Override
    public String getHome() {
        return "LOGIN";
    }

    @Override
    public String getAppTitle() {
        return null;
    }

    @Override
    public void registrarTelas() {
        registraTela("LOGIN",
                new ScreenRegistryFXML(getClass(), "fxml/auth/Login.fxml", (o) -> new LoginController()));
        registraTela("ALTERAR_SENHA",
                new ScreenRegistryFXML(getClass(), "fxml/auth/AlterarSenha.fxml", (o) -> new AlterarSenhaController()));
    }
}