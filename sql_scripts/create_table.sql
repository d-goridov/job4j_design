CREATE TABLE motocycle(
	id serial primary key,
	model text,
	year_release integer,
	as_type varchar(10),
	price double_precision
    );
	
insert into motocycle(model, year_release, as_type, price) 
values ('Kawasaki KLX250', 2010, 'enduro', 4250.54);

update motocycle set price = 4558.32;

delete from motocycle;

select * from motocycle;