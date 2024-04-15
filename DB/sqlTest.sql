--sql1
drop table MERCHANTS;
create table MERCHANTS (
    id number,
    name VARCHAR2(30),
    business_id varchar2(30),
    tax_type varchar2(30),
    category_id number
);

drop table CARD_USAGES;
create table CARD_USAGES (
    id number(10),
    created_at timestamp,
    category number(10),
    amount number(10),
    merchant_id number(10)
);

select * from MERCHANTS;
select * from CARD_USAGES;

insert into MERCHANTS values(3907,'KFC학동역','201-81-89723','일반과세자',1);
insert into MERCHANTS values(4989,'미켈(Mikelle)고깃집','785-49-00298','일반과세자',1);
insert into MERCHANTS values(6297,'뉴발란스 강남점','214-85-50334','일반과세자',6);
insert into MERCHANTS values(27052,'주식회사이마트몰','104086-50432','일반과세자',2);
insert into MERCHANTS values(118009,'플라이앤컴퍼니(주)','211-88-57343','일반과세자',1);

insert into CARD_USAGES values(195772,to_date('2018-05-02 18:54:43','yyyy-mm-dd hh24:mi:ss'),0,2700,3907);
insert into CARD_USAGES values(2530342,to_date('201901-28 09:47:33','yyyy-mm-dd hh24:mi:ss'),0,12300,3907);
insert into CARD_USAGES values(899325,to_date('2018-08-03 16:57:36','yyyy-mm-dd hh24:mi:ss'),0,45000,4989);
insert into CARD_USAGES values(400811,to_date('2018-05-28 12:45:34','yyyy-mm-dd hh24:mi:ss'),0,4000,6297);
insert into CARD_USAGES values(743640,to_date('2018-07-07 11:47:17','yyyy-mm-dd hh24:mi:ss'),0,299000,27052);
insert into CARD_USAGES values(1052039,to_date('2018-08-15 13:40:01','yyyy-mm-dd hh24:mi:ss'),1,-12900,118009);
insert into CARD_USAGES values(1120840,to_date('2018-08-21 06:58:55','yyyy-mm-dd hh24:mi:ss'),0,20800,118009);



--참조하는 쪽의 건수가 조회되었는지 확인
select *
from(
select mer.id, mer.name, sum(card.amount)
from MERCHANTS mer join CARD_USAGES card
on(mer.id = card.MERCHANT_ID)
where card.category=0
group by mer.id, mer.name
order by sum(card.amount) desc)
where rownum<=5;

----sql2
drop table EMPLOYEES2;
create table EMPLOYEES2(
    id number not null,
    name varchar2(20) not null,
    salary number(10,2) not null,
    branch_id number not null
);

drop table SELLINGS_shinhan;
create table SELLINGS_shinhan(
    car_id number not null,
    employee_id number not null,
    crated_at timestamp not null,
    price number(20,0) not null
);

insert into EMPLOYEES2 VALUES(1015,'Vex',900,1);
insert into EMPLOYEES2 VALUES(317,'Stephanie',250,3);
insert into EMPLOYEES2 VALUES(3884,'Audrina',470,1);
insert into EMPLOYEES2 VALUES(300,'Courtney',300,2);

insert into SELLINGS_shinhan values(306, 3317,  to_date('2016-07-19 12:40:54','yyyy-mm-dd hh24:mi:ss'), 500);
insert into SELLINGS_shinhan values(414, 3884 , to_date('2016-07-17 07:53:19','yyyy-mm-dd hh24:mi:ss'), 1700);
insert into SELLINGS_shinhan values(537, 3317,  to_date('2016-07-22 18:47:05','yyyy-mm-dd hh24:mi:ss'), 1600);
insert into SELLINGS_shinhan values(594, 3884,  to_date('2016-12-02 19:33:28','yyyy-mm-dd hh24:mi:ss'), 700);
insert into SELLINGS_shinhan values(810, 3912,  to_date('2016-07-09 03:09:21','yyyy-mm-dd hh24:mi:ss'), 4100);
insert into SELLINGS_shinhan values(900, 1015,  to_date('2016-08-14 13:20:56','yyyy-mm-dd hh24:mi:ss'), 15300);

select emp.name, max(emp.salary)
from   EMPLOYEES_shinhan emp join SELLINGS_shinhan  sell on (emp.id = sell.EMPLOYEE_ID)
where  to_char(CREATED_AT, 'yyyy-mm')  = '2016-07'
group by emp.name
having round(sum(sell.PRICE) /max(emp.salary)) between 0 and 10
order by 2 desc, 1 asc ;
-----------------------------------------------------------------------------------
select emp.name, max(emp.salary)
from   EMPLOYEES_shinhan emp join SELLINGS_shinhan  sell on (emp.id = sell.EMPLOYEE_ID)
where emp.id in (select  EMPLOYEE_ID
                                    from SELLINGS_shinhan
                                    where  to_char(CREATED_AT, 'yyyy-mm')  = '2016-07' )
group by emp.name
having round(sum(sell.PRICE) /max(emp.salary)) between 0 and 10
order by 2 desc, 1 asc ;



select * from departments;