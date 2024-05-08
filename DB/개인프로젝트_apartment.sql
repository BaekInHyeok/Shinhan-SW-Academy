--Table:�ֹ�--
drop table RESIDENT;
create table RESIDENT(
    RESIDENT_ID number primary key,
    RESIDENT_NAME varchar2(20) not null,
    RESIDENT_PHONE varchar2(20) not null,
    RESIDENT_DONG number not null,
    RESIDENT_HO number not null,
    RESIDENT_DATE DATE not null,
    RESIDENT_CAR varchar(20),
    RESIDENT_FEE varchar(20),
    RESIDENT_OWNER number not null 
);

--Table:����ü�--
drop table facility;
create table FACILITY(
    FACILITY_ID number primary key,
    FACILITY_NAME varchar2(20) not null,
    FACILITY_DATE DATE not null,
    FACILITY_TYPE varchar2(20) not null,
    FACILITY_START_TIME varchar2(20) not null,
    FACILITY_END_TIME varchar2(20) not null,
    FACILITY_MANAGER_ID number
);

--Table:�ٷ���--
drop table worker;
create table WORKER(
    WORKER_ID number primary key,
    WORKER_NAME varchar2(20) not null,
    WORKER_AGE number not null,
    WORKER_GENDER varchar2(3) not null,
    WORKER_PHONE varchar2(20) not null,
    WORKER_HIREDATE DATE not null,
    WORKER_WORKPLACE_ID number,
    WORKER_WORK varchar2(20),
    WORKER_SALARY number not null
);

--Table:��--
drop table STORE;
create table STORE(
    STORE_ID number primary key,
    STORE_BUSSINESS_NUMBER varchar2(30) not null,
    STORE_NAME varchar2(30) not null,
    STORE_OWNER varchar2(20) not null,
    STORE_PHONE varchar2(20) not null,
    STORE_TYPE varchar2(20) not null,
    STORE_STARTDATE DATE not null,
    STORE_START_TIME varchar2(20) not null,
    STORE_END_TIME varchar2(20) not null
);

/*�ֹ�(resident)�� sql��*/
--1.�ֹ� ID�� �ֹ� ���� �˻��ϱ�
select *
from resident
where resident_id = id;

--2.���� �ֹ� ��� ��ȸ�ϱ�
select *
from resident
where resident_dong = 105
order by resident_ho;

--3.�ֹ� ���� �Է�(�ֹ� �߰�)
insert into resient values(?,?,?,?,?,?,?,?,?);

--���뿡�� �����ְ� 2�� �̻��� ���� �ʵ��� �ϴ� Ʈ����
create or replace TRIGGER unique_dong_ho_owner_trigger
before insert on resident for each row
declare existing_count number;
begin
    if :new.resident_owner =1
    then
        select count(*) INTO existing_count
        from resident
        where resident_dong = :new.resident_dong
        and resident_ho = :new.resident_ho
        and resident_owner = 1;
        
        IF existing_count > 0 THEN
            raise_application_error(-20001,'�ش� ���뿡�� �̹� �����ְ� �ֽ��ϴ�');
        END IF;
    END IF;
end;
/

--4.�ֹ� ���� ����
update resident
set resident_name='�質��'
where resident_id=?;

--5.�ֹ� ���� ����
delete from resident
where resident_id = ?;

/*����ü� ���� sql*/

--�ü�ID�� �Է��Ͽ� �Ŵ��� ID �κ� ��� �Ŵ��� �̸��� ����ϴ� ����
SELECT F.FACILITY_NAME,F.FACILITY_TYPE,F.FACILITY_START_TIME,F.FACILITY_END_TIME,W.WORKER_NAME
FROM FACILITY F, WORKER W
where f.facility_manager_id = w.worker_id and f.facility_id=11;

--�ü����� �Է��Ͽ� �ش� �ü��� �ٹ��ڵ鿡 ���� ������ ����ϱ�
SELECT w.WORKER_ID,w.WORKER_NAME, w.WORKER_SALARY, w.WORKER_AGE, w.worker_work, w.worker_workplace_id
FROM WORKER w
where w.worker_workplace_id=
(select facility.facility_id
from facility
where facility.facility_name='ü����');

--�ü� �߰�
insert into facility values(?,?,?,?,?,?,?);
--�ü� ���� ����
update facility set facility_name = ? where facility_id =?;
--�ü� ���� ����
delete from facility where facility_id = ?;

/*�ٷ��� ���� sql*/
--�ٷ��� ID�� �˻��ϱ�
select * from worker where worker_id = ?;

--�������� �Է��Ͽ� �ش� ������ �۾��� ����� ���
SELECT w.WORKER_NAME, w.WORKER_AGE, w.WORKER_GENDER, w.WORKER_PHONE, f.FACILITY_NAME
FROM WORKER w
JOIN FACILITY f ON w.WORKER_WORKPLACE_ID = f.FACILITY_ID
where w.WORKER_WORK = '����';

--�ٷ��� �߰�
insert into worker values(?,?,?,?,?,?,?,?,?);
--�ٷ��� ����
update worker set worker_name = ? where worker_id=?;
--�ٷ��� ����
delete from worker where worker_id = ?;

/*�� ���� sql*/
--����ID�� ���� ���� ��ȸ
select * from store where store_id =?;
--�������� �Է��Ͽ� �ش� ���� ���� ��� ���
select * from store where store_type=? order by store_name;

--���� �߰�
insert into store values(?,?,?,?,?,?,?,?,?);
--���� ����
update store set store_name=? where store_id=?;
--���� ����
delete from store where store_id=?;

delete from resident where resident_id=0;
commit;

update resident set resident_name='��ö��', resident_phone = '010-1913-2939' where resident_id=124141;

select * from resident;
select * from facility;
select * from worker;
select * from store;