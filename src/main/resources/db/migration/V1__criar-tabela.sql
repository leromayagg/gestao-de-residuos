
CREATE SEQUENCE SEQ_ENDERECO START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_AGENDAMENTO START WITH 1 INCREMENT BY 1;


CREATE SEQUENCE SEQ_USUARIOS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE tbl_usuario (
                             id INTEGER DEFAULT SEQ_USUARIOS.NEXTVAL NOT NULL,
                             nome VARCHAR2(100) NOT NULL,
                             email VARCHAR(100)  NOT NULL,
                             senha VARCHAR(60) NOT NULL,
                             role VARCHAR(15) DEFAULT 'USER'

);
CREATE TABLE tbl_endereco (
                              id INTEGER DEFAULT SEQ_ENDERECO.NEXTVAL PRIMARY KEY,
                              rua VARCHAR(255),
                              bairro VARCHAR(255),
                              cidade VARCHAR(255),
                              estado VARCHAR(255),
                              numero INTEGER,
                              cep INTEGER
);
CREATE TABLE tbl_agendamento (
                              id INTEGER DEFAULT SEQ_AGENDAMENTO.NEXTVAL PRIMARY KEY,
                              timestamp INTEGER,
                              status VARCHAR(255)
);

ALTER TABLE tbl_usuario
    MODIFY senha VARCHAR2(100);