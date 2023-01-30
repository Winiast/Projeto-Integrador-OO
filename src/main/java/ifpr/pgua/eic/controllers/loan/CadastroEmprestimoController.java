package ifpr.pgua.eic.controllers.loan;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class CadastroEmprestimoController {

    public CadastroEmprestimoController() {
    }

    @FXML
    private MFXTextField tfNomeAluno;

    @FXML
    private MFXComboBox turmaInput;

    @FXML
    private MFXComboBox equipamentoInput;

    @FXML
    private MFXListView equipamentosSelecionados;

    @FXML
    private MFXTextField tfObservacao;

    @FXML
    public void usuarioLista() {
        System.out.println("Lista de Usuários");
    }

    @FXML
    public void emprestimoLista() {
        System.out.println("Lista de Empréstimos");
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
        System.out.println("Cadastrando Empréstimo");
    }

    @FXML
    public void turmaSelecionada() {
        System.out.println("Turma Selecionada");
    }

    @FXML
    public void equipamentoSelecionado() {
        System.out.println("Equipamento Selecionado");
    }
}
