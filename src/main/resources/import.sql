INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58');

INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_MANAGER');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1); 
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); 
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 3); 

insert into client(id) values(1);
insert into admin(id) values(2);
insert into manager(id) values(3);

insert into restaurant(rest_name, manager_id) values ('Restoran 1', 3);
insert into restaurant(rest_name, manager_id) values ('Restoran 2', 3);

insert into table_entity(capacity, rest_id) values(2, 1);
insert into table_entity(capacity, rest_id) values(4, 1);
insert into table_entity(capacity, rest_id) values(10, 1);
insert into table_entity(capacity, rest_id) values(6, 2);
insert into table_entity(capacity, rest_id) values(2, 2);

insert into table_reservation(num_of_people, reservation_date, table_id, client_id) values (3, '2022-06-15 11:58:58', 1, 1);

insert into ingredient(ing_name) values ('luk');
insert into ingredient(ing_name) values ('kupus');
insert into ingredient(ing_name) values ('hleb');
insert into ingredient(ing_name) values ('piletina');

insert into inventory(inv_name) values('sladište 1');
insert into inventory(inv_name) values('sladište 2');

insert into inventory_ingredient(ing_id, inv_id, amount) values ('luk', 'sladište 1', 50);

insert into rating(value, client_id, rest_id) values(5, 1, 1);
insert into rating(value, client_id, rest_id) values(4, 1, 2);

insert into comment(text, client_id, rest_id, like_count, published) values('Baš je dobar restoran', 1, 1, 0, '2022-06-15');