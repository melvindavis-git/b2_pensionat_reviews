package se.twowall.b2_pensionat_reviews.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.twowall.b2_pensionat_reviews.DTO.ReviewRequestDTO;
import se.twowall.b2_pensionat_reviews.DTO.ReviewResponseDTO;
import se.twowall.b2_pensionat_reviews.Service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> getReviews() {
        try {
            return ResponseEntity.ok(reviewService.getReviews());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        try {
            return ResponseEntity.ok(reviewService.createReview(reviewRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
