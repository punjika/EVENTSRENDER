package project.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "organiser")
public class Organiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organiserId;

    // @Column(name = "organiser_name", nullable = false)
    private String organiserName;

    // @Column(name = "contact_info", nullable = true)
    private String contactInfo;

    // @Column(name = "role", nullable = true)
    private String role;

    // Constructors
    public Organiser() {}

    public Organiser(String organiserName, String contactInfo, String role) {
        this.organiserName = organiserName;
        this.contactInfo = contactInfo;
        this.role = role;
    }

    // Getters and Setters
    public Long getOrganiserId() {
        return organiserId;
    }

    public void setOrganiserId(Long organiserId) {
        this.organiserId = organiserId;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public void setOrganiserName(String organiserName) {
        this.organiserName = organiserName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organiser organiser = (Organiser) o;
        return Objects.equals(organiserId, organiser.organiserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organiserId);
    }

    @Override
    public String toString() {
        return "Organiser{" +
                "organiserId=" + organiserId +
                ", organiserName='" + organiserName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
