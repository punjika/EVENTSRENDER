package project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.entity.Club;
import project.demo.repository.ClubRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    // Add a new club
    public Club addClub(Club club) {
        return clubRepository.save(club);
    }

    // Get all clubs
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    // Get club by id
    public Optional<Club> getClubById(Long id) {
        return clubRepository.findById(id);
    }

    // Update club
    public Club updateClub(Long id, Club updatedClub) {
        return clubRepository.findById(id).map(club -> {
            club.setClub_name(updatedClub.getClub_name());
            club.setClub_head(updatedClub.getClub_head());
            club.setClub_description(updatedClub.getClub_description());
            return clubRepository.save(club);
        }).orElseThrow(() -> new RuntimeException("Club not found"));
    }

    // Delete club by id
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }
}
