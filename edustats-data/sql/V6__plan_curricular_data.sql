insert into ciclo (id_ciclo, de_ciclo) values (1, 'VI Ciclo');
insert into ciclo (id_ciclo, de_ciclo) values (2, 'VII Ciclo');

alter sequence ciclo_id_ciclo_seq restart with 3;

insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (1, 1, 'PRIMERO SECUNDARIA', 1);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (2, 2, 'SEGUNDO SECUNDARIA', 1);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (3, 3, 'TERCER SECUNDARIA', 2);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (4, 4, 'CUARTO SECUNDARIA', 2);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (5, 5, 'QUINTO SECUNDARIA', 2);

alter sequence grado_id_grado_seq restart with 6;

insert into seccion (co_seccion, de_seccion) values ('A', 'A');
insert into seccion (co_seccion, de_seccion) values ('B', 'B');
insert into seccion (co_seccion, de_seccion) values ('C', 'C');

insert into curso (id_curso, de_curso, id_grado) values (1, 'MATEMATICA', 1);
insert into curso (id_curso, de_curso, id_grado) values (2, 'COMUNICACIÓN', 1);
insert into curso (id_curso, de_curso, id_grado) values (3, 'MATEMATICA', 2);
insert into curso (id_curso, de_curso, id_grado) values (4, 'COMUNICACIÓN', 2);
insert into curso (id_curso, de_curso, id_grado) values (5, 'MATEMATICA', 3);
insert into curso (id_curso, de_curso, id_grado) values (6, 'COMUNICACIÓN', 3);
insert into curso (id_curso, de_curso, id_grado) values (7, 'MATEMATICA', 4);
insert into curso (id_curso, de_curso, id_grado) values (8, 'COMUNICACIÓN', 4);
insert into curso (id_curso, de_curso, id_grado) values (9, 'MATEMATICA', 5);
insert into curso (id_curso, de_curso, id_grado) values (10, 'COMUNICACIÓN', 5);


alter sequence curso_id_curso_seq restart with 11;