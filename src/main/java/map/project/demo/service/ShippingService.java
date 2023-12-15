package map.project.demo.service;

import map.project.demo.repositories.ShippingRepository;
import map.project.demo.entities.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }

    public Optional<Shipping> getShippingById(int id) {
        return shippingRepository.findById(id);
    }

    public Shipping createShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Shipping updateShipping(int id, Shipping updatedShipping) {
        Shipping existingShipping = shippingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping not found with id: " + id));

        existingShipping.setAddress(updatedShipping.getAddress());
        existingShipping.setshipping_method(updatedShipping.getshipping_method());

        return shippingRepository.save(existingShipping);
    }

    public void deleteShipping(int id) {
        shippingRepository.deleteById(id);
    }
}