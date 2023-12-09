package com.jdbc_udemy.spring.springcore.dependencycheck;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
 
 public static void main(String[] args) {
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jdbc_udemy/spring/springcore/dependencycheck/config.xml");
	 Prescription prescription=(Prescription) context.getBean("prescription");
	 System.out.println(prescription);
	 System.out.println(prescription.getId());
}
}
