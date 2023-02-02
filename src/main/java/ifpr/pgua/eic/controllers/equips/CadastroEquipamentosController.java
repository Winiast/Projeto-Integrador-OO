package ifpr.pgua.eic.controllers.equips;

import java.net.URL;
import java.util.ResourceBundle;
import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.FabricaConexoes;
import ifpr.pgua.eic.models.daos.EsporteDao;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.entity.Estado;
import ifpr.pgua.eic.models.jdbc.EsporteJDBC;
import ifpr.pgua.eic.models.repositories.EquipamentoRepository;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadastroEquipamentosController implements Initializable {

    private EquipamentoRepository equipamentoRepository;
    private EsporteRepository esporteRepository;
    private EsporteDao esporteDao;
    private FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();

    @FXML
    private MFXTextField tfNomeEquipamento;

    @FXML
    private MFXTextField tfQuantidade;

    @FXML
    private MFXComboBox<Estado> estadoInput;

    @FXML
    private MFXComboBox<Esporte> esporteInput;

    public CadastroEquipamentosController(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
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

    }

    @FXML
    public void estadoSelecionado() {
        System.out.println(estadoInput.getValue());
    }

    @FXML
    public void esporteSelecionado() {
        System.out.println("Esporte Selecionado");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        esporteDao = new EsporteJDBC(fabricaConexoes);
        estadoInput.getItems().clear();
        esporteInput.getItems().clear();
        estadoInput.getItems().addAll(Estado.values());
        esporteInput.getItems().addAll(esporteDao.buscarTodos());
    }

}
