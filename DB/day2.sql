========================================
		������ �Լ�(1���� �Է�>>1���� ���)
========================================

select * from tab;
desc employees;

select * from employees;

--��ȸ:select
--�ۼ�����:select > from > where > order by
--�������:from > where > select > order by

select employee_id, first_name, salary �޿� --3
from employees --1
where salary>=10000 --2
order by 3; --4 : order by ��, Į���� �̸�, ����, select ������ �̿��� ���� ����. ���⼭�� salary�� �ȴ�.

select *
from employees
where salary>=10000
and commission_pct is not null
and first_name like '_____'
order by 2; 

--�ٶ������� ���� �ڵ�
select DISTINCT 10+20
from employees;

--dual�� �����ڰ� sys(hr �� �ƴ�) >> 1���� data�� ��ȸ�ؾ� �ϴ� ��� ���
desc dual;
select * from dual;

select 10+20, sysdate
from dual;

--1. ���� �Լ�
select 12.5, round(12.5) �ݿø�, round(12.56,1) "�Ҽ� ù°�ڸ� �ݿø�", FLOOR(15.7) ����, ceil(15.1) �ø�
,mod(10,3)
from dual;

--2.����ó�� �Լ�(concat�� �ٸ� DB���� ����, ||�� ����Ŭ������, MySQL������ +�� ����
select first_name, UPPER(first_name), lower(first_name),INITCAP(email), SUBSTR(first_name,1,3) "������ġ+���ⰳ��"
, LENGTH(first_name) ���� , first_name||' '||last_name "||�� ��ġ��" , concat(concat(first_name,' '),last_name) "concat���� ��ġ��"
from EMPLOYEES;

--SCOTT����ڿ��� �۾�
--job�� manager�� ���� ��ȸ
--''�� ���� ����� ��ҹ��ڸ� �����Ѵ�
select *
from emp
where job = upper('manager');

--���� DB_HR���� �۾�

--���� job_id�� index�� ������� �ִٸ�, Į���� ���� �������� �ʴ� ���� �� ȿ����
select *
from employees
where job_id = upper('it_prog');

select *
from employees
where lower(job_id)= lower('it_prog'); --Į������ �ǵ帮�� �Ŷ� �� ����

--jobs���� manager�� ã�� ����
select *
from jobs
where job_title like '%Manager';

select *
from jobs
where substr(job_title,-7) = initcap('manager'); --�����ڴ� like���� =�� �� ����

--��¥ �߶󺸱�(12�� �Ի��� ���)
select first_name, hire_date, substr(hire_date,1,2) �⵵, substr(hire_date, 4,2) ��, substr(hire_date, 7,2) ��
from employees
where to_char(hire_date,'MM')=12;
--where substr(hire_date,4,2) = 12;
--where hire_date like '__/12/__';

--Ư�� ���� ��ġ ã��
--�ڿ������� Ž�� >> -������ġ
select first_name, INSTR(first_name,'e') "ó�� ������ ��ġ", INSTR(first_name,'e',2) "Ư�� ��ġ���� ����", INSTR(first_name,'e',-1) "�ڿ������� Ž��"
,INSTR(first_name,'e',2,2) "2 ����, 2��° ����"
from employees;

--���� : data�� ��� �߸���
select first_name, lpad(first_name,10,'*') "10�ڸ� display", rpad(first_name,20,'#')
from employees;

select '*'||ltrim(' Oracle ')||'*' "���� ���� ����", '*'||rtrim(' Oracle ')||'*' "������ ���� ����",'*'||trim(' Oracle ')||'*' "���� ���� ����",
trim('a' from 'aaaaaaaaaaOracleaaaaaaa') "Ư�� ���� ����"
from dual;

select first_name, trim('A'from first_name)
from employees;

--��¥
select first_name, hire_date, sysdate+1 "����", floor(sysdate - hire_date) "�ٹ��ϼ�(����)", round(MONTHS_BETWEEN(SYSDATE,hire_date)/12,1) �ٹ����
, add_months(hire_date,6) "�Ի� 6���� ��", sysdate-22 "���� ��¥ 22�� ��", 
last_day(hire_date) "�Ի���� ������ ��¥", next_day(sysdate,'������') "���� ������", next_day(hire_date,'ȭ����') "�Ի��� ���� ȭ����"
,to_char(hire_date,'yyyy/mm/dd hh:mi:ss DAY D DY')
,round(hire_date,'MM') "�� �ݿø�(16�� ����)", trunc(hire_date,'MM') "�� ����"

from employees
order by �ٹ���� desc;

select sysdate, to_char(sysdate,'yyyy/mm/dd hh:mi:ss DAY D DY MON hh24 AM/PM'),
to_Char(100000,'L999,999,999,999') "ä���� ����", to_char(10000000,'L000,000,000,000') "ä��"
from dual;

select *
from employees
where hire_date >= '2005/01/01'; --yyyy

select *
from employees
where to_char(hire_date,'rr/mm/dd') >= '05/01/01'; --rr

select *
from v$nls_parameters;

alter session set NLS_DATE_FORMAT='mm/dd/yyyy';
alter session set NLS_DATE_FORMAT='RR/MM/DD';

--nvl(Į��, null�� �� ��ü��)
--nvl2(Į��, null �ƴ� ��, null�� ��) >> Ÿ���� �����ؾ� ��
select first_name,salary
,nvl(to_char(commission_pct),'Ŀ�̼� ����') "nvl�� ����"
,nvl2(commission_pct,to_char(commission_pct),'Ŀ�̼� ����') "nvl2�� ����", salary+salary*nvl(commission_pct,0) �Ǽ��ɾ�
,nvl(to_char(department_id),'�μ�����')
from employees
--where department_id is null
--where nvl(to_char(department_id),'�μ�����') = '�μ�����'
order by commission_pct nulls first;


select COALESCE(to_char(commission_pct),to_char(department_id), first_name)
from employees;

--decode�� = �����ڰ� ������ ��. �� = ��쿡�� ����
--case�� SQL������ ����Ǵ� ��� �����ڰ� ������
select first_name, salary,decode(salary, 24000,'�ſ� ����',17000,'����',12000,'����','����') �޿���,
    decode(length(first_name),9,'large',6,'middle','small')�̸�����,
    case when salary>=20000 then '����'
         when salary>=10000 and salary<20000 then '����'
         when salary < 10000 and salary >=5000 then '����'
         else '���ڶ�' end �޿���2,
    job_id,
    decode(job_id,'AD_PRES','A','AD_VP','A','IT_PROG','A','B') job2,
    case when job_id in ('AD_PRES','AD_VP','IT_PROG') then 'A' else 'B' end job3

from EMPLOYEES;


=============Group �Լ�==================


