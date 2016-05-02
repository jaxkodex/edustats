﻿insert into plantilla_monitoreo (id_plantilla_monitoreo) values (1);

insert into seccion_plantilla_monitoreo (id_seccion_plantilla_monitoreo, id_plantilla_monitoreo, de_seccion, va_puntaje_minimo) values (1, 1, 'Estrategias metodológicas empleadas por el docente (Datos a ser registrados mediante la OBSERVACIÓN)', 8);
insert into seccion_plantilla_monitoreo (id_seccion_plantilla_monitoreo, id_plantilla_monitoreo, de_seccion, va_puntaje_minimo) values (2, 1, 'Uso de materiales y recursos didácticos por el docente (Registrar estos datos a partir de la OBSERVACION)', 16);
insert into seccion_plantilla_monitoreo (id_seccion_plantilla_monitoreo, id_plantilla_monitoreo, de_seccion, va_puntaje_minimo) values (3, 1, 'Gestión del tiempo para los aprendizajes →Registrar estos datos a partir de la OBSERVACION ', 8);
insert into seccion_plantilla_monitoreo (id_seccion_plantilla_monitoreo, id_plantilla_monitoreo, de_seccion, va_puntaje_minimo) values (4, 1, 'Clima de aula→ Registrar estos datos a partir de la OBSERVACION', 8);
insert into seccion_plantilla_monitoreo (id_seccion_plantilla_monitoreo, id_plantilla_monitoreo, de_seccion, va_puntaje_minimo) values (5, 1, 'Planificación→ Datos a ser registrados CONSULTANDO al docente', 8);

