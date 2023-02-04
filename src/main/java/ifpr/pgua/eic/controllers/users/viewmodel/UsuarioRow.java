package ifpr.pgua.eic.controllers.users.viewmodel;

import ifpr.pgua.eic.models.entity.Usuario;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UsuarioRow {

    String nome;
    String sobrenome;
    String email;
    Button btnEditar;
    Button btnExcluir;

    public UsuarioRow(Usuario usuario) {
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();

        Image imageEdit = new Image(getClass().getResourceAsStream("../../../images/edit1.png"));
        ImageView imageViewEdit = new ImageView(imageEdit);

        Image imageDelete = new Image(getClass().getResourceAsStream("../../../images/trash.png"));
        ImageView imageViewDelete = new ImageView(imageDelete);

        this.btnEditar = new MFXButton("", imageViewEdit);
        this.btnEditar.setPrefSize(25, 25);
        this.btnEditar.setStyle("-fx-background-color: #0085FF;");

        this.btnExcluir = new MFXButton("", imageViewDelete);
        this.btnExcluir.setPrefSize(25, 25);
        this.btnExcluir.setStyle("-fx-background-color: red;");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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