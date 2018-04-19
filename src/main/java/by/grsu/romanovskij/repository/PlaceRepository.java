package by.grsu.romanovskij.repository;

import by.grsu.romanovskij.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAll();

    Place findByPlaceAbbreviation(String placeAbbreviation);
    Place findByPlaceId(Integer id);
}