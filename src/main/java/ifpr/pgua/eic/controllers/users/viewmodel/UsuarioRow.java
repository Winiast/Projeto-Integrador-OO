package ifpr.pgua.eic.controllers.users.viewmodel;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.users.CadastroUsuarioController;
import ifpr.pgua.eic.models.entity.Usuario;
import ifpr.pgua.eic.utils.Navigator.BorderPaneRegion;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UsuarioRow {

    private String nome;
    private String sobrenome;
    private String email;
    private Button btnEditar;
    private Button btnExcluir;

    public UsuarioRow(Usuario usuario, UsuarioVM usuarioVM) {
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();

        Image imageEdit = new Image(getClass().getResourceAsStream("../../../images/edit1.png"));
        ImageView imageViewEdit = new ImageView(imageEdit);

        Image imageDelete = new Image(getClass().getResourceAsStream("../../../images/trash.png"));
        ImageView imageViewDelete = new ImageView(imageDelete);

        btnEditar = new MFXButton("", imageViewEdit);
        btnEditar.setPrefSize(25, 25);
        btnEditar.setStyle("-fx-background-color: #0085FF;");
        btnEditar.setOnAction(event -> {
            CadastroUsuarioController.usuario = usuario;
            App.changeScreenRegion("CADASTRO_USUARIO", BorderPaneRegion.CENTER);
        });

        btnExcluir = new MFXButton("", imageViewDelete);
        btnExcluir.setPrefSize(25, 25);
        btnExcluir.setStyle("-fx-background-color: red;");
        btnExcluir.setOnAction(event -> {
            usuarioVM.deletarUsuario(usuario);
        });
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