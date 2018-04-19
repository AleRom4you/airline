package by.grsu.romanovskij.service;

import by.grsu.romanovskij.model.Employee;
import by.grsu.romanovskij.repository.BrigadeRepository;
import by.grsu.romanovskij.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BrigadeRepository brigadeRepository;

    @Override
    public Employee kickFromBrigade(Integer employeeId) {
        Employee employee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        employee.setBrigade(brigadeRepository.findBrigadeByBrigadeNumber("Without Brigade"));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee addToBrigade(Integer employeeId, Integer brigadeId) {
        Employee employee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        employee.setBrigade(brigadeRepository.findBrigadeByBrigadeId(brigadeId));
        return employeeRepository.save(employee);
    }
}
