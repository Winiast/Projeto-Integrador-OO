package ifpr.pgua.eic.controllers.equips;

import java.net.URL;
import java.util.ResourceBundle;
import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.entity.Estado;
import ifpr.pgua.eic.models.repositories.EquipamentoRepository;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import ifpr.pgua.eic.utils.Utils;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;

public class CadastroEquipamentosController implements Initializable {

    public static Equipamento equipamento;

    @FXML
    private Label lbTitle;

    @FXML
    private MFXTextField tfNomeEquipamento;

    @FXML
    private MFXTextField tfQuantidade;

    @FXML
    private MFXComboBox<Estado> estadoInput;

    @FXML
    private MFXComboBox<Esporte> esporteInput;

    private EquipamentoRepository equipamentoRepository;
    private EsporteRepository esporteRepository;

    public CadastroEquipamentosController(EquipamentoRepository equipamentoRepository,
            EsporteRepository esporteRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.esporteRepository = esporteRepository;
    }

    @FXML
    public void cadastrar() {

        if (tfNomeEquipamento.getText().isBlank() || tfQuantidade.getText().isBlank()
                || esporteInput.getSelectedItem() == null || estadoInput.getSelectedItem() == null) {

            Utils.exibeAlert(AlertType.ERROR, "Preencha os campos corretamente").showAndWait();
        } else {
            try {
                String nome = tfNomeEquipamento.getText();
                Esporte esporte = esporteInput.getValue();
                Estado estado = estadoInput.getValue();
                Integer quantidade = Integer.valueOf(tfQuantidade.getText());

                if (equipamento == null) {
                    if (equipamentoRepository.cadastrar(nome, esporte, quantidade, estado)) {
                        Utils.exibeAlert(AlertType.CONFIRMATION, "Equipamento cadastrado com sucesso!!").showAndWait();
                        App.changeScreenRegion("LISTA_EQUIPAMENTO", BorderPaneRegion.CENTER);
                    } else {
                        Utils.exibeAlert(AlertType.ERROR, "Erro ao cadastrar equipamento!!").showAndWait();
                    }
                } else {
                    equipamento.setNome(nome);
                    equipamento.setEsporte(esporte);
                    equipamento.setQuantidade(quantidade);
                    equipamento.setEstado(estado);

                    if (equipamentoRepository.atualizar(equipamento)) {
                        Utils.exibeAlert(AlertType.CONFIRMATION, "Equipamento atualizado com sucesso!!").showAndWait();
                        App.changeScreenRegion("LISTA_EQUIPAMENTO", BorderPaneRegion.CENTER);
                    } else {
                        Utils.exibeAlert(AlertType.ERROR, "Erro ao atualizar equipamento!!").showAndWait();
                    }
                }
            } catch (NumberFormatException e) {
                Utils.exibeAlert(AlertType.ERROR, "Quantidade inválida").showAndWait();
                return;
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        estadoInput.getItems().clear();
        esporteInput.getItems().clear();
        estadoInput.getItems().addAll(Estado.values());
        esporteInput.getItems().addAll(esporteRepository.buscarTodos());

        if (equipamento != null) {
            lbTitle.setText("Atualizar Equipamento");
            tfNomeEquipamento.setText(equipamento.getNome());
            tfQuantidade.setText(equipamento.getQuantidade().toString());
            estadoInput.getSelectionModel().selectItem(equipamento.getEstado());
            esporteInput.getItems().forEach(item -> {
                if (item.getId() == equipamento.getEsporte().getId()) {
                    esporteInput.getSelectionModel().selectItem(item);
                }
            });
        } else {
            lbTitle.setText("Cadastrar Equipamento");
            tfNomeEquipamento.clear();
            tfQuantidade.clear();
        }
    }

}
