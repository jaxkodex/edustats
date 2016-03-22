create table opcion (
  id_opcion serial not null,
  co_opcion varchar(10),
  de_opcion varchar(20),
  de_ruta varchar(50),
  id_opcion_padre int,
  constraint opcion_pk primary key (id_opcion)
);

create table rol_opcion (
  id_rol int,
  id_opcion int,
  constraint rol_opcion_pk primary key (id_rol, id_opcion),
  constraint rol_opcion_rol_fk foreign key (id_rol) references rol (id_rol),
  constraint rol_opcion_opcion_fk foreign key (id_opcion) references opcion (id_opcion)
);