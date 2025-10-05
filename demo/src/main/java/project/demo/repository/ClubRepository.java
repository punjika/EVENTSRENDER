package project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
