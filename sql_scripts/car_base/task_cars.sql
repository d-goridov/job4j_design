create table body (
    id serial primary key,
    name varchar(30)
);

create table engine (
     id serial primary key,
     name varchar(30)
);

create table gearbox (
      id serial primary key,
      name varchar(30)
);

create table cars (
     id serial primary key,
     name varchar(30),
     model varchar(30),
     body_id int references body(id),
     engine_id int references engine(id),
     gearbox_id int references gearbox(id)
);

insert into body(name) values
       ('Saloon'), ('Hatchback'), ('Estate'), ('Coupe'), ('Convertible'),
       ('Pickup'), ('Van');

insert into engine(name) values
       ('V4'), ('V6'), ('V8'), ('V10'), ('V12');

insert into gearbox(name) values ('Manual'), ('Automatic'), ('Robot');

insert into cars(name, model, body_id, engine_id, gearbox_id) values
('Chevrolet', 'Cruz', 2, 1, 2), ('Opel', 'Insignia', 1, 2, 1),
('Volkswagen', 'Passat', 3, 2, 1), ('Ford', 'Transit', 7, 1, 1),
('Audi', 'A6', 3, 2, 2), ('Nissan', 'Almera', 1, 1, 1),
('Bmw', 'M3', 4, 2, 2), ('Mersedes', 'Vito', 7, 2, 1),
('Skoda', 'Rapid', 1, 1, 2), ('Renault', 'Talisman', 3, 2, 2);

select auto.name, auto.model, b.name, e.name, g.name
from cars as auto
join body b on auto.body_id = b.id
join engine e on e.id = auto.engine_id
join gearbox g on g.id = auto.gearbox_id;

select body.name from cars right join body on body.id = cars.body_id
where cars.model is null;

select engine.name from engine left join cars on engine.id = cars.engine_id
where cars.name is null;

select gearbox.name from cars right join gearbox on gearbox.id = cars.gearbox_id
where cars.model is null;