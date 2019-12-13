package com.alfredomarino.mybooks.core.business.services;


import com.alfredomarino.mybooks.core.business.repository.UserRepository;
import com.alfredomarino.mybooks.core.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserNameAndPassword(String useName, String password) {
        return userRepository.findByUserNameAndPassword(useName, password);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}