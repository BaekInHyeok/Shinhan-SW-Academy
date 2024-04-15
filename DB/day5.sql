--�޿��� ���� ���� ���� ���� ���� 5�� ��ȸ
select rownum,aa.*
from(
select first_name, salary
from employees
order by salary desc
) aa
where rownum<=5;

--�޿��� 5��°�� ���� �޴� ���� ��ȸ
select *
from(
    select rownum rr,aa.*
    from(
        select first_name, salary
        from employees
        order by salary desc) aa)bb
where bb.rr=5;

--row_number() : �ߺ� ���� ��ü ���� ����
--rank() : �ߺ� ��ũ �����ϰ� ���� ����
--dense_rank() : �ߺ� ��ũ�� �ϳ��� ������ ����
select *
from(
select first_name,salary,
row_number() over (order by salary desc) ��ũ1,
rank() over (order by salary desc) ��ũ2,
dense_rank() over (order by salary desc) ��ũ3
from employees)
where rownum<=5;

--table ����(employees->emp_copy) : ���� ���� �� not null�� �����
--table ����(departments->dept_copy)
--DDL(create table, drop table, rename, truncate, alter table):�ڵ� commit��
create table emp_copy
as
select * from employees where department_id = 60;

create table dept_copy
as
select * from departments where manager_id is not null;

select * from user_constraints where table_name='EMP_COPY';
select * from user_cons_columns where table_name='EMP_COPY';

select * from user_constraints where table_name='DEPT_COPY';

--���Ἲ : ����� �� �����͸� �Է� ����
--���� ���� �߰��ϱ�
alter table emp_copy add constraint emp_copy_empid_pk Primary key(employee_id);
alter table dept_copy add constraint dept_copy_empid_pk Primary key(department_id);

alter table dept_copy drop constraint dept_copy_deptid_pk cascade;

alter table emp_copy add constraint emp_copy_deptid_fk FOREIGN KEY (department_id) references dept_copy(department_id);

select * from emp_copy;
select * from dept_copy;

--DML(insert,delete,update):����Ȯ�� commit,������� rollback
insert into emp_copy values(108,'aa','bb','cc','444',sysdate,'aa',1000,null,333,100);
insert into emp_copy values(109,'aa1','bb1','cc1','444',sysdate,'aa',1000,null,333,77);
delete from emp_copy where department_id =77;
commit;

--VIEW(������ ���̺�, select���� ����) : �並 ���ؼ� ���̺��� �̿�
--or replace : �����ϸ� ��ü
--noforce:������ �����̸� �����Ұ�
--force:������ ������ �־ ����
create or replace view emp_dept60_view 
as
select * from employees where department_id = 60 with check option;

select * from user_views;--data ���� �˻�, select ���� ����Ǿ� ����
select * from emp_dept60_view;--�並 ���ؼ� ���� table�� data ��ȸ

update emp_dept60_view
set salary=9999
where employee_id=107;

rollback;

update emp_dept60_view
set department_id=90
where employee_id=107;

--������ �ٹ��ϴ� �μ��� ��ġ�ϴ� ������ ����Ͻÿ�
--������ SQL���� ���� ���ȴٸ� VIEW�� �̸�  �����. DML�� �Ұ���
drop view emp_country_view;
create or replace view emp_country_view
as
select employees.first_name, countries.country_name
from employees, departments, locations, countries
where employees.department_id = departments.department_id
and departments.department_id = locations.location_id
and locations.country_id= countries.country_id;

select * from user_views;
select * from emp_country_view join regions using(region_id);

---------������ : �ڵ� ��ȣ ������(Oracle������ ����, mysql������ autoincrement)-------------
----�������� ũ�� �ǹ� ���� Ű���� �־ ������ ��쿡�� ����Ѵ�
--1���� �����ؼ� 1�� ����
create sequence board_seq;

create table board(
    bno number constraint board_bno_PK primary key,
    title varchar2(50) not null,
    content varchar2(2000),
    writer varchar2(30),
    create_date date default sysdate
);

insert into board(bno,title) values(999,'�ݿ���');
insert into board values(board_seq.nextval,'�ݿ���','�ɱ��� ���ô�','jin',sysdate);
delete from board where bno=5;
select * from board;

select * from user_sequences;

select * from departments;
insert into departments values(DEPARTMENTS_SEQ.nextval,'test',null,null);

----index(����):�˻� �ӵ� ��� ����, ����:����� �� �ð� �ҿ�. ���� ����
----Oracle�� Primary Key�� �ڵ����� index�� ���������. �߰� ����
----Index ������ Į���� �����ϸ�(�Լ����), Index�� ������ �ʰ� ���� ����
select *
from user_ind_columns
where table_name = 'EMPLOYEES';

select *
from employees
where employee_id=100;

select *
from employees
where first_name = 'Alexander';

explain plan for
select *
from employees
where first_name = 'Alexander';

explain plan for
select *
from employees
where job_id='IT_PROG';

select * from table(DBMS_XPLAN.display);


----index ���� ���� ���� ���� ���غ���
create table emp_copy2 --����+������ ����, not null ���������� �����. ������ ���� ������ ���� �� �� >> index�� ���� ����
as
select * from employees;

insert into emp_copy2
select * from employees;

commit;

select count(*) from emp_copy2;

select * from emp_copy2;
insert into emp_copy2 values(1,'aa','bb','zz','1234',sysdate,'IT',12345,null,null,null);
select * from emp_copy2 where employee_id=2;
select * from emp_copy2 where first_name='aa';
set timing on;

drop table emp_copy3;

create table emp_copy3
as select * from emp_copy3;

insert into emp_copy3
select * from emp_copy3;
commit;
select count(*) from emp_copy3;

create index emp_copy2_firstname_ix on emp_copy2(first_name);