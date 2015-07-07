
CREATE SEQUENCE estados_idestado_seq_1;

CREATE TABLE estados (
                idEstado NUMERIC(3) NOT NULL DEFAULT nextval('estados_idestado_seq_1'),
                nombre VARCHAR(15) NOT NULL,
                desc_1 VARCHAR NOT NULL,
                CONSTRAINT estados_pk PRIMARY KEY (idEstado)
);


ALTER SEQUENCE estados_idestado_seq_1 OWNED BY estados.idEstado;

CREATE TABLE persona (
                idPersona NUMERIC NOT NULL,
                pNmbre VARCHAR NOT NULL,
                sNombre VARCHAR,
                pApellido VARCHAR NOT NULL,
                sApellido VARCHAR,
                CONSTRAINT persona_pk PRIMARY KEY (idPersona)
);


CREATE SEQUENCE correos_idcorreo_seq;

CREATE TABLE correos (
                idCorreo NUMERIC NOT NULL DEFAULT nextval('correos_idcorreo_seq'),
                correo VARCHAR NOT NULL,
                idPersona NUMERIC NOT NULL,
                CONSTRAINT correos_pk PRIMARY KEY (idCorreo)
);


ALTER SEQUENCE correos_idcorreo_seq OWNED BY correos.idCorreo;

CREATE SEQUENCE telefonos_idphone_seq;

CREATE TABLE telefonos (
                idPhone NUMERIC NOT NULL DEFAULT nextval('telefonos_idphone_seq'),
                numero VARCHAR(15) NOT NULL,
                idPersona NUMERIC NOT NULL,
                CONSTRAINT telefonos_pk PRIMARY KEY (idPhone)
);


ALTER SEQUENCE telefonos_idphone_seq OWNED BY telefonos.idPhone;

CREATE SEQUENCE grupo_idgrupo_seq;

CREATE TABLE grupo (
                idGrupo NUMERIC NOT NULL DEFAULT nextval('grupo_idgrupo_seq'),
                area VARCHAR(20) NOT NULL,
                fechaCreacion DATE NOT NULL,
                fechaCierre DATE NOT NULL,
                CONSTRAINT grupo_pk PRIMARY KEY (idGrupo)
);


ALTER SEQUENCE grupo_idgrupo_seq OWNED BY grupo.idGrupo;

CREATE SEQUENCE actividad_codactividad_seq;

CREATE TABLE actividad (
                codActividad NUMERIC(4) NOT NULL DEFAULT nextval('actividad_codactividad_seq'),
                desc_1 VARCHAR NOT NULL,
                CONSTRAINT actividad_pk PRIMARY KEY (codActividad)
);


ALTER SEQUENCE actividad_codactividad_seq OWNED BY actividad.codActividad;

CREATE SEQUENCE rol_codrol_seq;

CREATE TABLE rol (
                codRol NUMERIC NOT NULL DEFAULT nextval('rol_codrol_seq'),
                desc_1 VARCHAR NOT NULL,
                CONSTRAINT rol_pk PRIMARY KEY (codRol)
);


ALTER SEQUENCE rol_codrol_seq OWNED BY rol.codRol;

CREATE TABLE rolAtividad (
                codRol NUMERIC NOT NULL,
                codActividad NUMERIC(4) NOT NULL
);


CREATE SEQUENCE usuarios_idusu_seq;

CREATE TABLE usuarios (
                idUsu NUMERIC NOT NULL DEFAULT nextval('usuarios_idusu_seq'),
                nUsuario VARCHAR(10) NOT NULL,
                pass VARCHAR(16) DEFAULT UnlimitedDreams NOT NULL,
                lTA DATE NOT NULL,
                idPersona NUMERIC NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (idUsu)
);


ALTER SEQUENCE usuarios_idusu_seq OWNED BY usuarios.idUsu;

CREATE SEQUENCE scambio_idsolicitud_seq;

