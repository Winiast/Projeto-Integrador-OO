-- pi_user
create trigger tg_insert_users after insert on pi_user for each row
    insert into pi_logs (operacao, datHora, tabela) values('INSERT', CURRENT_TIMESTAMP(), 'pi_user');

create trigger tg_update_users after update on pi_user for each row
    insert into pi_logs (operacao, datHora, tabela) values('UPDATE', CURRENT_TIMESTAMP(), 'pi_user');

-- pi_esporte
create trigger tg_insert_esportes after insert on pi_esporte for each row
	insert into pi_logs (operacao, datHora, tabela) values('INSERT', CURRENT_TIMESTAMP(), 'pi_esporte');

create trigger tg_update_esportes after update on pi_esporte for each row
	insert into pi_logs (operacao, datHora, tabela) values('UPDATE', CURRENT_TIMESTAMP(), 'pi_esporte');

-- pi_equipamento
create trigger tg_insert_equipamentos after insert on pi_equipamento for each row
    insert into pi_logs (operacao, datHora, tabela) values('INSERT', CURRENT_TIMESTAMP(), 'pi_equipamento');

create trigger tg_update_equipamentos after update on pi_equipamento for each row
    insert into pi_logs (operacao, datHora, tabela) values('UPDATE', CURRENT_TIMESTAMP(), 'pi_equipamento');

-- pi_emprestimo
create trigger tg_insert_emprestimos after insert on pi_emprestimo for each row
    insert into pi_logs (operacao, datHora, tabela) values('INSERT', CURRENT_TIMESTAMP(), 'pi_emprestimo');

create trigger tg_update_emprestimos after update on pi_emprestimo for each row
    insert into pi_logs (operacao, datHora, tabela) values('UPDATE', CURRENT_TIMESTAMP(), 'pi_emprestimo');


