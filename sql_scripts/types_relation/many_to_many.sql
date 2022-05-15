CREATE TABLE clients(
    id serial primary key,
	client_name varchar(30),
	passport text
);

CREATE TABLE routes(
    id serial primary key,
	country_name varchar(25),
	city_name varchar(15)
);

CREATE TABLE trips(
    id serial primary key,
	clients_id int references clients(id),
	routes_id int references routes(id)
);

insert into clients(client_name, passport) values ('Ivan', 'qw123298ui');
insert into clients(client_name, passport) values ('Oleg', 'klj0936nvb4');
insert into clients(client_name, passport) values ('Vasiliy', 'uy5643rfg32');

insert into routes(country_name, city_name) values ('Canada', 'Vacouver');
insert into routes(country_name, city_name) values ('Argentina', 'Buenos Aires');
insert into routes(country_name, city_name) values ('Japan', 'Tokio');

insert into trips(clients_id, routes_id) values (1, 2);
insert into trips(clients_id, routes_id) values (2, 1);
insert into trips(clients_id, routes_id) values (3, 3);
insert into trips(clients_id, routes_id) values (1, 1);
insert into trips(clients_id, routes_id) values (2, 3);

select * from trips;