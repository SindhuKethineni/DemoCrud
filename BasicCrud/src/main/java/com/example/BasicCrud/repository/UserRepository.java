package com.example.BasicCrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BasicCrud.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findById(Long id);

}
