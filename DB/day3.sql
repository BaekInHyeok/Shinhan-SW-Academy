--������ �Լ� >> 1��->1��--
select first_name,email, lower(email) --3
from employees --1
where job_id='IT_PROG' --2
and length(first_name)>5
order by 1; --4

--������ �Լ� : ���� �� ->1��, Į�� �̸��� ����ϸ� null�� ���ܵ�--

select avg(salary),sum(salary), max(salary),count(salary), count(department_id), count(commission_pct) "null ���� count", count(*) "null ���� count"
from employees;

select sum(department_id)/106, avg(department_id)
from employees;

select count(distinct department_id)
from employees;

select distinct department_id
from employees;

--�μ����� �� ���ϱ�--
select department_id, avg(salary),sum(salary), max(salary),count(salary), count(department_id), count(commission_pct) "null ���� count", count(*) "null ���� count"
from employees
group by department_id;

--select ���� ����� Į���� �����Լ��� ������� �ʾҴٸ� �ݵ�� group by ���� �����ؾ� �Ѵ�--
--�����ռ��� where �������� ��� �Ұ�--
--������ ���ؼ��� having�� ���
--rollup�� ��׷� �߰��հ踦 �����Ѵٴ� ��
--grouping : �ش� Į�� ���� null�̸� 1�� ��µ�
select department_id �μ���, job_id ��å��, sum(salary) �޿��հ�, count(*) ������, count(commission_pct)
,grouping(department_id), grouping(job_id)--5
from employees --1
where department_id is not null --2
group by rollup(department_id, job_id) --3
--having count(*)>10--4
order by �μ���;--6

--cube�� ��� ���տ� ���� �հ� ����
select department_id �μ���, decode (grouping(job_id),1,department_id||' �μ��� �հ�',job_id) ��å��, sum(salary) �޿��հ�, count(*) ������, count(commission_pct)
,grouping(department_id), grouping(job_id)--5
from employees --1
where department_id is not null --2
group by cube(department_id, job_id) --3
--having count(*)>10--4
order by �μ���;--6


select department_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name) over(PARTITION by job_id)"�μ��� ������"
from employees;
--group by department_id;

select department_id, job_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name)
from employees
group by department_id, job_id;

select * from employees;
select * from departments;
select * from locations;
select * from countries;
select * from regions;

--cross join : ���� ������ ���� ��� *�Ǽ���ŭ ����
select first_name, department_name
from employees, departments
order by first_name;

--equi join : = �����ڷ� ����
--������? :������ �μ��� ���� >> �Ǽ��� ���� �Ǽ�
select first_name, department_name
from employees, departments
where employees.department_id = departments.department_id
order by first_name;

select employees.first_name, employees.salary, jobs.job_title, jobs.max_salary
from employees, jobs
where employees.job_id = jobs.job_id
order by first_name;

--�μ� ���̺� manager_id�� �μ����̴�(���� �� 1��)
--�μ����� �̸���?
select departments.*, employees.first_name, salary, employees.last_name, departments.manager_id
from employees, departments
where employees.employee_id = departments.manager_id;

select first_name, department_name, emp.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id;

--���� ����(Oracle,Sybase, MySQL, Maria, Postge...)
select first_name, department_name, emp.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id(+);

--ǥ�� ����
--using�� ������ ���̺� ���� �̸��� Į������ ���ν� ���
--on�� �̿�(Į�� �̸��� �ٸ� ����� ����)
select first_name, department_name, emp.department_id
from employees emp join departments dept using(department_id)
where department_id>0;

select first_name, department_name, emp.department_id
from employees emp join departments dept on(emp.department_id=dept.department_id)
where emp.department_id>0;

--non-equi ����
select * from emp;
select*from salgrade;

--��������
select emp.*, salgrade.*
from emp, salgrade
where emp.sal between losal and hisal;

--ǥ�ع���
select emp.*, salgrade.*
from emp join salgrade
on (emp.sal between losal and hisal);


--���� ���� : �����ϰ��� �ϴ� Į���� �ڽ��� ���̺� �ִ� ���, �ϳ��� ���̺��� 2�� ��� �����Ѵ�--
select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ����, employees �Ŵ���
where ����.manager_id=�Ŵ���.employee_id;

