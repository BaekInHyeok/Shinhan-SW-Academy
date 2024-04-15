--1.설정하기
set SERVEROUTPUT on;

--2.선언하기
declare
    --스칼라 타입
    v_empid number(10):=100;
    v_fname varchar2(40);
    
    --참조타입
    v_empid2 employees.employee_id%type:=200;
    v_fname2 employees.first_name%type:='신한금융';
    v_empRecord employees%rowtype;

--3.작성해서 실행하기
begin
    v_fname:='스티븐';
    DBMS_OUTPUT.put_line('---------');
    DBMS_OUTPUT.put_line('v_empid='||v_empid);
    DBMS_OUTPUT.put_line('v_fname='||v_fname);
    DBMS_OUTPUT.put_line('v_empid2='||v_empid2);
    DBMS_OUTPUT.put_line('v_fname2='||v_fname2);
    
    select first_name
    into v_fname
    from employees
    where employee_id = v_empid;
    
    select *
    into v_empRecord
    from employees
    where employee_id = v_empid2;
    
    DBMS_OUTPUT.put_line('select 후 v_fname='||v_fname);
    DBMS_OUTPUT.put_line('select 후 v_empRecord='||v_empRecord.first_name);
    DBMS_OUTPUT.put_line('select 후 v_empRecord='||v_empRecord.salary);
end;
/
--:=:대입하기
--DBMS_OUTPUT:패키지 이름
--put_line():함수, 자바의 pirntln()과 같다.
--"":식별자
--'':값
--/:실행하기

declare
    --타입 정의
    type fnameType_table is table of employees.first_name%type index by binary_integer;
    type empRecordType is record(
        v_empid employees.employee_id%type,
        v_fname employees.first_name%type,
        v_salary employees.salary%type,
        v_salary2 number(8,2)
    );
    --변수 선언
    fname_arr fnameType_table;
    v_emp empRecordType;
    
    --첨자 선언
    index2 BINARY_INTEGER:=0;
begin
    select employee_id, first_name, salary, salary
    into v_emp
    from employees
    where employee_id=100;
    dbms_output.put_line('직원번호:'||v_emp.v_empid);
    dbms_output.put_line('직원이름:'||v_emp.v_fname);
    dbms_output.put_line('직원급여:'||v_emp.v_salary);
    dbms_output.put_line('직원급여-스칼라타입:'||v_emp.v_salary2);
    
    if(v_emp.v_salary>10000) then
        dbms_output.put_line('급여가 높다');
    end if;
    
    for fnameRec in(select first_name from employees where department_id=60) loop
        index2 := index2+1;
        fname_arr(index2) := fnameRec.first_name;
        dbms_output.put_line('Record:'||fnameRec.first_name||'배열:'||fname_arr(index2));
    end loop;
end;
/

declare
    i number := 1;
begin
    loop
        DBMS_OUTPUT.PUT_LINE('i='||i);
        i:=i+1;
        if i>5 then
            DBMS_OUTPUT.PUT_LINE('i는 5까지');
            exit;
        end if;
    end loop;
    dbms_output.putline('----');
    
    
end;
/


create or replace PROCEDURE sp_empall(v_deptid employees.department_id%type)
is
begin
    for empRecord in(select * from employees where department_id=v_deptid) loop
        dbms_output.put_line(empRecord.first_name);
        dbms_output.put_line(empRecord.email);
        dbms_output.put_line(empRecord.salary);
        dbms_output.put_line(empRecord.department_id);
        dbms_output.put_line('--------------');
    end loop;
end;
/

create or replace PROCEDURE sp_empsal(v_salary employees.salary%type)
is
begin
    for empRecord in(select * from employees where salary>=v_salary) loop
        dbms_output.put_line(empRecord.first_name);
        dbms_output.put_line(empRecord.email);
        dbms_output.put_line('급여:'||empRecord.salary);
        dbms_output.put_line('부서코드:'||empRecord.department_id);
        dbms_output.put_line('--------------');
    end loop;
end;
/
execute sp_empall;
execute sp_empall(90);
execute sp_empsal(10000);

create or replace procedure sp_empinfo(v_empid in employees.employee_id%type,
    v_fname out employees.first_name%type,
    v_job out employees.job_id%type,
    v_salary out employees.salary%type)
is
    a number;
begin
    select first_name,job_id,salary
    into v_fname, v_job, v_salary
    from employees
    where employee_id=v_empid;
end;
/

execute sp_empinfo(100,:a,:b,:c);

desc user_source;
select * from user_source;


variable x varchar2(25);
variable y varchar2(25);
variable z number;

execute sp_empinfo(200, :x, :y, :z);

print x;
print y;
print z;


create or replace function f_bonus(v_empid employees.employee_id%type)
    return number
is
    v_bonus number(10,2);
begin
    select salary*1.5
    into v_bonus
    from employees
    where employee_id = v_empid;
    return v_bonus;
end;
/

select f_bonus(100)
from dual;

select employee_id, first_name, length(first_name),salary, f_bonus(employee_id)
from employees;

