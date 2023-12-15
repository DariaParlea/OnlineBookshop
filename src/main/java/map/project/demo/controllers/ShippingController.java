package map.project.demo.controllers;

import map.project.demo.service.ShippingService;
import map.project.demo.entities.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    public List<Shipping> getAllShippings() {
        return shippingService.getAllShippings();
    }

    @GetMapping("/{ShippingID}")
    public Shipping getShippingById(@PathVariable int ShippingID) {
        return shippingService.getShippingById(ShippingID)
                .orElseThrow(() -> new RuntimeException("Shipping not found with id: " + ShippingID));
    }

    @PostMapping
    public Shipping createShipping(@RequestBody Shipping shipping) {
        return shippingService.createShipping(shipping);
    }

    @PutMapping("/{ShippingID}")
    public Shipping updateShipping(@PathVariable int ShippingID, @RequestBody Shipping updatedShipping) {
        return shippingService.updateShipping(ShippingID, updatedShipping);
    }

    @DeleteMapping("/{ShippingID}")
    public String deleteShipping(@PathVariable int ShippingID) {
        shippingService.deleteShipping(ShippingID);
        return "Shipping deleted successfully";
    }
}