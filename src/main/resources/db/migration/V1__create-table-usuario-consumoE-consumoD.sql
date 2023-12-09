CREATE TABLE usuario (
    id_usuario BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id_usuario)
);

CREATE TABLE consumoEnergetico (
    id_consumoe BIGINT NOT NULL AUTO_INCREMENT,
    watts DECIMAL(4, 4) NOT NULL,
    billValue DECIMAL(10, 2) NOT NULL,
    billMonth VARCHAR(50) NOT NULL UNIQUE,
    usuario_id BIGINT,
    PRIMARY KEY (id_consumoe),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id_usuario)
);

CREATE TABLE consumoAparelho (
    id_consumoa BIGINT NOT NULL AUTO_INCREMENT,
    deviceConsume TIME NOT NULL,
    usuario_id BIGINT,
    PRIMARY KEY (id_consumoa),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id_usuario)
);