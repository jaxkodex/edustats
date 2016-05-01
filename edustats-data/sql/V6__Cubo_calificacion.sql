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
  id_dim_periodo_calificacion integer not null,
  va_nota_promedio numeric not null,
  nu_alumnos_sobre_promedio numeric not null,
  nu_alumnos_bajo_promedio numeric not null,
  nu_alumnos_nivel_satisfaccion_0 numeric not null,
  nu_alumnos_nivel_satisfaccion_11 numeric not null,
  nu_alumnos_nivel_satisfaccion_14 numeric not null,
  nu_alumnos_nivel_satisfaccion_17 numeric not null,
  constraint hec_calificaciones_pk primary key (id_dim_curso, id_dim_grado, id_dim_periodo_calificacion, id_dim_seccion),
  constraint hec_calificaciones_dim_seccion_fk foreign key (id_dim_seccion) references dim_seccion (id_dim_seccion),
  constraint hec_calificaciones_dim_grado_fk foreign key (id_dim_seccion) references dim_grado (id_dim_grado),
  constraint hec_calificaciones_dim_curso_fk foreign key (id_dim_curso) references dim_curso (id_dim_curso),
  constraint hec_calificaciones_dim_periodo_calificacion_fk foreign key (id_dim_periodo_calificacion) references dim_periodo_calificacion (id_dim_periodo_calificacion)
);


/* Query para llenar tabla hec_calificaciones

select k.id_periodo_calificacion, k.id_grado, k.co_seccion, k.id_curso, k.va_nota_promedio_curso_grado,
  sum(case when p.va_nota_promedio_alumno > k.va_nota_promedio_curso_grado then 1 else 0 end) nu_sobre_avg,
  sum(case when p.va_nota_promedio_alumno < k.va_nota_promedio_curso_grado then 1 else 0 end) nu_bajo_avg,
  sum(case when va_nota_promedio_alumno < 11 then 1 else 0 end) nu_nvl_st_0,
  sum(case when va_nota_promedio_alumno >= 11 and va_nota_promedio_alumno < 14 then 1 else 0 end) nu_nvl_st_11,
  sum(case when va_nota_promedio_alumno >= 14 and va_nota_promedio_alumno < 18 then 1 else 0 end) nu_nvl_st_14,
  sum(case when va_nota_promedio_alumno >= 18 then 1 else 0 end) nu_nvl_st_17
from
  (select id_periodo_calificacion, id_grado, co_seccion, id_curso, avg(va_nota_promedio_alumno) va_nota_promedio_curso_grado
   from
     (select id_periodo_calificacion, id_grado, co_seccion, cu.id_curso, c.id_matricula, avg(va_nota) va_nota_promedio_alumno
      from calificacion c
        left join matricula m on m.id_matricula = c.id_matricula
        left join aula a on a.id_aula = m.id_aula
        left join criterio_evaluacion ce on ce.id_criterio_evaluacion = c.id_criterio_evaluacion
        left join curso cu on cu.id_curso = ce.id_curso
      group by id_periodo_calificacion, id_grado, co_seccion, cu.id_curso, c.id_matricula) q
   group by id_periodo_calificacion, id_grado, co_seccion, id_curso) k
left join
  (select id_periodo_calificacion, id_grado, co_seccion, cu.id_curso, c.id_matricula, avg(va_nota) va_nota_promedio_alumno
   from calificacion c
     left join matricula m on m.id_matricula = c.id_matricula
     left join aula a on a.id_aula = m.id_aula
     left join criterio_evaluacion ce on ce.id_criterio_evaluacion = c.id_criterio_evaluacion
     left join curso cu on cu.id_curso = ce.id_curso
   group by id_periodo_calificacion, id_grado, co_seccion, cu.id_curso, c.id_matricula) p
    on p.id_periodo_calificacion = k.id_periodo_calificacion
       and p.id_grado = k.id_grado and p.co_seccion = k.co_seccion and p.id_curso = k.id_curso
group by k.id_periodo_calificacion, k.id_grado, k.co_seccion, k.id_curso, k.va_nota_promedio_curso_grado
order by id_periodo_calificacion, id_grado, co_seccion, id_curso;


 */