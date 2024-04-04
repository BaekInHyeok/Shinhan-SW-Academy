--단일행 함수 >> 1건->1건--
select first_name,email, lower(email) --3
from employees --1
where job_id='IT_PROG' --2
and length(first_name)>5
order by 1; --4

--다중행 함수 : 여러 건 ->1건, 칼럼 이름을 사용하면 null이 제외됨--

select avg(salary),sum(salary), max(salary),count(salary), count(department_id), count(commission_pct) "null 제외 count", count(*) "null 포함 count"
from employees;

select sum(department_id)/106, avg(department_id)
from employees;

select count(distinct department_id)
from employees;

select distinct department_id
from employees;

--부서별로 값 구하기--
select department_id, avg(salary),sum(salary), max(salary),count(salary), count(department_id), count(commission_pct) "null 제외 count", count(*) "null 포함 count"
from employees
group by department_id;

--select 절에 사용한 칼럼이 집계함수를 사용하지 않았다면 반드시 group by 절에 참여해야 한다--
--집계합수는 where 조건절에 사용 불가--
--조건을 위해서는 having을 사용
--rollup은 대그룹 중간합계를 제공한다는 뜻
--grouping : 해당 칼럼 값이 null이면 1이 출력됨
select department_id 부서별, job_id 직책별, sum(salary) 급여합계, count(*) 직원수, count(commission_pct)
,grouping(department_id), grouping(job_id)--5
from employees --1
where department_id is not null --2
group by rollup(department_id, job_id) --3
--having count(*)>10--4
order by 부서별;--6

--cube는 모든 조합에 대한 합계 제공
select department_id 부서별, decode (grouping(job_id),1,department_id||' 부서의 합계',job_id) 직책별, sum(salary) 급여합계, count(*) 직원수, count(commission_pct)
,grouping(department_id), grouping(job_id)--5
from employees --1
where department_id is not null --2
group by cube(department_id, job_id) --3
--having count(*)>10--4
order by 부서별;--6


select department_id, LISTAGG(first_name, ', ') WITHIN GROUP (ORDER BY first_name) over(PARTITION by job_id)"부서별 직원들"
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

--cross join : 조인 문장이 없는 경우 *건수만큼 나옴
select first_name, department_name
from employees, departments
order by first_name;

--equi join : = 연산자로 조인
--기준은? :직원이 부서를 참조 >> 건수는 직원 건수
select first_name, department_name
from employees, departments
where employees.department_id = departments.department_id
order by first_name;

select employees.first_name, employees.salary, jobs.job_title, jobs.max_salary
from employees, jobs
where employees.job_id = jobs.job_id
order by first_name;

--부서 테이블에 manager_id는 부서장이다(직원 중 1명)
--부서장의 이름은?
select departments.*, employees.first_name, salary, employees.last_name, departments.manager_id
from employees, departments
where employees.employee_id = departments.manager_id;

select first_name, department_name, emp.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id;

--벤더 문법(Oracle,Sybase, MySQL, Maria, Postge...)
select first_name, department_name, emp.department_id
from employees emp, departments dept
where emp.department_id = dept.department_id(+);

--표준 문법
--using은 조인할 테이블에 같은 이름의 칼럼으로 조인시 사용
--on절 이용(칼럼 이름이 다른 경우의 조인)
select first_name, department_name, emp.department_id
from employees emp join departments dept using(department_id)
where department_id>0;

select first_name, department_name, emp.department_id
from employees emp join departments dept on(emp.department_id=dept.department_id)
where emp.department_id>0;

--non-equi 조인
select * from emp;
select*from salgrade;

--벤더문법
select emp.*, salgrade.*
from emp, salgrade
where emp.sal between losal and hisal;

--표준문법
select emp.*, salgrade.*
from emp join salgrade
on (emp.sal between losal and hisal);


--셀프 조인 : 참조하고자 하는 칼럼이 자신의 테이블에 있는 경우, 하나의 테이블을 2번 열어서 조인한다--
select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원, employees 매니저
where 직원.manager_id=매니저.employee_id;

