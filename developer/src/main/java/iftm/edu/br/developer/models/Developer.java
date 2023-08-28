package iftm.edu.br.developer.models;

import jakarta.websocket.DecodeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "developers")
public class Developer implements Serializable {

    @Id
    private ObjectId id;

    private String name;
    private String lastName;
    private String level;
    private String specialization;

    private Address address;
    private Sector sector;
}
