package com.alfredomarino.mybooks.core.services;

import com.alfredomarino.mybooks.core.model.User;

public interface UserService {

    User findByUserNameAndPassword(String userName, String password);

    User create(User user);
}
