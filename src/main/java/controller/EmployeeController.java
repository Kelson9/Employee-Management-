package controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Employee;
import exception.ResourceNotFoundException;
import repository.EmployeeRepository;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public  java.util.List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable(value = "id") int id){

	       Optional< Employee> employee = employeeRepository.findById(id);
	       if(employee==null)
	    	   throw new ResourceNotFoundException("id"+id);
	       return employee;
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		 return employeeRepository.save(employee);
		
	
}
	
    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") int id,
        @Valid @RequestBody Optional<Employee> employee) {
      employee = employeeRepository.findById(id);
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Optional<Employee> deleteEmployee(@PathVariable(value = "id") int id){
    	Optional<Employee> employee=employeeRepository.findById(id);
    	if(employee==null)
    		throw new ResourceNotFoundException("id-"+id);
    	return employee;
    
    	
    }
}


