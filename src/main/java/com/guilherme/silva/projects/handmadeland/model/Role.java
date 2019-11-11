package com.guilherme.silva.projects.handmadeland.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private RoleType  roleName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName.name();
    }

    public void setRoleName(String roleName) {
        this.roleName = RoleType.valueOf(roleName);
    }

    
}