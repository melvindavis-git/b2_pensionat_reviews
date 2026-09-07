package se.twowall.b2_pensionat_reviews.Mapper;

import se.twowall.b2_pensionat_reviews.DTO.ReviewRequestDTO;
import se.twowall.b2_pensionat_reviews.DTO.ReviewResponseDTO;
import se.twowall.b2_pensionat_reviews.Entity.Review;

public class ReviewMapper {


    public static ReviewResponseDTO toReviewResponseDTO(Review review) {
        return new ReviewResponseDTO(
                review.getRoomId(),
                review.getReviewContent(),
                review.getStars(),
                review.getName(),
                review.getCreatedAt());
    }


    public static Review toEntity(ReviewRequestDTO reviewRequestDTO) {
       return new Review(
               0L,
               reviewRequestDTO.roomId(),
               reviewRequestDTO.reviewContent(),
               reviewRequestDTO.stars(),
               reviewRequestDTO.name(),
               reviewRequestDTO.createdAt()) ;
    }
}
