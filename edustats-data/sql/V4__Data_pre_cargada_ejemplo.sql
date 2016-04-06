-- Registro tipo documento
insert into tipo_documento (id_tipo_documento, de_corta, de_larga) values ('01', 'L.E / DNI', 'LIBRETA ELECTORAL O DNI');

-- Registro de persona

insert into persona (id_persona, no_persona, ap_persona, am_persona, fe_nacimiento, id_tipo_documento, nu_documento) values (1, 'Pedro', 'Castillo', 'Izaguirre', '1990-01-25', '01', '11111111');
insert into persona (id_persona, no_persona, ap_persona, am_persona, fe_nacimiento, id_tipo_documento, nu_documento) values (2, 'Jesús', 'Alvarado', 'Cotillo', '1990-01-01', '01', '22222222');

alter sequence persona_id_persona_seq restart with 3;

-- Registro de usuario
insert into usuario (id_usuario, id_persona, no_cuenta, co_contrasenia) VALUES (1, 1, 'pcastillo', md5('pcastillo'));
insert into usuario (id_usuario, id_persona, no_cuenta, co_contrasenia) VALUES (2, 2, 'jalvarado', md5('jalvarado'));

alter sequence usuario_id_usuario_seq restart with 3;

-- Registro de rol
insert into rol (id_rol, no_rol) values (1, 'ADMIN');

-- Asignación de rol a usuario
insert into usuario_rol (id_usuario, id_rol) values (1, 1);

-- Opciones del sistema
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta) values (1, 'ADM', 'Administración', '#');
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta, id_opcion_padre) values (2, 'USUARIO', 'Usuarios', '#usuarios/', 1);

insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta) values (3, 'CONF', 'Configuración', '#');
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta, id_opcion_padre) values (4, 'CONFIE', 'Mis IEs', '#config/institucioneducativa/', 3);
insert into opcion (id_opcion, co_opcion, de_opcion, de_ruta, id_opcion_padre) values (5, 'CONFPA', 'Periodo académico', '#config/periodoacademico/', 3);

-- Asignación de la opción al rol
insert into rol_opcion (id_rol, id_opcion) values (1, 2);
insert into rol_opcion (id_rol, id_opcion) values (1, 4);
insert into rol_opcion (id_rol, id_opcion) values (1, 5);

-- Cargos del sistema
insert into cargo (co_cargo, de_cargo) values ('DI', 'Director');
insert into cargo (co_cargo, de_cargo) values ('DO', 'Docente');

-- Trabajadores
insert into trabajador (id_trabajador, co_cargo, id_persona) values (1, 'DI', 1);
insert into trabajador (id_trabajador, co_cargo, id_persona) values (2, 'DO', 2);

alter sequence trabajador_id_trabajador_seq restart with 3;

-- Institución educativa
insert into institucion_educativa (id_institucion_educativa, nu_institucion_educativa, no_institucion_educativa) values (1, 170, 'I.E. Santa Rosa del Sauce');

alter sequence institucion_educativa_id_institucion_educativa_seq restart with 2;

-- Asignación de usuario a institución educativa
insert into usuario_institucion_educativa (id_usuario, id_institucion_educativa) values (1, 1);
insert into usuario_institucion_educativa (id_usuario, id_institucion_educativa) values (2, 1);