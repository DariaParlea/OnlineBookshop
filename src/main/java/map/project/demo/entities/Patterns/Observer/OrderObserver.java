package map.project.demo.entities.Patterns.Observer;

import map.project.demo.entities.CartItem;

public interface OrderObserver {
    void update_event(String event, CartItem cartItem);
    void update_event2(String event, int id, int quantity);
}
