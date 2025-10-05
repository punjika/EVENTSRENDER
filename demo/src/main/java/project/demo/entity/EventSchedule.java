// package project.demo.entity;

// // public class EventSchedule {

// // }
// // package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDate;
// import java.time.LocalTime;

// import com.fasterxml.jackson.annotation.JsonFormat;

// @Entity
// @Table(name = "event_schedules")
// public class EventSchedule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long event_id;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
//     private LocalTime time;
//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//     private LocalDate date;
//     private Long venueID;
//     private Long coordinatorID;

//     // Constructors, Getters, and Setters

//     public EventSchedule() {}

//     public EventSchedule(LocalTime time, LocalDate date, Long venueID, Long coordinatorID) {
//         this.time = time;
//         this.date = date;
//         this.venueID = venueID;
//         this.coordinatorID = coordinatorID;
//     }

    
//     public LocalTime getTime() {
//         return time;
//     }

//     public void setTime(LocalTime time) {
//         this.time = time;
//     }

//     public LocalDate getDate() {
//         return date;
//     }

//     public void setDate(LocalDate date) {
//         this.date = date;
//     }

//     public Long getVenueID() {
//         return venueID;
//     }

//     public void setVenueID(Long venueID) {
//         this.venueID = venueID;
//     }

//     public Long getCoordinatorID() {
//         return coordinatorID;
//     }

//     public void setCoordinatorID(Long coordinatorID) {
//         this.coordinatorID = coordinatorID;
//     }

//     public Long getEvent_id() {
//         return event_id;
//     }

//     public void setEvent_id(Long event_id) {
//         this.event_id = event_id;
//     }

//     // Getters and setters
    
// }


package project.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "event_schedules")
public class EventSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;
    
    private String event_name;
    private String event_description;

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    // private Long venue_ID;
    @ManyToOne(cascade = CascadeType.ALL) // Assuming Many Events can belong to one Venue
    @JoinColumn(name = "venue_id") // No nullable constraint to allow flexibility
    private Venue venue; // Reference to Venue object

    private Long coordinator_ID;

    // private Long organiser_ID;
    @ManyToOne // Assuming Many Events can belong to one Organiser
    @JoinColumn(name = "organiserId")
    private Organiser organiser; // Changed to an object reference instead of Long

    // private Long club_ID;
    @ManyToOne // Assuming Many Events can belong to one Club
    @JoinColumn(name = "club_id") // Added foreign key constraint for club_id
    private Club club; // Reference to Club object



    // public Long getClub_ID() {
    //     return club_ID;
    // }

    // public void setClub_ID(Long club_ID) {
    //     this.club_ID = club_ID;
    // }

    // Constructors
    public EventSchedule() {}

    public EventSchedule(LocalTime time, LocalDate date, Long venue_ID, Long coordinator_ID, Long organiserId, Long club_ID ) {
        this.time = time;
        this.date = date;
        // this.venue_ID = venue_ID;
        this.venue = venue;
        this.coordinator_ID = coordinator_ID;
        this.club = club;
        // this.organiser_ID=organiser_ID;
        this.organiser = organiser;
    }

    // Getters and setters
    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // public Long getVenue_ID() {
    //     return venue_ID;
    // }

    // public void setVenue_ID(Long venue_ID) {
    //     this.venue_ID = venue_ID;
    // }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Long getCoordinator_ID() {
        return coordinator_ID;
    }

    public void setCoordinator_ID(Long coordinator_ID) {
        this.coordinator_ID = coordinator_ID;
    }
    // public Long getOrganiser_ID() {
    //     return organiser_ID;
    // }

    // public void setOrganiser_ID(Long organiser_ID) {
    //     this.organiser_ID = organiser_ID;

    public Organiser getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
