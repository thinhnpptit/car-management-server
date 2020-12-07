package btl.web.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import btl.Employee;
import btl.data.EmployeeRepository;

@RestController
@RequestMapping(path = "/employee", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {
	private final EmployeeRepository emRepo;
	
	@Autowired
	EntityLinks entityLinks;
	public EmployeeController(EmployeeRepository emRepo) {
		this.emRepo = emRepo;
	}
	
	@GetMapping("/recent")
	public Iterable<Employee> getDriverById() {
		return emRepo.findAll();
	}
	
}
