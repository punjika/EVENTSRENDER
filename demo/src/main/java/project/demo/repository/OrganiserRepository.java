package project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.entity.Organiser;

public interface OrganiserRepository extends JpaRepository<Organiser, Long> {
    // Additional custom queries can be added here if needed
}