/*<<<<<<< HEAD
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(1, 1, 'Al iniciar la sesión el o la docente motiva y genera el interés y la atención de los estudiantes?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(2, 1, 'A continuación, el o la docente comunica a los y las estudiantes los aprendizajes que se esperan lograr en la sesión?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(3, 1, '¿El/la docente utiliza diversas formas de organización de los estudiantes: trabajos individuales, trabajos en grupos, pequeños, grandes, con toda el aula, etc.?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(4, 1, '¿El/la docente observado brinda atención simultánea y diferenciada a sus estudiantes?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(5, 1, 'El/la docente recoge e incorpora permanente los conocimientos previos de los/las estudiantes para el desarrollo de los aprendizajes?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(6, 1, 'El/la docente promueve los conocimientos y practicas interculturales para el desarrollo de los aprendizajes?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(7, 1, 'El/la docente hace uso de algunas estrategias planteadas en las rutas del aprendizaje EBR y/o EIB (uso del juego, del error, la resolución de problemas, entre otras)?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(8, 1, 'El/la docente ha seguido una secuencia didáctica que corresponde al desarrollo de los aprendizajes propuestos?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(9, 2, 'El/la docente utiliza materiales y/o recursos didácticos que ayudan al desarrollo  de las actividades de aprendizaje propuestas para la sesión?', FALSE, FALSE, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(10, 2, 'El/la docente acompaña y orienta a los y las estudiantes durante el uso de los materiales en función del aprendizaje a lograr?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(11, 2, 'El aula cuenta con la cantidad suficiente de materiales educativos para el grupo de estudiantes observados?', FALSE, FALSE, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(12, 2, 'El/la docente organiza y facilita materiales y recursos didácticos a los y las estudiantes en el momento oportuno?', FALSE, FALSE, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(13, 2, 'El/la docente adecua el uso del material educativo considerando la realidad de los estudiantes?', FALSE, FALSE, 4);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(14, 3, 'El/la docente empieza la sesión a la hora prevista? (Responder a la siguiente pregunta solo si se logro estar en el aula en el momento en el que se inicio la sesión. En caso contrario, pasar a pregunta 2)', FALSE, FALSE, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(15, 3, 'El/la docente culmina la sesión a la hora prevista?', FALSE, FALSE, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(16, 3, 'El/la docente permanece durante toda la  sesión en el espacio  de aprendizaje?   (sea el aula u otro espacio en el que se esté desarrollando la sesión)', FALSE, FALSE, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(17, 3, 'Los /las estudiantes permanecen durante toda la sesión en el espacio de aprendizaje? (sea el aula u otro espacio en el que se esté desarrollando la sesión)', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(18, 3, 'Anotar si se dieron interrupciones al desarrollo de la sesión', FALSE, FALSE, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(21, 3, 'El/la docente ha optimizado el desarrollo para actividades significativas de aprendizaje', FALSE, FALSE, 4);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(22, 4, 'El/la docente dialoga y escucha con atención a los y las estudiantes?', FALSE, FALSE, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(23, 4, 'El/la docente se dirige a sus estudiantes por sus nombres sin utilizar apodos o números?', FALSE, FALSE, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(24, 4, 'El/la docente trata a sus estudiantes con respeto, sin ridiculizarlos?', FALSE, FALSE, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(25, 4, 'El/la docente emplea palabras positivas para reafirmar el esfuerzo individual o grupal de los y las estudiantes?', FALSE, FALSE, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(26, 4, 'El/la docente recurre a normas y acuerdos que ayuden a mejorar la convivencia en el aula?', FALSE, FALSE, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(27, 5, '¿Las actividades planificadas para la sesión, incorporan los contenidos de las rutas de aprendizaje?', TRUE, FALSE, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(28, 5, '¿Las actividades desarrolladas  en la sesión, están incluidas en algún documento de planificación? (no leer)', FALSE, TRUE, 1);


=======*/
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(1, 1, 'Al iniciar la sesión el o la docente motiva y genera el interés y la atención de los estudiantes?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(2, 1, 'A continuación, el o la docente comunica a los y las estudiantes los aprendizajes que se esperan lograr en la sesión?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(3, 1, '¿El/la docente utiliza diversas formas de organización de los estudiantes: trabajos individuales, trabajos en grupos, pequeños, grandes, con toda el aula, etc.?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(4, 1, '¿El/la docente observado brinda atención simultánea y diferenciada a sus estudiantes?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(5, 1, 'El/la docente recoge e incorpora permanente los conocimientos previos de los/las estudiantes para el desarrollo de los aprendizajes?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(6, 1, 'El/la docente promueve los conocimientos y practicas interculturales para el desarrollo de los aprendizajes?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(7, 1, 'El/la docente hace uso de algunas estrategias planteadas en las rutas del aprendizaje EBR y/o EIB (uso del juego, del error, la resolución de problemas, entre otras)?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(8, 1, 'El/la docente ha seguido una secuencia didáctica que corresponde al desarrollo de los aprendizajes propuestos?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(9, 2, 'El/la docente utiliza materiales y/o recursos didácticos que ayudan al desarrollo  de las actividades de aprendizaje propuestas para la sesión?', false, false, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(10, 2, 'El/la docente acompaña y orienta a los y las estudiantes durante el uso de los materiales en función del aprendizaje a lograr?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(11, 2, 'El aula cuenta con la cantidad suficiente de materiales educativos para el grupo de estudiantes observados?', false, false, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(12, 2, 'El/la docente organiza y facilita materiales y recursos didácticos a los y las estudiantes en el momento oportuno?', false, false, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(13, 2, 'El/la docente adecua el uso del material educativo considerando la realidad de los estudiantes?', false, false, 4);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(14, 3, 'El/la docente empieza la sesión a la hora prevista? (Responder a la siguiente pregunta solo si se logro estar en el aula en el momento en el que se inicio la sesión. En caso contrario, pasar a pregunta 2)', false, false, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(15, 3, 'El/la docente culmina la sesión a la hora prevista?', false, false, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(16, 3, 'El/la docente permanece durante toda la  sesión en el espacio  de aprendizaje?   (sea el aula u otro espacio en el que se esté desarrollando la sesión)', false, false, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(17, 3, 'Los /las estudiantes permanecen durante toda la sesión en el espacio de aprendizaje? (sea el aula u otro espacio en el que se esté desarrollando la sesión)', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(18, 3, 'Anotar si se dieron interrupciones al desarrollo de la sesión', false, false, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(21, 3, 'El/la docente ha optimizado el desarrollo para actividades significativas de aprendizaje', false, false, 4);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(22, 4, 'El/la docente dialoga y escucha con atención a los y las estudiantes?', false, false, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(23, 4, 'El/la docente se dirige a sus estudiantes por sus nombres sin utilizar apodos o números?', false, false, 3);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(24, 4, 'El/la docente trata a sus estudiantes con respeto, sin ridiculizarlos?', false, false, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(25, 4, 'El/la docente emplea palabras positivas para reafirmar el esfuerzo individual o grupal de los y las estudiantes?', false, false, 2);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(26, 4, 'El/la docente recurre a normas y acuerdos que ayuden a mejorar la convivencia en el aula?', false, false, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(27, 5, '¿Las actividades planificadas para la sesión, incorporan los contenidos de las rutas de aprendizaje?', false, false, 1);
insert into detalle_plantilla_monitoreo (id_detalle_plantilla_monitoreo, id_seccion_plantilla_monitoreo, de_pregunta, in_respuesta_corta, in_opciones, va_puntaje) values(28, 5, '¿Las actividades desarrolladas  en la sesión, están incluidas en algún documento de planificación? (no leer)', false, false, 1);
/*>>>>>>> origin/develop*/
