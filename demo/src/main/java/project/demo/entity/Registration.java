package project.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate registrationDate;

    // Foreign Key: Event
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventSchedule event;

    // Foreign Key: Participant
    private Long participant_id;

    // Constructors
    public Registration() {}

    public Registration(LocalDate registrationDate, EventSchedule event, Long participant_id) {
        this.registrationDate = registrationDate;
        this.event = event;
        this.participant_id = participant_id;
    }

    // Getters and Setters
    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public EventSchedule getEvent() {
        return event;
    }

    public void setEvent(EventSchedule event) {
        this.event = event;
    }

    public Long getparticipant_id() {
        return participant_id;
    }

    public void setparticipant_id(Long participant_id) {
        this.participant_id = participant_id;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(registrationId, that.registrationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", registrationDate=" + registrationDate +
                ", event=" + event +
                ", participant=" + participant_id +
                '}';
    }
}
