CREATE TABLE pi_emprestimo (
    idEmprestimo int NOT NULL AUTO_INCREMENT,
    idUsuario int NOT NULL,
    nomeAluno varchar(50) NOT NULL,
    turmaAluno varchar(50) NOT NULL,
    observacao varchar(100) NOT NULL,
    dataDevolucaoEmprestimo datetime,
    criadoEm datetime NOT NULL,
    atualizadoEm datetime,
    PRIMARY KEY (idEmprestimo),
    FOREIGN KEY (idUsuario) REFERENCES pi_user(idUser)
) 