import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.OrderService;

import java.util.*;

void main() {
    OrderService service = new OrderService();
    service.addProductToCart(1,3);
    service.addProductToCart(3,1);
    service.printProductDetails();
}