CREATE TABLE sCambio (
                idSolicitud NUMERIC NOT NULL DEFAULT nextval('scambio_idsolicitud_seq'),
                titulo VARCHAR(135) NOT NULL,
                shortDesc VARCHAR(300) NOT NULL,
                fechaApertura DATE NOT NULL,
                fechaCierre DATE NOT NULL,
                longDesc VARCHAR NOT NULL,
                idEstado NUMERIC(3) NOT NULL,
                idUsu NUMERIC NOT NULL,
                CONSTRAINT scambio_pk PRIMARY KEY (idSolicitud)
);


ALTER SEQUENCE scambio_idsolicitud_seq OWNED BY sCambio.idSolicitud;

CREATE SEQUENCE files_idfile_seq;

CREATE TABLE files (
                idFile NUMERIC NOT NULL DEFAULT nextval('files_idfile_seq'),
                fileName VARCHAR NOT NULL,
                filePath VARCHAR NOT NULL,
                fechaCreacion DATE NOT NULL,
                idSolicitud NUMERIC NOT NULL,
                CONSTRAINT files_pk PRIMARY KEY (idFile)
);


ALTER SEQUENCE files_idfile_seq OWNED BY files.idFile;

CREATE SEQUENCE revisiones_idrevision_seq;

CREATE TABLE revisiones (
                idRevision NUMERIC NOT NULL DEFAULT nextval('revisiones_idrevision_seq'),
                idSolicitud NUMERIC NOT NULL,
                observaciones VARCHAR NOT NULL,
                CONSTRAINT revisiones_pk PRIMARY KEY (idRevision)
);


ALTER SEQUENCE revisiones_idrevision_seq OWNED BY revisiones.idRevision;

CREATE TABLE grupoUsuario (
                idUsu NUMERIC NOT NULL,
                idGrupo NUMERIC NOT NULL
);


CREATE TABLE usuarioRol (
                codRol NUMERIC NOT NULL,
                idUsu NUMERIC NOT NULL
);


ALTER TABLE sCambio ADD CONSTRAINT estados_scambio_fk
FOREIGN KEY (idEstado)
REFERENCES estados (idEstado)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE telefonos ADD CONSTRAINT persona_telefonos_fk
FOREIGN KEY (idPersona)
REFERENCES persona (idPersona)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE correos ADD CONSTRAINT persona_correos_fk
FOREIGN KEY (idPersona)
REFERENCES persona (idPersona)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE usuarios ADD CONSTRAINT persona_usuarios_fk
FOREIGN KEY (idPersona)
REFERENCES persona (idPersona)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE grupoUsuario ADD CONSTRAINT grupo_grupousuario_fk
FOREIGN KEY (idGrupo)
REFERENCES grupo (idGrupo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE rolAtividad ADD CONSTRAINT actividad_rolatividad_fk
FOREIGN KEY (codActividad)
REFERENCES actividad (codActividad)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE usuarioRol ADD CONSTRAINT rol_usuariorol_fk
FOREIGN KEY (codRol)
REFERENCES rol (codRol)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE rolAtividad ADD CONSTRAINT rol_rolatividad_fk
FOREIGN KEY (codRol)
REFERENCES rol (codRol)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE usuarioRol ADD CONSTRAINT usuarios_usuariorol_fk
FOREIGN KEY (idUsu)
REFERENCES usuarios (idUsu)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE grupoUsuario ADD CONSTRAINT usuarios_grupousuario_fk
FOREIGN KEY (idUsu)
REFERENCES usuarios (idUsu)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE sCambio ADD CONSTRAINT usuarios_scambio_fk
FOREIGN KEY (idUsu)
REFERENCES usuarios (idUsu)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE revisiones ADD CONSTRAINT scambio_revisiones_fk
FOREIGN KEY (idSolicitud)
REFERENCES sCambio (idSolicitud)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE files ADD CONSTRAINT scambio_files_fk
FOREIGN KEY (idSolicitud)
REFERENCES sCambio (idSolicitud)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
