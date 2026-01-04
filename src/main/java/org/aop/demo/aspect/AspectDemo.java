package org.aop.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AspectDemo
{
	@Before("execution(* org.aop.demo.service.AopService.testing1(..)) || " + "execution" +
					"(*" + " org.aop.demo.service.AopService.testing2(..))")
	public void BeforeMethod()
	{
		System.out.println("Before method - Execution is for Method 1 and 2");
	}

	@After("execution(* org.aop.demo.service.AopService.testing1(..)) || " + "execution(*" +
					" org.aop.demo.service.AopService.testing2(..))")
	public void AfterMethod()
	{
		System.out.println("After method - Execution is for Method 1 and 2 ");
	}

	@Around("execution(* org.aop.demo.service.AopService.testing2(..))")
	public Object AroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		System.out.println("Before method only for testing2	");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("After method only for testing2	");
		return result;
	}

	@Around("@annotation(org.aop.demo.annotation.LogTest)")
	public Object aroundNew(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		System.out.println("Before new  method only for testing3	");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("After new  method only for testing3	");
		return result;
	}

	@Around("execution(* org.aop.demo.service.AopService.*(..))")
	public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		long start = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (end - start) + "milliseconds");
		return result;
	}

	@Around("execution(* org.aop.demo.service.AopService.testing5(..))")
	public Object LogMethodExecution(ProceedingJoinPoint proceedingJoinPoint)
					throws Throwable
	{
		String methodName = proceedingJoinPoint.getSignature().getName();
		Object[] args = proceedingJoinPoint.getArgs();
		log.info("Entering method {} with args {}" , methodName , Arrays.toString(args));
		Object result = proceedingJoinPoint.proceed();
		log.info("Exiting method {} with args {}" , methodName , Arrays.toString(args));
		return result;
	}
}
