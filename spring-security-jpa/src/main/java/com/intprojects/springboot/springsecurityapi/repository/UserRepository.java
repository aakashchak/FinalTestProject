package com.intprojects.springboot.springsecurityapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.intprojects.springboot.springsecurityapi.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String name);

}
