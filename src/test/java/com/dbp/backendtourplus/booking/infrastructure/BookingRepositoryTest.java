package com.dbp.backendtourplus.booking.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.booking.domain.Booking;
import com.dbp.backendtourplus.person.domain.Person;
import com.dbp.backendtourplus.tourinstance.domain.TourInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private BookingRepository bookingRepository;

    private Booking booking;
    private Person person;
    private TourInstance tourInstance;

    @BeforeEach
    void setUp() {
        person = new Person();
        person.setFirstname("John");
        person.setLastname("Doe");

        tourInstance = new TourInstance();
        tourInstance.setStartTime(LocalDateTime.now());
        tourInstance.setEndTime(LocalDateTime.now().plusHours(2));

        booking = new Booking();
        booking.setPerson(person);
        booking.setTourInstance(tourInstance);
        booking.setBookingDate(LocalDateTime.now());
    }

    @Test
    void testSaveAndFindBooking() {
        Booking savedBooking = bookingRepository.save(booking);

        Booking foundBooking = bookingRepository.findById(savedBooking.getId()).orElse(null);
        assertThat(foundBooking).isNotNull();
        assertThat(foundBooking.getPerson().getFirstname()).isEqualTo("John");
        assertThat(foundBooking.getTourInstance().getStartTime()).isEqualTo(tourInstance.getStartTime());
    }
}
