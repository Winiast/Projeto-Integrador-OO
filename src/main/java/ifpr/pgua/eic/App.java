package ifpr.pgua.eic;

import ifpr.pgua.eic.controllers.auth.LoginController;
import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

    @Override
    public String getHome() {
        return "TELA_LOGIN";
    }

    @Override
    public String getAppTitle() {
        return null;
    }

    @Override
    public void registrarTelas() {
        registraTela("TELA_LOGIN",
                new ScreenRegistryFXML(getClass(), "fxml/auth/Login.fxml", (o) -> new LoginController()));
    }
}