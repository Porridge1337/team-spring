package ru.spring.teamservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String login;
    private String username;
    private String surname;
    private String telegramUser;
    private long telegramId;
    private String phone;
    private Role role;
    private Group group;
}
