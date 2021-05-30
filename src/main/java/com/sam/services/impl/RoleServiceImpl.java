package com.sam.services.impl;

import com.sam.models.Role;
import com.sam.repositories.RoleRepository;
import com.sam.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        log.info("Request To save role", role);
        return roleRepository.save(role);
    }

    @Override
    public Page<Role> findAllRole(Pageable pageable) {
        log.info("Request To get all roles pageable");
        Page<Role> all = roleRepository.findAll(pageable);
        return all;
    }

    @Override
    public List<Role> findAll() {
        log.info("Request To get all roles");
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        log.info("Request To get all roles by name");
        return roleRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        log.info("Request To delete role by id");
        roleRepository.deleteById(id);
    }

    @Override
    public void delete(Role role) {
        log.info("Request To delete role");
        roleRepository.delete(role);
    }
}
