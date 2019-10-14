package myproject.demo.service;

import myproject.demo.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
