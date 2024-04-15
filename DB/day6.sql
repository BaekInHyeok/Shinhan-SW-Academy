--1.�����ϱ�
set SERVEROUTPUT on;

--2.�����ϱ�
declare
    --��Į�� Ÿ��
    v_empid number(10):=100;
    v_fname varchar2(40);
    
    --����Ÿ��
    v_empid2 employees.employee_id%type:=200;
    v_fname2 employees.first_name%type:='���ѱ���';
    v_empRecord employees%rowtype;

--3.�ۼ��ؼ� �����ϱ�
begin
    v_fname:='��Ƽ��';
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
    
    DBMS_OUTPUT.put_line('select �� v_fname='||v_fname);
    DBMS_OUTPUT.put_line('select �� v_empRecord='||v_empRecord.first_name);
    DBMS_OUTPUT.put_line('select �� v_empRecord='||v_empRecord.salary);
end;
/
--:=:�����ϱ�
--DBMS_OUTPUT:��Ű�� �̸�
--put_line():�Լ�, �ڹ��� pirntln()�� ����.
--"":�ĺ���
--'':��
--/:�����ϱ�

declare
    --Ÿ�� ����
    type fnameType_table is table of employees.first_name%type index by binary_integer;
    type empRecordType is record(
        v_empid employees.employee_id%type,
        v_fname employees.first_name%type,
        v_salary employees.salary%type,
        v_salary2 number(8,2)
    );
    --���� ����
    fname_arr fnameType_table;
    v_emp empRecordType;
    
    --÷�� ����
    index2 BINARY_INTEGER:=0;
begin
    select employee_id, first_name, salary, salary
    into v_emp
    from employees
    where employee_id=100;
    dbms_output.put_line('������ȣ:'||v_emp.v_empid);
    dbms_output.put_line('�����̸�:'||v_emp.v_fname);
    dbms_output.put_line('�����޿�:'||v_emp.v_salary);
    dbms_output.put_line('�����޿�-��Į��Ÿ��:'||v_emp.v_salary2);
    
    if(v_emp.v_salary>10000) then
        dbms_output.put_line('�޿��� ����');
    end if;
    
    for fnameRec in(select first_name from employees where department_id=60) loop
        index2 := index2+1;
        fname_arr(index2) := fnameRec.first_name;
        dbms_output.put_line('Record:'||fnameRec.first_name||'�迭:'||fname_arr(index2));
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
            DBMS_OUTPUT.PUT_LINE('i�� 5����');
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
        dbms_output.put_line('�޿�:'||empRecord.salary);
        dbms_output.put_line('�μ��ڵ�:'||empRecord.department_id);
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

--Ŀ�� : select �Ǽ��� ���� ���� ��� �ݵ�� Ŀ���� ����Ѵ�.
--1.Ŀ�� ����
--2.Ŀ�� open
--3.Ŀ�� fetch
--4.Ŀ�� �ݱ�

create or replace procedure sp_emp2
is
    v_empRecord employees%rowtype;
    cursor cur_emp is select * from employees;--1.Ŀ�� ����
