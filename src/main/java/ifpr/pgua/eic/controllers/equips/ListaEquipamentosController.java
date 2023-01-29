package ifpr.pgua.eic.controllers.equips;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class ListaEquipamentosController {

    @FXML
    private MFXTextField tfBuscaEquipamento;

    public ListaEquipamentosController() {
    }

    @FXML
    public void usuarioLista() {
        System.out.println("Lista de Usuários");
    }

    @FXML
    public void emprestimoLista() {
        System.out.println("Lista de Empréstimos");
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
    public void buscarEquipamento() {
        System.out.println("Buscando Equipamento");
    }

    @FXML
    public void cadastrarEquipamento() {
        App.pushScreen("CADASTRO_EQUIPAMENTO");
    }

}
