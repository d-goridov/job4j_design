create table faculty(
    id serial primary key,
    name varchar(255)
);

create table students(
    id serial primary key,
    name varchar(255),
    faculty_id int references faculty(id)
);

insert into faculty(name) values ('IT');
insert into faculty(name) values ('ECONOMIC');
insert into faculty(name) values ('BUILDING');

insert into students(name, faculty_id) values('Oleg', 1);
insert into students(name, faculty_id) values('Maria', 2);
insert into students(name, faculty_id) values('Dmitriy', 1);
insert into students(name, faculty_id) values ('Olga', 2);
insert into students(name, faculty_id) values ('Petr', 3);

select st.id as id, st.name as student, fac.name as faculty
from students as st join faculty as fac on (st.faculty_id = fac.id)
order by st.id;

select st.name as student, fac.name as faculty
from students as st join faculty as fac on (st.faculty_id = fac.id)
order by st.name;

select st.id as id, st.name as student, fac.name as faculty
from students as st join faculty as fac on (st.faculty_id = fac.id)
where fac.name = 'ECONOMIC';