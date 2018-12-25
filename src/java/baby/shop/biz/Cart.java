/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.biz;

import baby.shop.entity.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author badan
 */
public class Cart {
    private final Map<Product, Integer> cart = new HashMap<>();

    public Cart() {
    }
    
    public void addProduct(Product p){
        Integer amount = cart.get(p);
        cart.put(p, amount==null?1:(amount + 1));
    }
    
    public Map<Product, Integer> getProducts() {
        return cart;
    }
    
    public float getTotalPrice(){
        float total = 0;
        Set<Product> keys = cart.keySet();
        for(Product product : keys){
            total += product.getPrice() * cart.get(product);
        }
        return total;
    }
}
