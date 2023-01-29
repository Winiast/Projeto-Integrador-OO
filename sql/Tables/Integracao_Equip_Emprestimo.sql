CREATE TABLE pi_equip_emprestimo (
    id int NOT NULL AUTO_INCREMENT,
    idEquipamento int NOT NULL,
    idEmprestimo int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idEquipamento) REFERENCES pi_equipamento(idEquipamento),
    FOREIGN KEY (idEmprestimo) REFERENCES pi_emprestimo(idEmprestimo)
);