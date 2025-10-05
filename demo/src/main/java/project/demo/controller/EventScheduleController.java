// // package project.demo.controller;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.*;

// // import project.demo.entity.EventSchedule;
// // import project.demo.service.EventScheduleService;

// // import java.util.List;
// // import java.util.Optional;

// // @RestController
// // @RequestMapping("/api/event-schedule")
// // public class EventScheduleController {

// //     @Autowired
// //     private EventScheduleService service;

// //     @GetMapping
// //     public List<EventSchedule> getAllEventSchedules() {
// //         return service.getAllEventSchedules();
// //     }

// //     @GetMapping("/{event_id}")
// //     public ResponseEntity<EventSchedule> getEventScheduleByevent_id(@PathVariable Long event_id) {
// //         Optional<EventSchedule> eventSchedule = service.getEventScheduleByevent_id(event_id);
// //         return eventSchedule.map(ResponseEntity::ok)
// //                             .orElse(ResponseEntity.notFound().build());
// //     }

// //     @PostMapping("/create")
// //     public EventSchedule createEventSchedule(@RequestBody EventSchedule eventSchedule) {
// //         return service.createEventSchedule(eventSchedule);
// //     }

// //     @PutMapping("/{event_id}")
// //     public ResponseEntity<EventSchedule> updateEventSchedule(@PathVariable Long event_id, @RequestBody EventSchedule newEventSchedule) {
// //         return ResponseEntity.ok(service.updateEventSchedule(event_id, newEventSchedule));
// //     }

// //     @DeleteMapping("/{event_id}")
// //     public ResponseEntity<Voevent_id> deleteEventSchedule(@PathVariable Long event_id) {
// //         service.deleteEventSchedule(event_id);
// //         return ResponseEntity.noContent().build();
// //     }
// // }


// package project.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import project.demo.entity.EventSchedule;
// import project.demo.service.EventScheduleService;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/event-schedule")
// public class EventScheduleController {

//     private static final Logger logger = LoggerFactory.getLogger(EventScheduleController.class);

//     @Autowired
//     private EventScheduleService service;

//     @GetMapping
//     public List<EventSchedule> getAllEventSchedules() {
//         logger.info("Fetching all event schedules.........");
//         List<EventSchedule> eventSchedules = service.getAllEventSchedules();
//         logger.info("Found {} event schedules", eventSchedules.size());
//         return eventSchedules;
//     }

//     @GetMapping("/{event_id}")
//     public ResponseEntity<EventSchedule> getEventScheduleById(@PathVariable Long event_id) {
//         logger.info("Fetching event schedule with event_id: {}", event_id);
//         Optional<EventSchedule> eventSchedule = service.getEventScheduleById(event_id);
        
//         if (eventSchedule.isPresent()) {
//             logger.info("Event schedule found with event_id: {}", event_id);
//             return ResponseEntity.ok(eventSchedule.get());
//         } else {
//             logger.warn("Event schedule with event_id: {} not found", event_id);
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PostMapping("/create")
//     public EventSchedule createEventSchedule(@RequestBody EventSchedule eventSchedule) {
//         logger.info("Creating a new event schedule: {}", eventSchedule);
//         EventSchedule createdEventSchedule = service.createEventSchedule(eventSchedule);
//         logger.info("Event schedule created with event_id: {}", createdEventSchedule.getEvent_id());
//         return createdEventSchedule;
//     }

//     @PutMapping("/{event_id}")
//     public ResponseEntity<EventSchedule> updateEventSchedule(@PathVariable Long event_id, @RequestBody EventSchedule newEventSchedule) {
//         logger.info("Updating event schedule with event_id: {}", event_id);
//         EventSchedule updatedEventSchedule = service.updateEventSchedule(event_id, newEventSchedule);
//         logger.info("Event schedule updated with event_id: {}", event_id);
//         return ResponseEntity.ok(updatedEventSchedule);
//     }




//     @DeleteMapping("/{event_id}")
//     public ResponseEntity<Void> deleteEventSchedule(@PathVariable Long event_id) {
//         logger.info("Deleting event schedule with event_id: {}", event_id);
//         service.deleteEventSchedule(event_id);
//         logger.info("Event schedule with event_id: {} deleted", event_id);
//         return ResponseEntity.noContent().build();
//     }
// }


package project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.demo.entity.EventSchedule;
import project.demo.service.EventScheduleService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/event-schedule")
public class EventScheduleController {

    private static final Logger logger = LoggerFactory.getLogger(EventScheduleController.class);

    @Autowired
    private EventScheduleService service;

    @GetMapping
    public List<EventSchedule> getAllEventSchedules() {
        logger.info("Fetching all event schedules...");
        List<EventSchedule> eventSchedules = service.getAllEventSchedules();
        logger.info("Found {} event schedules", eventSchedules.size());
        return eventSchedules;
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventSchedule> getEventScheduleById(@PathVariable Long eventId) {
        logger.info("Fetching event schedule with event_id: {}", eventId);
        Optional<EventSchedule> eventSchedule = service.getEventScheduleById(eventId);
        
        if (eventSchedule.isPresent()) {
            logger.info("Event schedule found with event_id: {}", eventId);
            return ResponseEntity.ok(eventSchedule.get());
        } else {
            logger.warn("Event schedule with event_id: {} not found", eventId);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<EventSchedule> createEventSchedule(@RequestBody EventSchedule eventSchedule) {
        logger.info("Creating a new event schedule: {}", eventSchedule);
        EventSchedule createdEventSchedule = service.createEventSchedule(eventSchedule);
        logger.info("Event schedule created with event_id: {}", createdEventSchedule.getEvent_id());
        return ResponseEntity.status(201).body(createdEventSchedule); // Return created status
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventSchedule> updateEventSchedule(@PathVariable Long eventId, @RequestBody EventSchedule newEventSchedule) {
        logger.info("Updating event schedule with event_id: {}", eventId);
        EventSchedule updatedEventSchedule = service.updateEventSchedule(eventId, newEventSchedule);
        logger.info("Event schedule updated with event_id: {}", eventId);
        return ResponseEntity.ok(updatedEventSchedule);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEventSchedule(@PathVariable Long eventId) {
        logger.info("Deleting event schedule with event_id: {}", eventId);
        service.deleteEventSchedule(eventId);
        logger.info("Event schedule with event_id: {} deleted", eventId);
        return ResponseEntity.noContent().build();
    }
}
