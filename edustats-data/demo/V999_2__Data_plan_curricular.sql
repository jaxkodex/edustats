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

insert into curso (id_curso, de_curso) values (1, 'MATEMATICA');
insert into curso (id_curso, de_curso) values (2, 'COMUNICACIÓN');
insert into curso (id_curso, de_curso) values (3, 'INGLÉS');
insert into curso (id_curso, de_curso) values (4, 'ARTE');
insert into curso (id_curso, de_curso) values (5, 'HISTORIA, GEOGRAFÍA Y ECONOMÍA');
insert into curso (id_curso, de_curso) values (6, 'FORMACIÓN CIUDADANA Y CÍVICA');
insert into curso (id_curso, de_curso) values (7, 'PERSONA, FAMILIA Y RELACIONES HUMANAS');
insert into curso (id_curso, de_curso) values (8, 'EDUCACIÓN FÍSICA');
insert into curso (id_curso, de_curso) values (9, 'EDUCACIÓN RELIGIOSA');
insert into curso (id_curso, de_curso) values (10, 'CIENCIA, TECNOLOGÍA Y AMBIENTE');
insert into curso (id_curso, de_curso) values (11, 'EDUCACIÓN PARA EL TRABAJO');

insert into curso_grado (id_curso, id_grado) values (1, 1);
insert into curso_grado (id_curso, id_grado) values (2, 1);
insert into curso_grado (id_curso, id_grado) values (3, 1);
insert into curso_grado (id_curso, id_grado) values (4, 1);
insert into curso_grado (id_curso, id_grado) values (5, 1);
insert into curso_grado (id_curso, id_grado) values (6, 1);
insert into curso_grado (id_curso, id_grado) values (7, 1);
insert into curso_grado (id_curso, id_grado) values (8, 1);
insert into curso_grado (id_curso, id_grado) values (9, 1);
insert into curso_grado (id_curso, id_grado) values (10, 1);
insert into curso_grado (id_curso, id_grado) values (11, 1);

insert into curso_grado (id_curso, id_grado) values (1, 2);
insert into curso_grado (id_curso, id_grado) values (2, 2);
insert into curso_grado (id_curso, id_grado) values (3, 2);
insert into curso_grado (id_curso, id_grado) values (4, 2);
insert into curso_grado (id_curso, id_grado) values (5, 2);
insert into curso_grado (id_curso, id_grado) values (6, 2);
insert into curso_grado (id_curso, id_grado) values (7, 2);
insert into curso_grado (id_curso, id_grado) values (8, 2);
insert into curso_grado (id_curso, id_grado) values (9, 2);
insert into curso_grado (id_curso, id_grado) values (10, 2);
insert into curso_grado (id_curso, id_grado) values (11, 2);

insert into curso_grado (id_curso, id_grado) values (1, 3);
insert into curso_grado (id_curso, id_grado) values (2, 3);
insert into curso_grado (id_curso, id_grado) values (3, 3);
insert into curso_grado (id_curso, id_grado) values (4, 3);
insert into curso_grado (id_curso, id_grado) values (5, 3);
insert into curso_grado (id_curso, id_grado) values (6, 3);
insert into curso_grado (id_curso, id_grado) values (7, 3);
insert into curso_grado (id_curso, id_grado) values (8, 3);
insert into curso_grado (id_curso, id_grado) values (9, 3);
insert into curso_grado (id_curso, id_grado) values (10, 3);
insert into curso_grado (id_curso, id_grado) values (11, 3);

insert into curso_grado (id_curso, id_grado) values (1, 4);
insert into curso_grado (id_curso, id_grado) values (2, 4);
insert into curso_grado (id_curso, id_grado) values (3, 4);
insert into curso_grado (id_curso, id_grado) values (4, 4);
insert into curso_grado (id_curso, id_grado) values (5, 4);
insert into curso_grado (id_curso, id_grado) values (6, 4);
insert into curso_grado (id_curso, id_grado) values (7, 4);
insert into curso_grado (id_curso, id_grado) values (8, 4);
insert into curso_grado (id_curso, id_grado) values (9, 4);
insert into curso_grado (id_curso, id_grado) values (10, 4);
insert into curso_grado (id_curso, id_grado) values (11, 4);

