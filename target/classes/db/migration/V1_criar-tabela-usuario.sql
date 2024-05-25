CREATE SEQUENCE TBL_USER_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE TBL_USUARIO (
                         USUARIO_ID INTEGER DEFAULT SEQ_USUARIOS.NEXTVAL PRIMARY KEY,
                         NOME VARCHAR2(100) NOT NULL,
                         EMAIL VARCHAR2(100) UNIQUE NOT NULL,
                         SENHA VARCHAR2(20) NOT NULL,
                         ROLE VARCHAR(15) DEFAULT 'USER',
--                           address_id INTEGER,
--                           FOREIGN KEY (address_id) REFERENCES tbl_address(id)
);