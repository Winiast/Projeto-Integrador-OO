package ifpr.pgua.eic.controllers.equips.viewmodel;

import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.repositories.EquipamentoRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EquipamentoVM {

    private SimpleStringProperty nome = new SimpleStringProperty();
    private SimpleStringProperty esporte = new SimpleStringProperty();
    private SimpleIntegerProperty quantidade = new SimpleIntegerProperty();
    private SimpleStringProperty estado = new SimpleStringProperty();

    private ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList();

    private EquipamentoRepository equipamentoRepository;

    public EquipamentoVM(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
        
        carregarLista();
    }

    public void carregarLista() {
        equipamentos.clear();
        equipamentos.addAll(equipamentoRepository.buscarTodos());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getEsporte() {
        return esporte;
    }

    public SimpleIntegerProperty getQuantidade() {
        return quantidade;
    }

    public SimpleStringProperty getEstado() {
        return estado;
    }

    public ObservableList<Equipamento> getEquipamentos() {
        return equipamentos;
    }    
}
