package com.dbp.backendtourplus.person.domain;


import com.dbp.backendtourplus.booking.domain.Booking;
import com.dbp.backendtourplus.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends User {

    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;
}
