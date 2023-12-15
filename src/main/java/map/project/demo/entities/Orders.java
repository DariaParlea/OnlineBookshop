package map.project.demo.entities;

import java.util.List;
//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class Orders  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private String date;
    private int total_price;
    @ManyToOne
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID")
    private Clients client;
    private String status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    protected Orders(){}

    public Orders(int order_id, String date, int total_price, Clients client, String status, List<CartItem> cartItems) {
        this.order_id = order_id;
        this.date = date;
        this.total_price = total_price;
        this.client = client;
        this.status = status;
        this.cartItems = cartItems;
    }
//    public Orders(int order_id, String date, int total_price, int client_id, String status, List<CartItem> cartItems) {
//        this.order_id = order_id;
//        this.date = date;
//        this.total_price = total_price;
//        this.client_id = client_id;
//        this.status = status;
//        this.cartItems = cartItems;
//    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getQuantity() * item.getBook().getPrice();
        }
        return totalPrice;
    }

    public void setTotal_price(int total_price) {
        this.total_price = calculateTotalPrice();
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
    }
    public void removeCartItem(CartItem cartItem){ cartItems.remove(cartItem);}

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}

