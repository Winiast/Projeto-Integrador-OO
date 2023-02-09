package ifpr.pgua.eic.controllers.equips.viewmodel;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.equips.CadastroEquipamentosController;
import ifpr.pgua.eic.models.entity.Equipamento;
import ifpr.pgua.eic.models.entity.Estado;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EquipamentoRow {

    private String nome;
    private String esporte;
    private int quantidade;
    private Estado estado;
    private Button btnEditar;
    private Button btnExcluir;

    public EquipamentoRow(Equipamento equipamento, EquipamentoVM equipamentoVM) {
        this.nome = equipamento.getNome();
        this.esporte = equipamento.getEsporte().getNome();
        this.quantidade = equipamento.getQuantidade();
        this.estado = equipamento.getEstado();

        Image imageEdit = new Image(getClass().getResourceAsStream("../../../images/edit1.png"));
        ImageView imageViewEdit = new ImageView(imageEdit);

        Image imageDelete = new Image(getClass().getResourceAsStream("../../../images/trash.png"));
        ImageView imageViewDelete = new ImageView(imageDelete);

        btnEditar = new MFXButton("", imageViewEdit);
        btnEditar.setPrefSize(25, 25);
        btnEditar.setStyle("-fx-background-color: #0085FF;");
        btnEditar.setOnAction(event -> {
            CadastroEquipamentosController.equipamento = equipamento;
            App.pushScreen("CADASTRO_EQUIPAMENTO");
        });

        btnExcluir = new MFXButton("", imageViewDelete);
        btnExcluir.setPrefSize(25, 25);
        btnExcluir.setStyle("-fx-background-color: red;");
        btnExcluir.setOnAction(event -> {
            equipamentoVM.excluir(equipamento);
        });
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Button getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(Button btnEditar) {
        this.btnEditar = btnEditar;
    }

    public Button getBtnExcluir() {
        return btnExcluir;
    }

    public void setBtnExcluir(Button btnExcluir) {
        this.btnExcluir = btnExcluir;
    }

}
