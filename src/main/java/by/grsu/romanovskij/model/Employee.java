package by.grsu.romanovskij.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    private String employeeFirstName;
    private String employeeLastName;
    private String employeeMiddleName;
    @ManyToOne
    @JoinColumn(name="employeepositions_id", nullable=false)
    private EmployeePositions employeePositions;

    @ManyToOne
    @JoinColumn(name="brigade_id", nullable=false)
    private Brigade brigade;

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    public void setEmployeeMiddleName(String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }

    public EmployeePositions getEmployeePositions() {
        return employeePositions;
    }

    public void setEmployeePositions(EmployeePositions employeePositions) {
        this.employeePositions = employeePositions;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeMiddleName='" + employeeMiddleName + '\'' +
                '}';
    }
}
