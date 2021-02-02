package com.javainuse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.dao.TipoPagoRepository;
import com.javainuse.model.TipoPago;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200",
methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({ "/employees" })
@Api(value = "Users microservice generate cbm")
public class ClientesControllerAll {
	
	@Autowired
	private TipoPagoRepository tipoPagoRepository;

	//private List<Employee> employees = createList();

	/*@GetMapping(produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}*/
	
	@GetMapping(path="/listar")
	public List<TipoPago> getAllInventario() {
		return tipoPagoRepository.findAll();
		//return tipoPagoRepository.getByNameAll();
	}

	/*@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") int id) {
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}
*/
	/*@PostMapping
	@ApiOperation(value = "Crea nuevos empleados", notes = "Crea un nuevo empleado" )
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developerPrueba");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}
*/
}