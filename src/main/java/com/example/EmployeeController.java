package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	List<Employee> listEmployee;

	public EmployeeController() {
		listEmployee = new ArrayList<Employee>();
		listEmployee.add(new Employee("John", "Male"));
		listEmployee.add(new Employee("Johnny", "Male"));
		listEmployee.add(new Employee("Mary", "Female"));
		listEmployee.add(new Employee("Travolta", "Male"));
		listEmployee.add(new Employee("Jane", "Female"));
		listEmployee.add(new Employee("Mickey", "Male"));
		listEmployee.add(new Employee("Minnie", "Female"));
		listEmployee.add(new Employee("Donald", "Male"));
		listEmployee.add(new Employee("Daisy", "Female"));
	}

	@RequestMapping(value ="/employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> employee(@RequestParam(value = "gender", defaultValue = "Male") String gender) {
		List<Employee> result = new ArrayList<Employee>();
		for (Employee entry : listEmployee) {
			if (entry.getGender().equals(gender)) {
				result.add(entry);
			}
		}
		return result;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	public Employee employeePost(@RequestBody Employee emp) {
		listEmployee.add(emp);
		return listEmployee.get(listEmployee.size()-1);
	}
}
