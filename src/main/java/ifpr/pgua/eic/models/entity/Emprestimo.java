package ifpr.pgua.eic.models.entity;

import java.time.LocalDateTime;

public class Emprestimo {

    private long id;
    private LocalDateTime dataEmprestimo;
    private Equipamento equipamento;
    private String nomeAluno;
    private String turma;
    private Usuario usuario;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private boolean status;

    public Emprestimo(long id, LocalDateTime dataEmprestimo, Equipamento equipamento, String nomeAluno, String turma,
            Usuario usuario, long criadoEm, long atualizadoEm, boolean status) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.equipamento = equipamento;
        this.nomeAluno = nomeAluno;
        this.turma = turma;
        this.usuario = usuario;
    }

    public Emprestimo(LocalDateTime dataEmprestimo, Equipamento equipamento, String nomeAluno, String turma,
            Usuario usuario) {
        this.dataEmprestimo = dataEmprestimo;
        this.equipamento = equipamento;
        this.nomeAluno = nomeAluno;
        this.turma = turma;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
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
