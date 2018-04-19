package by.grsu.romanovskij.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer flightId;
    private String airplaneName;
    private Timestamp datetimeFrom;
    private Timestamp datetimeTo;
    private Float flightCost;
    private Integer placeToId;
    private Integer placeFromId;

    @ManyToOne
    @JoinColumn(name="brigade_id", nullable=false)
    private Brigade brigade;

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public Integer getPlaceToId() {
        return placeToId;
    }

    public void setPlaceToId(Integer placeToId) {
        this.placeToId = placeToId;
    }

    public Integer getPlaceFromId() {
        return placeFromId;
    }

    public void setPlaceFromId(Integer placeFromId) {
        this.placeFromId = placeFromId;
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

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", airplaneName='" + airplaneName + '\'' +
                ", datetimeFrom=" + datetimeFrom +
                ", datetimeTo=" + datetimeTo +
                ", flightCost=" + flightCost +
                ", placeToId=" + placeToId +
                ", placeFromId=" + placeFromId +
                ", brigade=" + brigade +
                '}';
    }
}
