package com.shop.controller;

import com.shop.model.CartRequest;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getAllProducts()
    {
        return  productRepository.findAll();
    }

    @Autowired
    private OrderService service;

    @PostMapping("/api/cart/add")
    public String addToCartFromWeb(@RequestBody CartRequest request)
    {
        service.addProductToCart(request.getProductId(),request.getQuantity());
        return "Đã thêm sản phẩm ID " + request.getProductId() + " vào giỏ hàng thành công!";
    }

    @GetMapping("/api/cart/view")
    public String viewCartDetail()
    {
        return service.printProductDetails();
    }

    @PostMapping("/api/admin/products")
    public String addProduct(@RequestBody Product newProduct)
    {
        productRepository.save(newProduct);
        return "Đã thêm thành công sản phẩm";
    }

    @PutMapping("/api/admin/products/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            productRepository.save(product);
            return "Admin đã cập nhật sản phẩm ID " + id + " thành công!";
        }).orElse("Không tìm thấy sản phẩm ID " + id + " để cập nhật!");
    }

    @DeleteMapping("/api/admin/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Admin đã xóa sản phẩm ID " + id + " thành công!";
        }
        return "Không tìm thấy sản phẩm ID " + id + " để xóa!";
    }
}
