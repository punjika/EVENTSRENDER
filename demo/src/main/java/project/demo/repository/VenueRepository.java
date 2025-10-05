package project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    // Custom query methods can be defined here, if needed
}
