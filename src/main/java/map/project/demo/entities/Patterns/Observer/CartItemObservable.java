package map.project.demo.entities.Patterns.Observer;

import map.project.demo.entities.CartItem;

public interface CartItemObservable {
    public void notifyObserver(String event, CartItem cartItem);
    public void notify_observer(String event, int id, int quantity);
}
