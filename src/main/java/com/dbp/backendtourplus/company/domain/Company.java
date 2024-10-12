package com.dbp.backendtourplus.company.domain;

import com.dbp.backendtourplus.tour.domain.Tour;
import com.dbp.backendtourplus.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Company extends User {

    private String name;
    private String ruc;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tour> tours;

    @Column(nullable = false)
    @NotNull
    private String email;
}