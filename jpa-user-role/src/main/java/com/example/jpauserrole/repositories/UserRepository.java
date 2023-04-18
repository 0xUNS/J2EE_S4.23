package com.example.jpauserrole.repositories;

import com.example.jpauserrole.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
	User findByUserName(String userName);
}
