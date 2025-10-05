package project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.demo.entity.Organiser;
import project.demo.service.OrganiserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organisers")
public class OrganiserController {

    @Autowired
    private OrganiserService organiserService;

    // Get all organisers
    @GetMapping
    public List<Organiser> getAllOrganisers() {
        return organiserService.getAllOrganisers();
    }

    // Get organiser by ID
    @GetMapping("/{id}")
    public ResponseEntity<Organiser> getOrganiserById(@PathVariable Long id) {
        Optional<Organiser> organiser = organiserService.getOrganiserById(id);
        return organiser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new organiser
    @PostMapping
    public Organiser addOrganiser(@RequestBody Organiser organiser) {
        return organiserService.addOrganiser(organiser);
    }

    // Update an organiser
    @PutMapping("/{id}")
    public ResponseEntity<Organiser> updateOrganiser(@PathVariable Long id, @RequestBody Organiser organiserDetails) {
        Organiser updatedOrganiser = organiserService.updateOrganiser(id, organiserDetails);
        return ResponseEntity.ok(updatedOrganiser);
    }

    // Delete an organiser
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganiser(@PathVariable Long id) {
        organiserService.deleteOrganiser(id);
        return ResponseEntity.noContent().build();
    }
}
