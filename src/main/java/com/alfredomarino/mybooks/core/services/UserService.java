package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.User;

public interface UserService {

    User getUserByUserNameAndPassword(String userName, String password);

    User createUser(User user);
}
