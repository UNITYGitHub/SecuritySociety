package com.example.SecuritySociety.Repository;

import com.example.SecuritySociety.Entity.SocietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocietyRepo extends JpaRepository<SocietyEntity,String> {
}
