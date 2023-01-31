package ifpr.pgua.eic.models.daos;

import java.util.List;

public interface EmprestimoDao {
    
    boolean cadastrar(EmprestimoDao emprestimo);

    boolean atualizar(EmprestimoDao emprestimo);

    boolean excluir(int id);

    List<EmprestimoDao> buscarTodos();
}
