package simsona.springcarscemo.date.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simsona.springcarscemo.date.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
