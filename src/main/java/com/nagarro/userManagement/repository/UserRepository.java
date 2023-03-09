package com.nagarro.userManagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.userManagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByLastName(String lastName);
	List<User> findByFirstNameAndLastName( String firstName,String lastname);
}
