package se.twowall.b2_pensionat_reviews.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class Review {
    @Id
    private Long id;

    private Long roomId;

    private String reviewContent;

    private int stars;

    private String name;

    private LocalDate createdAt;



}
