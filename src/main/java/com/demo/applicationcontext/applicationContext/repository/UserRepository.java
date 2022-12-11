package com.demo.applicationcontext.applicationContext.repository;

import com.demo.applicationcontext.applicationContext.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByMail(String mail);


}
