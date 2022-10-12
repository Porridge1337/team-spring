package ru.spring.teamservice.service;

import ru.spring.teamservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    List<User> findUsersByRole(String roleName);

    List<User> findUsersByGroup(String groupName);

    Optional<User> findUserById(int id);

    Optional<User> findUserByLogin(String login);

    Optional<User> findUserByTelegramId(String telegramId);

    boolean save(User user);

    boolean update(User user, int id);

    boolean deleteUserById(int id);

}
