package map.project.demo.service;

import map.project.demo.entities.Review;
import map.project.demo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(int id, Review updatedReview) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        existingReview.setStars_number(updatedReview.getStars_number());
        existingReview.setFeedback(updatedReview.getFeedback());
        existingReview.setBook(updatedReview.getBook());
        existingReview.setDate(updatedReview.getDate());

        return reviewRepository.save(existingReview);
    }
    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }
}