select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ���� inner join employees �Ŵ���
on(����.manager_id=�Ŵ���.employee_id)
order by ����.employee_id;

--Outer Join:���� ���ǿ� ���� �ʴ� �൵ ��ȸ(���� �ʿ� +�� �ִ´�)
select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ����, employees �Ŵ���
where ����.manager_id=�Ŵ���.employee_id(+) --Oracle�� ����, sybase:*�̿�
order by ����.employee_id;

select ����.first_name, ����.salary, �Ŵ���.first_name, �Ŵ���.salary
from employees ���� left outer join employees �Ŵ���
on(����.manager_id=�Ŵ���.employee_id)
order by ����.employee_id;

select ����.first_name, ����.salary, nvl(�Ŵ���.first_name,'�Ŵ��� ����'), nvl2(�Ŵ���.salary,to_char(�Ŵ���.salary),'�Ŵ��� ����')
from employees ���� right outer join employees �Ŵ���
on(����.manager_id=�Ŵ���.employee_id)
order by ����.employee_id;

--������ �μ����� ����--
select first_name, salary, nvl(department_name,'�μ�����')
from employees left outer join departments
on(employees.department_id = departments.department_id);

select nvl(first_name,'���� ����'), salary, nvl(department_name,'�μ�����')
from employees full outer join departments
on(employees.department_id = departments.department_id);

select first_name, salary, nvl(department_name,'�μ�����')
from employees inner join departments --inner�� ���� ����
on(employees.department_id = departments.department_id);


-----��������------

--�ϳ��� ���� �μ��� �ٹ��ϴ� �������� �̸��� �޿��� ��ȸ�ϱ�
select first_name, salary, department_id
from employees
where department_id=
(select department_id
from employees
where first_name = 'Neena');

--David�� ���� ��å�� ���� �������� �̸��� �޿��� ��ȸ�ϱ�
--=Any�� in�� ���� ���̴�
select *
from employees
where job_id in
(select job_id
from employees
where first_name='David');


--��ձ޿����� �� ���� �޿��� �ް� �ִ� �������� �̸��� �޿� ��ȸ
select first_name, salary
from employees
where salary>
(select avg(salary)
from employees);

--�޿��� 10000 �̻��� ���� �μ��� ���� �μ��� �������� ��ȸ
select first_name, salary, department_id
from employees
where department_id in--=ANY�� ���� ������
(select distinct department_id
from employees
where salary >=10000);

-- 60�� �μ��� �ٹ��ϴ� ��� ������ �޿����� ���� �޿��� �޴� �������� ��ȸ

-- >ALL�� ��κ��� ũ�� >> ���� ū �ͺ��� ũ�ٴ� ��
select first_name, salary
from employees
where salary>all
(select salary
from employees
where department_id=60);

-- >ANY�� �ƹ��ų����� ũ�� >> �ּҺ��� ũ�� �ȴ�
select first_name, salary
from employees
where salary>any
(select salary
from employees
where department_id=60);

-- <ALL�� ��κ��� �۴� >> �ּҺ��� �۴�
select first_name, salary
from employees
where salary <all
(select salary
from employees
where department_id=60);

-- <ANY�� �ƹ��ų����� �۴� >> �ִ뺸�� ������ ��
select first_name, salary
from employees
where salary <any
(select salary
from employees
where department_id=60);

--������ �������� : �������� ����� 1��
--������ �������� : �������� ����� 2�� �̻�(>ANy, >ALL, IN...)
--���� Į�� ��������
--�μ��� �ּ� �޿��� �޴� ���� ���� ��ȸ
select *
from employees
where(department_id,salary) in (
select department_id, min(salary)
from employees
group by department_id);

--������ �޴� �޿��� ������ ���� �μ��� ��� �޿����� ���� �������� ����
--�����������
select *
from employees outeremp
where salary<(select avg(salary) from employees where department_id =outeremp.department_id);

----from���� subquery(�ζ��κ�)�� �̿��� ����-----
--select���� subquery(��Į�󼭺�����)
select employees.*, inlineview.avgsal,(select avg(salary) from employees) "��ü���"
from(
select  department_id, avg(salary) avgsal
from employees
group by department_id)inlineview, employees
where inlineview.department_id=employees.department_id 
and salary<inlineview.avgsal;