--커서 : select 건수가 여러 건인 경우 반드시 커서를 사용한다.
--1.커서 선언
--2.커서 open
--3.커서 fetch
--4.커서 닫기

create or replace procedure sp_emp2
is
    v_empRecord employees%rowtype;
    cursor cur_emp is select * from employees;--1.커서 선언
begin
    --2.커서 열기(실행됨)
    open cur_emp;
    
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;--없으면 루프 빠져나가기
        dbms_output.put_line('직원이름:'||v_empRecord.first_name);
        dbms_output.put_line('급여:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;
    --4.커서 닫기
    close cur_emp;
end;
/

execute sp_emp2;


create or replace procedure sp_emp3
is
begin
    --암시적 커서 이용
    for v_empRecord in(select * from employees)loop
        dbms_output.put_line('직원이름:'||v_empRecord.first_name);
        dbms_output.put_line('급여:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;

end;
/

execute sp_emp3;

create or replace procedure sp_empByDeptSal(v_deptid employees.department_id%type, v_sal employees.salary%type)
is
    v_empRecord employees%rowtype;
    --1.커서 선언
    cursor cur_emp is 
    select * 
    from employees
    where employees.department_id = v_deptid and employees.salary >= v_sal;
begin
    open cur_emp;
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;--없으면 루프 빠져나가기
        dbms_output.put_line('직원이름:'||v_empRecord.first_name);
        dbms_output.put_line('부서번호:'||v_empRecord.department_id);
        dbms_output.put_line('급여:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;
    --4.커서 닫기
    close cur_emp;
end;
/


--첫 번째 arg : 세금을 부여할 부서
--두 번째 arg : 직원번호
select   employee_id, salary, department_id,  f_tax( 60, employee_id) 세금
from employees;

create or replace function f_tax(v_deptid in employees.department_id%type, v_empid in employees.employee_id%type)
    return number
is
    v_tax number:=0;
begin
    select salary*0.1 into v_tax
    from employees
    where employee_id = v_empid and department_id=v_deptid;
    return v_tax;
end;
/


--저장 프로시져 : sp_empByDeptSal, 특정 부서의 특정 금액 이상의 급여를 받는 직원 조회
execute sp_empByDeptSal(50,5000)

--저장 함수 : f_tax, 60번 부서의 직원들의 tax를 계산하는 함수(급여의 10%)
select f_tax(60, 103) 세금
from employees;



------패키지(묶음)------

--선언부
create or replace package pkg_exam1 is
    procedure sp_empByDeptSal2(v_deptid employees.department_id%type, v_sal employees.salary%type);
    function f_tax2(v_deptid in employees.department_id%type, v_empid in employees.employee_id%type) return number;
end;
/

--몸체
create or replace package body pkg_exam1 is
procedure sp_empByDeptSal2(v_deptid employees.department_id%type, v_sal employees.salary%type)
is
    v_empRecord employees%rowtype;
    --1.커서 선언
    cursor cur_emp is 
    select * 
    from employees
    where employees.department_id = v_deptid and employees.salary >= v_sal;
begin
    open cur_emp;
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;--없으면 루프 빠져나가기
        dbms_output.put_line('직원이름:'||v_empRecord.first_name);
        dbms_output.put_line('부서번호:'||v_empRecord.department_id);
        dbms_output.put_line('급여:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;
    --4.커서 닫기
    close cur_emp;
end;


function f_tax2(v_deptid in employees.department_id%type, v_empid in employees.employee_id%type)
    return number
is
    v_tax number:=0;
begin

    select salary*0.1 into v_tax
    from employees
    where employee_id = v_empid and department_id=v_deptid;
    return v_tax;
end;
end;
/

execute pkg_exam1.sp_empbydeptsal2(50,5000);
select pkg_exam1.f_tax2(60, employee_id) 세금
from employees;

--패키지 이름 pkg_exam2
--sp_empinfo
--f_bonus
create or replace package pkg_exam2 is
    procedure sp_empinfo2(v_empid in employees.employee_id%type,
    v_fname out employees.first_name%type,
    v_job out employees.job_id%type,
    v_salary out employees.salary%type);
    
    function f_bonus2(v_empid employees.employee_id%type) return number;
end;
/

create or replace package body pkg_exam2 is
procedure sp_empinfo2(v_empid in employees.employee_id%type,
    v_fname out employees.first_name%type,
    v_job out employees.job_id%type,
    v_salary out employees.salary%type)
is
    a number;
begin
    select first_name,job_id,salary
    into v_fname, v_job, v_salary
    from employees
    where employee_id=v_empid;
end;

function f_bonus2(v_empid employees.employee_id%type)
    return number
is
    v_bonus number(10,2);
begin
    select salary*1.5
    into v_bonus
    from employees
    where employee_id = v_empid;
    return v_bonus;
end;
end;
/

--패키지 내의 프로시져 호출--
variable x varchar2(25);
variable y varchar2(25);
variable z number;

execute pkg_exam2.sp_empinfo2(100, :x, :y, :z);

print x;
print y;
print z;

--패키지 내의 함수 호출--
select first_name,pkg_exam2.f_bonus2(employee_id)
from employees;
end;


--------------------Trigger-------------------------

drop table emp_trigger;
create table emp_trigger(
    id number primary key,
    name varchar2(100)
);

insert into emp_trigger values(1,'김');
insert into emp_trigger values(2,'나');
insert into emp_trigger values(3,'박');

commit;

select * from emp_trigger;

--insert,delete,update라는 사건이 발생하면 자동으로 실행되는 프로그램을 만들어보자.
--for each row: 건별마다, emp_tirgger 테이블에 insert한 건 마다
create or replace trigger trigger_emp1
after insert on emp_trigger for each row
begin
    DBMS_OUTPUT.PUT_LINE('------emp_trigger 테이블 insert 성공------');
    insert into emp_sal01 values(seq_emp_sal01.nextval,100,:new.id);
end;
/

create table emp_sal01(
    salno number(4) primary key,
    salary number(7,2),
    empid number(4) REFERENCES emp_trigger(id)
);

create sequence seq_emp_sal01;

insert into emp_trigger values(7,'은정');
--참조하는 테이블이 있으면 지울 수 없다.
--자식 테이블이 있으면 지울 수 없다.
delete from emp_trigger where id = 7;

create or replace trigger trigger_delete
before delete on emp_trigger for each row
begin
    DBMS_OUTPUT.PUT_LINE('------emp_trigger 테이블 delete 성공------');
    delete from emp_sal01 where empid=:old.id;
end;
/



CREATE TABLE 상품(
상품코드 CHAR(6) PRIMARY KEY,
상품명 VARCHAR2(12) NOT NULL,
제조사 VARCHAR(12),
소비자가격 NUMBER(8),
재고수량 NUMBER DEFAULT 0
);

INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00001','세탁기', 'LG', 500); 
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00002','컴퓨터', 'LG', 700);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격)
VALUES('A00003','냉장고', '삼성', 600);

commit;

CREATE TABLE 입고(
입고번호 NUMBER(6) PRIMARY KEY,
상품코드 CHAR(6) REFERENCES 상품(상품코드),
입고일자 DATE DEFAULT SYSDATE,
입고수량 NUMBER(6),
입고단가 NUMBER(8),
입고금액 NUMBER(8)
);

--상품이 입고되면 상품의 재고 수량을 수정한다.(trigger)

create or replace trigger trigger_재고수정
after insert on 입고 for each row
begin
    update 상품
    set 재고수량 = 재고수량+:New.입고수량
    where 상품코드 = :new.상품코드;
end;
/

INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(1, 'A00001', 5, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(2, 'A00001', 20, 320, 1600);
INSERT INTO 입고(입고번호, 상품코드, 입고수량, 입고단가, 입고금액) 
VALUES(3, 'A00002', 30, 420, 4600);
SELECT * FROM 입고;
SELECT * FROM 상품;

--상품이 출고되면 상품의 재고 수량을 수정한다.(trigger)

CREATE TABLE 출고(
출고번호 NUMBER(6) PRIMARY KEY,
상품코드 CHAR(6) REFERENCES 상품(상품코드),
출고일자 DATE DEFAULT SYSDATE,
출고수량 NUMBER(6),
출고단가 NUMBER(8),
출고금액 NUMBER(8)
);

create or replace trigger trigger_재고수정2
after insert on 출고 for each row
begin
    update 상품
    set 재고수량 = 재고수량-:New.출고수량
    where 상품코드 = :new.상품코드;
end;
/

INSERT INTO 출고(출고번호, 상품코드, 출고일자, 출고수량, 출고단가, 출고금액) 
VALUES(1, 'A00002', sysdate,10, 420, 4600);

SELECT * FROM 출고;
SELECT * FROM 상품;


-----employees 테이블의 100번 직원의 부서 수정
update employees
set department_id = 50
where employee_id = 100;

select * from employees where employee_id =100;

CREATE TABLE job_history
    ( employee_id   NUMBER(6)
	 CONSTRAINT    jhist_employee_nn  NOT NULL
    , start_date    DATE
	CONSTRAINT    jhist_start_date_nn  NOT NULL
    , end_date      DATE
	CONSTRAINT    jhist_end_date_nn  NOT NULL
    , job_id        VARCHAR2(10)
	CONSTRAINT    jhist_job_nn  NOT NULL
    , department_id NUMBER(4)
    , CONSTRAINT    jhist_date_interval
                    CHECK (end_date > start_date)
    ) ;

CREATE UNIQUE INDEX jhist_emp_id_st_date_pk 
ON job_history (employee_id, start_date) ;

ALTER TABLE job_history
ADD ( CONSTRAINT jhist_emp_id_st_date_pk
      PRIMARY KEY (employee_id, start_date)
    , CONSTRAINT     jhist_job_fk
                     FOREIGN KEY (job_id)
                     REFERENCES jobs
    , CONSTRAINT     jhist_emp_fk
                     FOREIGN KEY (employee_id)
                     REFERENCES employees
    , CONSTRAINT     jhist_dept_fk
                     FOREIGN KEY (department_id)
                     REFERENCES departments
    ) ;
