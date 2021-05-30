package com.sam.services;

import com.sam.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(User user);

    Page<User> findAllUser(Pageable pageable);

    List<User> findAll();

    User findByUsername(String username);

    void delete(Long id);

    void delete(User user);

}
