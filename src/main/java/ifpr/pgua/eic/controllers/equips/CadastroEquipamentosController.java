package ifpr.pgua.eic.controllers.equips;

import java.net.URL;
import java.util.ResourceBundle;
import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.entity.Estado;
import ifpr.pgua.eic.models.repositories.EquipamentoRepository;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import ifpr.pgua.eic.utils.Utils;

public class CadastroEquipamentosController implements Initializable {

    private EquipamentoRepository equipamentoRepository;
    private EsporteRepository esporteRepository;
    private Utils exibe;

    @FXML
    private MFXTextField tfNomeEquipamento;

    @FXML
    private MFXTextField tfQuantidade;

    @FXML
    private MFXComboBox<Estado> estadoInput;

    @FXML
    private MFXComboBox<Esporte> esporteInput;

    public CadastroEquipamentosController(EquipamentoRepository equipamentoRepository,
            EsporteRepository esporteRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.esporteRepository = esporteRepository;
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
    public void cadastrar() {

        String nome = tfNomeEquipamento.getText();
        Esporte esporte = esporteInput.getValue();
        Integer quantidade = Integer.valueOf(tfQuantidade.getText());
        Estado estado = estadoInput.getValue();

        equipamentoRepository.cadastrar(nome, esporte, quantidade, estado);

        tfNomeEquipamento.clear();
        esporteInput.clear();
        tfQuantidade.clear();
        estadoInput.clear();

        exibe.exibeAlert(AlertType.CONFIRMATION, "Equipamento cadastrado com sucesso!").showAndWait();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        estadoInput.getItems().clear();
        esporteInput.getItems().clear();
        estadoInput.getItems().addAll(Estado.values());
        esporteInput.getItems().addAll(esporteRepository.buscarTodos());
    }

}
