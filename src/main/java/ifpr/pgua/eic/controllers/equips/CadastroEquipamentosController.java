package ifpr.pgua.eic.controllers.equips;

import ifpr.pgua.eic.App;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class CadastroEquipamentosController {

    @FXML
    private MFXTextField tfNomeEquipamento;

    @FXML
    private MFXTextField tfDescricao;

    @FXML
    private MFXTextField tfQuantidade;

    public CadastroEquipamentosController() {
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
    public void sair() {
        App.pushScreen("LOGIN");
    }

    @FXML
    public void cadastrar() {
        System.out.println("Cadastrar Equipamento");
    }

    @FXML
    public void estadoSelecionado() {
        System.out.println("Estado Selecionado");
    }

    @FXML
    public void esporteSelecionado() {
        System.out.println("Esporte Selecionado");
    }

}
