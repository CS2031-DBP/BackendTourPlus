package com.dbp.backendtourplus.review.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.review.domain.Review;
import com.dbp.backendtourplus.person.domain.Person;
import com.dbp.backendtourplus.tour.domain.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private ReviewRepository reviewRepository;

    private Review review;
    private Person person;
    private Tour tour;

    @BeforeEach
    void setUp() {
        person = new Person();
        person.setFirstname("John");
        person.setLastname("Doe");

        tour = new Tour();
        tour.setTitle("Safari Adventure");

        review = new Review();
        review.setAuthor(person);
        review.setTour(tour);
        review.setComment("Amazing experience!");
        review.setRating(5);
    }

    @Test
    void testSaveAndFindReview() {
        Review savedReview = reviewRepository.save(review);

        Review foundReview = reviewRepository.findById(savedReview.getId()).orElse(null);
        assertThat(foundReview).isNotNull();
        assertThat(foundReview.getComment()).isEqualTo("Amazing experience!");
        assertThat(foundReview.getAuthor().getFirstname()).isEqualTo("John");
        assertThat(foundReview.getTour().getTitle()).isEqualTo("Safari Adventure");
        assertThat(foundReview.getRating()).isEqualTo(5);
    }
}
