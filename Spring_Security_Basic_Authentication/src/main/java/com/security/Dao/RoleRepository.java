package com.security.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
