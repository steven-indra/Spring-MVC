package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		listEmployee.add(new Employee(1,"John", "Male"));
		listEmployee.add(new Employee(2,"Johnny", "Male"));
		listEmployee.add(new Employee(3,"Mary", "Female"));
		listEmployee.add(new Employee(4,"Travolta", "Male"));
		listEmployee.add(new Employee(5,"Jane", "Female"));
		listEmployee.add(new Employee(6,"Mickey", "Male"));
		listEmployee.add(new Employee(7,"Minnie", "Female"));
		listEmployee.add(new Employee(8,"Donald", "Male"));
		listEmployee.add(new Employee(9,"Daisy", "Female"));
	}

	@RequestMapping(value ="/employees/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployee(@PathVariable(value = "id") int id) {
		Employee result = null;
		for (Employee entry : listEmployee) {
			if (entry.getId() == id) {
				result = entry;
			}
		}
		if (result == null)
		{
			throw new EmployeeNotFoundException();
		}else
		{
			return result;
		}
	}
	
	@RequestMapping(value ="/employees", method = RequestMethod.GET)
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

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	@ResponseBody
	public Employee employeePost(@RequestBody Employee emp) {
		listEmployee.add(emp);
		return listEmployee.get(listEmployee.size()-1);
	}
}
