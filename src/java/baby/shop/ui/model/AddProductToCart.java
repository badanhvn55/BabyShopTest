/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import baby.shop.biz.Cart;
import baby.shop.da.ProductManager;
import baby.shop.entity.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author badan
 */
public class AddProductToCart extends ActionSupport {

    private int newProductId;

    public int getNewProductId() {
        return newProductId;
    }

    public void setNewProductId(int newProductId) {
        this.newProductId = newProductId;
    }

    @Override
    public String execute() throws Exception {
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        if (cart == null) {
            cart = new Cart();
        }
        System.out.println("NEW PRODUCT ID = " + newProductId);
        Product p = new ProductManager().getProductById(newProductId);
        if (p.getId() == 0) {
            return ERROR;
        }
        cart.addProduct(p);
        ActionContext.getContext().getSession().put("cart", cart);
        System.out.println("SUCCESS ADD TO CART...");
        System.out.println(cart.getTotalPrice());
        return SUCCESS;
    }
}
