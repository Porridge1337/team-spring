package ru.spring.teamservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.spring.teamservice.dao.DaoUser;
import ru.spring.teamservice.model.Group;
import ru.spring.teamservice.model.Role;
import ru.spring.teamservice.model.User;

import java.util.List;
import java.util.Optional;

@Component
public class DaoUserImpl implements DaoUser {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userRowMapper = (rs, rowNum) ->
            new User(rs.getInt("id"), rs.getString("login"), rs.getString("username"),
                    rs.getString("surname"), rs.getString("telegram_user"),
                    rs.getLong("telegram_id"), rs.getString("phone"), new Role(rs.getInt("r_id"),
                    rs.getString("rolename")), new Group(rs.getInt("g_id"), rs.getString("groupname")));

    @Autowired
    public DaoUserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        final String sql = "SELECT * FROM service.users as usr\n" +
                "join service.roles as rl\n" +
                "on usr.role_fk=rl.r_id\n" +
                "join service.groups as gr\n" +
                "on usr.group_fk = gr.g_id;";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public List<User> findUsersByRole(String roleName) {
        final String sql = "SELECT * FROM service.users as usr\n" +
                "join service.roles as rl\n" +
                "on usr.role_fk=rl.r_id\n" +
                "join service.groups as gr\n" +
                "on usr.group_fk = gr.g_id\n" +
                "WHERE rl.rolename = ?;";

        return jdbcTemplate.query(sql, new Object[]{roleName}, userRowMapper);
    }

    @Override
    public List<User> findUsersByGroup(String groupName) {
        final String sql = "SELECT * FROM service.users as usr\n" +
                "join service.roles as rl\n" +
                "on usr.role_fk=rl.r_id\n" +
                "join service.groups as gr\n" +
                "on usr.group_fk = gr.g_id\n" +
                "WHERE gr.groupname = ?;";
        return jdbcTemplate.query(sql, new Object[]{groupName}, userRowMapper);
    }

    @Override
    public Optional<User> findUserById(int id) {
        final String sql = "SELECT * FROM service.users as usr\n" +
                "join service.roles as rl\n" +
                "on usr.role_fk=rl.r_id\n" +
                "join service.groups as gr\n" +
                "on usr.group_fk = gr.g_id\n" +
                "WHERE id = ?;";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new Object[]{id}, userRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        final String sql = "SELECT * FROM service.users as usr\n" +
                "join service.roles as rl\n" +
                "on usr.role_fk=rl.r_id\n" +
                "join service.groups as gr\n" +
                "on usr.group_fk = gr.g_id\n" +
                "WHERE login = ?;";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new Object[]{login}, userRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findUserByTelegramId(String telegramId) {
        final String sql = "SELECT * FROM service.users as usr\n" +
                "join service.roles as rl\n" +
                "on usr.role_fk=rl.r_id\n" +
                "join service.groups as gr\n" +
                "on usr.group_fk = gr.g_id\n" +
                "WHERE telegram_id = ?;";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, new Object[]{Long.parseLong(telegramId)}, userRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean save(User user) {
        final String sql = "INSERT INTO service.users (login, username, surname," +
                "telegram_user, telegram_id, phone, role_fk, group_fk) VALUES (?, ?," +
                " ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, user.getLogin(), user.getUsername(), user.getSurname(),
                user.getTelegramUser(), user.getTelegramId(), user.getPhone(), user.getRole().getR_id(),
                user.getGroup().getG_id()) > 0;
    }

    @Override
    public boolean update(User user, int id) {
        final String sql = "UPDATE service.users SET login = ?, username = ?, surname = ?," +
                "telegram_user = ?, telegram_id = ?, phone = ?, role_fk = ?, group_fk = ? WHERE id = ? ";

        return jdbcTemplate.update(sql, user.getLogin(), user.getUsername(), user.getSurname(),
                user.getTelegramUser(), user.getTelegramId(), user.getPhone(), user.getRole().getR_id(),
                user.getGroup().getG_id(), id) > 0;
    }

    @Override
    public boolean deleteUserById(int id) {
        final String sql = "DELETE FROM service.users WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
