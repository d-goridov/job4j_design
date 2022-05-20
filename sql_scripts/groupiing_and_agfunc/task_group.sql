create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('iPhone', 7500.43);
insert into devices(name, price) values ('Xbox', 3501.13);
insert into devices(name, price) values ('Smartwatch', 2049.03);
insert into devices(name, price) values ('Powerbank', 1500.6);
insert into devices(name, price) values ('iRobot', 6200.33);

insert into people(name) values ('Petr'), ('Ivan'), ('Maria');

insert into devices_people(device_id, people_id) VALUES (1, 1);
insert into devices_people(device_id, people_id) VALUES (4, 1);
insert into devices_people(device_id, people_id) VALUES (5, 1);

insert into devices_people(device_id, people_id) VALUES (2, 2);
insert into devices_people(device_id, people_id) VALUES (3, 2);

insert into devices_people(device_id, people_id) VALUES (4, 3);
insert into devices_people(device_id, people_id) VALUES (2, 3);

select avg(price) from devices;

select p.name, avg(d.price) from
devices_people as dp join devices as d on (dp.device_id = d.id)
join people as p on (dp.people_id = p.id) group by p.name;

select p.name, avg(d.price)  from
devices_people as dp join devices as d on (dp.device_id = d.id)
join people as p on (dp.people_id = p.id) group by p.name
having avg(d.price) > 5000;



