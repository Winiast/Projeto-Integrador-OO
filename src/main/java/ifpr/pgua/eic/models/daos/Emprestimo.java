package ifpr.pgua.eic.models.daos;

import java.util.List;

public interface Emprestimo {
    
    boolean cadastrar(Emprestimo emprestimo);

    boolean atualizar(Emprestimo emprestimo);

    boolean excluir(int id);

    List<Emprestimo> buscarTodos();
}
