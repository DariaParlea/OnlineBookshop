package map.project.demo.controllers;

import map.project.demo.entities.Orders;
import map.project.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{OrderID}")
    public Orders getOrderById(@PathVariable int OrderID) {
        return ordersService.getOrderById(OrderID).orElse(null);
    }

    @PostMapping
    public Orders saveOrder(@RequestBody Orders order) {
        return ordersService.saveOrder(order);
    }

    @DeleteMapping("/{OrderID}")
    public void deleteOrder(@PathVariable int OrderID) {
        ordersService.deleteOrder(OrderID);
    }

}
