-- 9장.DDL : 테이블 구조 생성,변경,삭제

-- LOB(LARGE OBJECT) : IMAGE, VIDEO 
-- ROWID 테이블에서 행의 위치를 지정하는 논리적인 주소값 : 실제 데이터가 저장된 위치로 DBMS가 사용 : INDEX(목차)
-- ROWNUM : SELECT된 순서
SELECT ROWID, ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC; -- SELECT 했을때 숫자이므로 DESC하면 숫자가 섞임
-- 급여를 가장 많이받는 상위 10명 
SELECT rownum, aa.*
FROM( SELECT ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC) AA
WHERE ROWNUM <= 10;
-- rownum이 6인애를 찾아보기 rr을 만들어서 수행
SELECT *
FROM( SELECT rownum rr, aa.*
        FROM( SELECT ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC) aa)
WHERE rr = 6;
-- 급여가 상위 6~10까지
SELECT ROWNUM,FIRST_NAME,SALARY FROM EMPLOYEES ORDER BY SALARY DESC; -- 순서가 SELECT 후 ROWNUM이 부여되고 ORDER BY를 하고 DISPLAY한다.

SELECT  ROWNUM, BB.*
FROM (
        SELECT ROWNUM RR, AA.*
        FROM ( SELECT ROWNUM, FIRST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC) AA) BB
WHERE RR BETWEEN 6 AND 10;
-- TIMESTAMP : DATE 형의 확장된 형태
-- INTERVAL YEAR TO MONTH
-- CHAR : 고정길이 문자데이터
-- VARCHAR2 : 가변길이 문자데이터
-- NUMBER : 
-- DATE :

------------------------------------------------------------------------------- DDL(DATA DEFINITION LANGUAGE) : CREATE TABLE, ALTER TABLE, DROP TABLE, RENAME, TRUNCATE : 자동 COMMIT복구불가
-- 새로운 테이블 생성
CREATE TABLE EMP01(
 EMPNO NUMBER(4),
 ENAME VARCHAR2(20),
 SAL NUMBER(7,2) -- 전체 7자리 소수밑에 2자리
);
CREATE TABLE EMP02(
 EMPNO NUMBER(4),
 ENAME VARCHAR2(20),
 SAL NUMBER(7,2)
);
SELECT * FROM TAB;

-- 서브쿼리로 데이터 저장? : 데이터 백업에 사용 : 구조 만들고 데이터도 저장
                                                                        
                                                                                --  CREATE TABLE
--CREATE TABLE EMP02 AS SELECT * FROM EMP;
CREATE TABLE EMP_03 
AS
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

DESC EMP_03;
SELECT * FROM EMP_03;

-- 테이블 구조는 복사하고 DATA는 복사하지 않기
CREATE TABLE EMP_04
AS
SELECT * FROM EMPLOYEES
WHERE 1=0; -- SELECT에 부정 조건 넣어서 테이블 구조만 복사가능
SELECT * FROM EMP_04;

                                                                                -- ALTER TABLE 
-- 컬럼 추가 ADD(컬럼명 타입)
ALTER TABLE EMP_03 ADD(JOB VARCHAR2(20));
DESC EMP_03;
SELECT * FROM EMP_03;
-- 컬럼 수정 MODIFY(컬럼명 타입)
ALTER TABLE EMP_03 MODIFY(FIRST_NAME VARCHAR2(20));
-- 컬럼 삭제 DROP COLUMN 컬럼명
ALTER TABLE EMP_03 DROP COLUMN FIRST_NAME;
ROLLBACK; -- DDL은 ROLLBACK 불가
-- SET UNUSED 사용하고 이후에 DROP 사용
ALTER TABLE EMP_03
set unused(JOB);
-- 테이블 삭제 DROP TABLE 테이블명
DROP TABLE EMP_03;

SELECT * FROM EMP01;

