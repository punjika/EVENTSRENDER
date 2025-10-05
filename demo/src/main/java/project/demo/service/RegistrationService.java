package project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.entity.Registration;
import project.demo.repository.RegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    // Get all registrations
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    // Get registration by ID
    public Optional<Registration> getRegistrationById(Long registrationId) {
        return registrationRepository.findById(registrationId);
    }

    // Add a new registration
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    // Update an existing registration
    public Registration updateRegistration(Long registrationId, Registration registrationDetails) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
        registration.setRegistrationDate(registrationDetails.getRegistrationDate());
        registration.setEvent(registrationDetails.getEvent());
        registration.setparticipant_id(registrationDetails.getparticipant_id());
        return registrationRepository.save(registration);
    }

    // Delete a registration
    public void deleteRegistration(Long registrationId) {
        registrationRepository.deleteById(registrationId);
    }
}
