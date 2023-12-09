package com.surbhi.springdata.idgenerators;

import org.springframework.data.repository.CrudRepository;

import com.surbhi.springdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
