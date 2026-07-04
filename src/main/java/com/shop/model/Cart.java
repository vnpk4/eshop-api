package com.shop.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Cart {
    Map<Integer, Integer> items = new HashMap<>();
    public void addToCart(int productId, int quantity)
    {
        int currentQuantity = items.getOrDefault(productId,0);
        items.put(productId,quantity+currentQuantity);
    }
    public void showCart(List<Product> storeProducts)
    {
        final double[] price = {0};
        System.out.println("**********   GIỎ HÀNG CỦA BẠN   **********");
        for(Map.Entry<Integer, Integer> entry : items.entrySet())
        {
            Product foundProduct = storeProducts.stream()
                            .filter(p->p.getId() == entry.getKey())
                                    .findFirst()
                                            .orElse(null);
            if(foundProduct != null)
            {
                double subTotal = foundProduct.getPrice()* entry.getValue();
                price[0] += subTotal;
                System.out.println("Tên: "+foundProduct.getName()+" Giá: "+foundProduct.getPrice()+" Số lượng: "+entry.getValue()+" Thành tiền: "+subTotal);
            }
        }
        System.out.println("TỔNG TIỀN PHẢI THANH TOÁN LÀ: "+price[0]+" VNĐ");
    }

}
