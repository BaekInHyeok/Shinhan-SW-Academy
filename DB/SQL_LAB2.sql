========================================
		������ �Լ�(1���� �Է�>>1���� ���)
========================================

1. �̸��� 'adam' �� ������ �޿��� �Ի����� ��ȸ�Ͻÿ�.

select salary, hire_date
from employees
where first_name = initcap('adam');

2. ���� ���� 'united states of america' �� ������ ���� �ڵ带 ��ȸ�Ͻÿ�.

select region_id
from countries
where lower(country_name)='united states of america';

3. 'Adam�� �Ի����� 95/11/02 �̰�, �޿��� 7000 �Դϴ�.' �̷� ������ ����
������ ��ȸ�Ͻÿ�.

select first_name||'�� �Ի����� '||hire_date||'�̰�, �޿��� '||salary||' �Դϴ�.'
from employees;


4. �̸��� 5���� ������ �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.

select first_name, salary, hire_date
from employees
where length(first_name)<=5;


5.2006�⵵�� �Ի��� ������ �̸�, �Ի����� ��ȸ�Ͻÿ�.

select first_name, hire_date
from employees
where to_char(hire_date,'RR')='06';


6. 7�� �̻� ��� �ټ��� �������� �̸�, �Ի���, �޿�, �ٹ������� ��ȸ�Ͻÿ�.

select first_name, hire_date, salary, ceil(MONTHS_BETWEEN(SYSDATE,hire_date)/12)����
from employees
where round(MONTHS_BETWEEN(SYSDATE,hire_date)/12,1)>=7;


=============Group �Լ�==================


7. �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.

select department_id �μ�, count(department_id)
from employees
having count(department_id)>5
group by department_id
order by �μ�;




8. �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧���� 
   ��ȸ������� ���ܽ�Ų��.

select department_id �μ�, max(salary) �ִ�޿�, min(salary) �ּұ޿�
from employees
where department_id is not null 
group by department_id
having count(department_id)>=2;
--having max(salary)<>min(salary);


   
9. �μ��� 50, 80, 110 ���� ������ �߿��� �޿��� 5000 �̻� 24000 ���ϸ� �޴�
   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
   ��, ��ձ޿��� 8000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
   �μ����� ��µǵ��� �ؾ� �Ѵ�.

select department_id �μ�, avg(salary) ��ձ޿�
from employees
where department_id in (50,80,110) and salary between 5000 and 24000
group by department_id
having avg(salary)>=8000
order by ��ձ޿� desc;



