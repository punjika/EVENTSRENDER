package project.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long club_id;  // Primary key

    private String club_name;
    private String club_head;
    private String club_description;

    // Constructors
    public Club() {}

    public Club(String club_name, String club_head, String club_description) {
        this.club_name = club_name;
        this.club_head = club_head;
        this.club_description = club_description;
    }

    // Getters and Setters
    public Long getClub_id() {
        return club_id;
    }

    public void setClub_id(Long club_id) {
        this.club_id = club_id;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getClub_head() {
        return club_head;
    }

    public void setClub_head(String club_head) {
        this.club_head = club_head;
    }

    public String getClub_description() {
        return club_description;
    }

    public void setClub_description(String club_description) {
        this.club_description = club_description;
    }
}
