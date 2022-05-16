CREATE table role (
    id serial primary key,
    name varchar(255)
);

CREATE table users (
    id serial primary key,
    name varchar(255),
    role_id int references role(id)
);


CREATE table rules (
    id serial primary key,
    name varchar(255)
);

CREATE table role_rules (
    id serial primary key,
    name varchar(255),
    role_id int references role(id),
    rules_id int references rules(id)
);

CREATE table category (
    id serial primary key,
    name varchar(255)
);

CREATE table state (
    id serial primary key,
    status varchar(255)
);

CREATE table item (
    id serial primary key,
    name varchar(255),
    users_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);

CREATE table comments (
    id serial primary key,
    description text,
    item_id int references item(id)
);

CREATE table attachs (
    id serial primary key,
    name varchar(255),
    item_id int references item(id)
);
