package com.atguigu.spring.calculator.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 存放日志的工具类
 *  切面类
 * @author pjw
 *
 */
@Component
@Aspect
public class LogAspect {

	
	/**
	 * 前置通知(方法)
	 * 
	 * JoinPoint 连接点对象
	 * @Before 被该注解标注的方法会在目标方法之前执行
	 * execution 切入点表达式
	 * @param jp
	 */
	 @Before(value = "execution(* *.*(..))")
	 public void logBefore(JoinPoint jp) {
		 
		 Object[] args = jp.getArgs();
		 String name = jp.getSignature().getName();
		 System.out.println("调用"+name+"方法,参数:"+Arrays.toString(args));
	 }
	/**
	 * 后置返回值通知
	 * 
	 * returning=“a” 获取目标方法的返回值  int a
	 * @param jp
	 * @param a
	 */
	@AfterReturning(value="execution(* *.*(..))",returning="a")
	 public void logAfter(JoinPoint jp,Integer a) {
		 System.out.println("调用"+jp.getSignature().getName()+",结果:"+a);
		 
	 }
	
	/**
	 * 后置通知(最终通知)
	 * 通配符 第一个* 代码访问修饰符+返回值类型
	 *      第二个*代表全类名
	 *      第三个* 方法名字
	 *      ..任何类型任意个数的参数
	 */
	 @After(value="execution(* *.*(..))")
	public void after() {
		System.out.println("执行最终通知...");
		
	}
	 
	 /**
	  *  try  catch 
	  *  throw  throws
	  *  异常通知
	  */
	  @AfterThrowing(value="execution(* *.*(..))",throwing="e")
	 public void afterThrowing(JoinPoint jp,RuntimeException e) {
		 System.out.println("执行"+jp.getSignature().getName()+",异常信息"+e);
		 
	 }
	
	
	 /**
	  * 
	  * 环绕通知
	  * 
	  */
	  @Around(value="execution(* *.*(..))")
	  public Object around(ProceedingJoinPoint pjp) { 
		    System.out.println("around前置通知,执行"+pjp.getSignature().getName()+",参数"+Arrays.toString(pjp.getArgs()));
		   try {
			Object result = pjp.proceed();// invoke()调用目标方法
			System.out.println("around 返回通知,结果:"+result);
			return result;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("around 异常通知"+e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("最终通知");
			
		}
		   
		   //check 检查异常
		  return null;
	  }
	
	
	
	
	
	
	
	
}
