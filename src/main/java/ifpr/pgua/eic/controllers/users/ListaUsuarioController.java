package ifpr.pgua.eic.controllers.users;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioRow;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioVM;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaUsuarioController implements Initializable {

    @FXML
    private TableView<UsuarioRow> tbUsuarios;

    @FXML
    private TableColumn<UsuarioRow, String> tbcNome;

    @FXML
    private TableColumn<UsuarioRow, String> tbcSobrenome;

    @FXML
    private TableColumn<UsuarioRow, String> tbcEmail;

    @FXML
    private TableColumn<UsuarioRow, Button> tbcEditar;

    @FXML
    private TableColumn<UsuarioRow, Button> tbcExcluir;

    private UsuarioVM usuarioVM;

    public ListaUsuarioController(UsuarioVM usuarioVM) {
        this.usuarioVM = usuarioVM;
    }

    @FXML
    public void usuarioLista() {
        App.pushScreen("LISTA_USUARIO");
    }

    @FXML
    public void emprestimoLista() {
        App.pushScreen("LISTA_EMPRESTIMO");
    }

    @FXML
    public void equipamentosLista() {
        App.pushScreen("LISTA_EQUIPAMENTO");
    }

    @FXML
    public void esporteLista() {
        App.pushScreen("LISTA_ESPORTE");
    }

    @FXML
    public void cadastrar() {
        CadastroUsuarioController.usuario = null;
        App.pushScreen("CADASTRO_USUARIO");
    }

    @FXML
    public void buscarUsuario() {
        System.out.println("Buscar");
    }

    @FXML
    public void sair() {
        App.pushScreen("LOGIN");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbcEditar.setCellValueFactory(new PropertyValueFactory<>("btnEditar"));
        tbcExcluir.setCellValueFactory(new PropertyValueFactory<>("btnExcluir"));

        usuarioVM.getUsuarios().forEach(usuario -> {
            tbUsuarios.getItems().add(new UsuarioRow(usuario, usuarioVM));
        });
    }
}
