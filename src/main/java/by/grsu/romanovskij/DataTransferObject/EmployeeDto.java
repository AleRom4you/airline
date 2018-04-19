package by.grsu.romanovskij.DataTransferObject;

import by.grsu.romanovskij.model.Brigade;
import by.grsu.romanovskij.model.EmployeePositions;

import javax.validation.constraints.NotEmpty;

public class EmployeeDto {
    private Integer employeeId;
    @NotEmpty
    private String employeeFirstName;
    @NotEmpty
    private String employeeLastName;
    @NotEmpty
    private String employeeMiddleName;
    @NotEmpty
    private Brigade brigade;
    @NotEmpty
    private EmployeePositions employeePositions;

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

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public EmployeePositions getEmployeePositions() {
        return employeePositions;
    }

    public void setEmployeePositions(EmployeePositions employeePositions) {
        this.employeePositions = employeePositions;
    }
}
