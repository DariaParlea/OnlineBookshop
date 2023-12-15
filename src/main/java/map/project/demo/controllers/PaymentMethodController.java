package map.project.demo.controllers;

import map.project.demo.service.PaymentMethodService;
import map.project.demo.entities.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Paymentmethod")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @GetMapping("/{PaymentID}")
    public PaymentMethod getPaymentMethodById(@PathVariable int PaymentID) {
        return paymentMethodService.getPaymentMethodById(PaymentID)
                .orElseThrow(() -> new RuntimeException("PaymentMethod not found with id: " + PaymentID));
    }

    @PostMapping
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.createPaymentMethod(paymentMethod);
    }

    @PutMapping("/{PaymentID}")
    public PaymentMethod updatePaymentMethod(@PathVariable int PaymentID, @RequestBody PaymentMethod updatedPaymentMethod) {
        return paymentMethodService.updatePaymentMethod(PaymentID, updatedPaymentMethod);
    }

    @DeleteMapping("/{PaymentID}")
    public String deletePaymentMethod(@PathVariable int PaymentID) {
        paymentMethodService.deletePaymentMethod(PaymentID);
        return "PaymentMethod deleted successfully";
    }
}