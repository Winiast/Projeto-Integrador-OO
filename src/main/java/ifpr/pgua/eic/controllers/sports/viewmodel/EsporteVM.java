package ifpr.pgua.eic.controllers.sports.viewmodel;

import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EsporteVM {

    private SimpleStringProperty nome = new SimpleStringProperty();
    private SimpleStringProperty descricao = new SimpleStringProperty();

    private ObservableList<Esporte> esportes = FXCollections.observableArrayList();

    private EsporteRepository esporteRepository;

    public EsporteVM(EsporteRepository esporteRepository) {
        this.esporteRepository = esporteRepository;

        carregarLista();
    }

    private void carregarLista() {
        esportes.clear();
        esportes.addAll(esporteRepository.buscarTodos());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getDescricao() {
        return descricao;
    }

    public ObservableList<Esporte> getEsportes() {
        return esportes;
    }
}
