-- 9��.DDL : ���̺� ���� ����,����,����

-- LOB(LARGE OBJECT) : IMAGE, VIDEO 
-- ROWID ���̺��� ���� ��ġ�� �����ϴ� ������ �ּҰ� : ���� �����Ͱ� ����� ��ġ�� DBMS�� ��� : INDEX(����)
-- ROWNUM : SELECT�� ����
SELECT ROWID, ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC; -- SELECT ������ �����̹Ƿ� DESC�ϸ� ���ڰ� ����
-- �޿��� ���� ���̹޴� ���� 10�� 
SELECT rownum, aa.*
FROM( SELECT ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC) AA
WHERE ROWNUM <= 10;
-- rownum�� 6�ξָ� ã�ƺ��� rr�� ���� ����
SELECT *
FROM( SELECT rownum rr, aa.*
        FROM( SELECT ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC) aa)
WHERE rr = 6;
-- �޿��� ���� 6~10����
SELECT ROWNUM,FIRST_NAME,SALARY FROM EMPLOYEES ORDER BY SALARY DESC; -- ������ SELECT �� ROWNUM�� �ο��ǰ� ORDER BY�� �ϰ� DISPLAY�Ѵ�.

SELECT  ROWNUM, BB.*
FROM (
        SELECT ROWNUM RR, AA.*
        FROM ( SELECT ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC) AA) BB
WHERE RR BETWEEN 6 AND 10;
-- TIMESTAMP : DATE ���� Ȯ��� ����
-- INTERVAL YEAR TO MONTH
-- CHAR : �������� ���ڵ�����
-- VARCHAR2 : �������� ���ڵ�����
-- NUMBER : 
-- DATE :

------------------------------------------------------------------------------- DDL(DATA DEFINITION LANGUAGE) : CREATE TABLE, ALTER TABLE, DROP TABLE, RENAME, TRUNCATE : �ڵ� COMMIT�����Ұ�
-- ���ο� ���̺� ����
CREATE TABLE EMP01(
 EMPNO NUMBER(4),
 ENAME VARCHAR2(20),
 SAL NUMBER(7,2) -- ��ü 7�ڸ� �Ҽ��ؿ� 2�ڸ�
);
CREATE TABLE EMP02(
 EMPNO NUMBER(4),
 ENAME VARCHAR2(20),
 SAL NUMBER(7,2)
);
SELECT * FROM TAB;

-- ���������� ������ ����? : ������ ����� ��� : ���� ����� �����͵� ����
                                                                        
                                                                                --  CREATE TABLE
--CREATE TABLE EMP02 AS SELECT * FROM EMP;
CREATE TABLE EMP_03 
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

DESC EMP_03;
SELECT * FROM EMP_03;

-- ���̺� ������ �����ϰ� DATA�� �������� �ʱ�
CREATE TABLE EMP_04
AS
SELECT * FROM EMPLOYEES
WHERE 1=0; -- SELECT�� ���� ���� �־ ���̺� ������ ���簡��
SELECT * FROM EMP_04;

                                                                                -- ALTER TABLE 
-- �÷� �߰� ADD(�÷��� Ÿ��)
ALTER TABLE EMP_03 ADD(JOB VARCHAR2(20));
DESC EMP_03;
SELECT * FROM EMP_03;
-- �÷� ���� MODIFY(�÷��� Ÿ��)
ALTER TABLE EMP_03 MODIFY(FIRST_NAME VARCHAR2(20));
-- �÷� ���� DROP COLUMN �÷���
ALTER TABLE EMP_03 DROP COLUMN FIRST_NAME;
ROLLBACK; -- DDL�� ROLLBACK �Ұ�
-- SET UNUSED ����ϰ� ���Ŀ� DROP ���
ALTER TABLE EMP_03
set unused(JOB);
-- ���̺� ���� DROP TABLE ���̺��
DROP TABLE EMP_03;

SELECT * FROM EMP01;

-- TRUNCATE : ������ �����ϰ�, �����͸� ����
TRUNCATE TABLE EMP01; 

-- DD(Data Dictionary)
SELECT * FROM USER_TABLES; -- ���� ������ �ִ� ���̺���� ���� 
SELECT * FROM ALL_TABLES; -- ������ ��� ���̺� ���� (��������) : Ÿ������ ��ü�� ��Ģ�����δ� ���� X
SHOW USER; -- ���� ������
--DBA_��ųʸ� : DBA_TABLES : DBA�� ���� �� �� ����


----------------------------------------------------------------------------------- DML(DATA MANIPULATION LANGUAGE) : INSERT, DELETE, UPDATE : �ڵ� COMMIT�� �ƴ� : ��������
INSERT INTO EMP01 VALUES (100,'������',1000); 
SELECT * FROM EMP01; -- ���� ���ǿ����� Ȯ�ε����� �ٸ� ���ǿ����� Ȯ�κҰ�
COMMIT; -- DB�� ������ ����ȴ�.


desc emp01;


