package com.shinhan.myapp.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//��������(Advice)...�������� ���������� �־����� �־���
@Component
//@Aspect
public class StopWatchAdvice{
	//com.shinhan.myapp.aop2.Calculator Ŭ���� ���� StopWatchAdvice ����
	//�־��� ���Ŀ� StopWatch ����� ����.
	
	@Pointcut("within(com.shinhan.myapp.controller.BoardController)")
	public void pointcutTarget() {}
	
	@Around("pointcutTarget()")
	public Object aa(ProceedingJoinPoint jp) throws Throwable {
		// ��������
		String methodName = jp.getSignature().getName();
		System.out.println("******" + methodName + "�޼��� ȣ�� ��");
		StopWatch watch = new StopWatch("���ð�");
		watch.start();
		
		// �־����� �����Ѵ�.
		Object object = jp.proceed();
		
		// ��������
		System.out.println("*****" + methodName + "�޼��� ȣ�� ��");
		watch.stop();
		System.out.println("�־��� ���� �ð�:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}
