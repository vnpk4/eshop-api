import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;

import java.util.*;

void main() {
    ProductRepository repo = new ProductRepository();
    Cart cart = new Cart();
    cart.addToCart(1,2);
    cart.addToCart(2,4);
    cart.addToCart(3,6);
    cart.showCart(repo.getAllProducts());
}