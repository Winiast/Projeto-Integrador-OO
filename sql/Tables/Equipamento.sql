CREATE TABLE pi_equipamento (
    idEquipamento int NOT NULL,
    nomeEquipamento varchar(50) NOT NULL,
    idEsporte int NOT NULL,
    quantidade int NOT NULL,
    estado varchar(50) NOT NULL,
    criadoEm datetime NOT NULL,
    atualizadoEm datetime,
    status boolean NOT NULL,
    FOREIGN KEY (idEsporte) REFERENCES pi_esporte(idEsporte),
    PRIMARY KEY (idEquipamento)
);