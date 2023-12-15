package map.project.demo.service;

import map.project.demo.entities.Orders;
import map.project.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(int orderId) {
        return ordersRepository.findById(orderId);
    }

    public Orders saveOrder(Orders order) {
        order.setTotal_price(order.calculateTotalPrice());
        return ordersRepository.save(order);
    }

    public void deleteOrder(int orderId) {
        ordersRepository.deleteById(orderId);
    }

}
