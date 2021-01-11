package com.backend.phoenixhealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.phoenixhealth.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
