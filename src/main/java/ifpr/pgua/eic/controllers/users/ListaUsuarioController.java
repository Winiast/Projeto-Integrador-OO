package ifpr.pgua.eic.controllers.users;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import ifpr.pgua.eic.App;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioRow;
import ifpr.pgua.eic.controllers.users.viewmodel.UsuarioVM;
import ifpr.pgua.eic.models.entity.Usuario;
import io.github.palexdev.materialfx.controls.MFXPaginatedTableView;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableRow;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ListaUsuarioController implements Initializable{

    @FXML
    private MFXTableView<UsuarioRow> tbUsuarios;

    private UsuarioVM usuarioVM;

    public ListaUsuarioController(UsuarioVM usuarioVM) {
        this.usuarioVM = usuarioVM;
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
    public void cadastrar() {
        App.pushScreen("CADASTRO_USUARIO");
    }

    @FXML
    public void buscarUsuario() {
        System.out.println("Buscar");
    }

    @FXML
    public void sair() {
        App.pushScreen("LOGIN");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        MFXTableColumn<UsuarioRow> tbcNome = new MFXTableColumn<>("Nome", false, Comparator.comparing(UsuarioRow::getNome));
        MFXTableColumn<UsuarioRow> tbcSobrenome = new MFXTableColumn<>("Sobrenome", false, Comparator.comparing(UsuarioRow::getSobrenome));
        MFXTableColumn<UsuarioRow> tbcEmail = new MFXTableColumn<>("Email", false, Comparator.comparing(UsuarioRow::getEmail));
        MFXTableColumn<UsuarioRow> tbcEditar = new MFXTableColumn<>("Editar", false, Comparator.comparing(UsuarioRow::getBtnEditar));

        tbcNome.setRowCellFactory(usuario -> new MFXTableRowCell<>(UsuarioRow::getNome));
        tbcSobrenome.setRowCellFactory(usuario -> new MFXTableRowCell<>(UsuarioRow::getSobrenome));
        tbcEmail.setRowCellFactory(usuario -> new MFXTableRowCell<>(UsuarioRow::getEmail));
        tbcEditar.setRowCellFactory(usuario -> new MFXTableRowCell<>(UsuarioRow::getBtnEditar));
        
        tbcNome.setMinWidth(200);
        tbcSobrenome.setMinWidth(200);
        tbcEmail.setMinWidth(200);
        tbcEditar.setMinWidth(200);

        tbUsuarios.getTableColumns().add(tbcNome);
        tbUsuarios.getTableColumns().add(tbcSobrenome);
        tbUsuarios.getTableColumns().add(tbcEmail);
        tbUsuarios.getTableColumns().add(tbcEditar);
        
        usuarioVM.getUsuarios().forEach(usuario -> {
            UsuarioRow usuarioRow = new UsuarioRow(usuario, new Button("Editar"));
            tbUsuarios.getItems().add(usuarioRow);
        });

        tbUsuarios.getChildrenUnmodifiable().add(new Button("teste"));

        System.out.println(tbUsuarios.getChildrenUnmodifiable());

        
    }
}
