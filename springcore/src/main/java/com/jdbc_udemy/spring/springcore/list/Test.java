package com.jdbc_udemy.spring.springcore.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
 
 public static void main(String[] args) {
	 ApplicationContext context = new ClassPathXmlApplicationContext("com/jdbc_udemy/spring/springcore/list/listspringconfig.xml");
	 Hospital hospital=(Hospital) context.getBean("hospital");
	 System.out.println(hospital.getName());
	 System.out.println(hospital.getDepartments());
	 System.out.println(hospital.getDepartments().getClass());
}
}
