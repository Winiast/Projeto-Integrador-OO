package ifpr.pgua.eic;

import ifpr.pgua.eic.controllers.auth.*;
import ifpr.pgua.eic.controllers.users.CadastroUsuarioController;
import ifpr.pgua.eic.controllers.users.ListaUsuarioController;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioVM;
import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EmprestimoDao;
import ifpr.pgua.eic.models.daos.EquipamentoDao;
import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.daos.UsuarioDao;
import ifpr.pgua.eic.models.entity.Usuario;
import ifpr.pgua.eic.models.jdbc.EmprestimoJDBC;
import ifpr.pgua.eic.models.jdbc.EquipamentoJDBC;
import ifpr.pgua.eic.models.jdbc.EsporteJDBC;
import ifpr.pgua.eic.models.jdbc.UsuarioJDBC;
import ifpr.pgua.eic.models.repositories.EmprestimoRepository;
import ifpr.pgua.eic.models.repositories.EquipamentoRepository;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import ifpr.pgua.eic.models.repositories.UsuarioRepository;
import ifpr.pgua.eic.controllers.equips.CadastroEquipamentosController;
import ifpr.pgua.eic.controllers.equips.ListaEquipamentosController;
import ifpr.pgua.eic.controllers.equips.viewmodel.EquipamentoVM;
import ifpr.pgua.eic.controllers.loan.CadastroEmprestimoController;
import ifpr.pgua.eic.controllers.loan.ListaEmprestimoController;
import ifpr.pgua.eic.controllers.loan.viewmodel.EmprestimoVM;
import ifpr.pgua.eic.controllers.sports.EsporteCadastroController;
import ifpr.pgua.eic.controllers.sports.EsporteListaController;
import ifpr.pgua.eic.controllers.sports.viewmodel.EsporteVM;
import ifpr.pgua.eic.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

        public static int conexoes = 0;

        public static Usuario usuarioLogado;
        private FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();
        private UsuarioRepository usuarioRepository;
        private UsuarioDao usuarioDao;

        private EquipamentoRepository equipamentoRepository;
        private EquipamentoDao equipamentoDao;
        private EsporteDao esporteDao;
        private EsporteRepository esporteRepository;
        private EmprestimoRepository emprestimoRepository;
        private EmprestimoDao emprestimoDao;

        @Override
        public void init() throws Exception {
                usuarioDao = new UsuarioJDBC(fabricaConexoes);
                usuarioRepository = new UsuarioRepository(usuarioDao);

                esporteDao = new EsporteJDBC(fabricaConexoes);
                esporteRepository = new EsporteRepository(esporteDao);

                equipamentoDao = new EquipamentoJDBC(fabricaConexoes, esporteDao);
                equipamentoRepository = new EquipamentoRepository(equipamentoDao);

                emprestimoDao = new EmprestimoJDBC(fabricaConexoes, equipamentoDao, usuarioDao);
                emprestimoRepository = new EmprestimoRepository(emprestimoDao);
        }

        @Override
        public String getHome() {
                return "LOGIN";
        }

        @Override
        public String getAppTitle() {
                return "IFPR EMPRÉSTIMOS";
        }

        @Override
        public void registrarTelas() {

                registraTela("MENU", new ScreenRegistryFXML(getClass(), "fxml/Menu.fxml", null));

                registraTela("CADASTRO_EMPRESTIMO",
                                new ScreenRegistryFXML(getClass(), "fxml/loan/CadastroEmprestimo.fxml",
                                                (o) -> new CadastroEmprestimoController(emprestimoRepository,
                                                                equipamentoRepository)));
                registraTela("LISTA_EMPRESTIMO",
                                new ScreenRegistryFXML(getClass(), "fxml/loan/ListaEmprestimo.fxml",
                                                (o) -> new ListaEmprestimoController(new EmprestimoVM(emprestimoRepository))));

                registraTela("CADASTRO_USUARIO",
                                new ScreenRegistryFXML(getClass(), "fxml/users/CadastroUsuario.fxml",
                                                (o) -> new CadastroUsuarioController(usuarioRepository)));

                registraTela("LISTA_USUARIO",
                                new ScreenRegistryFXML(getClass(), "fxml/users/ListaUsuario.fxml",
                                                (o) -> new ListaUsuarioController(new UsuarioVM(usuarioRepository))));
                registraTela("LOGIN",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/Login.fxml",
                                                (o) -> new LoginController(usuarioRepository)));

                registraTela("LISTA_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/ListaEsporte.fxml",
                                (o) -> new EsporteListaController(new EsporteVM(esporteRepository))));

                registraTela("CADASTRO_ESPORTE", new ScreenRegistryFXML(getClass(), "fxml/sports/CadastroEsporte.fxml",
                                (o) -> new EsporteCadastroController(esporteRepository)));

                registraTela("ALTERAR_SENHA",
                                new ScreenRegistryFXML(getClass(), "fxml/auth/AlterarSenha.fxml",
                                                (o) -> new AlterarSenhaController(usuarioRepository)));

                registraTela("CADASTRO_EQUIPAMENTO",
                                new ScreenRegistryFXML(getClass(), "fxml/equips/CadastroEquipamentos.fxml",
                                                (o) -> new CadastroEquipamentosController(equipamentoRepository,
                                                                esporteRepository)));

                registraTela("LISTA_EQUIPAMENTO",
                                new ScreenRegistryFXML(getClass(), "fxml/equips/ListaEquipamentos.fxml",
                                                (o) -> new ListaEquipamentosController(new EquipamentoVM(equipamentoRepository))));

        }
}