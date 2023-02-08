package ifpr.pgua.eic.controllers.sports;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.sports.viewmodel.EsporteRow;
import ifpr.pgua.eic.controllers.sports.viewmodel.EsporteVM;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioRow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EsporteListaController implements Initializable {

    @FXML
    private TableView<EsporteRow> tbEsportes;

    @FXML
    private TableColumn<UsuarioRow, String> tbcNome;

    @FXML
    private TableColumn<UsuarioRow, String> tbcDescricao;

    @FXML
    private TableColumn<UsuarioRow, Button> tbcEditar;

    @FXML
    private TableColumn<UsuarioRow, Button> tbcExcluir;

    private EsporteVM esporteVM;

    public EsporteListaController(EsporteVM esporteVM) {
        this.esporteVM = esporteVM;
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
    public void sair() {
        App.pushScreen("LOGIN");
    }

    @FXML
    public void cadastrarEsporte() {
        App.pushScreen("CADASTRO_ESPORTE");
    }

    @FXML
    public void buscarEsporte() {
        System.out.println("Buscar Esporte");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcEditar.setCellValueFactory(new PropertyValueFactory<>("btnEditar"));
        tbcExcluir.setCellValueFactory(new PropertyValueFactory<>("btnExcluir"));

        esporteVM.getEsportes().forEach(esporte -> {
            tbEsportes.getItems().add(new EsporteRow(esporte, esporteVM));
        });

    }

}
