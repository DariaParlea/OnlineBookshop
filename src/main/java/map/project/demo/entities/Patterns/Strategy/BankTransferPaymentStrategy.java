package map.project.demo.entities.Patterns.Strategy;

public class BankTransferPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing bank transfer payment");
    }

    @Override
    public String getPaymentType() {
        return "Bank Transfer";
    }
}