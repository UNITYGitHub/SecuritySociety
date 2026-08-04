package com.example.SecuritySociety.Repository;

import com.example.SecuritySociety.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long>{
    User findByName(String user);
}
