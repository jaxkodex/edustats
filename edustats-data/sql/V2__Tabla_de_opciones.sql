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

insert into rol (id_rol, no_rol) values (1, 'ADMIN');

insert into usuario_rol (id_usuario, id_rol) values (1, 1);

insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta) values (1, 'ADM', 'Administración', '#');
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta, id_opcion_padre) values (2, 'USUARIO', 'Usuarios', '#usuarios/', 1);

insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta) values (3, 'CONF', 'Configuración', '#');
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta, id_opcion_padre) values (4, 'CONFIE', 'Mis IEs', '#config/institucioneducativa/', 3);
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta, id_opcion_padre) values (5, 'CONFPA', 'Periodo académico', '#config/periodoacademico/', 3);

insert into rol_opcion (id_rol, id_opcion) values (1, 2);
insert into rol_opcion (id_rol, id_opcion) values (1, 4);
insert into rol_opcion (id_rol, id_opcion) values (1, 5);