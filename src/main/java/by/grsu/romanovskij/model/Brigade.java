package by.grsu.romanovskij.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brigade")
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer brigadeId;
    private String brigadeNumber;

    @OneToMany(mappedBy="brigade")
    private Set<Employee> employeeSet;

    @OneToMany(mappedBy="brigade")
    private Set<Flight> flightSet;

    public Brigade() {
    }

    public Brigade(String brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }

    public Integer getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Integer brigadeId) {
        this.brigadeId = brigadeId;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Flight> getFlightSet() {
        return flightSet;
    }

    public void setFlightSet(Set<Flight> flightSet) {
        this.flightSet = flightSet;
    }

    public String getBrigadeNumber() {
        return brigadeNumber;
    }

    public void setBrigadeNumber(String brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }

    @Override
    public String toString() {
        String result = "Brigade{" +
                "brigadeId=" + brigadeId +
                ", brigadeNumber='" + brigadeNumber + '\'' +
                '}';
        if (employeeSet != null) {
            for(Employee employee : employeeSet) {
                result += "Employee{" +
                        "employeeId=" + employee.getEmployeeId() +
                        ", employeeFirstName='" + employee.getEmployeeFirstName() + '\'' +
                        ", employeeLastName='" + employee.getEmployeeLastName() + '\'' +
                        ", employeeMiddleName='" + employee.getEmployeeMiddleName() + '\'' +
                        '}';
            }
        }

        return result;
    }
}
