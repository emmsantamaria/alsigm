--  Crear tablas para el conector de organizaci�n
spool 08_create_tables_organizacion.log
CREATE TABLE AOESTRORG(
	ID               VARCHAR2(32) NOT NULL,
	CODIGO           VARCHAR2(64) NOT NULL,
	NOMBRE           VARCHAR2(254) NOT NULL,
	TIPO             NUMBER(38) NOT NULL,
	NIVEL            NUMBER(38) NOT NULL,
	IDORGPADRE       VARCHAR2(32),
	ESTADO           NUMBER(38) NOT NULL,
	FINICIOVIGENCIA  DATE,
	FFINVIGENCIA     DATE,
	DESCRIPCION      VARCHAR2(254)
);

CREATE TABLE AOUSR(
	ID             VARCHAR2(64) NOT NULL,
	DIRECCION      VARCHAR2(254),
	EMAIL          VARCHAR2(254),
	NOMBRE         VARCHAR2(64),
	APELLIDOS      VARCHAR2(128),
	NOMBREUSUARIO  VARCHAR2(64) NOT NULL,
	PASSWORD       VARCHAR2(64) NOT NULL
);

CREATE TABLE AOUSRORGV(
	IDUSUARIO      VARCHAR2(64) NOT NULL,
	NOMBREUSUARIO  VARCHAR2(254) NOT NULL,
	IDORGANO       VARCHAR2(32) NOT NULL
);

CREATE UNIQUE INDEX ORGANIZACION1 ON AOESTRORG (ID) TABLESPACE &1;
CREATE UNIQUE INDEX ORGANIZACION2 ON AOESTRORG (CODIGO) TABLESPACE &1;

CREATE INDEX USUARIO1 ON AOUSR (NOMBRE) TABLESPACE &1;
CREATE UNIQUE INDEX USUARIO2 ON AOUSR (NOMBREUSUARIO) TABLESPACE &1;

CREATE UNIQUE INDEX USRORGANO1 ON AOUSRORGV (IDUSUARIO) TABLESPACE &1;

-- Si las tablas se meten en un schema distinto del de archivo habr�a que ejecutar las siguientes sentencias:

-- CREATE TABLE ITDGUIDGEN(
-- 	cnode  VARCHAR2(12),
--	clpid  NUMBER(38)
-- );

-- INSERT INTO ITDGUIDGEN (CNODE, CLPID) VALUES ('000000000000', 1);

--INSTITUCIONES
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('IARCHIDOC','IARCHIDOC','ARCHIDOC',1,0,NULL,2,SYSDATE,NULL,NULL);
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('INST1','INST1','Instituci�n 1',1,0,NULL,2,SYSDATE,NULL,'Instituci�n 1');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('INST2','INST2','Instituci�n 2',1,0,NULL,2,SYSDATE,NULL,'Instituci�n 2');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('INST3','INST3','Instituci�n 3',1,0,NULL,2,SYSDATE,NULL,'Instituci�n 3');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('INST4','INST4','Instituci�n 4',1,0,NULL,2,SYSDATE,NULL,'Instituci�n 4');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('INST5','INST5','Instituci�n 5',1,0,NULL,2,SYSDATE,NULL,'Instituci�n 5');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('INST6','INST6','Instituci�n 6',1,0,NULL,2,SYSDATE,NULL,'Instituci�n 6');
-- 6 INSTITUCIONES

--ORGANOS
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('ORG1','ORG1','�rgano 1',2,1,'INST1',2,SYSDATE,NULL,'�rgano 1');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('ORG2','ORG2','�rgano 2',2,1,'INST2',2,SYSDATE,NULL,'�rgano 2');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('ORG3','ORG3','�rgano 3',2,1,'INST3',2,SYSDATE,NULL,'�rgano 3');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('ORG4','ORG4','�rgano 4',2,1,'INST4',2,SYSDATE,NULL,'�rgano 4');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('ORG5','ORG5','�rgano 5',2,1,'INST5',2,SYSDATE,NULL,'�rgano 5');
INSERT INTO AOESTRORG (ID,CODIGO,NOMBRE,TIPO,NIVEL,IDORGPADRE,ESTADO,FINICIOVIGENCIA,FFINVIGENCIA,DESCRIPCION) VALUES ('ORG6','ORG6','�rgano 6',2,1,'INST6',2,SYSDATE,NULL,'�rgano 6');
-- 6 �RGANOS

--USUARIOS
INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR1','Administrador de Series','ORG1');
INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR2','Administrador de Fondos','ORG2');
INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR3','Administrador de Pr�stamos','ORG3');
INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR4','Administrador de Dep�sito','ORG4');
INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR5','Administrador de Archivo','ORG5');
INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR6','Administrador de Oficina','ORG6');
--INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR7','nacho','ORG1');
--INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR8','lucas','ORG2');
--INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR9','david','ORG3');
--INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR10','laura','ORG4');
--INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR11','omar','ORG5');
--INSERT INTO AOUSRORGV (IDUSUARIO,NOMBREUSUARIO,IDORGANO) VALUES ('USR12','alicia','ORG6');

COMMIT;
spool off