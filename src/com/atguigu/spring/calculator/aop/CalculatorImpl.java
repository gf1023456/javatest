package com.atguigu.spring.calculator.aop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {

	/**
	 * 缺点:代码冗余
	 *  非核心业务: 日志的代码
	 *  核心业务    : 计算的代码 
	 * 
	 */
	@Override
	public int add(int i, int j) {
		 int result=i+j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		 int result=i-j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		 int result=i*j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		 int result=i/j;
		return result;
	}

}
