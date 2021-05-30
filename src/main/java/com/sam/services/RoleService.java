package com.sam.services;

import com.sam.models.Role;
import com.sam.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    Role save(Role role);

    Page<Role> findAllRole(Pageable pageable);

    List<Role> findAll();

    Role findByName(String name);

    void delete(Long id);

    void delete(Role role);
}
