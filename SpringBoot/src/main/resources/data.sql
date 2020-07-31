INSERT INTO user(name, email, password) VALUES('Admin', 'admin@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO user(name, email, password) VALUES('Aluno', 'aluno@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO user(name, email, password) VALUES('User', 'user@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');



INSERT INTO Category(name) VALUES('Programação');
INSERT INTO Category(name) VALUES('Front');
INSERT INTO Category(name) VALUES('Back');


INSERT INTO curse(name) VALUES('Spring Boot');
INSERT INTO curse(name) VALUES('HTML 5');
INSERT INTO curse(name) VALUES('C#');
INSERT INTO curse(name) VALUES('Nodejs');
INSERT INTO curse(name) VALUES('Groovy');


INSERT INTO curse_list_category VALUES(1, 1);
INSERT INTO curse_list_category VALUES(1, 3);
INSERT INTO curse_list_category VALUES(2, 2);
INSERT INTO curse_list_category VALUES(3, 1);
INSERT INTO curse_list_category VALUES(3, 3);
INSERT INTO curse_list_category VALUES(4, 1);
INSERT INTO curse_list_category VALUES(4, 3);


INSERT INTO TOPIC(title, message, create_date, status, user_id, curse_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 2, 1);
INSERT INTO TOPIC(title, message, create_date, status, user_id, curse_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 2, 1);
INSERT INTO TOPIC(title, message, create_date, status, user_id, curse_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 2, 2);


INSERT INTO PERFIL VALUES(1, 'ADMIN');
INSERT INTO PERFIL VALUES(2, 'USER');
INSERT INTO PERFIL VALUES(3, 'CLIENT');

INSERT INTO user_list_perfil VALUES(1, 1);
INSERT INTO user_list_perfil VALUES(2, 3);
INSERT INTO user_list_perfil VALUES(3, 2);