package com.dbp.backendtourplus.booking.domain;

import com.dbp.backendtourplus.booking.dto.BookingDto;
import com.dbp.backendtourplus.booking.infrastructure.BookingRepository;
import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking save(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setBookingStatus(bookingDto.getBookingStatus());
        booking.setTour(bookingDto.getTour());
        booking.setUser(bookingDto.getUser());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, BookingDto bookingDto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setBookingStatus(bookingDto.getBookingStatus());
        booking.setTour(bookingDto.getTour());
        booking.setUser(bookingDto.getUser());
        return bookingRepository.save(booking);
    }

    public void deleteById(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id " + id);
        }
        bookingRepository.deleteById(id);
    }
}
