-------------
--나의DB_HR--
-------------
select * from tab;
select * from employees;

desc employees;

--*는 모든 컬럼을 의미함
select *
from employees;

--칼럼 나열하기, 별명 사용 가능, as는 생략 가능
select employee_id as 직원번호, first_name 직원이름
from employees;

--직원들이 근무하는 부서들(중복제거 >> distinct)
select distinct department_id
from employees;

--null:정의된 값이 없다. 부서값이 없다.
select distinct department_id,first_name,last_name
from employees;

--invalid identifier 유효하지 않은 식별자, 칼럼 이름이 틀림.
--table 생성하면 Data Dictionary에 칼럼 이름이 대문자로 들어간다.(ORACLE)
--SQL문에서 ""를 사용하면 식별자이름이다.
--SQL문에서 ''는 값을 의미한다.
--||dms concat연산자(문자열 연결)
--null은 =으로 값 비교 불가(is null 사용), 계산 불가
--nvl(commission_pct,1):null인지 체크해서 값 변경

--산술연산자
select first_name, last_name, salary, salary*12 "연~봉",10+20, last_name||'->'||salary,commission_pct,nvl(commission_pct,1)*Salary
from employees
where commission_pct is null
;

select first_name, last_name, salary, commission_pct, nvl(commission_pct,0)*salary+salary "실제 급여"
from employees
where department_id is not null
;

select '이름:'||first_name||' '||last_name||' 급여:'||salary "직원소개"
from employees
;

--이전 이후는 해당 날짜를 포함한다
--2005년 1월 30일 이후에 입사한 직원 조회 조건도 추가
--Oracle은 자동 형변환 제공 ex)'10000' -> 10000, 'hire_date'->to_date('05/01/30')
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

----급여가 10000 이상 20000 이하
select *
from employees
where salary>=10000 and salary<=20000;
    
select *
from employees
where salary between 10000 and 20000;

----부서가 60,90,100인 직원 조회
select *
from employees
where department_id=60 or department_id=90 or department_id=100;

select *
from employees
where department_id in(60,90,100);


----부서가 60,90,100가 아닌 직원 조회
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
--%:하나 이상의 임의의 문자
--_:하나의 임의의 문자
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

------정렬-------
--asc : 생략가능, Oracle에서는 null이 마지막에 나옴
select*
from employees
where manager_id is not null
order by commission_pct asc;

--nulls first : null이 먼저 나오게 바꾸기--
select*
from employees
where manager_id is not null
order by commission_pct asc nulls first;

--desc : 생략 불가, null이 먼저 나옴--
select*
from employees
where manager_id is not null
order by commission_pct desc;

--nulls last : null이 나중에 나오게 바꾸기--
select*
from employees
where manager_id is not null
order by commission_pct desc nulls last;

--CRUD 작업
--insert(Create)
--select(Read)
--update(Update)
--delete(Delete)

--select Display할 정보들(*, 칼럼들, 수식, 함수, distinct, 별명...)
--from 테이블들
--where 조건들(비교연산자, 논리연산자...)
--order by 칼럼 asc, 칼럼 desc

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
--SCOTT사용자--
--------------

select*
from emp
where MGR is null;

