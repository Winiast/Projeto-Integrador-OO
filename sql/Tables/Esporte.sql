-- Comando para criar a tabela Esporte

CREATE TABLE pi_esporte (
    idEsporte int NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    descricao varchar(150) NOT NULL,
    criadoEm datetime NOT NULL,
    atualizadoEm datetime,
    status bit NOT NULL,
    PRIMARY KEY (idEsporte)
);

