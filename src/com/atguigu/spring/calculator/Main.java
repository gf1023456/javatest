package com.atguigu.spring.calculator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  CalculatorImpl target=new CalculatorImpl();
	//创建工厂对象(获取代理对象)
		 ProxyObjectFactory pof=new ProxyObjectFactory(target);
		Object proxy = pof.createProxyObject();//创建代理对象
		
		CalculatorImpl c=(CalculatorImpl)proxy;
		c.div(10, 5);
		 
		
	}

}
