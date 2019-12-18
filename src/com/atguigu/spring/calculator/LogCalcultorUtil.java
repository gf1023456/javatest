package com.atguigu.spring.calculator;

import java.util.Arrays;

/**
 * 存放日志代码的工具类
 * @author pjw
 *
 */
public class LogCalcultorUtil {

	/**
	 * 在执行运算之前调用
	 *  作用:记录方法的名字以及该方法的参数
	 */
	  public static void logBefore(String methodName,Object[] args) {
		  System.out.println("调用:"+methodName+",参数:"+Arrays.toString(args));
		  
		  
	  } 
	
	  
	  
		/**
		 * 在执行运算之后调用
		 *  作用:记录方法的名字以及该方法的结果
		 */
		  public static void logAfter(String methodName,Object result) {
			  System.out.println("调用:"+methodName+",结果:"+result);
			  
			  
		  } 
		
	
}
