package com.atguigu.spring.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 作用:构建代理类,创建代理对象
 * @author pjw
 *
 */
public class ProxyObjectFactory {
    
	private Object target;//目标对象(计算器类)
	
	public ProxyObjectFactory(Object target) {
		 this.target=target;
	}
	
	/**
	 * 获得(创建代理对象)
	 */
	
	public Object createProxyObject() {
		
		Object proxy=null;// proxy代理对象
		
		//JDK动态代理
		
		//获得类加载器（动态的加载一个类(代理类)）
		ClassLoader loader=target.getClass().getClassLoader();
		//获得目标接口（计算器的接口）
		Class<?>[] interfaces=target.getClass().getInterfaces();
		//创建代理对象
		proxy=Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			
			/**
			 * proxy 代理对象
			 * method 方法对象
			 * args 参数(调用计算器方法是传入的实参)
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			   LogCalcultorUtil.logBefore(method.getName(), args);
				 
				Object result = method.invoke(target, args);//add 动态的调用目标方法
				LogCalcultorUtil.logAfter(method.getName(), result);
				
				return result;
			}
		});
		
		
		
		return  proxy;
	}
	
}
