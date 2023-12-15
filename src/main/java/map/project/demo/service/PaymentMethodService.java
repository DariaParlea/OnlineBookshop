package map.project.demo.service;

import map.project.demo.repositories.PaymentMethodRepository;
import map.project.demo.entities.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(int id) {
        return paymentMethodRepository.findById(id);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethod(int id, PaymentMethod updatedPaymentMethod) {
        PaymentMethod existingPaymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PaymentMethod not found with id: " + id));

        existingPaymentMethod.setStatus(updatedPaymentMethod.getStatus());
        existingPaymentMethod.setPaymentStrategy(updatedPaymentMethod.getPaymentStrategy());

        return paymentMethodRepository.save(existingPaymentMethod);
    }

    public void deletePaymentMethod(int id) {
        paymentMethodRepository.deleteById(id);
    }
}