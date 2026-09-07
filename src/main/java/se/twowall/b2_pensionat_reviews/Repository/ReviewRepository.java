package se.twowall.b2_pensionat_reviews.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.twowall.b2_pensionat_reviews.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


}
