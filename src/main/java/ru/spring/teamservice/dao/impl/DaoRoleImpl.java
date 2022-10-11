package ru.spring.teamservice.dao.impl;

import ru.spring.teamservice.dao.DaoRole;
import ru.spring.teamservice.model.Role;

import java.util.List;

public class DaoRoleImpl implements DaoRole {
    @Override
    public List<Role> findUserRoles() {
        return null;
    }

    @Override
    public boolean saveNewRole(Role role) {
        return false;
    }
}
