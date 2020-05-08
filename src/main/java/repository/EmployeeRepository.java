package repository;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;


import entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee save(@Valid Optional<Employee> employee);


}
