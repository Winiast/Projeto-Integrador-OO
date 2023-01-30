package ifpr.pgua.eic.controllers.loan;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class ListaEmprestimoController {

    public ListaEmprestimoController() {

    }

    @FXML
    private MFXTextField tfBuscaEmprestimo;

    @FXML
    public void usuarioLista() {
        System.out.println("Lista de Usuários");
    }

    @FXML
    public void emprestimoLista() {
        App.pushScreen("LISTA_EMPRESTIMO");
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

}
