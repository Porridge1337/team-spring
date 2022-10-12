package ru.spring.teamservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.teamservice.dao.DaoGroup;
import ru.spring.teamservice.model.Group;
import ru.spring.teamservice.service.GroupService;

import java.util.List;

@Service
@Transactional(readOnly = true)
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
    @Transactional
    public boolean saveGroup(Group group) {
        return daoGroup.saveGroup(group);
    }

    @Override
    @Transactional
    public boolean updateGroup(Group group, int id) {
        return daoGroup.updateGroup(group, id);
    }

    @Override
    @Transactional
    public boolean deleteGroupById(int id) {
        return daoGroup.deleteGroupById(id);
    }
}
