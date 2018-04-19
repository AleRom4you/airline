package by.grsu.romanovskij.DataTransferObject;

import javax.validation.constraints.NotEmpty;

public class FlightDto {
    private Integer flightId;
    @NotEmpty
    private String airplaneName;
    @NotEmpty
    private String datetimeFrom;
    @NotEmpty
    private String datetimeTo;
    @NotEmpty
    private String flightCost;
    @NotEmpty
    private String brigadeId;
    @NotEmpty
    private String placeFrom;
    @NotEmpty
    private String placeTo;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getDatetimeFrom() {
        return datetimeFrom;
    }

    public void setDatetimeFrom(String datetimeFrom) {
        this.datetimeFrom = datetimeFrom;
    }

    public String getDatetimeTo() {
        return datetimeTo;
    }

    public void setDatetimeTo(String datetimeTo) {
        this.datetimeTo = datetimeTo;
    }

    public String getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(String flightCost) {
        this.flightCost = flightCost;
    }

    public String getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(String brigadeId) {
        this.brigadeId = brigadeId;
    }

    public String getPlaceFrom() {
        return placeFrom;
    }

    public void setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
    }

    public String getPlaceTo() {
        return placeTo;
    }

    public void setPlaceTo(String placeTo) {
        this.placeTo = placeTo;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "flightId=" + flightId +
                ", airplaneName='" + airplaneName + '\'' +
                ", datetimeFrom='" + datetimeFrom + '\'' +
                ", datetimeTo='" + datetimeTo + '\'' +
                ", flightCost='" + flightCost + '\'' +
                ", brigadeId='" + brigadeId + '\'' +
                ", placeFrom='" + placeFrom + '\'' +
                ", placeTo='" + placeTo + '\'' +
                '}';
    }
}
