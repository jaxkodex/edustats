create table dim_aspecto_observado (
  id_dim_aspecto_observado serial,
  id_seccion integer not null,
  de_seccion varchar (200) not null,
  constraint dim_aspecto_observado_pk primary key (id_dim_aspecto_observado)
);

create table hec_monitoreo (
  id_dim_seccion integer not null,
  id_dim_grado integer not null,
  id_dim_aspecto_observado integer not null,
  id_dim_periodo_calificacion integer not null,
  nu_docente_cumple_aspecto numeric not null,
  nu_docente_no_cumple_aspecto numeric not null,
  va_puntaje_promedio numeric not null,
  nu_docente_cumple_indicador numeric not null,
  constraint hec_monitoreo_pk primary key (id_dim_aspecto_observado, id_dim_grado, id_dim_periodo_calificacion, id_dim_seccion),
  constraint hec_monitoreo_dim_seccion_fk foreign key (id_dim_seccion) references dim_seccion (id_dim_seccion),
  constraint hec_monitoreo_dim_grado_fk foreign key (id_dim_seccion) references dim_grado (id_dim_grado),
  constraint hec_monitoreo_dim_periodo_calificacion_fk foreign key (id_dim_periodo_calificacion) references dim_periodo_calificacion (id_dim_periodo_calificacion),
  constraint hec_monitoreo_dim_aspecto_observado_fk foreign key (id_dim_aspecto_observado) references dim_aspecto_observado (id_dim_aspecto_observado)
);