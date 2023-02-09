package ifpr.pgua.eic.controllers.loan.viewmodel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.loan.CadastroEmprestimoController;
import ifpr.pgua.eic.models.entity.Emprestimo;
import ifpr.pgua.eic.models.entity.Equipamento;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EmprestimoRow {

    private String nomeAluno;
    private String turma;
    private List<Equipamento> equipamento;
    private String observacoes;
    private LocalDate diaEmprestimo;
    private LocalTime horarioEmprestimo;
    private Button btnEditar;
    private Button btnExcluir;

    public EmprestimoRow(Emprestimo emprestimo, EmprestimoVM emprestimoVM) {
        this.nomeAluno = emprestimo.getNomeAluno();
        this.turma = emprestimo.getTurma();
        this.equipamento = emprestimo.getEquipamento();
        this.observacoes = emprestimo.getObservacoes();
        this.diaEmprestimo = emprestimo.getCriadoEm().toLocalDate();
        this.horarioEmprestimo = emprestimo.getCriadoEm().toLocalTime();

        Image imageEdit = new Image(getClass().getResourceAsStream("../../../images/edit1.png"));
        ImageView imageViewEdit = new ImageView(imageEdit);

        Image imageDelete = new Image(getClass().getResourceAsStream("../../../images/trash.png"));
        ImageView imageViewDelete = new ImageView(imageDelete);

        btnEditar = new MFXButton("", imageViewEdit);
        btnEditar.setPrefSize(25, 25);
        btnEditar.setStyle("-fx-background-color: #0085FF;");
        btnEditar.setOnAction(event -> {
            CadastroEmprestimoController.emprestimo = emprestimo;
            App.pushScreen("CADASTRO_EMPRESTIMO");
        });

        btnExcluir = new MFXButton("", imageViewDelete);
        btnExcluir.setPrefSize(25, 25);
        btnExcluir.setStyle("-fx-background-color: red;");
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

    public LocalDate getDiaEmprestimo() {
        return diaEmprestimo;
    }

    public LocalTime getHorarioEmprestimo() {
        return horarioEmprestimo;
    }

    public Button getBtnEditar() {
        return btnEditar;
    }

    public Button getBtnExcluir() {
        return btnExcluir;
    }
}
