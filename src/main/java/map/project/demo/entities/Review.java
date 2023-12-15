package map.project.demo.entities;

//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;

    @ManyToOne
    @JoinColumn(name = "BookId")
    private Books book;

    private int stars_number;
    private String feedback;
    private String date;

    protected Review() {
    }

    public Review(int review_id, int stars_number, String feedback, Books book, String date) {
        this.review_id = review_id;
        this.stars_number = stars_number;
        this.feedback = feedback;
        this.book = book;
        this.date = date;
    }

    //    public Review(int stars_number, String feedback, Books book, String date, int book_id) {
//        this.stars_number = stars_number;
//        this.feedback = feedback;
//        this.book = book;
//        this.date = date;
//        this.book_id = book_id;
//    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getStars_number() {
        return stars_number;
    }

    public void setStars_number(int stars_number) {
        this.stars_number = stars_number;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}