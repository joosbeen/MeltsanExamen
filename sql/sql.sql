-- Database: clinica

-- DROP DATABASE clinica;

CREATE DATABASE clinica
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
-- Table: public.sustancias

-- DROP TABLE public.sustancias;

CREATE TABLE public.sustancias
(
    idsustancia integer NOT NULL,
    nombre character varying(30) COLLATE pg_catalog."default",
    clave character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT sustancias_pkey PRIMARY KEY (idsustancia)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.sustancias
    OWNER to postgres;


-- Table: public.direccion

-- DROP TABLE public.direccion;

CREATE TABLE public.direccion
(
    iddireccion integer NOT NULL,
    calle text COLLATE pg_catalog."default" NOT NULL,
    municipio text COLLATE pg_catalog."default" NOT NULL,
    colonia text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT direccion_pkey PRIMARY KEY (iddireccion)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.direccion
    OWNER to postgres;

    -- Table: public.doctor

-- DROP TABLE public.doctor;

CREATE TABLE public.doctor
(
    iddoctor integer NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cedula character varying(100) COLLATE pg_catalog."default" NOT NULL,
    telefono character varying(100) COLLATE pg_catalog."default" NOT NULL,
    codigo character varying(10) COLLATE pg_catalog."default" NOT NULL,
    idespecialidad integer,
    iddireccion integer,
    CONSTRAINT doctor_pkey PRIMARY KEY (iddoctor),
    CONSTRAINT direccion_fk FOREIGN KEY (iddireccion)
        REFERENCES public.direccion (iddireccion) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT especialidad_fk FOREIGN KEY (idespecialidad)
        REFERENCES public.especialidad (idespecialidad) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.doctor
    OWNER to postgres;

-- Table: public.enfermedad_medicamento

-- DROP TABLE public.enfermedad_medicamento;

CREATE TABLE public.enfermedad_medicamento
(
    idenfermedades integer,
    idmedicamentos integer,
    CONSTRAINT encomiendas_fk FOREIGN KEY (idenfermedades)
        REFERENCES public.enfermedades (idenfermedades) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT medicamentos_fk FOREIGN KEY (idmedicamentos)
        REFERENCES public.medicamentos (idmedicamentos) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.enfermedad_medicamento
    OWNER to postgres;
    -- Table: public.enfermedades

-- DROP TABLE public.enfermedades;

CREATE TABLE public.enfermedades
(
    idenfermedades integer NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    descripcion character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT enfermedades_pkey PRIMARY KEY (idenfermedades)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.enfermedades
    OWNER to postgres;
    -- Table: public.especialidad

-- DROP TABLE public.especialidad;

CREATE TABLE public.especialidad
(
    idespecialidad integer NOT NULL,
    especialidad character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT especialidad_pkey PRIMARY KEY (idespecialidad)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.especialidad
    OWNER to postgres;



    -- Table: public.pacientes

-- DROP TABLE public.pacientes;

CREATE TABLE public.pacientes
(
    idpacientes integer NOT NULL,
    nombre character varying(30) COLLATE pg_catalog."default",
    clave character varying(10) COLLATE pg_catalog."default",
    telefono character varying(10) COLLATE pg_catalog."default",
    iddireccion integer,
    CONSTRAINT pacientes_pkey PRIMARY KEY (idpacientes)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pacientes
    OWNER to postgres;
-- Table: public.medicamentos

-- DROP TABLE public.medicamentos;

CREATE TABLE public.medicamentos
(
    idmedicamentos integer NOT NULL,
    nombre "char"[] NOT NULL,
    codigo "char"[] NOT NULL,
    idcompuestos integer,
    CONSTRAINT medicamentos_pkey PRIMARY KEY (idmedicamentos),
    CONSTRAINT compuesto_fk FOREIGN KEY (idcompuestos)
        REFERENCES public.compuestos (idcompuestos) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.medicamentos
    OWNER to postgres;

-- Table: public.consultas

-- DROP TABLE public.consultas;

CREATE TABLE public.consultas
(
    idconnsultas integer NOT NULL,
    fecha date,
    costo double precision,
    horario time without time zone,
    idenfermedad integer,
    idmedicamentos integer,
    iddoctor integer,
    idpaciente integer,
    CONSTRAINT consultas_pkey PRIMARY KEY (idconnsultas),
    CONSTRAINT doctor_fk FOREIGN KEY (iddoctor)
        REFERENCES public.doctor (iddoctor) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT enfermedad_fk FOREIGN KEY (idenfermedad)
        REFERENCES public.enfermedades (idenfermedades) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT medicamentos_fk FOREIGN KEY (idmedicamentos)
        REFERENCES public.medicamentos (idmedicamentos) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT pacientes_fk FOREIGN KEY (idpaciente)
        REFERENCES public.pacientes (idpacientes) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.consultas
    OWNER to postgres;

    -- Table: public.compuestos

-- DROP TABLE public.compuestos;

CREATE TABLE public.compuestos
(
    idcompuestos integer NOT NULL,
    nombre character varying(30) COLLATE pg_catalog."default",
    idsustancia1 integer,
    cantidad1 double precision,
    idsustancia2 integer,
    cantidad2 double precision,
    CONSTRAINT compuestos_pkey PRIMARY KEY (idcompuestos),
    CONSTRAINT sustancias0_fk FOREIGN KEY (idsustancia1)
        REFERENCES public.sustancias (idsustancia) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT sustancias1_fk FOREIGN KEY (idsustancia2)
        REFERENCES public.sustancias (idsustancia) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.compuestos
    OWNER to postgres;

    -- Table: public.peligrosas

-- DROP TABLE public.peligrosas;

CREATE TABLE public.peligrosas
(
    idsustancia1 integer,
    idsustancia2 integer,
    CONSTRAINT sustancias2_fk FOREIGN KEY (idsustancia1)
        REFERENCES public.sustancias (idsustancia) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT sustancias_fk FOREIGN KEY (idsustancia2)
        REFERENCES public.sustancias (idsustancia) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.peligrosas
    OWNER to postgres;
    -- Table: public.sustancias

-- DROP TABLE public.sustancias;

CREATE TABLE public.sustancias
(
    idsustancia integer NOT NULL,
    nombre character varying(30) COLLATE pg_catalog."default",
    clave character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT sustancias_pkey PRIMARY KEY (idsustancia)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.sustancias
    OWNER to postgres;