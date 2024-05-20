package com.shinhan.myapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//(cross cutting concern)
@Component
//@Aspect // �������� + pointcut
public class LoggingAdvice {

	@Pointcut("execution(* selectAll())")
	public void targetMethod2() {
	}

	@Pointcut("within(com.shinhan.myapp.model.BoardService)")
	public void targetMethod3() {
	}

	@Before("targetMethod3()")
	public void f_before() {
		System.out.println("-----@Before-----");
	}

	@After("targetMethod3()")
	public void f_after() {
		System.out.println("-----@After-----");
	}

	@AfterReturning("targetMethod3()")
	public void f_return() {
		System.out.println("-----@AfterReturning-----");
	}

	// target�� �־��� ���� ����
	@Around("targetMethod2()")
	public Object arroundMethod(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("[�޼��� ȣ�� �� : LogginAdvice");
		System.out.println(jp.getSignature().getName() + "�޼��� ȣ�� ��");

		// �־����� �����Ѵ�.(����!!!!)
		Object object = jp.proceed();

		// �־��� ������ ���ƿͼ� �����Ѵ�.
		System.out.println("[�޼��� ȣ�� �� : loggingAdvice");
		System.out.println(jp.getSignature().getName() + "�޼��� ȣ�� ��");
		return object;
	}
}
