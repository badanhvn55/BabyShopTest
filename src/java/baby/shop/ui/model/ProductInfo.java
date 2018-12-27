/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import baby.shop.da.ProductManager;
import baby.shop.entity.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author badan
 */
public class ProductInfo extends ActionSupport {

    private int id;
    private Product product;

    @Override
    public String execute() throws Exception {
        if (id == 0) {
            return ERROR;
        }
        product = new ProductManager().getProductById(id);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

}
