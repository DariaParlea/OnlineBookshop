package map.project.demo.entities.Patterns.Proxy;

import map.project.demo.entities.Review;

public class ReviewProxy implements ReviewComponent{
    private final Review review;

    public ReviewProxy(Review review) {
        this.review = review;
    }

    @Override
    public int getStars() {
        if(verifyStars()){
            return review.getStars_number();
        }
        else {
            System.out.println("Hidden review because of spam or hateful speech");
            return -1;
        }
    }

    @Override
    public Boolean verifyStars() {
        int stars = review.getStars_number();
        if(stars >= 3) {
            return true;
        }
        return false;
    }
}
