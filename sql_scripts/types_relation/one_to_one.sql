CREATE TABLE cards(
    id serial primary key,
	seria int,
    number int
    );

CREATE TABLE pets(
    id serial primary key,
	pets_name varchar(15),
	cards_id int references cards(id) unique
    );

insert into cards(seria, number) values ('5467', '234326');
insert into pets(pets_name, cards_id) values ('Rexs', 1);

select * from pets;