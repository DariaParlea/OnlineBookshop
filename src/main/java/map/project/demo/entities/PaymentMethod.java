package map.project.demo.entities;
import map.project.demo.entities.Patterns.Strategy.PaymentStrategy;
//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    private String status;

    @Transient
    private PaymentStrategy paymentStrategy;

    protected PaymentMethod(){}
    public PaymentMethod(int payment_id, String status, PaymentStrategy paymentStrategy) {
        this.payment_id = payment_id;
        this.status = status;
        this.paymentStrategy = paymentStrategy;
    }


    //    public PaymentMethod(String status, PaymentStrategy paymentStrategy) {
//        this.status = status;
//        this.paymentStrategy = paymentStrategy;
//    }

    public void processPayment() {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment();
            String paymentType = paymentStrategy.getPaymentType();
            System.out.println("Payment type: " + paymentType);
        } else {
            System.out.println("Please set a payment strategy before processing payment.");
        }
    }


    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }



}