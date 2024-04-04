========================================
		단일행 함수(1건이 입력>>1건이 출력)
========================================

select * from tab;
desc employees;

select * from employees;

--조회:select
--작성순서:select > from > where > order by
--실행순서:from > where > select > order by

select employee_id, first_name, salary 급여 --3
from employees --1
where salary>=10000 --2
order by 3; --4 : order by 시, 칼럼의 이름, 별명, select 순서를 이용해 지정 가능. 여기서는 salary가 된다.

select *
from employees
where salary>=10000
and commission_pct is not null
and first_name like '_____'
order by 2; 

--바람직하지 않은 코드
select DISTINCT 10+20
from employees;

--dual은 소유자가 sys(hr 거 아님) >> 1건의 data를 조회해야 하는 경우 사용
desc dual;
select * from dual;

select 10+20, sysdate
from dual;

--1. 숫자 함수
select 12.5, round(12.5) 반올림, round(12.56,1) "소수 첫째자리 반올림", FLOOR(15.7) 버림, ceil(15.1) 올림
,mod(10,3)
from dual;

--2.문자처리 함수(concat은 다른 DB에도 존재, ||는 오라클에서만, MySQL에서는 +로 연결
select first_name, UPPER(first_name), lower(first_name),INITCAP(email), SUBSTR(first_name,1,3) "시작위치+추출개수"
, LENGTH(first_name) 길이 , first_name||' '||last_name "||로 합치기" , concat(concat(first_name,' '),last_name) "concat으로 합치기"
from EMPLOYEES;

--SCOTT사용자에서 작업
--job이 manager인 직원 조회
--''로 값을 감사면 대소문자를 구별한다
select *
from emp
where job = upper('manager');

--나의 DB_HR에서 작업

--만약 job_id가 index로 만들어져 있다면, 칼럼의 값을 조작하지 않는 것이 더 효율적
select *
from employees
where job_id = upper('it_prog');

select *
from employees
where lower(job_id)= lower('it_prog'); --칼럼값을 건드리는 거라 안 좋음

--jobs에서 manager만 찾고 싶음
select *
from jobs
where job_title like '%Manager';

select *
from jobs
where substr(job_title,-7) = initcap('manager'); --연산자는 like보단 =이 더 낫다

--날짜 잘라보기(12월 입사자 대상)
select first_name, hire_date, substr(hire_date,1,2) 년도, substr(hire_date, 4,2) 월, substr(hire_date, 7,2) 일
from employees
where to_char(hire_date,'MM')=12;
--where substr(hire_date,4,2) = 12;
--where hire_date like '__/12/__';

--특정 문자 위치 찾기
--뒤에서부터 탐색 >> -시작위치
select first_name, INSTR(first_name,'e') "처음 만나는 위치", INSTR(first_name,'e',2) "특정 위치에서 시작", INSTR(first_name,'e',-1) "뒤에서부터 탐색"
,INSTR(first_name,'e',2,2) "2 시작, 2번째 만남"
from employees;

--주의 : data가 길면 잘린다
select first_name, lpad(first_name,10,'*') "10자리 display", rpad(first_name,20,'#')
from employees;

select '*'||ltrim(' Oracle ')||'*' "왼쪽 공백 제거", '*'||rtrim(' Oracle ')||'*' "오른쪽 공백 제거",'*'||trim(' Oracle ')||'*' "양쪽 공백 제거",
trim('a' from 'aaaaaaaaaaOracleaaaaaaa') "특정 문자 제거"
from dual;

select first_name, trim('A'from first_name)
from employees;

--날짜
select first_name, hire_date, sysdate+1 "내일", floor(sysdate - hire_date) "근무일수(버림)", round(MONTHS_BETWEEN(SYSDATE,hire_date)/12,1) 근무년수
, add_months(hire_date,6) "입사 6개월 후", sysdate-22 "현재 날짜 22일 전", 
last_day(hire_date) "입사월의 마지막 날짜", next_day(sysdate,'월요일') "다음 월요일", next_day(hire_date,'화요일') "입사일 다음 화요일"
,to_char(hire_date,'yyyy/mm/dd hh:mi:ss DAY D DY')
,round(hire_date,'MM') "월 반올림(16일 기준)", trunc(hire_date,'MM') "일 버림"

from employees
order by 근무년수 desc;

select sysdate, to_char(sysdate,'yyyy/mm/dd hh:mi:ss DAY D DY MON hh24 AM/PM'),
to_Char(100000,'L999,999,999,999') "채우지 않음", to_char(10000000,'L000,000,000,000') "채움"
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

--nvl(칼럼, null일 때 대체값)
--nvl2(칼럼, null 아닐 때, null일 때) >> 타입을 통일해야 함
select first_name,salary
,nvl(to_char(commission_pct),'커미션 없음') "nvl로 구현"
,nvl2(commission_pct,to_char(commission_pct),'커미션 없음') "nvl2로 구현", salary+salary*nvl(commission_pct,0) 실수령액
,nvl(to_char(department_id),'부서없음')
from employees
--where department_id is null
--where nvl(to_char(department_id),'부서없음') = '부서없음'
order by commission_pct nulls first;


select COALESCE(to_char(commission_pct),to_char(department_id), first_name)
from employees;

--decode는 = 연산자가 생략된 것. 즉 = 경우에만 가능
--case는 SQL문에서 허락되는 모든 연산자가 가능함
select first_name, salary,decode(salary, 24000,'매우 많음',17000,'많음',12000,'적당','적음') 급여평가,
    decode(length(first_name),9,'large',6,'middle','small')이름길이,
    case when salary>=20000 then '많음'
         when salary>=10000 and salary<20000 then '적당'
         when salary < 10000 and salary >=5000 then '적음'
         else '모자람' end 급여평가2,
    job_id,
    decode(job_id,'AD_PRES','A','AD_VP','A','IT_PROG','A','B') job2,
    case when job_id in ('AD_PRES','AD_VP','IT_PROG') then 'A' else 'B' end job3

from EMPLOYEES;


=============Group 함수==================


