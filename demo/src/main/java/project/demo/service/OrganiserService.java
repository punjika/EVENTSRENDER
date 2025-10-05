package project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.entity.Organiser;
import project.demo.repository.OrganiserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganiserService {

    @Autowired
    private OrganiserRepository organiserRepository;

    // Get all organisers
    public List<Organiser> getAllOrganisers() {
        return organiserRepository.findAll();
    }

    // Get organiser by ID
    public Optional<Organiser> getOrganiserById(Long organiserId) {
        return organiserRepository.findById(organiserId);
    }

    // Add a new organiser
    public Organiser addOrganiser(Organiser organiser) {
        return organiserRepository.save(organiser);
    }

    // Update an existing organiser
    public Organiser updateOrganiser(Long organiserId, Organiser organiserDetails) {
        Organiser organiser = organiserRepository.findById(organiserId)
                .orElseThrow(() -> new RuntimeException("Organiser not found"));
        organiser.setOrganiserName(organiserDetails.getOrganiserName());
        organiser.setContactInfo(organiserDetails.getContactInfo());
        organiser.setRole(organiserDetails.getRole());
        return organiserRepository.save(organiser);
    }

    // Delete an organiser
    public void deleteOrganiser(Long organiserId) {
        organiserRepository.deleteById(organiserId);
    }
}