-- TRUNCATE : 구조는 유지하고, 데이터만 삭제
TRUNCATE TABLE EMP01; 

-- DD(Data Dictionary)
SELECT * FROM USER_TABLES; -- 내가 가지고 있는 테이블들의 정보 
SELECT * FROM ALL_TABLES; -- 공개된 모든 테이블 정보 (권한존재) : 타계정의 객체는 원칙적으로는 접근 X
SHOW USER; -- 내가 누군지
--DBA_딕셔너리 : DBA_TABLES : DBA로 들어가면 볼 수 있음


----------------------------------------------------------------------------------- DML(DATA MANIPULATION LANGUAGE) : INSERT, DELETE, UPDATE : 자동 COMMIT이 아님 : 복구가능
INSERT INTO EMP01 VALUES (100,'백인혁',1000); 
SELECT * FROM EMP01; -- 같은 세션에서는 확인되지만 다른 세션에서는 확인불가
COMMIT; -- DB에 실제로 저장된다.


desc emp01;


insert into emp01(EMPNO,ENAME,SAL) values(1,'aa',500);
insert into emp01(EMPNO,ENAME,SAL) values(1,'aa',500,600); -- too many values
insert into emp01(EMPNO,ENAME,SAL) values(1,aa,500);--missing expression
insert into emp01(EMPNO,SAL,ENAME) values(1,'aa',500);--invalid number(Type 오류)
insert into emp01(EMPNO,SAL) values(1,500);--암시적 null 삽입
insert into emp01(EMPNO,SAL) values(2,600);--암시저
insert into emp01(EMPNO,ENAME,SAL) values(1,null,500);--명시적으로 null 삽입
insert into emp01(EMPNO,ENAME,SAL) values(1,null,null);--명시적으로 null 삽입

insert into emp01(EMPNO,ENAME,SAL) values(1,'aa',500);
insert into emp01 values(1,'aa'); --not enough values >> 칼럼의 갯수는 3인데 값이 2개이므로 모자람

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
set salary=20000, first_name='신한DS'
where employee_id =103;

rollback; --지금까지 수행한 모든 DML을 원상복귀한다

--104번 직원의 급여를 107번 직원의 급여와 같게 한다
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

--transaction : 하나의 논리적 작업단위
--이체 업무 :


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

--foreign key : 외래키, 참조키, 다른 테이블 or 같은 테이블의 PK를 참조함
--칼럼 레벨에서 정의하기
--default 값은 제약조건보다 앞부분에 정의한다
create table customer(
    cust_id number constraints customer_cid_pk primary key,--primary key=>not null+unique
    cust_name varchar2(30) not null, --꼭 넣어야 한다는 뜻
    email varchar(5) constraint customer_email_uk unique,--unique는 null을 허용함
    deptid number constraint customer_deptid_fk references departments(department_id),--null 허용함, 참조키>>반드시 부모키가 존재해야 함
    point2 number constraint customer_point_check check(point2>0),--check 조건에 만족
    gender char(3) default '남' constraint customer_gender_check check(gender in ('남','여'))--한글은 한 자당 3byte
);

--테이블 레벨에서 정의하기
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
    constraint customer_gender_check2 check(gender in ('남','여'))
}
    

insert into customer(cust_id) values(1);
insert into customer(cust_id,cust_name) values(1,'김길동');
insert into customer(cust_id,cust_name,email) values(2,'김길동','dde3');
insert into customer(cust_id,cust_name,email) values(3,'김길동','dde34');
insert into customer(cust_id,cust_name,email) values(4,'김길동','dde35');
insert into customer(cust_id,cust_name,email,deptid) values(5,'김길동','dde36',10);
insert into customer(cust_id,cust_name,email,deptid, point2) values(6,'김길동','dde37',10,1000);
insert into customer(cust_id,cust_name,email,deptid, point2, gender) values(7,'김길동','dde38',10,1000,'남');

select * from customer where cust_id = 1;

select * from user_constraints;