--급여를 가장 많이 받은 직원 상위 5명 조회
select rownum,aa.*
from(
select first_name, salary
from employees
order by salary desc
) aa
where rownum<=5;

--급여를 5번째로 많이 받는 직원 조회
select *
from(
    select rownum rr,aa.*
    from(
        select first_name, salary
        from employees
        order by salary desc) aa)bb
where bb.rr=5;

--row_number() : 중복 없이 전체 순위 지정
--rank() : 중복 랭크 제외하고 순위 지정
--dense_rank() : 중복 랭크를 하나의 순서로 지정
select *
from(
select first_name,salary,
row_number() over (order by salary desc) 랭크1,
rank() over (order by salary desc) 랭크2,
dense_rank() over (order by salary desc) 랭크3
from employees)
where rownum<=5;

--table 복사(employees->emp_copy) : 제약 조건 중 not null만 복사됨
--table 복사(departments->dept_copy)
--DDL(create table, drop table, rename, truncate, alter table):자동 commit됨
create table emp_copy
as
select * from employees where department_id = 60;

create table dept_copy
as
select * from departments where manager_id is not null;

select * from user_constraints where table_name='EMP_COPY';
select * from user_cons_columns where table_name='EMP_COPY';

select * from user_constraints where table_name='DEPT_COPY';

--무결성 : 제대로 된 데이터만 입력 가능
--제약 조건 추가하기
alter table emp_copy add constraint emp_copy_empid_pk Primary key(employee_id);
alter table dept_copy add constraint dept_copy_empid_pk Primary key(department_id);

alter table dept_copy drop constraint dept_copy_deptid_pk cascade;

alter table emp_copy add constraint emp_copy_deptid_fk FOREIGN KEY (department_id) references dept_copy(department_id);

select * from emp_copy;
select * from dept_copy;

--DML(insert,delete,update):저장확정 commit,저장취소 rollback
insert into emp_copy values(108,'aa','bb','cc','444',sysdate,'aa',1000,null,333,100);
insert into emp_copy values(109,'aa1','bb1','cc1','444',sysdate,'aa',1000,null,333,77);
delete from emp_copy where department_id =77;
commit;

--VIEW(가상의 테이블, select문만 저장) : 뷰를 통해서 테이블을 이용
--or replace : 존재하면 대체
--noforce:컴파일 오류이면 생성불가
--force:컴파일 오류가 있어도 생성
create or replace view emp_dept60_view 
as
select * from employees where department_id = 60 with check option;

select * from user_views;--data 사전 검사, select 문이 저장되어 있음
select * from emp_dept60_view;--뷰를 통해서 실제 table의 data 조회

update emp_dept60_view
set salary=9999
where employee_id=107;

rollback;

update emp_dept60_view
set department_id=90
where employee_id=107;

--직원이 근무하는 부서가 위치하는 국가를 출력하시오
--복잡한 SQL문이 자주 사용된다면 VIEW로 미리  만든다. DML은 불가능
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

---------시퀀스 : 자동 번호 생성기(Oracle에서만 제공, mysql에서는 autoincrement)-------------
----시퀀스는 크게 의미 없는 키값을 넣어도 괜찮은 경우에만 사용한다
--1부터 시작해서 1씩 증가
create sequence board_seq;

create table board(
    bno number constraint board_bno_PK primary key,
    title varchar2(50) not null,
    content varchar2(2000),
    writer varchar2(30),
    create_date date default sysdate
);

insert into board(bno,title) values(999,'금요일');
insert into board values(board_seq.nextval,'금요일','꽃구경 갑시다','jin',sysdate);
delete from board where bno=5;
select * from board;

select * from user_sequences;

select * from departments;
insert into departments values(DEPARTMENTS_SEQ.nextval,'test',null,null);

----index(색인):검색 속도 향상 목적, 단점:만드는 데 시간 소요. 공간 차지
----Oracle은 Primary Key가 자동으로 index로 만들어진다. 추가 가능
----Index 설정한 칼럼을 조작하면(함수사용), Index는 사용되지 않게 됨을 주의
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


----index 있을 때와 없을 때를 비교해보기
create table emp_copy2 --구조+데이터 복사, not null 제약조건은 복사됨. 나머지 제약 조건은 복사 안 됨 >> index도 없는 상태
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