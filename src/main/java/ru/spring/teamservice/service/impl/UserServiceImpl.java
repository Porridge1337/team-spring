package ru.spring.teamservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.teamservice.dao.DaoUser;
import ru.spring.teamservice.model.User;
import ru.spring.teamservice.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final DaoUser daoUser;

    @Autowired
    public UserServiceImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    public List<User> findAllUsers() {
        return daoUser.findAll();
    }

    @Override
    public List<User> findUsersByRole(String roleName) {
        return daoUser.findUsersByRole(roleName);
    }

    @Override
    public List<User> findUsersByGroup(String groupName) {
        return daoUser.findUsersByGroup(groupName);
    }

    @Override
    public Optional<User> findUserById(int id) {
        return daoUser.findUserById(id);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return daoUser.findUserByLogin(login);
    }

    @Override
    public Optional<User> findUserByTelegramId(String telegramId) {
        return daoUser.findUserByTelegramId(telegramId);
    }

    @Override
    @Transactional
    public boolean save(User user) {
        return daoUser.save(user);
    }

    @Override
    @Transactional
    public boolean update(User user, int id) {
        return daoUser.update(user, id);
    }

    @Override
    @Transactional
    public boolean deleteUserById(int id) {
        return daoUser.deleteUserById(id);
    }
}
