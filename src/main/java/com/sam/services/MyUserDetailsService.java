package com.sam.services;

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

    private List<User> users = Arrays.asList(
            new User("foo", "foo", new ArrayList<>()),
            new User("me", "me", new ArrayList<>()),
            new User("you", "you", new ArrayList<>()),
            new User("run", "run", new ArrayList<>())
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userr = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userr = user;
            }
        }

        return userr;
    }
}
