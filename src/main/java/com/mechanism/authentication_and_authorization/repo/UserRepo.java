package com.mechanism.authentication_and_authorization.repo;

import com.mechanism.authentication_and_authorization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    User getUserByName(String name);

    User getUserByNameAndEmail(String name, String email);

    User getUserByEmail(String email);
}
