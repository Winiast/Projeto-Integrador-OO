package ifpr.pgua.eic.controllers.sports;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.models.entity.Esporte;
import ifpr.pgua.eic.models.repositories.EsporteRepository;
import ifpr.pgua.eic.utils.Utils;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class EsporteCadastroController implements Initializable {

    public static Esporte esporte;

    @FXML
    private Label lbTitle;
    
    @FXML
    private MFXTextField tfEsporte;
    
    @FXML
    private MFXTextField tfDescricao;
    
    private EsporteRepository esporteRepository;


    public EsporteCadastroController(EsporteRepository esporteRepository) {
        this.esporteRepository = esporteRepository;
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if(esporte != null) {
            lbTitle.setText("Atualizar Esporte");
            tfEsporte.setText(esporte.getNome());
            tfDescricao.setText(esporte.getDescricao());
        } else {
            lbTitle.setText("Cadastrar Esporte");
            tfEsporte.setText("");
            tfDescricao.setText("");
        }
    }

    @FXML
    public void cadastrarEsporte() {

        if(tfEsporte.getText().isBlank() || tfDescricao.getText().isBlank()) {
            Utils.exibeAlert(AlertType.ERROR, "Preencha os campos corretamente").showAndWait();    
        } else {
            String nomeEsporte = tfEsporte.getText();
            String descricao = tfDescricao.getText();
            
            if(esporte == null) {
                if(esporteRepository.cadastrar(new Esporte(nomeEsporte, descricao))) {
                    Utils.exibeAlert(AlertType.CONFIRMATION, "Esporte cadastrado com sucesso!!").showAndWait();
                    App.popScreen();
                } else {
                    Utils.exibeAlert(AlertType.ERROR, "Erro ao cadastrar esporte!!").showAndWait();
                }
            } else {
                esporte.setNome(nomeEsporte);
                esporte.setDescricao(descricao);
                
                if(esporteRepository.atualizar(esporte)) {
                    Utils.exibeAlert(AlertType.CONFIRMATION, "Esporte atualizado com sucesso!!").showAndWait();
                    App.popScreen();
                } else {
                    Utils.exibeAlert(AlertType.ERROR, "Erro ao atualizar esporte!!").showAndWait();
                }
            }
        }

    }


}
