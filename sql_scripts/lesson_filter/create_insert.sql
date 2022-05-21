create table type (
    id serial primary key,
    name varchar(30)
);

create table products (
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price float
);

insert into type (name) values ('Cheese'), ('Milk'), ('Fish'), ('Meet'), ('Fruit');

insert into products (name, type_id, expired_date, price) values ('Mozzarella', 1, '2022-08-12', 320);
insert into products (name, type_id, expired_date, price) values ('Parmesan', 1, '2022-07-02', 288.5);
insert into products (name, type_id, expired_date, price) values ('Roquefort', 1, '2022-04-10', 231.7);

insert into products (name, type_id, expired_date, price) values ('Pasteurized milk', 2, '2022-05-30', 30.3);
insert into products (name, type_id, expired_date, price) values ('Lactose free milk', 2, '2022-05-12', 42.5);

insert into products (name, type_id, expired_date, price) values ('Salmon_fresh', 3, '2022-06-10', 150.5);
insert into products (name, type_id, expired_date, price) values ('Halibut_frozen', 3, '2022-10-10', 121.2);
insert into products (name, type_id, expired_date, price) values ('Catfish_frozen', 3, '2022-11-02', 113.7);

insert into products (name, type_id, expired_date, price) values ('Chicken_fresh', 4, '2022-05-24', 172.5);
insert into products (name, type_id, expired_date, price) values ('Beef_frozen', 4, '2022-04-01', 181.2);
insert into products (name, type_id, expired_date, price) values ('Pork_frozen', 4, '2022-11-02', 165.7);

insert into products (name, type_id, expired_date, price) values ('Lemon_fresh', 5, '2022-06-07', 21.7);
insert into products (name, type_id, expired_date, price) values ('Strawberry_frozen', 5, '2022-09-01', 39.9);
insert into products (name, type_id, expired_date, price) values ('Cherry_frozen', 5, '2022-04-28', 19.1);