begin
    --2.Ŀ�� ����(�����)
    open cur_emp;
    
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;--������ ���� ����������
        dbms_output.put_line('�����̸�:'||v_empRecord.first_name);
        dbms_output.put_line('�޿�:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;
    --4.Ŀ�� �ݱ�
    close cur_emp;
end;
/

execute sp_emp2;


create or replace procedure sp_emp3
is
begin
    --�Ͻ��� Ŀ�� �̿�
    for v_empRecord in(select * from employees)loop
        dbms_output.put_line('�����̸�:'||v_empRecord.first_name);
        dbms_output.put_line('�޿�:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;

end;
/

execute sp_emp3;

create or replace procedure sp_empByDeptSal(v_deptid employees.department_id%type, v_sal employees.salary%type)
is
    v_empRecord employees%rowtype;
    --1.Ŀ�� ����
    cursor cur_emp is 
    select * 
    from employees
    where employees.department_id = v_deptid and employees.salary >= v_sal;
begin
    open cur_emp;
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;--������ ���� ����������
        dbms_output.put_line('�����̸�:'||v_empRecord.first_name);
        dbms_output.put_line('�μ���ȣ:'||v_empRecord.department_id);
        dbms_output.put_line('�޿�:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;
    --4.Ŀ�� �ݱ�
    close cur_emp;
end;
/


--ù ��° arg : ������ �ο��� �μ�
--�� ��° arg : ������ȣ
select   employee_id, salary, department_id,  f_tax( 60, employee_id) ����
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


--���� ���ν��� : sp_empByDeptSal, Ư�� �μ��� Ư�� �ݾ� �̻��� �޿��� �޴� ���� ��ȸ
execute sp_empByDeptSal(50,5000)

--���� �Լ� : f_tax, 60�� �μ��� �������� tax�� ����ϴ� �Լ�(�޿��� 10%)
select f_tax(60, 103) ����
from employees;



------��Ű��(����)------

--�����
create or replace package pkg_exam1 is
    procedure sp_empByDeptSal2(v_deptid employees.department_id%type, v_sal employees.salary%type);
    function f_tax2(v_deptid in employees.department_id%type, v_empid in employees.employee_id%type) return number;
end;
/

--��ü
create or replace package body pkg_exam1 is
procedure sp_empByDeptSal2(v_deptid employees.department_id%type, v_sal employees.salary%type)
is
    v_empRecord employees%rowtype;
    --1.Ŀ�� ����
    cursor cur_emp is 
    select * 
    from employees
    where employees.department_id = v_deptid and employees.salary >= v_sal;
begin
    open cur_emp;
    loop
        fetch cur_emp into v_empRecord;
        exit when cur_emp%notfound;--������ ���� ����������
        dbms_output.put_line('�����̸�:'||v_empRecord.first_name);
        dbms_output.put_line('�μ���ȣ:'||v_empRecord.department_id);
        dbms_output.put_line('�޿�:'||v_empRecord.salary);
        dbms_output.put_line('------------------------');
    end loop;
    --4.Ŀ�� �ݱ�
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
select pkg_exam1.f_tax2(60, employee_id) ����
from employees;

--��Ű�� �̸� pkg_exam2
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

--��Ű�� ���� ���ν��� ȣ��--
variable x varchar2(25);
variable y varchar2(25);
variable z number;

execute pkg_exam2.sp_empinfo2(100, :x, :y, :z);

print x;
print y;
print z;

--��Ű�� ���� �Լ� ȣ��--
select first_name,pkg_exam2.f_bonus2(employee_id)
from employees;
end;


--------------------Trigger-------------------------

drop table emp_trigger;
create table emp_trigger(
    id number primary key,
    name varchar2(100)
);

insert into emp_trigger values(1,'��');
insert into emp_trigger values(2,'��');
insert into emp_trigger values(3,'��');

commit;

select * from emp_trigger;

--insert,delete,update��� ����� �߻��ϸ� �ڵ����� ����Ǵ� ���α׷��� ������.
--for each row: �Ǻ�����, emp_tirgger ���̺� insert�� �� ����
create or replace trigger trigger_emp1
after insert on emp_trigger for each row
begin
    DBMS_OUTPUT.PUT_LINE('------emp_trigger ���̺� insert ����------');
    insert into emp_sal01 values(seq_emp_sal01.nextval,100,:new.id);
end;
/

create table emp_sal01(
    salno number(4) primary key,
    salary number(7,2),
    empid number(4) REFERENCES emp_trigger(id)
);

create sequence seq_emp_sal01;

insert into emp_trigger values(7,'����');
--�����ϴ� ���̺��� ������ ���� �� ����.
--�ڽ� ���̺��� ������ ���� �� ����.
delete from emp_trigger where id = 7;

create or replace trigger trigger_delete
before delete on emp_trigger for each row
begin
    DBMS_OUTPUT.PUT_LINE('------emp_trigger ���̺� delete ����------');
    delete from emp_sal01 where empid=:old.id;
end;
/



CREATE TABLE ��ǰ(
��ǰ�ڵ� CHAR(6) PRIMARY KEY,
��ǰ�� VARCHAR2(12) NOT NULL,
������ VARCHAR(12),
�Һ��ڰ��� NUMBER(8),
������ NUMBER DEFAULT 0
);

INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00001','��Ź��', 'LG', 500); 
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00002','��ǻ��', 'LG', 700);
INSERT INTO ��ǰ(��ǰ�ڵ�, ��ǰ��, ������, �Һ��ڰ���)
VALUES('A00003','�����', '�Ｚ', 600);

commit;

CREATE TABLE �԰�(
�԰��ȣ NUMBER(6) PRIMARY KEY,
��ǰ�ڵ� CHAR(6) REFERENCES ��ǰ(��ǰ�ڵ�),
�԰����� DATE DEFAULT SYSDATE,
�԰���� NUMBER(6),
�԰�ܰ� NUMBER(8),
�԰�ݾ� NUMBER(8)
);

--��ǰ�� �԰�Ǹ� ��ǰ�� ��� ������ �����Ѵ�.(trigger)

create or replace trigger trigger_������
after insert on �԰� for each row
begin
    update ��ǰ
    set ������ = ������+:New.�԰����
    where ��ǰ�ڵ� = :new.��ǰ�ڵ�;
end;
/

INSERT INTO �԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�, �԰�ݾ�) 
VALUES(1, 'A00001', 5, 320, 1600);
INSERT INTO �԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�, �԰�ݾ�) 
VALUES(2, 'A00001', 20, 320, 1600);
INSERT INTO �԰�(�԰��ȣ, ��ǰ�ڵ�, �԰����, �԰�ܰ�, �԰�ݾ�) 
VALUES(3, 'A00002', 30, 420, 4600);
SELECT * FROM �԰�;
SELECT * FROM ��ǰ;

--��ǰ�� ���Ǹ� ��ǰ�� ��� ������ �����Ѵ�.(trigger)

CREATE TABLE ���(
����ȣ NUMBER(6) PRIMARY KEY,
��ǰ�ڵ� CHAR(6) REFERENCES ��ǰ(��ǰ�ڵ�),
������� DATE DEFAULT SYSDATE,
������ NUMBER(6),
���ܰ� NUMBER(8),
���ݾ� NUMBER(8)
);

create or replace trigger trigger_������2
after insert on ��� for each row
begin
    update ��ǰ
    set ������ = ������-:New.������
    where ��ǰ�ڵ� = :new.��ǰ�ڵ�;
end;
/

INSERT INTO ���(����ȣ, ��ǰ�ڵ�, �������, ������, ���ܰ�, ���ݾ�) 
VALUES(1, 'A00002', sysdate,10, 420, 4600);

SELECT * FROM ���;
SELECT * FROM ��ǰ;


-----employees ���̺��� 100�� ������ �μ� ����
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
