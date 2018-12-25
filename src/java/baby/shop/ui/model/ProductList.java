/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import baby.shop.da.ProductManager;
import baby.shop.entity.Product;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author badan
 */
public class ProductList extends ActionSupport{
    private String keyword;
    private List<Product> products;
    
    @Override
    public String execute() throws Exception{
        products = new ProductManager().getProductsByName(keyword);
        return SUCCESS;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    
}
