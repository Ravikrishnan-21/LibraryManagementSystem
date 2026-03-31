package com.library.management.repository;

import java.util.*;
import com.library.management.model.User;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}

