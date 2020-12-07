package btl.data;

import org.springframework.data.repository.CrudRepository;

import btl.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
