package ru.spring.teamservice.dao.impl;

import ru.spring.teamservice.dao.DaoGroup;
import ru.spring.teamservice.model.Group;

import java.util.List;

public class DaoGroupImpl implements DaoGroup {
    @Override
    public List<Group> findAllGroups() {
        return null;
    }

    @Override
    public boolean saveGroup(Group group) {
        return false;
    }

    @Override
    public boolean updateGroup(Group group) {
        return false;
    }

    @Override
    public boolean deleteGroupById(int id) {
        return false;
    }
}
