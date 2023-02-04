package ifpr.pgua.eic.models.repositories;

import java.util.List;

import ifpr.pgua.eic.models.daos.EmprestimoDao;
import ifpr.pgua.eic.models.entity.Emprestimo;

public class EmprestimoRepository {

    private EmprestimoDao emprestimoDao;

    public EmprestimoRepository(EmprestimoDao emprestimoDao) {
        this.emprestimoDao = emprestimoDao;
    }

    public boolean cadastrar(Emprestimo emprestimo) {
        return emprestimoDao.cadastrar(emprestimo);
    }

    public boolean atualizar(Emprestimo emprestimo) {
        return emprestimoDao.atualizar(emprestimo);
    }

    public boolean finalizarEmprestimo(int id) {
        return emprestimoDao.finalizarEmprestimo(id);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoDao.buscarTodos();
    }

}