insert into emp01(EMPNO,ENAME,SAL) values(1,'aa',500);
insert into emp01(EMPNO,ENAME,SAL) values(1,'aa',500,600); -- too many values
insert into emp01(EMPNO,ENAME,SAL) values(1,aa,500);--missing expression
insert into emp01(EMPNO,SAL,ENAME) values(1,'aa',500);--invalid number(Type ����)
insert into emp01(EMPNO,SAL) values(1,500);--�Ͻ��� null ����
insert into emp01(EMPNO,SAL) values(2,600);--�Ͻ���
insert into emp01(EMPNO,ENAME,SAL) values(1,null,500);--��������� null ����
insert into emp01(EMPNO,ENAME,SAL) values(1,null,null);--��������� null ����

insert into emp01(EMPNO,ENAME,SAL) values(1,'aa',500);
insert into emp01 values(1,'aa'); --not enough values >> Į���� ������ 3�ε� ���� 2���̹Ƿ� ���ڶ�

select * from emp01;


create table emp05
as
select employee_id, first_name, salary from employees
where 1=0;

select * from emp05;

--insert--
insert into emp05
select employee_id, first_name, salary from employees where department_id = 60;

insert into emp05
select department_id, department_name, 0 from departments;
select department_id, department_name, 0 from departments;
select department_id, department_name, 0 from departments;



--alter--
select * from emp05 order by 1;

commit;

update emp05
set salary=20000, first_name='����DS'
where employee_id =103;

rollback; --���ݱ��� ������ ��� DML�� ���󺹱��Ѵ�

--104�� ������ �޿��� 107�� ������ �޿��� ���� �Ѵ�
update emp05
set salary=(select distinct salary from emp05 where employee_id=107)
where employee_id=104;


delete from emp05
where employee_id =103;

create table emp06
as
select * from employees;


create table emp07
as
select * from employees;
where job_id = 'IT_PROG';

select * from emp06;

update emp07
set job_id = 'firs_zone';

commit;

insert into emp07
values(999,'a','b','zz','1234',sysdate,'aa',1000, 0.1,100,60);

merge into emp06 using emp07 on(emp06.employee_id = emp07.employee_id)
when matched then
        update set emp06.job_id = emp07.job_id
when not matched then
        insert   values(
                        emp07.employee_id,
                        emp07.first_name,
                        emp07.last_name,
                        emp07.email,
                        emp07.phone_number,
                        emp07.hire_date,
                        emp07.job_id,
                        emp07.salary,
                        emp07.commission_pct,
                        emp07.manager_id,
                        emp07.department_id);

--transaction : �ϳ��� ���� �۾�����
--��ü ���� :


select *
from employees
where department_id=60
and job_id = 'IT_PROG'
and hire_date>=sysdate-20*365
and salary>=0;

insert into employees values(?,?,?,?,?,?,?,?,?,?,?);
insert into employees values(999,'a','b','zz','1234',sysdate,'IT_PROG',1000, 0.1,100,60);

desc employees;

update employees
set 
FIRST_NAME=?,
LAST_NAME=?,
EMAIL=?,
PHONE_NUMBER=?,
HIRE_DATE=?,
JOB_ID=?,
SALARY=?,
COMMISSION_PCT=?,
MANAGER_ID=?,
DEPARTMENT_ID=?
where EMPLOYEE_ID=?
;
rollback
;


desc user_constraints;
select *
from user_cons_colums;



drop table customer;
drop table customer2;

--foreign key : �ܷ�Ű, ����Ű, �ٸ� ���̺� or ���� ���̺��� PK�� ������
--Į�� �������� �����ϱ�
--default ���� �������Ǻ��� �պκп� �����Ѵ�
create table customer(
    cust_id number constraints customer_cid_pk primary key,--primary key=>not null+unique
    cust_name varchar2(30) not null, --�� �־�� �Ѵٴ� ��
    email varchar(5) constraint customer_email_uk unique,--unique�� null�� �����
    deptid number constraint customer_deptid_fk references departments(department_id),--null �����, ����Ű>>�ݵ�� �θ�Ű�� �����ؾ� ��
    point2 number constraint customer_point_check check(point2>0),--check ���ǿ� ����
    gender char(3) default '��' constraint customer_gender_check check(gender in ('��','��'))--�ѱ��� �� �ڴ� 3byte
);

--���̺� �������� �����ϱ�
create table customer2(
    cust_id number.
    cust_name varchr2(30) not null,
    email varchar(30),
    deptid number,
    point2 number,
    gender char(3),
    constraint customer_cust_id_pk2 primary key(cust_id),
    constraint customer_email_uk2 unique(email),
    constraint cusomer_deptid_fk2 foreign key(deptid) references departments(department_id),
    constraint customer_point_check2 check(point2>0),
    constraint customer_gender_check2 check(gender in ('��','��'))
}
    

insert into customer(cust_id) values(1);
insert into customer(cust_id,cust_name) values(1,'��浿');
insert into customer(cust_id,cust_name,email) values(2,'��浿','dde3');
insert into customer(cust_id,cust_name,email) values(3,'��浿','dde34');
insert into customer(cust_id,cust_name,email) values(4,'��浿','dde35');
insert into customer(cust_id,cust_name,email,deptid) values(5,'��浿','dde36',10);
insert into customer(cust_id,cust_name,email,deptid, point2) values(6,'��浿','dde37',10,1000);
insert into customer(cust_id,cust_name,email,deptid, point2, gender) values(7,'��浿','dde38',10,1000,'��');

select * from customer where cust_id = 1;

select * from user_constraints;