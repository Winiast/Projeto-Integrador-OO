-- Relatório de quipamentos mais emprestados no mês
create procedure relatorio(in mes int, in ano int)
	select
	    pe2.nomeEquipamento as Equipamento,
	    COUNT(pee.idEquipamento) as Quantidade
	from
	    tads21_pedro.pi_equip_emprestimo pee
	inner join tads21_pedro.pi_emprestimo pe on
	    pee.idEmprestimo = pe.idEmprestimo
	inner join tads21_pedro.pi_equipamento pe2 on
	    pee.idEquipamento = pe2.idEquipamento
	where
	    month(pe.criadoEm) = mes and 
	    year(pe.criadoEm) = ano
	group by
	    (pe2.nomeEquipamento)
	order by
    Quantidade desc


-- Relatório de quantos empréstimos foram feitos por mês
create procedure relatorio2(in mes int, in ano int)
    select
        month(pe.criadoEm) as Mes,
        count(pe.idEmprestimo) as Quantidade
    from
        tads21_pedro.pi_emprestimo pe
    where
        month(pe.criadoEm) = mes and 
        year(pe.criadoEm) = ano
    group by
        (month(pe.criadoEm))
    order by
    Quantidade desc