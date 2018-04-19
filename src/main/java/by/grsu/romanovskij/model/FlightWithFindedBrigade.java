package by.grsu.romanovskij.model;

import javax.persistence.*;
import java.sql.Timestamp;

public class FlightWithFindedBrigade {
    private Integer flightId;
    private String airplaneName;
    private Timestamp datetimeFrom;
    private Timestamp datetimeTo;
    private Float flightCost;

    private Brigade brigade;
    private Place placeFrom;
    private Place placeTo;

    @Override
    public String toString() {
        return "FlightWithFindedBrigade{" +
                "flightId=" + flightId +
                ", airplaneName='" + airplaneName + '\'' +
                ", datetimeFrom=" + datetimeFrom +
                ", datetimeTo=" + datetimeTo +
                ", flightCost=" + flightCost +
                ", brigade=" + brigade +
                ", placeFrom=" + placeFrom +
                ", placeTo=" + placeTo +
                '}';
    }

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

    public Timestamp getDatetimeFrom() {
        return datetimeFrom;
    }

    public void setDatetimeFrom(Timestamp datetimeFrom) {
        this.datetimeFrom = datetimeFrom;
    }

    public Timestamp getDatetimeTo() {
        return datetimeTo;
    }

    public void setDatetimeTo(Timestamp datetimeTo) {
        this.datetimeTo = datetimeTo;
    }

    public Float getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(Float flightCost) {
        this.flightCost = flightCost;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public Place getPlaceFrom() {
        return placeFrom;
    }

    public void setPlaceFrom(Place placeFrom) {
        this.placeFrom = placeFrom;
    }

    public Place getPlaceTo() {
        return placeTo;
    }

    public void setPlaceTo(Place placeTo) {
        this.placeTo = placeTo;
    }
}
