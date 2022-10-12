package ru.spring.teamservice.service;

import ru.spring.teamservice.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllUserRoles();

    boolean saveNewRole(Role role);
}
