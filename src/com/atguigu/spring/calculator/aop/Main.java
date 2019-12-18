package com.atguigu.spring.calculator.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		Calculator cal = ctx.getBean(Calculator.class);
		int div = cal.div(10, 5);
		System.out.println(div+".........................");
	}
}
