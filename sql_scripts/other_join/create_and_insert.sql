create table department(
    id serial primary key,
    name varchar(30)
);
create table employees(
    id serial primary key,
    name varchar(30),
    department_id int references department(id)
)

insert into department(name) values
('Administration'), ('IT'), ('Marketing'), ('Sales'), ('Finance'),
('Executive'), ('Recruiting'), ('Construction'),
('Operations'), ('Control and Credit'), ('Public Relations');

insert into employees (name, department_id) values
('Petr', 1), ('Ekaterina', 1), ('Olga', 3),
('Nikolay', 5), ('Alexandra', 2), ('Dmitriy', 2),
('Evgeniy', 2), ('Vasiliy', 4), ('Maria', 4),
('Oxana', 7), ('Ivan', 6), ('Timur', 10),
('Konstantin', 10), ('Nina', null), ('Margarita', null),
('Vladislav', null), ('Gennadiy', null);