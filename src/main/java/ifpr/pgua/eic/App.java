package ifpr.pgua.eic;

import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

    @Override
    public String getHome() {
        // TODO Auto-generated method stub

        return "CADASTRO";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "IFPR EMPRÉSTIMOS";
    }

    @Override
    public void registrarTelas() {
        // TODO Auto-generated method stub
        registraTela("CADASTRO", new ScreenRegistryFXML(getClass(), "fxml/sports/CadastroEsporte.fxml", null));

    }

}