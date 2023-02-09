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
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class CadastroEmprestimoController implements Initializable {

    public static Emprestimo emprestimo;

    @FXML
    private Label lbTitle;

    @FXML
    private MFXTextField tfNomeAluno;

    @FXML
    private MFXTextField turmaInput;

    @FXML
    private MFXComboBox<Equipamento> equipamentoInput;

    @FXML
    private MFXButton btnAdicionar;

    @FXML
    private MFXListView<Equipamento> equipamentosSelecionados;

    @FXML
    private MFXTextField tfObservacao;

    private EmprestimoRepository emprestimoRepository;

    private EquipamentoRepository equipamentoRepository;

    public CadastroEmprestimoController(EmprestimoRepository emprestimoRepository,
            EquipamentoRepository equipamentoRepository) {
        this.emprestimoRepository = emprestimoRepository;
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

        if (verifyFields()) {
            Utils.exibeAlert(AlertType.ERROR, "Preencha todos os campos!").showAndWait();
            return;
        } else {
            List<Equipamento> equipamentos = equipamentosSelecionados.getItems();
            String nomeAluno = tfNomeAluno.getText();
            String turma = turmaInput.getText();
            String observacoes = tfObservacao.getText();

            if (emprestimo == null) {
                if (emprestimoRepository
                        .cadastrar(new Emprestimo(equipamentos, nomeAluno, turma, observacoes, App.usuarioLogado))) {
                    Utils.exibeAlert(AlertType.INFORMATION, "Emprestimo cadastrado com sucesso!").showAndWait();
                    App.popScreen();
                } else {
                    Utils.exibeAlert(AlertType.ERROR, "Erro ao cadastrar emprestimo!").showAndWait();
                }
            } else {
                emprestimo.setEquipamento(equipamentos);
                emprestimo.setNomeAluno(nomeAluno);
                emprestimo.setTurma(turma);
                emprestimo.setObservacoes(observacoes);
                emprestimo.setUsuario(App.usuarioLogado);

                if (emprestimoRepository.atualizar(emprestimo)) {
                    Utils.exibeAlert(AlertType.CONFIRMATION, "Emprestimo atualizado com sucesso!").showAndWait();
                    App.popScreen();
                } else {
                    Utils.exibeAlert(AlertType.ERROR, "Erro ao atualizar emprestimo!").showAndWait();
                    return;
                }
            }
        }
    }

    @FXML
    public void adicionar() {
        equipamentosSelecionados.getItems().add(equipamentoInput.getValue());
        equipamentoInput.getItems().remove(equipamentoInput.getValue());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        equipamentoInput.getItems().clear();
        equipamentoInput.getItems().addAll(equipamentoRepository.buscarTodos());

        if (emprestimo != null) {
            lbTitle.setText("Atualizar emprestimo");
            tfNomeAluno.setText(emprestimo.getNomeAluno());
            turmaInput.setText(emprestimo.getTurma());
            tfObservacao.setText(emprestimo.getObservacoes());
            equipamentosSelecionados.getItems().addAll(emprestimo.getEquipamento());

            equipamentoInput.setDisable(true);
            btnAdicionar.setDisable(true);
            equipamentosSelecionados.setDisable(true);
        } else {
            lbTitle.setText("Cadastrar emprestimo");
            limparCampos();
        }
    }

    private void limparCampos() {
        tfNomeAluno.clear();
        turmaInput.clear();
        tfObservacao.clear();
        equipamentoInput.clear();
        equipamentosSelecionados.getItems().clear();
    }

    private boolean verifyFields() {
        if (tfNomeAluno.getText().isEmpty()) {
            tfNomeAluno.styleProperty().set("-fx-border-color: red");
        } else {
            tfNomeAluno.styleProperty().set("-fx-border-color: #329e43");
        }

        if (turmaInput.getText().isEmpty()) {
            turmaInput.styleProperty().set("-fx-border-color: red");
        } else {
            turmaInput.styleProperty().set("-fx-border-color: #329e43");
        }

        if (equipamentosSelecionados.getItems().isEmpty()) {
            equipamentoInput.styleProperty().set("-fx-border-color: red");
            equipamentosSelecionados.styleProperty().set("-fx-border-color: red");
        } else {
            equipamentoInput.styleProperty().set("-fx-border-color: #329e43");
            equipamentosSelecionados.styleProperty().set("-fx-border-color: #329e43");

        }

        return tfNomeAluno.getText().isEmpty() || turmaInput.getText().isEmpty()
                || equipamentosSelecionados.getItems().isEmpty();

    }
}
