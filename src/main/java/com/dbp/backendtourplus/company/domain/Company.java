package com.dbp.backendtourplus.company.domain;


import com.dbp.backendtourplus.tour.domain.Tour;
import com.dbp.backendtourplus.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends User {

    private String name;
    private String ruc;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tour> tours;
}