insert into curso_grado (id_curso, id_grado) values (1, 5);
insert into curso_grado (id_curso, id_grado) values (2, 5);
insert into curso_grado (id_curso, id_grado) values (3, 5);
insert into curso_grado (id_curso, id_grado) values (4, 5);
insert into curso_grado (id_curso, id_grado) values (5, 5);
insert into curso_grado (id_curso, id_grado) values (6, 5);
insert into curso_grado (id_curso, id_grado) values (7, 5);
insert into curso_grado (id_curso, id_grado) values (8, 5);
insert into curso_grado (id_curso, id_grado) values (9, 5);
insert into curso_grado (id_curso, id_grado) values (10, 5);
insert into curso_grado (id_curso, id_grado) values (11, 5);

alter sequence curso_id_curso_seq restart with 66;

insert into periodo_academico (id_periodo_academico, id_institucion_educativa, co_periodo_academico) values (1, 1, '2013');
insert into periodo_academico (id_periodo_academico, id_institucion_educativa, co_periodo_academico) values (2, 1, '2014');
insert into periodo_academico (id_periodo_academico, id_institucion_educativa, co_periodo_academico) values (3, 1, '2015');
insert into periodo_academico (id_periodo_academico, id_institucion_educativa, co_periodo_academico) values (4, 1, '2016');

alter sequence periodo_academico_id_periodo_academico_seq restart with 5;

insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (1, 1, 'PRIMER TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (2, 1, 'SEGUNDO TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (3, 1, 'TERCER TRIMESTRE');

insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (4, 2, 'PRIMER TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (5, 2, 'SEGUNDO TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (6, 2, 'TERCER TRIMESTRE');

insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (7, 3, 'PRIMER TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (8, 3, 'SEGUNDO TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (9, 3, 'TERCER TRIMESTRE');

insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (10, 4, 'PRIMER TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (11, 4, 'SEGUNDO TRIMESTRE');
insert into periodo_calificacion (id_periodo_calificacion, id_periodo_academico, no_periodo_calificacion) values (12, 4, 'TERCER TRIMESTRE');

alter sequence periodo_calificacion_id_periodo_calificacion_seq restart with 16;

insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (1, 'Razonamiento y demostración', 1,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (2, 'Comunicación  matemática', 1,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (3, 'Resolución de problemas', 1,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (4, 'Actitud ante el área', 1,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (5, 'Expresión y comprensión oral', 2,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (6, 'Comprensión de textos', 2,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (7, 'Producción de textos', 2,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (8, 'Actitud ante el área', 2,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (9, 'Expresión y comprensión oral', 3,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (10, 'Comprensión de textos', 3,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (11, 'Producción de textos', 3,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (12, 'Actitud ante el área', 3,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (13, 'Expresión artística', 4,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (14, 'Apreciación artística', 4,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (15, 'Actitud ante el área', 4,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (16, 'Manejo de información', 5,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (17, 'Comprensión espacio-temporal', 5,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (18, 'Juicio crítico', 5,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (19, 'Actitud ante el área', 5,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (20, 'Construcción de la cultura cívica', 6,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (21, 'Ejercicio ciudadano', 6,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (22, 'Actitud ante el área', 6,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (23, 'Construcción de la autonomía', 7,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (24, 'Relaciones Interpersonales', 7,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (25, 'Actitud ante el área', 7,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (26, 'Comprensión y desarrollo de la Corp. y la Salud', 8,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (27, 'Dominio corporal y expresión creativa', 8,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (28, 'Convivencia e interacción sociomotriz', 8,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (29, 'Actitud ante el área', 8,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (30, 'Comprensión doctrinal cristiana', 9,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (31, 'Discernimiento de fe', 9,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (32, 'Actitud ante el área', 9,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (33, 'Comprensión de información', 10,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (34, 'Indagación y experimentación', 10,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (35, 'Actitud ante el área', 10,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (36, 'Gestión de procesos', 11,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (37, 'Ejecución de procesos', 11,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (38, 'Comprensión y aplicación de tecnologías', 11,  1);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (39, 'Actitud ante el área', 11,  1);


insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (40, 'Razonamiento y demostración', 1,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (41, 'Comunicación  matemática', 1,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (42, 'Resolución de problemas', 1,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (43, 'Actitud ante el área', 1,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (44, 'Expresión y comprensión oral', 2,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (45, 'Comprensión de textos', 2,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (46, 'Producción de textos', 2,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (47, 'Actitud ante el área', 2,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (48, 'Expresión y comprensión oral', 3,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (49, 'Comprensión de textos', 3,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (50, 'Producción de textos', 3,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (51, 'Actitud ante el área', 3,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (52, 'Expresión artística', 4,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (53, 'Apreciación artística', 4,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (54, 'Actitud ante el área', 4,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (55, 'Manejo de información', 5,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (56, 'Comprensión espacio-temporal', 5,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (57, 'Juicio crítico', 5,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (58, 'Actitud ante el área', 5,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (59, 'Construcción de la cultura cívica', 6,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (60, 'Ejercicio ciudadano', 6,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (61, 'Actitud ante el área', 6,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (62, 'Construcción de la autonomía', 7,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (63, 'Relaciones Interpersonales', 7,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (64, 'Actitud ante el área', 7,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (65, 'Comprensión y desarrollo de la Corp. y la Salud', 8,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (66, 'Dominio corporal y expresión creativa', 8,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (67, 'Convivencia e interacción sociomotriz', 8,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (68, 'Actitud ante el área', 8,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (69, 'Comprensión doctrinal cristiana', 9,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (70, 'Discernimiento de fe', 9,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (71, 'Actitud ante el área', 9,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (72, 'Comprensión de información', 10,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (73, 'Indagación y experimentación', 10,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (74, 'Actitud ante el área', 10,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (75, 'Gestión de procesos', 11,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (76, 'Ejecución de procesos', 11,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (77, 'Comprensión y aplicación de tecnologías', 11,  2);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (78, 'Actitud ante el área', 11,  2);


insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (79, 'Actúa y piensa matemáticamente en situaciones de cantidad', 1,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (80, 'Actúa y piensa matemáticamente en situaciones de regularidad, equivalencia y cambio', 1,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (81, 'Actúa y piensa matemáticamente en situaciones de forma, movimiento y localización', 1,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (82, 'Actúa y piensa matemáticamente en situaciones de gestión de datos e incertidumbre', 1,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (83, 'Comprende textos orales', 2,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (84, 'Se expresa oralmente', 2,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (85, 'Comprende textos escritos', 2,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (86, 'Produce textos escritos', 2,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (87, 'Interactúa con expresiones literarias', 2,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (88, 'Expresión y comprensión oral', 3,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (89, 'Comprensión de textos', 3,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (90, 'Producción de textos', 3,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (91, 'Expresión artística', 4,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (92, 'Apreciación artística', 4,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (93, 'Construye interpretaciones históricas', 5,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (94, 'Actúa responsablemente en el ambiente', 5,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (95, 'Actúa responsablemente respecto a los recursos económicos', 5,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (96, 'Convive resperándose a sí mismo y a los demás', 6,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (97, 'Participa en asuntos públicos para promover el bien común', 6,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (98, 'Afirma su identidad', 7,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (99, 'Se desenvuelve éticamente', 7,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (100, 'Comprensión y desarrollo de la Corp. y la Salud', 8,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (101, 'Dominio corporal y expresión creativa', 8,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (102, 'Convivencia e interacción sociomotriz', 8,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (103, 'Comprensión doctrinal cristiana', 9,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (104, 'Discernimiento de fe', 9,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (105, 'Indaga, mediante métodos científicos, situaciones que pueden ser investigadas por la ciencia', 10,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (106, 'Explica el mundo físico, basado en conocimientos científicos', 10,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (107, 'Diseña y produce prototipos tecnológicos para resolver problemas de su entorno', 10,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (108, 'Construye una posición crítica sobre la ciencia y la tecnología en sociedad', 10,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (109, 'Gestión de procesos', 11,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (110, 'Ejecución de procesos', 11,  3);
insert into criterio_evaluacion (id_criterio_evaluacion, de_criterio_evaluacion, id_curso, id_periodo_academico) values (111, 'Compresión y aplicación de tecnologías', 11,  3);

alter sequence criterio_evaluacion_id_criterio_evaluacion_seq restart with 112;