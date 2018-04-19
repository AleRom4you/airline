package by.grsu.romanovskij.repository;

import by.grsu.romanovskij.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    long count();
    List<Flight> findAll();

    long countAllByPlaceFromIdAndPlaceToId(Integer placeFrom, Integer placeTo);
    List<Flight> findAllByPlaceFromIdAndPlaceToId(Integer placeFrom, Integer placeTo);

    Flight findFlightByFlightId(Integer flightId);

    @Override
    void delete(Flight flight);
}