create table cargo (
  co_cargo char (2),
  de_cargo varchar(20),
  constraint cargo_pk primary key (co_cargo)
);

create table trabajador (
  id_trabajador serial not null,
  co_cargo char(2),
  constraint trabajador_pk primary key (id_trabajador),
  constraint trabajador_cargo_fk foreign key (co_cargo) references cargo (co_cargo)
);

create table institucion_educativa (
  id_institucion_educativa serial not null,
  nu_institucion_educativa int,
  no_institucion_educativa varchar(100),
  constraint institucion_educativa_pk primary key (id_institucion_educativa)
);

create table periodo_academico (
  id_periodo_academico serial not null,
  id_institucion_educativa int,
  co_periodo_academico char(6),
  fe_inicio timestamp with time zone,
  fe_fin timestamp with time zone,
  constraint periodo_academico_pk primary key (id_periodo_academico),
  constraint periodo_academico_institucion_educativa_fk foreign key (id_institucion_educativa) references institucion_educativa (id_institucion_educativa)
);

create table planilla (
  id_periodo_academico int,
  id_trabajador int,
  constraint planilla_pk primary key (id_periodo_academico, id_trabajador),
  constraint planilla_trabajador_fk foreign key (id_trabajador) references trabajador (id_trabajador),
  constraint planilla_periodo_academico_fk foreign key (id_periodo_academico) references periodo_academico (id_periodo_academico)
);

create table usuario_institucion_educativa (
  id_usuario int,
  id_institucion_educativa int,
  constraint usuario_institucion_educativa_pk primary key (id_usuario, id_institucion_educativa),
  constraint usuario_institucion_educativa_usuario_fk foreign key (id_usuario) references usuario (id_usuario),
  constraint usuario_institucion_educativa_institucion_educativa_fk foreign key (id_institucion_educativa) references institucion_educativa (id_institucion_educativa)
);