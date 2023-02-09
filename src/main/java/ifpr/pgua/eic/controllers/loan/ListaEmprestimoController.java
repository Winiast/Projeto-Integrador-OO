package ifpr.pgua.eic.controllers.loan;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.loan.viewmodel.EmprestimoRow;
import ifpr.pgua.eic.controllers.loan.viewmodel.EmprestimoVM;
import ifpr.pgua.eic.models.entity.Emprestimo;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaEmprestimoController implements Initializable {

    @FXML
    private TableView<EmprestimoRow> tbEmprestimo;

    @FXML
    private TableColumn<EmprestimoRow, String> tbcNomeAluno;

    @FXML
    private TableColumn<EmprestimoRow, String> tbcTurma;

    @FXML
    private TableColumn<EmprestimoRow, List<Emprestimo>> tbcEquipamentos;

    @FXML
    private TableColumn<EmprestimoRow, String> tbcObservacoes;

    @FXML
    private TableColumn<EmprestimoRow, String> tbcDia;

    @FXML
    private TableColumn<EmprestimoRow, String> tbcHorario;

    @FXML
    private TableColumn<EmprestimoRow, Button> tbcEditar;

    @FXML
    private TableColumn<EmprestimoRow, Button> tbcFinalizar;

    private EmprestimoVM emprestimoVM;

    public ListaEmprestimoController(EmprestimoVM emprestimoVM) {
        this.emprestimoVM = emprestimoVM;
    }

    @FXML
    private MFXTextField tfBuscaEmprestimo;

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
    public void buscarEmprestimo() {
        System.out.println("Buscando empréstimo");
    }

    @FXML
    public void cadastrarEmprestimo() {
        CadastroEmprestimoController.emprestimo = null;
        App.pushScreen("CADASTRO_EMPRESTIMO");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcNomeAluno.setCellValueFactory(new PropertyValueFactory<>("nomeAluno"));
        tbcTurma.setCellValueFactory(new PropertyValueFactory<>("turma"));
        tbcEquipamentos.setCellValueFactory(new PropertyValueFactory<>("equipamento"));
        tbcObservacoes.setCellValueFactory(new PropertyValueFactory<>("observacoes"));
        tbcDia.setCellValueFactory(new PropertyValueFactory<>("diaEmprestimo"));
        tbcHorario.setCellValueFactory(new PropertyValueFactory<>("horarioEmprestimo"));
        tbcFinalizar.setCellValueFactory(new PropertyValueFactory<>("btnCheck"));
        tbcEditar.setCellValueFactory(new PropertyValueFactory<>("btnEditar"));

        emprestimoVM.getEmprestimos().forEach(emprestimo -> {
            tbEmprestimo.getItems().add(new EmprestimoRow(emprestimo, emprestimoVM));
        });

    }
}
