package project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // Additional custom queries can be added here if needed
}
