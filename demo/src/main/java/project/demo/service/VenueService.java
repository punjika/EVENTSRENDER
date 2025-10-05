package project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.entity.Venue;
import project.demo.repository.VenueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    // Get all venues
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    // Get venue by ID
    public Optional<Venue> getVenueById(Long venueId) {
        return venueRepository.findById(venueId);
    }

    // Add a new venue
    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Update an existing venue
    public Venue updateVenue(Long venueId, Venue venueDetails) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found"));
        venue.setVenueName(venueDetails.getVenueName());
        venue.setCapacity(venueDetails.getCapacity());
        venue.setLocation(venueDetails.getLocation());
        return venueRepository.save(venue);
    }

    // Delete a venue
    public void deleteVenue(Long venueId) {
        venueRepository.deleteById(venueId);
    }
}

