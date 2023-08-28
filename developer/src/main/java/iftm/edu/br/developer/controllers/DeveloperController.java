package iftm.edu.br.developer.controllers;

import iftm.edu.br.developer.dto.DeveloperDTO;
import iftm.edu.br.developer.models.Developer;
import iftm.edu.br.developer.services.DeveloperService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll(){
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable ObjectId id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> save(@RequestBody DeveloperDTO developer){
        return service.save(developer);
    }

    @PutMapping()
    public ResponseEntity<DeveloperDTO> update(@RequestBody DeveloperDTO developer){
        return service.update(developer);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable ObjectId id){
        return service.delete(id);
    }

}
