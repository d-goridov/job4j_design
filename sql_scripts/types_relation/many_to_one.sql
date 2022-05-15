CREATE TABLE countries (
	id serial primary key,
    country_name varchar(15)
    );

CREATE TABLE pilots (
	id serial primary key,
	pilot_name varchar(20),
    model_car text,
	countries_id int references COUNTRIES(id)
    );

insert into countries (country_name) values ('FINLAND');
insert into pilots (pilot_name, model_car, countries_id)
values ('PETER', 'SUBARU', 1);

select * from pilots;
select * from countries;