package btl.web.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import btl.Car;
import btl.Employee;
import btl.Pair;
import btl.Trip;
import btl.data.CarRepository;
import btl.data.EmployeeRepository;
import btl.data.TripRepository;
import lombok.extern.java.Log;

@RestController
@RequestMapping(path = "/trip", produces = "application/json")
@CrossOrigin(origins = "*") 
public class TripController {
	private final TripRepository tripRepo;
	
	@Autowired
	EntityLinks entityLinks;
	public TripController(TripRepository tripRepo) {
		this.tripRepo = tripRepo;
	}
	
	// FIND ALL trips
	@GetMapping("/recent")
	public Iterable<Trip> getAllTrip(){
		return tripRepo.findAll();
	}
	
	// FIND By others id
	@GetMapping("/drive/{id}")
	public Iterable<Trip> getDriverById(@PathVariable("id") Long id) {
		List<Trip> trip = new ArrayList<>();
		trip.addAll(tripRepo.findByDriverId(id));
		trip.addAll(tripRepo.findBySubdriverId(id));
		return trip;
	}

	@GetMapping("/car/{id}")
	public Iterable<Trip> showCarForm(@PathVariable("id") Long id) {
		return tripRepo.findByCarId(id); 
	}
	@GetMapping("/{id}")
	public Trip tripById(@PathVariable Long id) {
		Optional<Trip> tripOptional = tripRepo.findById(id);
		if(tripOptional.isPresent()) {
			return tripOptional.get();
		}
		return null;
	}
	@GetMapping("/find/{driverId}")
	public List<Trip> findByDriverId(@PathVariable Long driverId){
		return tripRepo.findByDriverId(driverId);
	}
	@GetMapping("/find/{route_id}")
	public List<Trip> findByRouteId(@PathVariable Long route_id){
		return tripRepo.findByRouteId(route_id);
	}
	
	// ADD Trip
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Trip postTrip(@RequestBody Trip trip) {
		return tripRepo.save(trip);
	}
	
	// Delete trip
	@DeleteMapping("/{id}")
	public void deleteTrip(@PathVariable Long id) {
		tripRepo.deleteById(id);;
	}
	
	// Add trips by id
	@PutMapping("/{id}")
	public Trip putTrip(@RequestBody Trip trip) {
		return tripRepo.save(trip);
	}
}
