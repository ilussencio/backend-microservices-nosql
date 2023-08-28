package iftm.edu.br.developer.services;

import iftm.edu.br.developer.dto.DeveloperDTO;
import iftm.edu.br.developer.models.Developer;
import iftm.edu.br.developer.repositories.DeveloperRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository repository;

    public ResponseEntity<List<DeveloperDTO>> findAll() {
        var dbDevelopers = repository.findAll();
        if (dbDevelopers.isEmpty())
            return ResponseEntity.noContent().build();
        var developersDTO = dbDevelopers.stream().map(x -> new DeveloperDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(developersDTO);
    }

    public ResponseEntity<DeveloperDTO> findById(ObjectId id) {
        var dbDeveloper = repository.findById(id);
        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DeveloperDTO(dbDeveloper.get()));
    }

    public ResponseEntity<DeveloperDTO> save(DeveloperDTO developerDTO) {
        var developer = new Developer();
        developer.setName(developerDTO.getName());
        developer.setLastName(developerDTO.getLastName());
        developer.setLevel(developerDTO.getLevel());
        developer.setSpecialization(developerDTO.getSpecialization());
        developer.setAddress(developerDTO.getAddress());
        developer.setSector(developerDTO.getSector());

        var dbDeveloper = repository.save(developer);
        return ResponseEntity.ok(new DeveloperDTO(dbDeveloper));
    }

    public ResponseEntity<DeveloperDTO> update(DeveloperDTO developerDTO) {
        var developer = new Developer();

        developer.setId(new ObjectId(developerDTO.getId()));
        developer.setName(developerDTO.getName());
        developer.setLastName(developerDTO.getLastName());
        developer.setLevel(developerDTO.getLevel());
        developer.setSpecialization(developerDTO.getSpecialization());
        developer.setAddress(developerDTO.getAddress());
        developer.setSector(developerDTO.getSector());

        var dbDeveloper = repository.findById(developer.getId());
        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        repository.save(developer);
        return ResponseEntity.ok(new DeveloperDTO(developer));
    }

    public ResponseEntity<?> delete(ObjectId id) {
        var dbDeveloper = repository.findById(id);
        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();
        repository.delete(dbDeveloper.get());
        return ResponseEntity.ok().build();
    }
}
