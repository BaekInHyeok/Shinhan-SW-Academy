
hr/hr
========================================
		SELECT 기본
========================================

1. 급여가 15000 이상인 직원들의 이름, 급여, 부서id를 조회하시오.

select first_name, salary, department_id
from employees
where salary>=15000;

2. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.
   연봉은 급여(salary)에 12를 곱한 값입니다.

select first_name, salary*12 "연봉"
from employees
where salary*12>=170000;

3. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오.

select first_name, salary
from employees
where department_id is null;

4. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

select first_name,salary,hire_date
from employees
where hire_date <='04/12/31';

select first_name,salary,hire_date
from employees
where to_char(hire_date,'yyyy')<='2004';

--년도: yyyy
--년도 : yy
--년도: RR(50 이상이면(50~99) >>앞에 1900. 미만이면(0~49)>>앞에 2000) -> Oracle은 RR/MM/DD

select * from nls_session_parameters;
--기본 설정:NLS_DATE_FORMAT>>RR/MM/DD
alter session set NLS_DATE_FORMAT='yyyy/mm/dd';
alter session set NLS_DATE_FORMAT='RR/MM/DD';

-- 논리연산자 -- 
1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.

select first_name, salary, department_id
from employees
where department_id in(50,80)
and salary>=13000;


2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 
이름, 급여, 부서id, 입사일을 조회하시오.

select first_name, salary, department_id, hire_date
from employees
where salary>=1300 and salary<=20000;


-- SQL 비교연산자 --
1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.

select first_name, salary, department_id
from employees
where department_id in(50,80) and salary>=1300 and salary<=20000;

2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 30000 이하인 직원들의 
이름, 급여, 부서id, 입사일을 조회하시오.

select first_name, salary, department_id, hire_date
from employees
where hire_date>='05/01/01' and salary>=1300 and salary<=30000;

3. 2005년도 입사한 직원의 정보만 출력하시오.

select *
from employees
where hire_date>='05/01/01' and hire_date<='05/12/31';


4. 이름이 D로 시작하는 직원의 이름, 급여, 입사일을 조회하시오.

select first_name, salary, hire_date
from employees
where first_name like 'D%';

5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

select first_name, salary, hire_date
from employees
where to_char(hire_date,'MM')='12';

select first_name, salary, hire_date
from employees
where hire_date like '__/12/__';

6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.

select first_name, salary, hire_date
from employees
where first_name like '%le%';


7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.

select first_name, salary, hire_date
from employees
where first_name like '%m';


8. 이름의 세번째 글자가 r인 이름, 급여, 입사일을 조회하시오.

select first_name, salary, hire_date
from employees
where first_name like '__r%';


9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.

select first_name, commission_pct, salary
from employees
where commission_pct is not null;

10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.

select first_name, commission_pct, salary
from employees
where commission_pct is null;

11. 2000년대에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.

--invalid identifier : 칼럼 이름 오류
--invalid relational operator : 연산자 오류
--table or view does not exist : 테이블 이름 오류

select first_name, commission_pct, salary, hire_date
from employees
where hire_date>='00/01/01' and hire_date<='09/12/31'
and department_id in (30,50,80)
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date asc, salary desc;
