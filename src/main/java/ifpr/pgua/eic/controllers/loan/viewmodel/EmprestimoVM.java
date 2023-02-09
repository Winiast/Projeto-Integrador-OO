package ifpr.pgua.eic.controllers.loan.viewmodel;

import ifpr.pgua.eic.models.entity.Emprestimo;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.repositories.EmprestimoRepository;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmprestimoVM {

    private SimpleStringProperty nomeAluno = new SimpleStringProperty();
    private SimpleStringProperty turma = new SimpleStringProperty();
    private SimpleListProperty<Equipamento> equipamentos = new SimpleListProperty<>();
    private SimpleStringProperty observacoes = new SimpleStringProperty();
    private SimpleStringProperty diaEmprestimo = new SimpleStringProperty();
    private SimpleStringProperty horarioEmprestimo = new SimpleStringProperty();

    private ObservableList<Emprestimo> emprestimos = FXCollections.observableArrayList();

    private EmprestimoRepository emprestimoRepository;

    public EmprestimoVM(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;

        carregarLista();
    }

    public void carregarLista() {
        emprestimos.clear();
        emprestimos.addAll(emprestimoRepository.buscarTodos());
    }

    public void excluir(Emprestimo emprestimo) {
        emprestimoRepository.finalizarEmprestimo(emprestimo.getId());
        carregarLista();
    }

    public SimpleStringProperty getNomeAluno() {
        return nomeAluno;
    }

    public SimpleStringProperty getTurma() {
        return turma;
    }

    public SimpleListProperty<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public SimpleStringProperty getObservacoes() {
        return observacoes;
    }

    public SimpleStringProperty getDiaEmprestimo() {
        return diaEmprestimo;
    }

    public SimpleStringProperty getHorarioEmprestimo() {
        return horarioEmprestimo;
    }

    public ObservableList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
