package map.project.demo.entities;

//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShippingID;

    private String Address;
    private String ShippingMethod;

//    public Shipping(String Address, String ShippingMethod) {
//        this.Address = Address;
//        this.ShippingMethod = ShippingMethod;
//    }

    protected Shipping(){}
    public Shipping(int shippingID, String Address, String ShippingMethod) {
        ShippingID = shippingID;
        this.Address = Address;
        this.ShippingMethod = ShippingMethod;
    }

    public int getShipping_id() {
        return ShippingID;
    }

    public void setShipping_id(int shipping_id) {
        this.ShippingID = shipping_id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getshipping_method() {
        return ShippingMethod;
    }

    public void setshipping_method(String ShippingMethod) {
        this.ShippingMethod = ShippingMethod;
    }
}