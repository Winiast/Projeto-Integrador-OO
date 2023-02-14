package ifpr.pgua.eic.controllers.users;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioRow;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioVM;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaUsuarioController implements Initializable {

    @FXML
    private MFXTextField tfBusca;

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
    public void cadastrar() {
        CadastroUsuarioController.usuario = null;
        App.changeScreenRegion("CADASTRO_USUARIO", BorderPaneRegion.CENTER);
    }

    @FXML
    public void buscarUsuario() {
        if(!tfBusca.getText().isBlank()) {
            String nome = tfBusca.getText();

            usuarioVM.buscarUsuario(nome);
            carregarTableView();
        } else {
            usuarioVM.carregarLista();
            carregarTableView();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbcEditar.setCellValueFactory(new PropertyValueFactory<>("btnEditar"));
        tbcExcluir.setCellValueFactory(new PropertyValueFactory<>("btnExcluir"));

        carregarTableView();
    }

    public void carregarTableView() {
        tbUsuarios.getItems().clear();
        usuarioVM.getUsuarios().forEach(usuario -> {
            tbUsuarios.getItems().add(new UsuarioRow(usuario, usuarioVM));
        });
    }
}
