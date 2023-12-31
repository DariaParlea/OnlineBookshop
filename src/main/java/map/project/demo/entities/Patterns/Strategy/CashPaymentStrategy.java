package map.project.demo.entities.Patterns.Strategy;

public class CashPaymentStrategy implements PaymentStrategy {

    public CashPaymentStrategy() {
    }

    @Override
    public void processPayment() {
        System.out.println("Processing cash payment");
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}