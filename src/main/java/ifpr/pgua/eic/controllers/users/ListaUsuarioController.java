package ifpr.pgua.eic.controllers.users;

import ifpr.pgua.eic.App;
import javafx.fxml.FXML;

public class ListaUsuarioController {

    public ListaUsuarioController() {

    }

    @FXML
    public void usuarioLista() {
        App.pushScreen("LISTA_USUARIO");
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
    public void cadastrar() {
        App.pushScreen("CADASTRO_USUARIO");
    }

    @FXML
    public void buscarUsuario() {
        System.out.println("Buscar");
    }

    @FXML
    public void sair() {
        App.pushScreen("LOGIN");
    }

}
