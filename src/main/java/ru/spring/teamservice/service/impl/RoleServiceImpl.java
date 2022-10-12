package ru.spring.teamservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.teamservice.dao.DaoRole;
import ru.spring.teamservice.model.Role;
import ru.spring.teamservice.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final DaoRole daoRole;

    @Autowired
    public RoleServiceImpl(DaoRole daoRole) {
        this.daoRole = daoRole;
    }

    @Override
    public List<Role> findAllUserRoles() {
        return daoRole.findUserRoles();
    }

    @Override
    public boolean saveNewRole(Role role) {
        return daoRole.saveNewRole(role);
    }
}
