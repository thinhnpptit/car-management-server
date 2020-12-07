package btl.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import btl.Trip;

public interface TripRepository extends CrudRepository<Trip, Long>{
//	@Query("select u from Trip u where u.driver_id = ?1")
	List<Trip> findByDriverId(Long id);
	
//	@Query("select u from Trip u where u.subdriver_id = ?1")
	List<Trip> findBySubdriverId(Long id);
	
//	@Query("select u from Trip u where u.car =?1")
	List<Trip> findByCarId(Long id);
	
//	@Query("SELECT m FROM Trip m WHERE m.route_id LIKE %?1%")
	@Query("SELECT u FROM Trip u WHERE u.route.id =?1")
	List<Trip> findByRouteId(Long id);
}
