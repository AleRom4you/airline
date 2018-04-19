package by.grsu.romanovskij.model;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer placeId;

    private String placeAbbreviation;
    private String placeName;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceAbbreviation() {
        return placeAbbreviation;
    }

    public void setPlaceAbbreviation(String placeAbbreviation) {
        this.placeAbbreviation = placeAbbreviation;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", placeAbbreviation='" + placeAbbreviation + '\'' +
                ", placeName='" + placeName + '\'' +
                '}';
    }
}
