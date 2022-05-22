create table teens (
    id serial primary key,
    name varchar(30),
    gender varchar(2)
);

insert into teens (name, gender) values
('Petr', 'M'), ('Ekaterina', 'W'), ('Olga', 'W'),
('Nikolay', 'M'), ('Alexandra', 'W'), ('Dmitriy', 'M'),
('Evgeniy', 'M'), ('Vasiliy', 'M'), ('Maria', 'W'),
('Oxana', 'W'), ('Ivan', 'M'), ('Timur', 'M'),
('Konstantin', 'M'), ('Nina', 'W'), ('Margarita', 'W'),
('Vladislav', 'M'), ('Gennadiy', 'M');

select men.name, woman.name from teens as men
cross join teens as woman where men.gender <> woman.gender;