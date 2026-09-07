package se.twowall.b2_pensionat_reviews.DTO;

import se.twowall.b2_pensionat_reviews.Entity.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReviewRequestDTO(
        Long roomId,
        String reviewContent,
        int stars,
        String name,
        LocalDate createdAt
) {}
