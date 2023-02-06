package ifpr.pgua.eic.controllers.loan;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Emprestimo;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.repositories.EmprestimoRepository;
import ifpr.pgua.eic.models.repositories.EquipamentoRepository;
import ifpr.pgua.eic.utils.Utils;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

public class CadastroEmprestimoController implements Initializable {

    private EmprestimoRepository emprestimoRepository;
    private EquipamentoRepository equipamentoRepository;
    private Utils alert;

    public CadastroEmprestimoController(EmprestimoRepository emprestimoRepository,
            EquipamentoRepository equipamentoRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    @FXML
    private MFXTextField tfNomeAluno;

    @FXML
    private MFXTextField turmaInput;

    @FXML
    private MFXComboBox<Equipamento> equipamentoInput;

    @FXML
    private MFXListView<Equipamento> equipamentosSelecionados;

    @FXML
    private MFXTextField tfObservacao;

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

        List<Equipamento> equipamentos = equipamentosSelecionados.getItems();
        String nomeAluno = tfNomeAluno.getText();
        String turma = turmaInput.getText();
        String observacoes = tfObservacao.getText();

        emprestimoRepository.cadastrar(new Emprestimo(equipamentos, nomeAluno, turma, observacoes, App.usuarioLogado));

        equipamentosSelecionados.getItems().clear();
        tfNomeAluno.clear();
        turmaInput.clear();
        tfObservacao.clear();
        equipamentoInput.clear();

        alert.exibeAlert(AlertType.CONFIRMATION, "Emprestimo cadastrado com sucesso!").showAndWait();
    }

    @FXML
    public void adicionar() {
        equipamentosSelecionados.getItems().add(equipamentoInput.getValue());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        equipamentoInput.getItems().clear();

        // equipamentoInput.getItems().addAll(equipamentoRepository.listarTodos());

        // Erro na hora de adicionar o equipamento a comboBox, o que pode ser?
    }
}
