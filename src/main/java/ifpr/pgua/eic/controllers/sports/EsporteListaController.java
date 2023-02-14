package ifpr.pgua.eic.controllers.sports;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.sports.viewmodel.EsporteRow;
import ifpr.pgua.eic.controllers.sports.viewmodel.EsporteVM;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioRow;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EsporteListaController implements Initializable {

    @FXML
    private MFXTextField tfBusca;

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
    public void cadastrarEsporte() {
        EsporteCadastroController.esporte = null;
        App.changeScreenRegion("CADASTRO_ESPORTE", BorderPaneRegion.CENTER);
    }

    @FXML
    public void buscarEsporte() {
        if(!tfBusca.getText().isBlank()) {
            String nome = tfBusca.getText();

            esporteVM.buscarEsportes(nome);
            carregarTableView();
        } else {
            esporteVM.carregarLista();
            carregarTableView();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcEditar.setCellValueFactory(new PropertyValueFactory<>("btnEditar"));
        tbcExcluir.setCellValueFactory(new PropertyValueFactory<>("btnExcluir"));

        carregarTableView();
    }

    private void carregarTableView() {
        tbEsportes.getItems().clear();
        esporteVM.getEsportes().forEach(esporte -> {
            tbEsportes.getItems().add(new EsporteRow(esporte, esporteVM));
        });
    }

}
