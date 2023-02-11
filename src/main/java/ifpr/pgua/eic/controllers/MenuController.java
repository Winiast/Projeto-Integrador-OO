package ifpr.pgua.eic.controllers;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class MenuController {
    
    @FXML
    private void mudarTelaUsuarios() {
        App.changeScreenRegion("LISTA_USUARIO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void mudarTelaEmprestimos() {
        App.changeScreenRegion("LISTA_EMPRESTIMO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void mudarTelaEquipamentos() {
        App.changeScreenRegion("LISTA_EQUIPAMENTO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void mudarTelaEsportes() {
        App.changeScreenRegion("LISTA_ESPORTE", BorderPaneRegion.CENTER);
    }

    @FXML
    private void sair() {
        App.usuarioLogado = null;
        App.popScreen();
    }
}
