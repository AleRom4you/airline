package by.grsu.romanovskij.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee_positions")
public class EmployeePositions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeepositionsId;
    private String employeepositionsName;

    @OneToMany(mappedBy="employeePositions")
    private Set<Employee> employeeSet;

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Integer getEmployeepositionsId() {
        return employeepositionsId;
    }

    public void setEmployeepositionsId(Integer employeepositionsId) {
        this.employeepositionsId = employeepositionsId;
    }

    public String getEmployeepositionsName() {
        return employeepositionsName;
    }

    public void setEmployeepositionsName(String employeepositionsName) {
        this.employeepositionsName = employeepositionsName;
    }
}
