create table dim_seccion (
  id_dim_seccion serial,
  co_seccion char(1) not null,
  constraint dim_seccion_pk primary key (id_dim_seccion)
);

create table dim_grado (
  id_dim_grado serial,
  id_grado integer not null,
  de_grado varchar(20) not null,
  id_ciclo integer not null,
  de_ciclo varchar(20) not null,
  constraint dim_grado_pk primary key (id_dim_grado)
);

create table dim_curso (
  id_dim_curso serial,
  id_curso integer not null,
  de_curso varchar(50) not null,
  constraint dim_curso_pk primary key (id_dim_curso)
);

create table dim_criterio_evaluacion (
  id_dim_criterio_evaluacion serial,
  id_criterio_evaluacion integer not null,
  de_criterio_evaluacion varchar (100) not null,
  constraint dim_criterio_evaluacion_pk primary key (id_dim_criterio_evaluacion)
);

create table dim_periodo_calificacion (
  id_dim_periodo_calificacion serial,
  id_periodo_calificacion integer not null,
  no_periodo_calificacion varchar(20) not null,
  id_periodo_academico integer not null,
  co_periodo_academico varchar(4) not null,
  constraint dim_periodo_calificacion_pk primary key (id_dim_periodo_calificacion)
);

create table hec_calificaciones (
  id_dim_seccion integer not null,
  id_dim_grado integer not null,
  id_dim_curso integer not null,
  id_dim_criterio_evaluacion integer not null,
  id_dim_periodo_calificacion integer not null,
  va_nota_promedio numeric not null,
  nu_alumnos_sobre_promedio numeric not null,
  nu_alumnos_bajo_promedio numeric not null,
  constraint hec_calificaciones_pk primary key (id_dim_criterio_evaluacion, id_dim_curso, id_dim_grado, id_dim_periodo_calificacion, id_dim_seccion),
  constraint hec_calificaciones_dim_seccion_fk foreign key (id_dim_seccion) references dim_seccion (id_dim_seccion),
  constraint hec_calificaciones_dim_grado_fk foreign key (id_dim_seccion) references dim_grado (id_dim_grado),
  constraint hec_calificaciones_dim_curso_fk foreign key (id_dim_curso) references dim_curso (id_dim_curso),
  constraint hec_calificaciones_dim_criterio_evaluacion_fk foreign key (id_dim_criterio_evaluacion) references dim_criterio_evaluacion (id_dim_criterio_evaluacion),
  constraint hec_calificaciones_dim_periodo_calificacion_fk foreign key (id_dim_periodo_calificacion) references dim_periodo_calificacion (id_dim_periodo_calificacion)
);