package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrAppApplicationTests {
	
	//scan in memory all the components and provide the
	//best match object in the component
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	Employee emp;

	@Test
	public void addEmployeeUsingService() {
		Employee emp = new Employee();
		emp.setEmpno(6);
		emp.setName ("New Employee 5");
		emp.setSalary(702);
		
		emp = empService.registerOrUpdateEmployee(emp);
		
		assertNotNull(emp);
	}
	
	@Test
	public void findByEmpnoUsingService() {
		int empno = 1;
		assertNotNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void deleteByEmpnoUsingService(){
		int empno = 12;
		empService.deleteByEmpno(empno);
		assertNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps = empService
				.fetchEmployeeBySalaryRange(0, 1000);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		
		assertEquals(emps.size(),2);	}
	
	@Test
	public void simpleTest() {
		System.out.println("Test Application Failed");
		
	}

}
