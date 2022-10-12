package ru.spring.teamservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.spring.teamservice.dao.DaoRole;
import ru.spring.teamservice.model.Role;

import java.util.List;

@Component
public class DaoRoleImpl implements DaoRole {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Role> roleRowMapper = (rs, rowNum) -> new Role(rs.getInt("r_id"),
            rs.getString("rolename"));

    @Autowired
    public DaoRoleImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findUserRoles() {
        final String sql = "SELECT * FROM service.roles";
        return jdbcTemplate.query(sql, roleRowMapper);
    }

    @Override
    public boolean saveNewRole(Role role) {
        final String sql = "INSERT INTO service.roles (rolename) VALUES (?)";
        return jdbcTemplate.update(sql, role.getRoleName()) > 0;
    }
}
