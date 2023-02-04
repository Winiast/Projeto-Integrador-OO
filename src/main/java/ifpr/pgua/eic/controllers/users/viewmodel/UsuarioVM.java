package ifpr.pgua.eic.controllers.users.viewmodel;

import ifpr.pgua.eic.models.entity.Usuario;
import ifpr.pgua.eic.models.repositories.UsuarioRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuarioVM {

    private StringProperty nome = new SimpleStringProperty();
    private StringProperty sobrenome = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();

    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

    private UsuarioRepository usuarioRepository;

    public UsuarioVM(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

        carregarLista();
    }

    private void carregarLista() {
        usuarios.clear();
        usuarios.addAll(usuarioRepository.buscarTodos());
    }

    public boolean deletarUsuario(Usuario usuario) {
        return usuarioRepository.excluir(usuario);
    }

    public StringProperty getNome() {
        return nome;
    }

    public StringProperty getSobrenome() {
        return sobrenome;
    }

    public StringProperty getEmail() {
        return email;
    }

    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }
}