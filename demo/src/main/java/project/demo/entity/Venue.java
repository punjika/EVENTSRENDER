package project.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "venue")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    // @Column(name = "venue_name", nullable = false)
    private String venueName;

    // @Column(name = "capacity", nullable = false)
    private int capacity;

    // @Column(name = "location", nullable = false)
    private String location;

    // Constructors
    public Venue() {}

    public Venue(String venueName, int capacity, String location) {
        this.venueName = venueName;
        this.capacity = capacity;
        this.location = location;
    }

    // Getters and Setters
    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(venueId, venue.venueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueId);
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", venueName='" + venueName + '\'' +
                ", capacity=" + capacity +
                ", location='" + location + '\'' +
                '}';
    }
}
