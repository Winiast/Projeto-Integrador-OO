package ifpr.pgua.eic.controllers.sports;

import ifpr.pgua.eic.App;
import javafx.fxml.FXML;

public class EsporteListaController {

    public EsporteListaController() {
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
    public void cadastrarEsporte() {
        App.pushScreen("CADASTRO_ESPORTE");
    }

    @FXML
    public void buscarEsporte() {
        System.out.println("Buscar Esporte");
    }

}
