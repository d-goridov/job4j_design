select pr.name, pr.expired_date, pr.price
from products as pr join type as t on (pr.type_id = t.id)
where t.name = 'Cheese';

select pr.name, pr.expired_date, pr.price
from products as pr join type as t on (pr.type_id = t.id)
where pr.name LIKE '%frozen%';

select pr.name, t.name, pr.expired_date from products as pr
join type as t on (pr.type_id = t.id)
where expired_date < CURRENT_DATE;

select name, price FROM products where price = (select max(price) from products);

select t.name, count(*)
from products as pr join type as t on (pr.type_id = t.id)
group by t.name;

select t.name, pr.name from products as pr
join type as t on (pr.type_id = t.id) where
t.name = 'Cheese' or t.name = 'Milk';

select t.name, count(*)  from products as pr
join type as t on (pr.type_id = t.id)
group by t.name having count(*) < 10;

select pr.name, t.name from products as pr
join type as t on (pr.type_id = t.id);