package ifpr.pgua.eic;

import ifpr.pgua.eic.controllers.auth.*;
import ifpr.pgua.eic.controllers.esporte.EsporteCadastroController;
import ifpr.pgua.eic.controllers.esporte.EsporteListaController;
import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

        @Override
        public String getHome() {
                return "LISTA_ESPORTE";
        }

        @Override
        public String getAppTitle() {
                return "IFPR EMPRÉSTIMOS";
        }

        @Override
        public void registrarTelas() {
                registraTela("CADASTRO_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/CadastroEsporte.fxml",
                                (o) -> new EsporteCadastroController()));

                registraTela("LISTA_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/ListaEsporte.fxml",
                                (o) -> new EsporteListaController()));

                registraTela("LOGIN",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/Login.fxml",
                                                (o) -> new LoginController()));
                registraTela("ALTERAR_SENHA",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/AlterarSenha.fxml",
                                                (o) -> new AlterarSenhaController()));
        }
}