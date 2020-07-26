package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.User;

public interface UserService {

    User getUserByUsernameAndPassword(String username, String password);

    User createUser(User user);
}
