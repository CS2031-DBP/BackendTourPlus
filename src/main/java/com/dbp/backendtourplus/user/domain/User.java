package com.dbp.backendtourplus.user.domain;

import com.dbp.backendtourplus.company.domain.Company;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Company> companies;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
