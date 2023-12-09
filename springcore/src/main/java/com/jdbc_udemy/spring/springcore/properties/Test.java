package com.jdbc_udemy.spring.springcore.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jdbc_udemy/spring/springcore/properties/propertyspringconfig.xml");
		CountriesAndLanguages countriesAndLanguages = (CountriesAndLanguages) context.getBean("countriesAndLangs");
		System.out.println(countriesAndLanguages);
	}
}
