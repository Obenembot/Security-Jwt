package com.sam.controllers;

import com.sam.models.Role;
import com.sam.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RoleResource {

    private final static Logger log = LoggerFactory.getLogger(RoleResource.class);

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        log.info("Request To save role", role);
        Role result = roleService.save(role);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/role")
    public ResponseEntity<Role> update(@RequestBody Role role) {
        log.info("Request To save role", role);
        Role result = roleService.save(role);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/role")
    public ResponseEntity<List<Role>> allRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }
}
