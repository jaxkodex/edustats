insert into ciclo (id_ciclo, de_ciclo) values (1, 'VI Ciclo');
insert into ciclo (id_ciclo, de_ciclo) values (2, 'VII Ciclo');

alter sequence ciclo_id_ciclo_seq restart with 3;

insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (1, 1, 'PRIMERO SECUNDARIA', 1);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (2, 2, 'SEGUNDO SECUNDARIA', 1);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (3, 3, 'TERCERO SECUNDARIA', 2);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (4, 4, 'CUARTO SECUNDARIA', 2);
insert into grado (id_grado, nu_grado, de_grado, id_ciclo) values (5, 5, 'QUINTO SECUNDARIA', 2);

alter sequence grado_id_grado_seq restart with 6;

insert into seccion (co_seccion, de_seccion) values ('A', 'A');
insert into seccion (co_seccion, de_seccion) values ('B', 'B');
insert into seccion (co_seccion, de_seccion) values ('C', 'C');

insert into curso (id_curso, de_curso, id_grado) values (1, 'MATEMATICA', 1);
insert into curso (id_curso, de_curso, id_grado) values (2, 'COMUNICACIÓN', 1);
insert into curso (id_curso, de_curso, id_grado) values (3, 'INGLÉS', 1);
insert into curso (id_curso, de_curso, id_grado) values (4, 'ARTE', 1);
insert into curso (id_curso, de_curso, id_grado) values (5, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA', 1);
insert into curso (id_curso, de_curso, id_grado) values (6, 'FORMACIÓN CIUDADANA Y CÍVICA', 1);
insert into curso (id_curso, de_curso, id_grado) values (7, 'PERSONA, FAMILIA Y RELACIONES HUMANAS', 1);
insert into curso (id_curso, de_curso, id_grado) values (8, 'EDUCACIÓN FÍSICA', 1);
insert into curso (id_curso, de_curso, id_grado) values (9, 'EDUCACIÓN RELIGIOSA', 1);
insert into curso (id_curso, de_curso, id_grado) values (10, 'CIENCIA, TECNOLOGÍA Y AMBIENTE', 1);
insert into curso (id_curso, de_curso, id_grado) values (11, 'EDUCACIÓN PARA EL TRABAJO', 1);

insert into curso (id_curso, de_curso, id_grado) values (12, 'MATEMATICA', 2);
insert into curso (id_curso, de_curso, id_grado) values (13, 'COMUNICACIÓN', 2);
insert into curso (id_curso, de_curso, id_grado) values (14, 'INGLÉS', 2);
insert into curso (id_curso, de_curso, id_grado) values (15, 'ARTE', 2);
insert into curso (id_curso, de_curso, id_grado) values (16, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA', 2);
insert into curso (id_curso, de_curso, id_grado) values (17, 'FORMACIÓN CIUDADANA Y CÍVICA', 2);
insert into curso (id_curso, de_curso, id_grado) values (18, 'PERSONA, FAMILIA Y RELACIONES HUMANAS', 2);
insert into curso (id_curso, de_curso, id_grado) values (19, 'EDUCACIÓN FÍSICA', 2);
insert into curso (id_curso, de_curso, id_grado) values (20, 'EDUCACIÓN RELIGIOSA', 2);
insert into curso (id_curso, de_curso, id_grado) values (21, 'CIENCIA, TECNOLOGÍA Y AMBIENTE', 2);
insert into curso (id_curso, de_curso, id_grado) values (22, 'EDUCACIÓN PARA EL TRABAJO', 2);

insert into curso (id_curso, de_curso, id_grado) values (23, 'MATEMATICA', 3);
insert into curso (id_curso, de_curso, id_grado) values (24, 'COMUNICACIÓN', 3);
insert into curso (id_curso, de_curso, id_grado) values (25, 'INGLÉS', 3);
insert into curso (id_curso, de_curso, id_grado) values (26, 'ARTE', 3);
insert into curso (id_curso, de_curso, id_grado) values (27, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA', 3);
insert into curso (id_curso, de_curso, id_grado) values (28, 'FORMACIÓN CIUDADANA Y CÍVICA', 3);
insert into curso (id_curso, de_curso, id_grado) values (29, 'PERSONA, FAMILIA Y RELACIONES HUMANAS', 3);
insert into curso (id_curso, de_curso, id_grado) values (30, 'EDUCACIÓN FÍSICA', 3);
insert into curso (id_curso, de_curso, id_grado) values (31, 'EDUCACIÓN RELIGIOSA', 3);
insert into curso (id_curso, de_curso, id_grado) values (32, 'CIENCIA, TECNOLOGÍA Y AMBIENTE', 3);
insert into curso (id_curso, de_curso, id_grado) values (33, 'EDUCACIÓN PARA EL TRABAJO', 3);

insert into curso (id_curso, de_curso, id_grado) values (34, 'MATEMATICA', 4);
insert into curso (id_curso, de_curso, id_grado) values (35, 'COMUNICACIÓN', 4);
insert into curso (id_curso, de_curso, id_grado) values (36, 'INGLÉS', 4);
insert into curso (id_curso, de_curso, id_grado) values (37, 'ARTE', 4);
insert into curso (id_curso, de_curso, id_grado) values (38, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA', 4);
insert into curso (id_curso, de_curso, id_grado) values (39, 'FORMACIÓN CIUDADANA Y CÍVICA', 4);
insert into curso (id_curso, de_curso, id_grado) values (40, 'PERSONA, FAMILIA Y RELACIONES HUMANAS', 4);
insert into curso (id_curso, de_curso, id_grado) values (41, 'EDUCACIÓN FÍSICA', 4);
insert into curso (id_curso, de_curso, id_grado) values (42, 'EDUCACIÓN RELIGIOSA', 4);
insert into curso (id_curso, de_curso, id_grado) values (43, 'CIENCIA, TECNOLOGÍA Y AMBIENTE', 4);
insert into curso (id_curso, de_curso, id_grado) values (44, 'EDUCACIÓN PARA EL TRABAJO', 4);

insert into curso (id_curso, de_curso, id_grado) values (45, 'MATEMATICA', 5);
insert into curso (id_curso, de_curso, id_grado) values (46, 'COMUNICACIÓN', 5);
insert into curso (id_curso, de_curso, id_grado) values (47, 'INGLÉS', 5);
insert into curso (id_curso, de_curso, id_grado) values (48, 'ARTE', 5);
insert into curso (id_curso, de_curso, id_grado) values (49, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA', 5);
insert into curso (id_curso, de_curso, id_grado) values (50, 'FORMACIÓN CIUDADANA Y CÍVICA', 5);
insert into curso (id_curso, de_curso, id_grado) values (51, 'PERSONA, FAMILIA Y RELACIONES HUMANAS', 5);
insert into curso (id_curso, de_curso, id_grado) values (52, 'EDUCACIÓN FÍSICA', 5);
insert into curso (id_curso, de_curso, id_grado) values (53, 'EDUCACIÓN RELIGIOSA', 5);
insert into curso (id_curso, de_curso, id_grado) values (54, 'CIENCIA, TECNOLOGÍA Y AMBIENTE', 5);
insert into curso (id_curso, de_curso, id_grado) values (55, 'EDUCACIÓN PARA EL TRABAJO', 5);

insert into curso (id_curso, de_curso, id_grado) values (56, 'MATEMATICA', 6);
insert into curso (id_curso, de_curso, id_grado) values (57, 'COMUNICACIÓN', 6);
insert into curso (id_curso, de_curso, id_grado) values (58, 'INGLÉS', 6);
insert into curso (id_curso, de_curso, id_grado) values (59, 'ARTE', 6);
insert into curso (id_curso, de_curso, id_grado) values (60, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA', 6);
insert into curso (id_curso, de_curso, id_grado) values (61, 'FORMACIÓN CIUDADANA Y CÍVICA', 6);
insert into curso (id_curso, de_curso, id_grado) values (62, 'PERSONA, FAMILIA Y RELACIONES HUMANAS', 6);
insert into curso (id_curso, de_curso, id_grado) values (63, 'EDUCACIÓN FÍSICA', 6);
insert into curso (id_curso, de_curso, id_grado) values (64, 'EDUCACIÓN RELIGIOSA', 6);
insert into curso (id_curso, de_curso, id_grado) values (65, 'CIENCIA, TECNOLOGÍA Y AMBIENTE', 6);
insert into curso (id_curso, de_curso, id_grado) values (66, 'EDUCACIÓN PARA EL TRABAJO', 6);

alter sequence curso_id_curso_seq restart with 67;