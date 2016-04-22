create table ciclo (
  id_ciclo serial not null,
  de_ciclo varchar(25) not null,
  constraint ciclo_pk primary key (id_ciclo)
);

create table grado (
  id_grado serial not null,
  nu_grado int not null,
  de_grado varchar(25) not null,
  id_ciclo int not null,
  constraint grado_pk primary key (id_grado),
  constraint grado_ciclo_fk foreign key (id_ciclo) references ciclo (id_ciclo)
);

create table seccion (
  co_seccion varchar(2) not null,
  de_seccion varchar(25) not null,
  constraint seccion_pk primary key (co_seccion)
);

create table aula (
  id_aula serial not null,
  id_grado int not null,
  co_seccion varchar(2) not null,
  id_periodo_academico int not null,
  co_turno char(1) not null,
  constraint aula_pk primary key(id_aula),
  constraint aula_grado_fk foreign key (id_grado) references grado (id_grado),
  constraint aula_seccion_fk foreign key (co_seccion) references seccion (co_seccion),
  constraint aula_periodo_academico_fk foreign key (id_periodo_academico) references periodo_academico (id_periodo_academico)
);

create table curso (
  id_curso serial not null,
  de_curso varchar (50) not null,
  constraint curso_pk primary key (id_curso)
);

create table curso_grado (
  id_curso int not null,
  id_grado int not null,
  constraint curso_grado_pk primary key (id_curso, id_grado),
  constraint curso_grado_grado_id_grado_fk foreign key (id_grado) references grado (id_grado),
  constraint curso_grado_curso_id_curso_fk foreign key (id_curso) references curso (id_curso)
);

create table asignacion_docente (
  id_asignacion_docente serial not null,
  fe_asignacion timestamp not null,
  id_planilla int not null,
  id_aula int not null,
  id_curso int not null,
  constraint asignacion_docente_pk primary key (id_asignacion_docente),
  constraint asignacion_docente_planilla_fk foreign key (id_planilla) references planilla (id_planilla),
  constraint asignacion_docente_aula_fk foreign key (id_aula) references aula (id_aula),
  constraint asignacion_docente_curso_fk foreign key (id_curso) references curso(id_curso)
);

create table criterio_evaluacion (
  id_criterio_evaluacion serial,
  de_criterio_evaluacion varchar(100),
  id_curso integer not null,
  id_periodo_academico integer not null,
  constraint criterio_evaluacion_pk primary key (id_criterio_evaluacion),
  constraint criterio_evaluacion_curso_fk foreign key (id_curso) references curso (id_curso)
);