package map.project.demo.controllers;

import map.project.demo.entities.Review;
import map.project.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import map.project.demo.entities.Patterns.Singelton.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reviews")
public class ReviewController implements ReviewControllerSingelton {

    private static ReviewController instance;

    public static ReviewController getInstance(ReviewService reviewService) {
        if (instance == null) {
            instance = new ReviewController(reviewService);
        }
        return instance;
    }

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{ReviewId}")
    public Review getReviewById(@PathVariable int ReviewId) {
        return reviewService.getReviewById(ReviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + ReviewId));
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{ReviewId}")
    public Review updateReview(@PathVariable int ReviewId, @RequestBody Review updatedReview) {
        return reviewService.updateReview(ReviewId, updatedReview);
    }

    @DeleteMapping("/{ReviewId}")
    public String deleteReview(@PathVariable int ReviewId) {
        reviewService.deleteReview(ReviewId);
        return "Review deleted successfully";
    }




}