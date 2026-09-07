package se.twowall.b2_pensionat_reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.twowall.b2_pensionat_reviews.Entity.Review;
import se.twowall.b2_pensionat_reviews.Repository.ReviewRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class B2PensionatReviewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(B2PensionatReviewsApplication.class, args);
    }

    @Bean
    public CommandLineRunner createReviews(ReviewRepository reviewRepository) {
        return (args) -> {

            LocalDate today = LocalDate.now();


            Review review1 = reviewRepository.save(new Review(1L, 1L, "This is a test review for room with id 1.", 4, today));
        };

    }
}
