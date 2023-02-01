package ifpr.pgua.eic.models.daos;

import java.util.List;

import ifpr.pgua.eic.models.entity.Emprestimo;

public interface EmprestimoDao {
    
    boolean cadastrar(Emprestimo emprestimo);

    boolean atualizar(Emprestimo emprestimo);

    boolean finalizarEmprestimo(int id);

    List<Emprestimo> buscarTodos();
}
