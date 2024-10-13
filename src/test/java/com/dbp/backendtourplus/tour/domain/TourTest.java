package com.dbp.backendtourplus.tour.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TourTest {

    @Test
    void testTourCreation() {
        Tour tour = new Tour();
        tour.setTitle("Amazon Jungle Tour");
        tour.setPrice(250.0);

        assertEquals("Amazon Jungle Tour", tour.getTitle());
        assertEquals(250.0, tour.getPrice());
    }
}
