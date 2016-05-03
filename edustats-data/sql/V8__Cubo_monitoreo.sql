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


/*

SELECT
  k.id_seccion_plantilla_monitoreo,
  m3.id_perido_calificacion,
  a3.id_grado,
  a3.co_seccion,
  avg(puntaje)          va_puntaje_promedio,
  sum(cumple_indicador) nu_cumple_indicador,
  sum(cumple_aspecto)   nu_cumple_aspecto,
  sum(no_cumple_aspecto)   nu_no_cumple_aspecto
FROM (SELECT
        m2.id_monitoreo,
        q.id_seccion_plantilla_monitoreo,
        puntaje,
        (CASE WHEN puntaje > spm2.va_puntaje_minimo
          THEN 1
         ELSE 0 END) cumple_indicador,
        (CASE WHEN puntaje > 0
          THEN 1
         ELSE 0 END) cumple_aspecto,
        (CASE WHEN puntaje > 0
          THEN 0
         ELSE 1 END) no_cumple_aspecto
      FROM (SELECT
              m.id_monitoreo,
              spm.id_seccion_plantilla_monitoreo,
              sum(va_respuesta) puntaje
            FROM respuesta_monitoreo rm
              LEFT JOIN monitoreo m ON m.id_monitoreo = rm.id_monitoreo
              LEFT JOIN detalle_plantilla_monitoreo dpm
                ON dpm.id_detalle_plantilla_monitoreo = rm.id_detalle_plantilla_monitoreo
              LEFT JOIN seccion_plantilla_monitoreo spm
                ON spm.id_seccion_plantilla_monitoreo = dpm.id_seccion_plantilla_monitoreo
              LEFT JOIN asignacion_docente ad ON ad.id_asignacion_docente = m.id_asignacion_docente
              LEFT JOIN aula a ON a.id_aula = ad.id_aula
              LEFT JOIN periodo_calificacion pc ON pc.id_periodo_calificacion = a.id_periodo_academico
            GROUP BY m.id_monitoreo, spm.id_seccion_plantilla_monitoreo) q
        LEFT JOIN seccion_plantilla_monitoreo spm2
          ON spm2.id_seccion_plantilla_monitoreo = q.id_seccion_plantilla_monitoreo
        LEFT JOIN monitoreo m2 ON m2.id_monitoreo = q.id_monitoreo
        LEFT JOIN asignacion_docente ad2 ON ad2.id_asignacion_docente = m2.id_asignacion_docente
        LEFT JOIN aula a2 ON a2.id_aula = ad2.id_aula) k
  LEFT JOIN monitoreo m3 ON m3.id_monitoreo = k.id_monitoreo
  LEFT JOIN asignacion_docente ad3 ON ad3.id_asignacion_docente = m3.id_asignacion_docente
  LEFT JOIN aula a3 ON a3.id_aula = ad3.id_aula
GROUP BY id_seccion_plantilla_monitoreo, id_perido_calificacion, a3.id_grado, a3.co_seccion
ORDER BY id_seccion_plantilla_monitoreo, id_perido_calificacion, a3.id_grado, a3.co_seccion;

*/