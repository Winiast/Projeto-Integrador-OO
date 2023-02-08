package ifpr.pgua.eic.controllers.sports;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import ifpr.pgua.eic.utils.Utils;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;

public class EsporteCadastroController {
    
    @FXML
    private MFXTextField tfEsporte;
    
    @FXML
    private MFXTextField tfDescricao;
    
    private EsporteRepository esporteRepository;


    public EsporteCadastroController(EsporteRepository esporteRepository) {
        this.esporteRepository = esporteRepository;
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
    public void cadastrarEsporte() {
        String nomeEsporte = tfEsporte.getText();
        String descricao = tfDescricao.getText();

        if(esporteRepository.cadastrar(new Esporte(nomeEsporte, descricao))) {
            Utils.exibeAlert(AlertType.CONFIRMATION, "Esporte cadastrado com sucesso!!").showAndWait();
            App.popScreen();
        } else {
            Utils.exibeAlert(AlertType.ERROR, "Erro ao cadastrar esporte!!");
        }
    }

}
