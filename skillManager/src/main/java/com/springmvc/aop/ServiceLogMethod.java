package com.springmvc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class ServiceLogMethod implements MethodInterceptor  {

	public Object invoke(MethodInvocation arg0) throws Throwable {
		
		System.out.print(">> SERVICE : try to " +arg0.getMethod().getName() + ((arg0.getArguments().length>0)?" with :":""));
		for(Object objetParametre : arg0.getArguments()){
			System.out.print("> SERVICE " + objetParametre + "; "); 
		}
		try {
			Object returnValue = arg0.proceed(); 
			if(returnValue!=null) {
				System.out.print("<< SERVICE Returned value=" + returnValue); 
			}
			return returnValue;
		} catch(Exception e) {
			System.out.println(">> SERVICE EXCEPTION << : " + e.getMessage() + " for " +arg0.getMethod().getName());
			throw e;
		}
	}


}
