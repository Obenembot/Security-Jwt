package com.sam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    private static List<User> users = Arrays.asList(
            new User("foo", "foo", new ArrayList<>()),
            new User("me", "me", new ArrayList<>()),
            new User("you", "you", new ArrayList<>()),
            new User("run", "run", new ArrayList<>())
    );

    //If you want to use the default data above remove Exchange from this method name.
    //then comment the method at line 45
    //@Override
    public UserDetails loadUserByUsernameExchange(String username) throws UsernameNotFoundException {

        User userr = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userr = user;
            }
        }

        return userr;
    }

    //Using the data from db.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //User Model From DB
        com.sam.models.User existingUser = userService.findByUsername(username);

        //User That Spring comes with.
        User user = null;
        if (existingUser != null) {
            user = new User(existingUser.getUsername(), existingUser.getPassword(), new ArrayList<>());
            return user;
        } else {
            throw new UsernameNotFoundException("Invalid Username or password!.");
        }
    }
}
