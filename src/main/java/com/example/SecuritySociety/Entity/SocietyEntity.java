package com.example.SecuritySociety.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SocietyEntity {
    @Id
    private  String name;
    private String carName;
    private String phone;
}
