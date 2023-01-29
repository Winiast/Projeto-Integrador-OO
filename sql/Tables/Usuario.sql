--Comando para criar a tabela de usuários

CREATE TABLE pi_user (
    idUser int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    sobrenome varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    senha varchar(255) NOT NULL,
    criadoEm datetime NOT NULL,
    atualizadoEm datetime,
    status bit NOT NULL,
    PRIMARY KEY (idUser)
);

-- Comando para inserir usuario ficticio

INSERT INTO pi_user (nome, sobrenome, email, senha, criadoEm, status) VALUES ('Julio', 'Cesar', 'juliocesar@gmail.com', 'juliocesar', '2019-01-01 00:00:00', 1); 

