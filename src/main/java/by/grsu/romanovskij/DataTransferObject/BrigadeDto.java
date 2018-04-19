package by.grsu.romanovskij.DataTransferObject;

import javax.validation.constraints.NotEmpty;

public class BrigadeDto {
    private Integer brigadeId;
    @NotEmpty
    private String brigadeNumber;

    public Integer getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Integer brigadeId) {
        this.brigadeId = brigadeId;
    }

    public String getBrigadeNumber() {
        return brigadeNumber;
    }

    public void setBrigadeNumber(String brigadeNumber) {
        this.brigadeNumber = brigadeNumber;
    }
}
