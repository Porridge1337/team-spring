package ru.spring.teamservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.teamservice.dao.DaoUser;
import ru.spring.teamservice.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamController {

    private final DaoUser daoUser;

    @Autowired
    public TeamController(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @GetMapping("/api/user/all")
    public List<User> getAllUsers() {
        return daoUser.findAll();
    }

    @GetMapping("/api/user/role/{role}")
    public List<User> getAllUsersByRole(@PathVariable(name = "role") String roleName) {
        return daoUser.findUsersByRole(roleName);
    }

    @GetMapping("/api/user/id/{userId}")
    public User getUserById(@PathVariable("userId") int id) {
        return daoUser.findUserById(id).orElse(null);
    }

    @PostMapping("/api/user/create")
    public boolean createUser(@RequestBody User emp) {
        return daoUser.save(emp);
    }

}
