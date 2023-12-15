package map.project.demo.controllers;

import map.project.demo.entities.CartItem;
import map.project.demo.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CartItem")
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }


    @PostMapping
    public CartItem saveCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @DeleteMapping("/{BookId}")
    public void deleteCartItem(@PathVariable Long BookId) {
        cartItemService.deleteCartItem(BookId);
    }

}
