package ifpr.pgua.eic.controllers.sports;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class EsporteCadastroController {

    @FXML
    private MFXTextField tfEsporte;

    @FXML
    private MFXTextField tfDescricao;

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
    public void sair() {
        App.pushScreen("LOGIN");
    }

    @FXML
    public void cadastrarEsporte() {
        System.out.println("Cadastrando Esporte");
    }

    public EsporteCadastroController() {
    }
}