select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원 inner join employees 매니저
on(직원.manager_id=매니저.employee_id)
order by 직원.employee_id;

--Outer Join:조인 조건에 맞지 않는 행도 조회(없는 쪽에 +를 넣는다)
select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원, employees 매니저
where 직원.manager_id=매니저.employee_id(+) --Oracle만 지원, sybase:*이용
order by 직원.employee_id;

select 직원.first_name, 직원.salary, 매니저.first_name, 매니저.salary
from employees 직원 left outer join employees 매니저
on(직원.manager_id=매니저.employee_id)
order by 직원.employee_id;

select 직원.first_name, 직원.salary, nvl(매니저.first_name,'매니저 없음'), nvl2(매니저.salary,to_char(매니저.salary),'매니저 없음')
from employees 직원 right outer join employees 매니저
on(직원.manager_id=매니저.employee_id)
order by 직원.employee_id;

--직원의 부서정보 보기--
select first_name, salary, nvl(department_name,'부서없음')
from employees left outer join departments
on(employees.department_id = departments.department_id);

select nvl(first_name,'직원 없음'), salary, nvl(department_name,'부서없음')
from employees full outer join departments
on(employees.department_id = departments.department_id);

select first_name, salary, nvl(department_name,'부서없음')
from employees inner join departments --inner는 생략 가능
on(employees.department_id = departments.department_id);


-----서브쿼리------

--니나와 같은 부서에 근무하는 직원들의 이름과 급여를 조회하기
select first_name, salary, department_id
from employees
where department_id=
(select department_id
from employees
where first_name = 'Neena');

--David와 같은 직책을 가진 직원들의 이름과 급여를 조회하기
--=Any와 in은 같은 뜻이다
select *
from employees
where job_id in
(select job_id
from employees
where first_name='David');


--평균급여보다 더 높은 급여를 받고 있는 직원들의 이름과 급여 조회
select first_name, salary
from employees
where salary>
(select avg(salary)
from employees);

--급여가 10000 이상인 직원 부서와 같은 부서인 직원들을 조회
select first_name, salary, department_id
from employees
where department_id in--=ANY와 같은 연산자
(select distinct department_id
from employees
where salary >=10000);

-- 60번 부서에 근무하는 모든 직원의 급여보다 높은 급여를 받는 직원들을 조회

-- >ALL은 모두보다 크다 >> 가장 큰 것보다 크다는 뜻
select first_name, salary
from employees
where salary>all
(select salary
from employees
where department_id=60);

-- >ANY는 아무거나보다 크다 >> 최소보다 크면 된다
select first_name, salary
from employees
where salary>any
(select salary
from employees
where department_id=60);

-- <ALL은 모두보다 작다 >> 최소보다 작다
select first_name, salary
from employees
where salary <all
(select salary
from employees
where department_id=60);

-- <ANY는 아무거나보다 작다 >> 최대보다 작으면 됨
select first_name, salary
from employees
where salary <any
(select salary
from employees
where department_id=60);

--단일행 서브쿼리 : 서브쿼리 결과가 1건
--다중행 서브쿼리 : 서브쿼리 결과가 2건 이상(>ANy, >ALL, IN...)
--다중 칼럼 서브쿼리
--부서별 최소 급여를 받는 직원 정보 조회
select *
from employees
where(department_id,salary) in (
select department_id, min(salary)
from employees
group by department_id);

--본인이 받는 급여가 본인이 속한 부서의 평균 급여보다 적은 직원들의 정보
--상관서브쿼리
select *
from employees outeremp
where salary<(select avg(salary) from employees where department_id =outeremp.department_id);

----from절에 subquery(인라인뷰)를 이용한 조인-----
--select절에 subquery(스칼라서브쿼리)
select employees.*, inlineview.avgsal,(select avg(salary) from employees) "전체평균"
from(
select  department_id, avg(salary) avgsal
from employees
group by department_id)inlineview, employees
where inlineview.department_id=employees.department_id 
and salary<inlineview.avgsal;



