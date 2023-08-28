package iftm.edu.br.developer.dto;

import iftm.edu.br.developer.models.Address;
import iftm.edu.br.developer.models.Developer;
import iftm.edu.br.developer.models.Sector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeveloperDTO implements Serializable {
    private String id;
    private String name;
    private String lastName;
    private String level;
    private String specialization;

    private Address address;
    private Sector sector;

    public DeveloperDTO(Developer developer){
        this.id = developer.getId().toString();
        this.name = developer.getName();
        this.lastName = developer.getLastName();
        this.level = developer.getLevel();
        this.specialization = developer.getSpecialization();
        this.address = developer.getAddress();
        this.sector = developer.getSector();
    }
}
