create table persona (
  id_persona serial not null,
  no_persona varchar(100),
  ap_persona varchar(100),
  am_persona varchar(100),
  fe_nacimiento date,
  constraint persona_pk primary key (id_persona)
);

CREATE TABLE usuario (
  id_usuario serial NOT NULL,
  id_persona int,
  no_cuenta varchar(30),
  co_contrasenia varchar(32),
  CONSTRAINT usuario_pk PRIMARY KEY (id_usuario),
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

INSERT INTO usuario (id_usuario, no_cuenta, co_contrasenia) VALUES (1, 'demo', md5('demo'));
