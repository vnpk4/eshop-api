package com.shop.service;
import com.shop.model.Cart;
import com.shop.repository.ProductRepository;

public class OrderService {
    private final ProductRepository productRepository;
    private final Cart cart;

    public OrderService() {
        this.productRepository = new ProductRepository();
        this.cart = new Cart();
    }

    public void addProductToCart(int productId, int quantity)
    {
        if(quantity > 0)
            cart.addToCart(productId,quantity);
        else
            System.out.println("Quantity must be larger than 0!");
    }
    public void printProductDetails()
    {
        cart.showCart(productRepository.getAllProducts());
    }
}
