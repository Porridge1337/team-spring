package ru.spring.teamservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.spring.teamservice.dao.DaoGroup;
import ru.spring.teamservice.model.Group;

import java.util.List;

@Component
public class DaoGroupImpl implements DaoGroup {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Group> groupRowMapper = (rs, rowNum) ->
            new Group(rs.getInt("g_id"), rs.getString("groupname"));

    @Autowired
    public DaoGroupImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Group> findAllGroups() {
        final String sql = "SELECT * FROM service.groups";
        return jdbcTemplate.query(sql, groupRowMapper);
    }

    @Override
    public boolean saveGroup(Group group) {
        final String sql = "INSERT INTO service.groups (groupname) VALUES (?)";
        return jdbcTemplate.update(sql, group.getGroup()) > 0;
    }

    @Override
    public boolean updateGroup(Group group, int id) {
        final String sql = "UPDATE service.groups SET groupname = ? WHERE g_id = ?";
        return jdbcTemplate.update(sql, group.getGroup(), id) > 0;
    }

    @Override
    public boolean deleteGroupById(int id) {
        final String sql = "DELETE from service.groups WHERE g_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
