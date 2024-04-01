-------------
--����DB_HR--
-------------
select * from tab;
select * from employees;

desc employees;

--*�� ��� �÷��� �ǹ���
select *
from employees;

--Į�� �����ϱ�, ���� ��� ����, as�� ���� ����
select employee_id as ������ȣ, first_name �����̸�
from employees;

--�������� �ٹ��ϴ� �μ���(�ߺ����� >> distinct)
select distinct department_id
from employees;

--null:���ǵ� ���� ����. �μ����� ����.
select distinct department_id,first_name,last_name
from employees;

--invalid identifier ��ȿ���� ���� �ĺ���, Į�� �̸��� Ʋ��.
--table �����ϸ� Data Dictionary�� Į�� �̸��� �빮�ڷ� ����.(ORACLE)
--SQL������ ""�� ����ϸ� �ĺ����̸��̴�.
--SQL������ ''�� ���� �ǹ��Ѵ�.
--||dms concat������(���ڿ� ����)
--null�� =���� �� �� �Ұ�(is null ���), ��� �Ұ�
--nvl(commission_pct,1):null���� üũ�ؼ� �� ����

--���������
select first_name, last_name, salary, salary*12 "��~��",10+20, last_name||'->'||salary,commission_pct,nvl(commission_pct,1)*Salary
from employees
where commission_pct is null
;

select first_name, last_name, salary, commission_pct, nvl(commission_pct,0)*salary+salary "���� �޿�"
from employees
where department_id is not null
;

select '�̸�:'||first_name||' '||last_name||' �޿�:'||salary "�����Ұ�"
from employees
;

--���� ���Ĵ� �ش� ��¥�� �����Ѵ�
--2005�� 1�� 30�� ���Ŀ� �Ի��� ���� ��ȸ ���ǵ� �߰�
--Oracle�� �ڵ� ����ȯ ���� ex)'10000' -> 10000, 'hire_date'->to_date('05/01/30')
select *
from employees
where salary>=10000 
and commission_pct is not null 
and job_id = 'SA_REP'
and hire_date >='05/01/30'
;

select *
from employees
where not department_id=80;

select *
from employees
where department_id <> 80;

select *
from employees
where department_id != 80;

----�޿��� 10000 �̻� 20000 ����
select *
from employees
where salary>=10000 and salary<=20000;
    
select *
from employees
where salary between 10000 and 20000;

----�μ��� 60,90,100�� ���� ��ȸ
select *
from employees
where department_id=60 or department_id=90 or department_id=100;

select *
from employees
where department_id in(60,90,100);


----�μ��� 60,90,100�� �ƴ� ���� ��ȸ
select *
from employees
where department_id<>60 and department_id<>90 and department_id<>100;

select *
from employees
where department_id not in(60,90,100);

select 10+20,sysdate
from dual;

select *from dual;
desc dual;

--LIKE,%--
--%:�ϳ� �̻��� ������ ����
--_:�ϳ��� ������ ����
select *
from employees
where first_name like 'Sa%';

select *
from employees
where first_name like '%ane%';

select *
from employees
where first_name like '%e';

select *
from employees
where first_name not like '____a';


select*
from employees
where manager_id is null;

------����-------
--asc : ��������, Oracle������ null�� �������� ����
select*
from employees
where manager_id is not null
order by commission_pct asc;

--nulls first : null�� ���� ������ �ٲٱ�--
select*
from employees
where manager_id is not null
order by commission_pct asc nulls first;

--desc : ���� �Ұ�, null�� ���� ����--
select*
from employees
where manager_id is not null
order by commission_pct desc;

--nulls last : null�� ���߿� ������ �ٲٱ�--
select*
from employees
where manager_id is not null
order by commission_pct desc nulls last;

--CRUD �۾�
--insert(Create)
--select(Read)
--update(Update)
--delete(Delete)

--select Display�� ������(*, Į����, ����, �Լ�, distinct, ����...)
--from ���̺��
--where ���ǵ�(�񱳿�����, ��������...)
--order by Į�� asc, Į�� desc

--Q1--
select first_name, salary, department_id
from employees
where salary>=15000;

--Q2--
select first_name, salary*12
from employees
where salary*12>=170000;

--Q3--
select first_name, salary
from employees
where department_id is null;

--Q4--
select first_name,salary,hire_date
from employees
where hire_date <='04/12/31';

--------------
--SCOTT�����--
--------------

select*
from emp
where MGR is null;

