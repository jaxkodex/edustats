create table plantilla_monitoreo (
  id_plantilla_monitoreo serial,
  constraint plantilla_monitoreo_pk primary key (id_plantilla_monitoreo)
);

create table seccion_plantilla_monitoreo (
  id_seccion_plantilla_monitoreo serial,
  id_plantilla_monitoreo integer not null,
  de_seccion varchar (200) not null,
  va_puntaje_minimo numeric not null,
  constraint seccion_plantilla_monitoreo_pk primary key (id_seccion_plantilla_monitoreo),
  constraint seccion_plantilla_monitoreo_plantilla_monitoreo_fk foreign key (id_plantilla_monitoreo) references plantilla_monitoreo (id_plantilla_monitoreo)
);

create table detalle_plantilla_monitoreo (
  id_detalle_plantilla_monitoreo serial,
  id_seccion_plantilla_monitoreo integer not null,
  de_pregunta varchar(300) not null,
  va_puntaje numeric not null,
  in_respuesta_corta boolean,
  in_opciones boolean,
  constraint detalle_plantilla_monitoreo_pk primary key (id_detalle_plantilla_monitoreo),
  constraint detalle_plantilla_monitoreo_seccion_pk foreign key (id_seccion_plantilla_monitoreo) references seccion_plantilla_monitoreo (id_seccion_plantilla_monitoreo)
);

create table monitoreo (
  id_monitoreo serial,
  id_plantilla_monitoreo integer not null,
  id_trabajador integer not null,
  id_asignacion_docente integer not null,
  id_perido_calificacion integer not null,
  de_compromiso text,
  constraint monitoreo_pk primary key (id_monitoreo),
  constraint monitoreo_trabajador_fk foreign key (id_trabajador) references trabajador (id_trabajador),
  constraint monitoreo_asignacion_docente_fk foreign key (id_asignacion_docente) references asignacion_docente (id_asignacion_docente),
  constraint monitoreo_plantilla_monitoreo_fk foreign key (id_plantilla_monitoreo) references plantilla_monitoreo (id_plantilla_monitoreo),
  constraint monitoreo_periodo_calificacion_fk foreign key (id_perido_calificacion) references periodo_calificacion (id_periodo_calificacion)
);

create table respuesta_monitoreo (
  id_respuesta_monitoreo serial,
  id_monitoreo integer not null,
  id_detalle_plantilla_monitoreo integer not null,
  va_respuesta integer not null,
  de_respuesta_corta varchar(100),
  constraint respuesta_monitoreo_pk primary key (id_respuesta_monitoreo),
  constraint respuesta_monitoreo_monitoreo_fk foreign key (id_monitoreo) references monitoreo (id_monitoreo)
);