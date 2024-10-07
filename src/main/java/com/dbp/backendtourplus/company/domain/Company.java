package com.dbp.backendtourplus.company.domain;

import com.dbp.backendtourplus.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ruc;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Company(String name, String ruc, User user) {
        this.name = name;
        this.ruc = ruc;
        this.user = user;
    }

    public Company() {

    }
}
