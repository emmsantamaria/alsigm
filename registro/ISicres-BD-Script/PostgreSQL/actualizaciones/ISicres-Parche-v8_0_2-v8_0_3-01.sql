--Actualizacion de la version 8.0.2 a la version 8.0.3

-- Tablas

-- Tabla para mapeo de los c�digos de tipo de transporte de la normativa de intercambio
-- registal de la normativa sicres 3 con la tabla SCR_TT.
CREATE TABLE scr_ttexreg (
    id integer NOT NULL,
    code character varying(10) NOT NULL,
    name character varying(31) NOT NULL,
    id_scr_tt integer not null
);

-- Secuencias

-- Secuencia para el identificador de la tabla scr_ttexreg
CREATE SEQUENCE scr_ttexreg_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


-- Constraints

-- TABLA scr_tt
ALTER TABLE scr_tt ADD CONSTRAINT pk_scr_tt0 PRIMARY KEY (id);
CREATE UNIQUE INDEX scr_tt0 ON scr_tt USING btree (transport);

-- TABLA scr_ttexreg
CREATE UNIQUE INDEX scr_ttexreg0 ON scr_ttexreg USING btree (name);
ALTER TABLE scr_ttexreg ADD CONSTRAINT pk_scr_ttexreg0 PRIMARY KEY (id);
ALTER TABLE scr_ttexreg ADD CONSTRAINT fk_scr_ttexreg0 FOREIGN KEY (id_scr_tt) REFERENCES scr_tt(id) ON DELETE CASCADE;