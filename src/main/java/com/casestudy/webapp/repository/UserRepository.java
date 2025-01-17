package com.casestudy.webapp.repository;

import com.casestudy.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//     User findById(Integer id);

     User findByEmailIgnoreCase(String email);
}
