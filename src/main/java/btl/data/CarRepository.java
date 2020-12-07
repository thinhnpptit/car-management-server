package btl.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import btl.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
	@Query("SELECT m FROM Car m WHERE m.brandname LIKE %?1%")
	List<Car> findByBrandnameLike(String brandname);
}
