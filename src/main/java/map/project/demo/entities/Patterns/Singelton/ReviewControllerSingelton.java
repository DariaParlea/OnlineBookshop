package map.project.demo.entities.Patterns.Singelton;

import map.project.demo.controllers.ReviewController;
import map.project.demo.service.ReviewService;

public interface ReviewControllerSingelton {
    static ReviewController getInstance(ReviewService reviewService)
    {
        return ReviewController.getInstance(reviewService);
    };

}