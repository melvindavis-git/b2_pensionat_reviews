package se.twowall.b2_pensionat_reviews.Service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.twowall.b2_pensionat_reviews.DTO.ReviewRequestDTO;
import se.twowall.b2_pensionat_reviews.DTO.ReviewResponseDTO;
import se.twowall.b2_pensionat_reviews.Entity.Review;
import se.twowall.b2_pensionat_reviews.Mapper.ReviewMapper;
import se.twowall.b2_pensionat_reviews.Repository.ReviewRepository;

import javax.sound.sampled.ReverbType;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    ReviewMapper map = new  ReviewMapper();

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;


    }

    public List<ReviewResponseDTO> getReviews() {
        final List<Review> reviews = reviewRepository.findAll();
        List<ReviewResponseDTO> reviewResponseDTOS = reviews.stream().map(ReviewMapper::toReviewResponseDTO).toList();
        return reviewResponseDTOS;
    }

    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        try {
            Review review = ReviewMapper.toEntity(reviewRequestDTO);
            return map.toReviewResponseDTO(reviewRepository.save(review));

        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

}
