package ifpr.pgua.eic.models.entity;

import java.time.LocalDateTime;

public class Equipamento {

    private long id;
    private String nome;
    private Esporte esporte;
    private Integer quantidade;
    private Estado estado;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private boolean status;

    public Equipamento(long id, String nome, Esporte esporte, Integer quantidade, Estado estado, LocalDateTime criadoEm,
            LocalDateTime atualizadoEm, boolean status) {
        this.id = id;
        this.nome = nome;
        this.esporte = esporte;
        this.quantidade = quantidade;
        this.estado = estado;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.status = status;
    }

    public Equipamento(String nome, Esporte esporte, Integer quantidade, Estado estado) {
        this.nome = nome;
        this.esporte = esporte;
        this.quantidade = quantidade;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return nome;
    }

}
