create table estudiante (
  id_estudiante serial,
  id_persona integer not null,
  constraint estudiante_pk primary key (id_estudiante)
);

create table matricula (
  id_matricula serial,
  id_estudiante integer not null,
  id_aula integer not null,
  constraint matricula_pk primary key (id_matricula),
  constraint matricula_estudiante_fk foreign key (id_estudiante) references estudiante (id_estudiante),
  constraint matricula_aula_fk foreign key (id_aula) references aula (id_aula)
);

create table periodo_calificacion (
  id_periodo_calificacion serial,
  id_periodo_academico integer not null,
  no_periodo_calificacion varchar(20) not null,
  constraint periodo_calificacion_pk primary key (id_periodo_calificacion),
  constraint periodo_calificacion_periodo_academico_fk foreign key (id_periodo_academico) references periodo_academico(id_periodo_academico)
);

create table calificacion (
  id_calificacion serial,
  va_nota numeric not null,
  id_periodo_calificacion integer not null,
  id_criterio_evaluacion integer not null,
  id_matricula integer not null,
  constraint calificacion_pk primary key (id_calificacion),
  constraint calificacion_criterio_evaluacion_fk foreign key (id_criterio_evaluacion) references criterio_evaluacion (id_criterio_evaluacion),
  constraint calificacion_periodo_calificacion_fk  foreign key (id_periodo_calificacion) references periodo_calificacion (id_periodo_calificacion),
  constraint calificacion_matricula_fk foreign key (id_matricula) references matricula (id_matricula)
);