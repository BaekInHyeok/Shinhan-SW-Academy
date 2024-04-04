========================================
		JOIN
========================================

1.직원들의 이름과 직급명(job_title)을 조회하시오.


select first_name, job_title
from employees left outer join jobs
on(employees.job_id = jobs.job_id);


2.부서이름과 부서가 속한 도시명(city)을 조회하시오.

select department_name, city
from departments left outer join locations
on(departments.location_id = locations.location_id);

3. 직원의 이름과 근무국가명을 조회하시오. (employees, departments, locations,countries)

select employees.first_name, countries.country_name
from employees, departments, locations,countries
where employees.department_id = departments.department_id 
and departments.location_id=locations.location_id 
and locations.country_id=countries.country_id;

select employees.first_name, countries.country_name
from employees join departments on (employees.department_id = departments.department_id) 
join locations on(departments.location_id=locations.location_id)
join countries on(locations.country_id=countries.country_id);

select employees.first_name, countries.country_name
from employees join departments using department_id
join locations using location_id
join countries using country_i;

4. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
 
select first_name, job_title, department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id
and e.department_id = d.department_id
and substr(j.job_title,-7)=initcap('manager');

select first_name, job_title, department_name
from employees e inner join jobs j on(e.job_id=j.job_id)
inner join departments d on(e.department_id = d.department_id)
where substr(j.job_title,-7)=initcap('manager');

select first_name, job_title, department_name
from employees e inner join jobs j using(job_id)
inner join departments d using(department_id)
where substr(j.job_title,-7)=initcap('manager');

5. 직원들의 이름, 입사일, 부서명을 조회하시오.
 
select first_name, hire_date, department_name
from employees join departments using(department_id);

6. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.

select first_name, hire_date, department_name
from employees left outer join departments using(department_id);

7. 직원의 이름과 직책(job_title)을 출력하시오.
단, 사용되지 않는 직책이 있다면 그 직책정보도 출력결과에 포함시키시오.

select first_name, job_title
from employees right outer join jobs using(job_id);

desc jobs;
insert into jobs values('play','룰루랄라~~~~',50000,60000);
commit;
select * from jobs;


select *
from departments;
select department_id
from employees;
