package com.alfredomarino.mybooks.core.repository;

import com.alfredomarino.mybooks.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsernameAndPassword(String username, String password);

}