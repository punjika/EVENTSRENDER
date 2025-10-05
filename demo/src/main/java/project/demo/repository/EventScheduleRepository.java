package project.demo.repository;

// public interface EventScheduleRepository {

// }

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.entity.EventSchedule;

@Repository
public interface EventScheduleRepository extends JpaRepository<EventSchedule, Long> {
}

