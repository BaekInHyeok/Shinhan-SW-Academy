========================================
		JOIN
========================================

1.�������� �̸��� ���޸�(job_title)�� ��ȸ�Ͻÿ�.


select first_name, job_title
from employees left outer join jobs
on(employees.job_id = jobs.job_id);


2.�μ��̸��� �μ��� ���� ���ø�(city)�� ��ȸ�Ͻÿ�.

select department_name, city
from departments left outer join locations
on(departments.location_id = locations.location_id);

3. ������ �̸��� �ٹ��������� ��ȸ�Ͻÿ�. (employees, departments, locations,countries)

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

4. ��å(job_title)�� 'manager' �� ����� �̸�, ��å, �μ����� ��ȸ�Ͻÿ�.
 
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

5. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�.
 
select first_name, hire_date, department_name
from employees join departments using(department_id);

6. �������� �̸�, �Ի���, �μ����� ��ȸ�Ͻÿ�.
��, �μ��� ���� ������ �ִٸ� �� ���������� ��°���� ���Խ�Ų��.

select first_name, hire_date, department_name
from employees left outer join departments using(department_id);

7. ������ �̸��� ��å(job_title)�� ����Ͻÿ�.
��, ������ �ʴ� ��å�� �ִٸ� �� ��å������ ��°���� ���Խ�Ű�ÿ�.

select first_name, job_title
from employees right outer join jobs using(job_id);

desc jobs;
insert into jobs values('play','������~~~~',50000,60000);
commit;
select * from jobs;


select *
from departments;
select department_id
from employees;
