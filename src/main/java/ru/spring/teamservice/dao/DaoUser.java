package ru.spring.teamservice.dao;

import ru.spring.teamservice.model.User;

import java.util.List;
import java.util.Optional;


public interface DaoUser {


    List<User> findAll();

    List<User> findUsersByRole(String roleName);

    List<User> findUsersByGroup(String groupName);

    Optional<User> findUserById(int id);

    Optional<User> findUserByLogin(String login);

    Optional<User> FindUserByTelegramId(String telegramId);

    boolean save(User user);

    boolean update(User user);

    boolean deleteUserById(int id);

}
