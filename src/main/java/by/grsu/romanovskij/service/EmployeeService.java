package by.grsu.romanovskij.service;

import by.grsu.romanovskij.model.Employee;

public interface EmployeeService {
    Employee kickFromBrigade(Integer employeeId);

    Employee addToBrigade(Integer employeeId, Integer brigadeId);
}
