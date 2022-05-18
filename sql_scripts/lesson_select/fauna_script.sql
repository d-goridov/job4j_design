CREATE table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values (fish_shark, 12908, date '1934-09-05');

insert into fauna(name, avg_age, discovery_date)
values (animal_bear, 15447, date '1921-07-10');

insert into fauna(name, avg_age, discovery_date)
values (bird_eagle, 25000, date '1951-12-01');

insert into fauna(name, avg_age, discovery_date)
values (shake_viper, 9005, date '1960-07-12');

insert into fauna(name, avg_age, discovery_date)
values (arthropods_spider, 5498, null);

select * from fauna where name LIKE '%fish%';
select * from fauna where avg_age between 10000 and 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
