package ifpr.pgua.eic.controllers.users.viewmodel;

import ifpr.pgua.eic.models.entity.Usuario;
import javafx.scene.control.Button;

public class UsuarioRow {

    String nome;
    String sobrenome;
    String email;
    Button btnEditar = new Button("Editar");

    public UsuarioRow(Usuario usuario, Button btnEditar) {
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
        this.btnEditar = btnEditar;
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

    public String getBtnEditar() {
        return btnEditar.getText();
    }

    public void setBtnEditar(Button btnEditar) {
        this.btnEditar = btnEditar;
    }
    
}
