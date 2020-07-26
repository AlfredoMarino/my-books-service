package com.alfredomarino.mybooks.core.services.impl;


import com.alfredomarino.mybooks.core.repository.UserRepository;
import com.alfredomarino.mybooks.core.services.UserService;
import com.alfredomarino.mybooks.core.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}