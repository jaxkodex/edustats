create table tipo_documento (
  id_tipo_documento char (2) not null,
  de_corta varchar (15) not null,
  de_larga varchar (50) not null,
  constraint tipo_documento_pk primary key (id_tipo_documento)
);

create table persona (
  id_persona serial not null,
  no_persona varchar(100),
  ap_persona varchar(100),
  am_persona varchar(100),
  fe_nacimiento date,
  nu_documento character varying(15),
  de_genero character varying(1),
  de_telefono character varying(15),
  de_correo character varying(100),
  de_direccion varchar (100),
  id_tipo_documento char(2) not null,
  constraint persona_pk primary key (id_persona),
  constraint persona_tipo_documento foreign key (id_tipo_documento) references tipo_documento (id_tipo_documento)
);

CREATE TABLE usuario (
  id_usuario serial NOT NULL,
  id_persona int,
  no_cuenta varchar(30),
  co_contrasenia varchar(32),
  constraint usuario_pk PRIMARY KEY (id_usuario),
  constraint persona_fk foreign key (id_persona) references persona(id_persona),
  constraint no_cuenta_unique unique (no_cuenta)
);

CREATE TABLE rol (
  id_rol integer NOT NULL,
  no_rol varchar(50),
  CONSTRAINT ROL_pk PRIMARY KEY (ID_ROL)
);

CREATE TABLE usuario_rol (
  id_usuario integer NOT NULL,
  id_rol integer NOT NULL,
  CONSTRAINT usuario_rol_id_rol_fk FOREIGN KEY (id_rol)
      REFERENCES rol (id_rol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_rol_id_usuario_fk FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_rol_pk PRIMARY KEY (id_usuario, id_rol)
);
