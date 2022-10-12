package ru.spring.teamservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.teamservice.model.Role;
import ru.spring.teamservice.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamRoleController {

    private final RoleService roleService;

    @Autowired
    public TeamRoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role/all")
    public List<Role> getAllRoles() {
        return roleService.findAllUserRoles();
    }

    @PostMapping("/role/create")
    public boolean createRole(@RequestBody Role role) {
        return roleService.saveNewRole(role);
    }

}
