package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by branden on 3/16/16 at 10:15.
 */
@RestController
public class AngularSpringController {
    @Autowired
    UserRepository userRepository;


    //get all users
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    //get just one user
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return userRepository.findOne(id);
    }

    //add a new user
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {    //@RequestBody requests the entire JSON object from form and automatically converts it into an object
        userRepository.save(user);
    }

    //edit a user
    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT)
    public void editUser(@RequestBody User user, @PathVariable("id") int id) {  //@PathVariable converts the {id} part into something we can use
        userRepository.save(user);
    }

    //delete a user
    @RequestMapping(path = "user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        userRepository.delete(id);
    }




}