package ifpr.pgua.eic.models.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Emprestimo {

    private long id;
    private LocalDateTime dataDevolucaoEmprestimo;
    private List<Equipamento> equipamento;
    private String nomeAluno;
    private String turma;
    private String observacoes;
    private Usuario usuario;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private boolean status;

    public Emprestimo(long id, LocalDateTime dataDevolucaoEmprestimo, List<Equipamento> equipamento,
            String nomeAluno, String turma, String observacoes, Usuario usuario, LocalDateTime criadoEm,
            LocalDateTime atualizadoEm) {
        this.id = id;
        this.dataDevolucaoEmprestimo = dataDevolucaoEmprestimo;
        this.equipamento = equipamento;
        this.nomeAluno = nomeAluno;
        this.turma = turma;
        this.observacoes = observacoes;
        this.usuario = usuario;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Emprestimo(List<Equipamento> equipamento, String nomeAluno, String turma, String observacoes,
            Usuario usuario) {
        this.equipamento = equipamento;
        this.nomeAluno = nomeAluno;
        this.turma = turma;
        this.observacoes = observacoes;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataDevolucaoEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataDevolucaoEmprestimo) {
        this.dataDevolucaoEmprestimo = dataDevolucaoEmprestimo;
    }

    public List<Equipamento> getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(List<Equipamento> equipamento) {
        this.equipamento = equipamento;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
