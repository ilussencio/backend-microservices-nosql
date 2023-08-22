package com.iftm.startexample.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iftm.startexample.models.User;
import com.iftm.startexample.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    //CRUD
    //ReadAll
    public ResponseEntity<List<User>> findAll(){
        var dbUsers = repository.findAll();
        if(dbUsers.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dbUsers);
    }

    //ReadOne
    public ResponseEntity<User> findOne(ObjectId objectId){
        var dbUser = repository.findById(objectId);
        if(dbUser.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dbUser.get());
    }

    //Insert
    public ResponseEntity<User> save(User user){
        //verificacao
        if(user.getName().isBlank() || user.getAge() <= 0)
            return ResponseEntity.badRequest().build();
        
        return ResponseEntity.ok(repository.save(user));
    }

    //update
    public ResponseEntity<User> update(User user){
        if(user.getId() == null || user.getId.toString.isBlank())
            return ResponseEntity.badRequest().build();

        var dbUser = repository.findById(user.getId());

        if(dbUser.isEmpty())
            return ResponseEntity.notFound().build();

        var dbUserObj = dbUser.get();
        dbUserObj.setName(user.getName);
        dbUserObj.setAge(user.getAge);
        dbUserObj.setAddress(user.setAddress);
        return ResponseEntity.ok(repository.save(dbUserObj));
    }

    //delete
    public ResponseEntity<?> delete(ObjectId objectId){
        repository.deleteById(objectId);
        var dbUser = repository.findById(objectId);
        if(dbUser.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok();
    }

}
