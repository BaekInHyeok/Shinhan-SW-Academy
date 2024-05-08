--Table:주민--
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

--Table:공용시설--
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

--Table:근로자--
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

--Table:상가--
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

/*주민(resident)용 sql문*/
--1.주민 ID로 주민 정보 검색하기
select *
from resident
where resident_id = id;

--2.동별 주민 목록 조회하기
select *
from resident
where resident_dong = 105
order by resident_ho;

--3.주민 정보 입력(주민 추가)
insert into resient values(?,?,?,?,?,?,?,?,?);

--세대에서 세대주가 2명 이상이 되지 않도록 하는 트리거
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
            raise_application_error(-20001,'해당 세대에는 이미 세대주가 있습니다');
        END IF;
    END IF;
end;
/

--4.주민 정보 수정
update resident
set resident_name='김나은'
where resident_id=?;

--5.주민 정보 삭제
delete from resident
where resident_id = ?;

/*공용시설 관련 sql*/

--시설ID를 입력하여 매니저 ID 부분 대신 매니저 이름을 출력하는 쿼리
SELECT F.FACILITY_NAME,F.FACILITY_TYPE,F.FACILITY_START_TIME,F.FACILITY_END_TIME,W.WORKER_NAME
FROM FACILITY F, WORKER W
where f.facility_manager_id = w.worker_id and f.facility_id=11;

--시설명을 입력하여 해당 시설의 근무자들에 대한 정보를 출력하기
SELECT w.WORKER_ID,w.WORKER_NAME, w.WORKER_SALARY, w.WORKER_AGE, w.worker_work, w.worker_workplace_id
FROM WORKER w
where w.worker_workplace_id=
(select facility.facility_id
from facility
where facility.facility_name='체육관');

--시설 추가
insert into facility values(?,?,?,?,?,?,?);
--시설 정보 수정
update facility set facility_name = ? where facility_id =?;
--시설 정보 삭제
delete from facility where facility_id = ?;

/*근로자 관련 sql*/
--근로자 ID로 검색하기
select * from worker where worker_id = ?;

--업무명을 입력하여 해당 업무의 작업자 목록을 출력
SELECT w.WORKER_NAME, w.WORKER_AGE, w.WORKER_GENDER, w.WORKER_PHONE, f.FACILITY_NAME
FROM WORKER w
JOIN FACILITY f ON w.WORKER_WORKPLACE_ID = f.FACILITY_ID
where w.WORKER_WORK = '강사';

--근로자 추가
insert into worker values(?,?,?,?,?,?,?,?,?);
--근로자 수정
update worker set worker_name = ? where worker_id=?;
--근로자 삭제
delete from worker where worker_id = ?;

/*상가 관련 sql*/
--상점ID로 상점 정보 조회
select * from store where store_id =?;
--업종명을 입력하여 해당 업종 상점 목록 출력
select * from store where store_type=? order by store_name;

--상점 추가
insert into store values(?,?,?,?,?,?,?,?,?);
--상점 수정
update store set store_name=? where store_id=?;
--상점 삭제
delete from store where store_id=?;

delete from resident where resident_id=0;
commit;

update resident set resident_name='김철수', resident_phone = '010-1913-2939' where resident_id=124141;

select * from resident;
select * from facility;
select * from worker;
select * from store;