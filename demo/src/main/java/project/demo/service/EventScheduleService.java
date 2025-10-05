package project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.EventSchedule;
import project.demo.entity.Club;
import project.demo.entity.Venue;
import project.demo.entity.Organiser;
import project.demo.repository.EventScheduleRepository;

import java.util.List;
import java.util.Optional;
@Service
public class EventScheduleService {

    @Autowired
    private EventScheduleRepository repository;

    public List<EventSchedule> getAllEventSchedules() {
        return repository.findAll();
    }

    public Optional<EventSchedule> getEventScheduleById(Long event_id) {
        return repository.findById(event_id);
    }

    public EventSchedule createEventSchedule(EventSchedule eventSchedule) {
        return repository.save(eventSchedule);
    }

    public EventSchedule updateEventSchedule(Long event_id, EventSchedule newEventSchedule) {
        return repository.findById(event_id)
                .map(event -> {
                    event.setEvent_name(newEventSchedule.getEvent_name());
                    event.setEvent_description(newEventSchedule.getEvent_description());
                    event.setTime(newEventSchedule.getTime());
                    event.setDate(newEventSchedule.getDate());
                    // event.setVenue_ID(newEventSchedule.getVenue_ID());
                    event.setVenue(newEventSchedule.getVenue());
                    event.setCoordinator_ID(newEventSchedule.getCoordinator_ID());
                    // event.setOrganiser_ID(newEventSchedule.getOrganiser_ID());
                    event.setOrganiser(newEventSchedule.getOrganiser());
                    event.setClub(newEventSchedule.getClub());
                    return repository.save(event);
                })
                .orElseGet(() -> {
                    newEventSchedule.setEvent_id(event_id);
                    return repository.save(newEventSchedule);
                });
    }

    public void deleteEventSchedule(Long id) {
        repository.deleteById(id);
    }
}


