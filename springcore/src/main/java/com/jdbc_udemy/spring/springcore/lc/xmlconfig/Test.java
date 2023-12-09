package com.jdbc_udemy.spring.springcore.lc.xmlconfig;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
 
 public static void main(String[] args) {
	 AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/jdbc_udemy/spring/springcore/lc/xmlconfig/config.xml");
	 Patient patient=(Patient) context.getBean("patient");
	 System.out.println(patient);
	 System.out.println(patient.getId());
	 context.registerShutdownHook();
}
}
