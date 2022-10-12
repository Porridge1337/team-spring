package ru.spring.teamservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.teamservice.dao.DaoGroup;
import ru.spring.teamservice.model.Group;
import ru.spring.teamservice.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final DaoGroup daoGroup;

    @Autowired
    public GroupServiceImpl(DaoGroup daoGroup) {
        this.daoGroup = daoGroup;
    }

    @Override
    public List<Group> findAllGroups() {
        return daoGroup.findAllGroups();
    }

    @Override
    public boolean saveGroup(Group group) {
        return daoGroup.saveGroup(group);
    }

    @Override
    public boolean updateGroup(Group group, int id) {
        return daoGroup.updateGroup(group, id);
    }

    @Override
    public boolean deleteGroupById(int id) {
        return daoGroup.deleteGroupById(id);
    }
}
