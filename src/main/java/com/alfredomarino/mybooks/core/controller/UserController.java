package com.alfredomarino.mybooks.core.controller;

import com.alfredomarino.mybooks.core.model.User;
import com.alfredomarino.mybooks.core.business.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser(
        @RequestParam(value="userName") String userName, 
        @RequestParam(value="password") String password) {
        

        return new ResponseEntity<User>(this.userService.findByUserNameAndPassword(userName, password), HttpStatus.OK);
    }
    
}