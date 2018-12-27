/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import baby.shop.da.ProductManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author badan
 */
public class UpdateProduct extends ActionSupport {

    private String type;

    private String name, description;

    private int id;
    
    private float price;

    @Override
    public String execute() throws Exception {
        System.out.println("TYPE: " + type);
        switch (type) {
            case "add":
//                DO ADD
                System.out.println("*****ADD A PRODUCT: " + name);
                if (name == null || price < 0) {
                    return ERROR;
                }
                if (new ProductManager().addProduct(name, price, description)) {
                    return SUCCESS;
                } else {
                    return ERROR;
                }
            case "edit":
//                DO EDIT
                System.out.println("*****EDIT A PRODUCT: " + name);
                if (name == null || price < 0) {
                    return ERROR;
                }
                if (new ProductManager().editProduct(id, name, price, description)) {
                    return SUCCESS;
                } else {
                    return ERROR;
                }
            case "delete":
//                DO DELETE
                System.out.println("*****DELETE A PRODUCT: " + name);
                if (id == 0) {
                    return ERROR;
                }
                if (new ProductManager().deleteProduct(id)) {
                    return SUCCESS;
                } else {
                    return ERROR;
                }
            default:
                return ERROR;
        }
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
