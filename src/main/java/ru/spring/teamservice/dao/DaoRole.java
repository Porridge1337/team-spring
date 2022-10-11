package ru.spring.teamservice.dao;

import ru.spring.teamservice.model.Role;

import java.util.List;

public interface DaoRole {

    List<Role> findUserRoles();

    boolean saveNewRole(Role role);
}
