package com.accolite.studentManagement.controller;

import com.accolite.studentManagement.models.Ids;
import com.accolite.studentManagement.models.User;
import com.accolite.studentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public User getUserDetails(@PathVariable int id)
    {
        return userService.getUserDetails(id);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user)
    {
        System.out.println(user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable int id)
    {
        return userService.deleteUser(id);
    }

    @GetMapping("/")
    public List<User> getAll()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public boolean addCourse(@RequestBody Ids ids){ return  userService.addCourse(ids);}
}
