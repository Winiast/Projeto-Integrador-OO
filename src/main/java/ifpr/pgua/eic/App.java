package ifpr.pgua.eic;

import ifpr.pgua.eic.controllers.auth.*;
import ifpr.pgua.eic.controllers.users.CadastroUsuarioController;
import ifpr.pgua.eic.controllers.users.ListaUsuarioController;
import ifpr.pgua.eic.controllers.equips.CadastroEquipamentosController;
import ifpr.pgua.eic.controllers.equips.ListaEquipamentosController;
import ifpr.pgua.eic.controllers.loan.CadastroEmprestimoController;
import ifpr.pgua.eic.controllers.sports.EsporteCadastroController;
import ifpr.pgua.eic.controllers.sports.EsporteListaController;
import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

        @Override
        public String getHome() {
                return "CADASTRO_EMPRESTIMO";
        }

        @Override
        public String getAppTitle() {
                return "IFPR EMPRÉSTIMOS";
        }

        @Override
        public void registrarTelas() {

                registraTela("CADASTRO_EMPRESTIMO",
                                new ScreenRegistryFXML(getClass(), "fxml/loan/CadastroEmprestimo.fxml",
                                                (o) -> new CadastroEmprestimoController()));
                registraTela("LISTA_EMPRESTIMO",
                                new ScreenRegistryFXML(getClass(), "fxml/loan/ListaEmprestimo.fxml",
                                                (o) -> new CadastroEmprestimoController()));

                registraTela("CADASTRO_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/CadastroEsporte.fxml",
                                (o) -> new EsporteCadastroController()));

                registraTela("LISTA_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/ListaEsporte.fxml",
                                (o) -> new EsporteListaController()));

                registraTela("CADASTRO_USUARIO",
                                new ScreenRegistryFXML(getClass(), "fxml/users/CadastroUsuario.fxml",
                                                (o) -> new CadastroUsuarioController()));
                registraTela("LISTA_USUARIO",
                                new ScreenRegistryFXML(getClass(), "fxml/users/ListaUsuario.fxml",
                                                (o) -> new ListaUsuarioController()));
                registraTela("LOGIN",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/Login.fxml",
                                                (o) -> new LoginController()));

                registraTela("ALTERAR_SENHA",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/AlterarSenha.fxml",
                                                (o) -> new AlterarSenhaController()));

                registraTela("CADASTRO_EQUIPAMENTO",
                                new ScreenRegistryFXML(getClass(), "fxml/equips/CadastroEquipamentos.fxml",
                                                (o) -> new CadastroEquipamentosController()));

                registraTela("LISTA_EQUIPAMENTO",
                                new ScreenRegistryFXML(getClass(), "fxml/equips/ListaEquipamentos.fxml",
                                                (o) -> new ListaEquipamentosController()));

        }
}