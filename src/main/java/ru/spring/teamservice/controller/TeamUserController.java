package ru.spring.teamservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.teamservice.model.User;
import ru.spring.teamservice.service.UserService;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class TeamUserController {

    private final UserService userService;

    @Autowired
    public TeamUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/role/{role}")
    public List<User> getAllUsersByRole(@PathVariable(name = "role") String roleName) {
        return userService.findUsersByRole(roleName);
    }

    @GetMapping("/user/group/{groupId}")
    public List<User> getAllUsersByGroup(@PathVariable("groupName") String groupName) {
        return userService.findUsersByGroup(groupName);
    }

    @GetMapping("/user/id/{userId}")
    public User getUserById(@PathVariable("userId") int id) {
        return userService.findUserById(id).orElse(null);
    }

    @GetMapping("/user/login/{login}")
    public User getUserByLogin(@PathVariable("login") String login) {
        return userService.findUserByLogin(login).orElse(null);
    }

    @GetMapping("/user/telegramId/{telegramId}")
    public User getUserByTelegramId(@PathVariable("telegramId") String telegramId) {
        return userService.findUserByTelegramId(telegramId).orElse(null);
    }

    @PostMapping("/user/create")
    public boolean createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PatchMapping("/user/update/{id}")
    public boolean updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.update(user, id);
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
