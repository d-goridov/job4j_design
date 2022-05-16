insert into role(name) values ('Beginner');
insert into users(name, role_id) values ('Peter', 1);
insert into rules(name) values ('rule 1');
insert into role_rules(name, role_id, rules_id) values ('r_r', 1, 1);
insert into category(name) values ('Technics');
insert into state(name) values ('In progress');
insert into item(name, users_id, category_id, state_id) values ('Item1', 1, 1, 1);
insert into comments(name, item_id) values ('Go go go', 1);
insert into attachs(name, item_id) values ('foto1', 1);