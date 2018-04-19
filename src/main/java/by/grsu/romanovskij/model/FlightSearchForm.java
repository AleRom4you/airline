package by.grsu.romanovskij.model;

import java.sql.Timestamp;

public class FlightSearchForm {
    private String fromPlace;
    private String toPlace;

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }
}
