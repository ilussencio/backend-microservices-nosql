package com.iftm.startexample.controllers;

@RestController("api/v1/users")
public class UserController(){
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return service.findAll();
    }
}