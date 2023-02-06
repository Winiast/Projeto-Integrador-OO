package ifpr.pgua.eic.controllers.sports.viewmodel;

import ifpr.pgua.eic.models.entity.Esporte;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EsporteRow {

    private String nome;
    private String descricao;
    private Button btnEditar;
    private Button btnExcluir;

    public EsporteRow(Esporte esporte) {
        this.nome = esporte.getNome();
        this.descricao = esporte.getDescricao();

        Image imageEdit = new Image(getClass().getResourceAsStream("../../../images/edit1.png"));
        ImageView imageViewEdit = new ImageView(imageEdit);

        Image imageDelete = new Image(getClass().getResourceAsStream("../../../images/trash.png"));
        ImageView imageViewDelete = new ImageView(imageDelete);

        btnEditar = new MFXButton("", imageViewEdit);
        btnEditar.setPrefSize(25, 25);
        btnEditar.setStyle("-fx-background-color: #0085FF;");

        btnExcluir = new MFXButton("", imageViewDelete);
        btnExcluir.setPrefSize(25, 25);
        btnExcluir.setStyle("-fx-background-color: red;");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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