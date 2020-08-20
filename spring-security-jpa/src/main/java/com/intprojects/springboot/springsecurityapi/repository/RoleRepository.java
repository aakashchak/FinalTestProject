package com.intprojects.springboot.springsecurityapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.intprojects.springboot.springsecurityapi.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
