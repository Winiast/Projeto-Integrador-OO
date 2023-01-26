package ifpr.pgua.eic;

import ifpr.pgua.eic.controllers.auth.*;
import ifpr.pgua.eic.controllers.esporte.EsporteController;
import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

        @Override
        public String getHome() {
                return "CADASTRO_ESPORTE";
        }

        @Override
        public String getAppTitle() {
                return "IFPR EMPRÉSTIMOS";
        }

        @Override
        public void registrarTelas() {
                registraTela("CADASTRO_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/CadastroEsporte.fxml",
                                (o) -> new EsporteController()));

                registraTela("LOGIN",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/Login.fxml",
                                                (o) -> new LoginController()));
                registraTela("ALTERAR_SENHA",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/AlterarSenha.fxml",
                                                (o) -> new AlterarSenhaController()));
        }
}