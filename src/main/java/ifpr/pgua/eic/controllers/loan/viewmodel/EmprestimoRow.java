package ifpr.pgua.eic.controllers.loan.viewmodel;

import java.time.format.DateTimeFormatter;
import java.util.List;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.loan.CadastroEmprestimoController;
import ifpr.pgua.eic.models.entity.Emprestimo;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EmprestimoRow {

    private String nomeAluno;
    private String turma;
    private List<Equipamento> equipamento;
    private String observacoes;
    private String diaEmprestimo;
    private String horarioEmprestimo;
    private Button btnEditar;
    private Button btnCheck;

    public EmprestimoRow(Emprestimo emprestimo, EmprestimoVM emprestimoVM) {
        this.nomeAluno = emprestimo.getNomeAluno();
        this.turma = emprestimo.getTurma();
        this.equipamento = emprestimo.getEquipamento();
        this.observacoes = emprestimo.getObservacoes();
        this.diaEmprestimo = emprestimo.getCriadoEm().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.horarioEmprestimo = emprestimo.getCriadoEm().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));

        Image imageEdit = new Image(getClass().getResourceAsStream("../../../images/edit1.png"));
        ImageView imageViewEdit = new ImageView(imageEdit);

        Image imageCheck = new Image(getClass().getResourceAsStream("../../../images/check.png"));
        ImageView imageViewCheck = new ImageView(imageCheck);

        btnCheck = new MFXButton("", imageViewCheck);
        btnCheck.setPrefSize(25, 25);
        btnCheck.setStyle("-fx-background-color: #5CD959;");
        btnCheck.setOnAction(event -> {
            emprestimoVM.finalizarEmprestimo(emprestimo);
        });

        btnEditar = new MFXButton("", imageViewEdit);
        btnEditar.setPrefSize(25, 25);
        btnEditar.setStyle("-fx-background-color: #0085FF;");
        btnEditar.setOnAction(event -> {
            CadastroEmprestimoController.emprestimo = emprestimo;
            App.changeScreenRegion("CADASTRO_EMPRESTIMO", BorderPaneRegion.CENTER);
        });
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getTurma() {
        return turma;
    }

    public List<Equipamento> getEquipamento() {
        return equipamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getDiaEmprestimo() {
        return diaEmprestimo;
    }

    public String getHorarioEmprestimo() {
        return horarioEmprestimo;
    }

    public Button getBtnEditar() {
        return btnEditar;
    }

    public Button getBtnCheck() {
        return btnCheck;
    }
}
