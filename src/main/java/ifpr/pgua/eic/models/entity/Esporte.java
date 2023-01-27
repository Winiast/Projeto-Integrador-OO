package ifpr.pgua.eic.models.entity;

import java.time.LocalDateTime;

public class Esporte {
    private long id;
    private String nome;
    private String descricao;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private boolean status;

    public Esporte(long id, String nome, String descricao, long criadoEm, long atualizadoEm, boolean status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Esporte(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
