package by.grsu.romanovskij.repository;

import by.grsu.romanovskij.model.Brigade;
import by.grsu.romanovskij.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    long count();
    List<Employee> findAll();

    long countAllByBrigade(Brigade brigade);
    List<Employee> findEmployeesByBrigade(Brigade brigade);

    Employee findEmployeeByBrigade(Brigade brigade);
    Employee findEmployeeByEmployeeId(Integer employeeId);
}
