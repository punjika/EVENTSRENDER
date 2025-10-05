package project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.demo.entity.Club;
import project.demo.service.ClubService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    // Create a new club
    @PostMapping
    public Club addClub(@RequestBody Club club) {
        return clubService.addClub(club);
    }

    // Get all clubs
    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    // Get a club by ID
    @GetMapping("/{id}")
    public Optional<Club> getClubById(@PathVariable Long id) {
        return clubService.getClubById(id);
    }

    // Update a club by ID
    @PutMapping("/{id}")
    public Club updateClub(@PathVariable Long id, @RequestBody Club updatedClub) {
        return clubService.updateClub(id, updatedClub);
    }

    // Delete a club by ID
    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
    }
}

