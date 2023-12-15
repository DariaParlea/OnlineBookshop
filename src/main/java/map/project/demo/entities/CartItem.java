package map.project.demo.entities;
//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
@IdClass(CartItemId.class)
public class CartItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "BookId")
    private Books book;

    private int quantity;


    protected CartItem(){}

    public CartItem(Orders order, Books book, int quantity) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book.toString() +
                ", quantity=" + quantity +
                '}';
    }
}
