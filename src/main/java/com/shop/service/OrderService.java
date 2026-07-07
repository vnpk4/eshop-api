package com.shop.service;
import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    private ProductRepository productRepository;
    private final Cart cart;

    public OrderService() {
        this.cart = new Cart();
    }

    public void addProductToCart(int productId, int quantity)
    {
        if(quantity > 0)
            cart.addToCart(productId,quantity);
        else
            System.out.println("Quantity must be larger than 0!");
    }
    public String printProductDetails()
    {
        Set<Integer> purchasedIds = cart.getPurchaseProductIds();
        List<Product> missingProducts = productRepository.findAllById(purchasedIds);
        return cart.showCart(missingProducts);
    }
}
