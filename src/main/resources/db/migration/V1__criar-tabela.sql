CREATE SEQUENCE SEQ_ENDERECO START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tbl_endereco START WITH 1 INCREMENT BY 1;

CREATE TABLE tbl_usuario (
                             id INTEGER DEFAULT SEQ_USUARIOS.NEXTVAL PRIMARY KEY,
                             nome VARCHAR2(100) NOT NULL,
                             email VARCHAR2(100) UNIQUE NOT NULL,
                             senha VARCHAR2(60) NOT NULL,
                             role VARCHAR(15) DEFAULT 'USER',
                             endereco_id INTEGER,
                             FOREIGN KEY (endereco_id) REFERENCES tbl_address(id)
);

CREATE TABLE tbl_endereco (
                              id INTEGER DEFAULT TBL_ADDRESS_SEQ.NEXTVAL PRIMARY KEY,
                              rua VARCHAR(255),
                              bairro VARCHAR(255),
                              cidade VARCHAR(255),
                              estado VARCHAR(255),
                              numero INTEGER,
                              cep INTEGER
);
