package btl.web.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;

import btl.Car;
import btl.data.CarRepository;

@RestController
@RequestMapping(path = "/car", produces = "application/json")
@CrossOrigin(origins = "*")
public class CarController {
	private CarRepository carRepo;
	
	@Autowired
	EntityLinks entityLinks;
	public CarController(CarRepository carRepo) {
		this.carRepo = carRepo;
	}
	
	@GetMapping("/recent")
	public Iterable<Car> getAllIngredients() {
		return carRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Car carById(@PathVariable("id") Long id) {
		Optional<Car> optCar = carRepo.findById(id);
		if (optCar.isPresent()) {
			return optCar.get();
		}
		return null;
	}
	
	@GetMapping("/find/{brandname}")
	public Iterable<Car> carByBrandname(@PathVariable("brandname") String brandname) {
		 return carRepo.findByBrandnameLike(brandname);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Car postCar(@RequestBody Car car) {
		return carRepo.save(car);
	}

	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable("id") Long id) {
		try {
			carRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {}
	} 
	
	@PutMapping("/{id}")
	public Car putIngredient(@RequestBody Car car) {
		return carRepo.save(car);
	} 
}
