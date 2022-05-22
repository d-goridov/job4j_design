select emp.name, dep.name from employees as emp
left join department as dep on emp.department_id = dep.id;

select emp.name, dep.name from employees as emp
right join department as dep on emp.department_id = dep.id;

select emp.name, dep.name from employees as emp
full join department as dep on emp.department_id = dep.id;

select emp.name, dep.name from employees as emp
cross join department as dep;

select dep.name from department as dep
left join employees as emp on emp.department_id = dep.id
where emp.name is null;





