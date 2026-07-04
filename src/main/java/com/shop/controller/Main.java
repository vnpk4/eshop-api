import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;

import java.util.*;

void main() {
    ProductRepository repo = new ProductRepository();
//    List<Product> danhSach = new ArrayList<>(
//            List.of(
//                    new Product(1,"Iphone X",100000),
//                    new Product(2,"MSI",200000),
//                    new Product(3,"Gaming", 300000)
//            ));
    Cart cart = new Cart();
    cart.addToCart(1,2);
    cart.addToCart(2,4);
    cart.addToCart(3,6);
    cart.showCart(repo.getAllProducts());
}