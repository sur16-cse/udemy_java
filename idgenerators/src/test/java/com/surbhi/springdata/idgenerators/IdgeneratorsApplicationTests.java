package com.surbhi.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.surbhi.springdata.idgenerators.entities.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
class IdgeneratorsApplicationTests {
	
	@Autowired
	EmployeeRepository repository;
	
	@Test
	void testCreateEmployee() {
		Employee employee=new Employee();
		employee.setName("John");
		repository.save(employee);
	}

}
