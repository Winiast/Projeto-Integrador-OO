package ifpr.pgua.eic.controllers.equips;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.equips.viewmodel.EquipamentoRow;
import ifpr.pgua.eic.controllers.equips.viewmodel.EquipamentoVM;
import ifpr.pgua.eic.models.entity.Estado;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaEquipamentosController implements Initializable {

    @FXML
    private MFXTextField tfBusca;

    @FXML
    private TableView<EquipamentoRow> tbEquipamento;

    @FXML
    private TableColumn<EquipamentoRow, String> tbcNome;

    @FXML
    private TableColumn<EquipamentoRow, String> tbcEsporte;

    @FXML
    private TableColumn<EquipamentoRow, Integer> tbcQuantidade;

    @FXML
    private TableColumn<EquipamentoRow, Estado> tbcEstado;

    @FXML
    private TableColumn<EquipamentoRow, Button> tbcEditar;

    @FXML
    private TableColumn<EquipamentoRow, Button> tbcExcluir;

    private EquipamentoVM equipamentoVM;

    public ListaEquipamentosController(EquipamentoVM equipamentoVM) {
        this.equipamentoVM = equipamentoVM;
    }

    @FXML
    public void buscarEquipamento() {
        if(!tfBusca.getText().isBlank()) {
            String nome = tfBusca.getText();

            equipamentoVM.buscarEquipamentos(nome);
            carregarTableView();
        } else {
            equipamentoVM.carregarLista();
            carregarTableView();
        }
    }

    @FXML
    public void cadastrarEquipamento() {
        CadastroEquipamentosController.equipamento = null;
        App.changeScreenRegion("CADASTRO_EQUIPAMENTO", BorderPaneRegion.CENTER);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcEsporte.setCellValueFactory(new PropertyValueFactory<>("esporte"));
        tbcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tbcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbcEditar.setCellValueFactory(new PropertyValueFactory<>("btnEditar"));
        tbcExcluir.setCellValueFactory(new PropertyValueFactory<>("btnExcluir"));

        carregarTableView();
    }

    private void carregarTableView() {
        tbEquipamento.getItems().clear();
        equipamentoVM.getEquipamentos().forEach(equipamento -> {
            tbEquipamento.getItems().add(new EquipamentoRow(equipamento, equipamentoVM));
        });
    }
}
