package ifpr.pgua.eic.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MenuController implements Initializable {

    @FXML
    private MFXButton btnUsuario;

    @FXML
    private MFXButton btnEmprestimo;

    @FXML
    private MFXButton btnEquipamento;

    @FXML
    private MFXButton btnEsporte;

    private boolean[] telaAtiva = new boolean[4];
    private HashMap<Integer, MFXButton> btnsMenu = new HashMap<>();

    @FXML
    private void mudarTelaUsuarios() {
        estiloMenu(0);
        App.changeScreenRegion("LISTA_USUARIO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void mudarTelaEmprestimos() {
        estiloMenu(1);
        App.changeScreenRegion("LISTA_EMPRESTIMO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void mudarTelaEquipamentos() {
        estiloMenu(2);
        App.changeScreenRegion("LISTA_EQUIPAMENTO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void mudarTelaEsportes() {
        estiloMenu(3);
        App.changeScreenRegion("LISTA_ESPORTE", BorderPaneRegion.CENTER);
    }

    @FXML
    private void sair() {
        App.usuarioLogado = null;
        App.popScreen();
    }

    private void estiloMenu(int index) {
        for (int i = 0; i < telaAtiva.length; i++) {
            if (i == index) {
                telaAtiva[i] = true;
            } else {
                telaAtiva[i] = false;
            }
            btnsMenu.get(i).getStyleClass().clear();
        }
        for (int i = 0; i < telaAtiva.length; i++) {
            if (telaAtiva[i]) {
                btnsMenu.get(i).getStyleClass().add("button-menu-special");
            } else {
                btnsMenu.get(i).getStyleClass().add("button-menu");
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnsMenu.put(0, btnUsuario);
        btnsMenu.put(1, btnEmprestimo);
        btnsMenu.put(2, btnEquipamento);
        btnsMenu.put(3, btnEsporte);

        estiloMenu(10);
    }
}
