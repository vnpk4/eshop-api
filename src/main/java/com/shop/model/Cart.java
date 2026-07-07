package com.shop.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cart {
    Map<Integer, Integer> items = new HashMap<>();
    public void addToCart(int productId, int quantity)
    {
        int currentQuantity = items.getOrDefault(productId,0);
        items.put(productId,quantity+currentQuantity);
    }
    public Set<Integer> getPurchaseProductIds()
    {
        return this.items.keySet();
    }
    public String showCart(List<Product> storeProducts)
    {
        final double[] price = {0};
        StringBuilder htmlResult = new StringBuilder();
        htmlResult.append("**********   GIỎ HÀNG CỦA BẠN   **********\n");
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
                String line = String.format("\nTên: %s | Giá: %.0f | Số lượng: %d | Thành tiền: %.0f VNĐ\n",
                        foundProduct.getName(), foundProduct.getPrice(), entry.getValue(), subTotal);
                htmlResult.append(line);
            }
        }
        String totalLine = String.format("\nTỔNG TIỀN PHẢI THANH TOÁN LÀ: %.0f VNĐ\n", price[0]);
        htmlResult.append(totalLine);
        return htmlResult.toString();
    }

}
