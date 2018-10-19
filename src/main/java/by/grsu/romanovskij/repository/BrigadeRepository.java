package by.grsu.romanovskij.repository;

import by.grsu.romanovskij.model.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrigadeRepository extends JpaRepository<Brigade, Long> {
    long count();

    List<Brigade> findAll();
    List<Brigade> findAllByBrigadeNumberIsNot(String brigadeNumber);

    Brigade findBrigadeByBrigadeId(Integer brigadeId);
    Brigade findBrigadeByBrigadeNumber(String brigadeNumber);

    @Override
    void delete(Brigade brigade);
}
