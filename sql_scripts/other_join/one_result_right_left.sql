select emp.name, dep.name from employees as emp
left join department as dep on emp.department_id = dep.id;

select emp.name, dep.name from department as dep
right join employees as emp on emp.department_id = dep.id;