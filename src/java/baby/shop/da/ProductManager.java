/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import baby.shop.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author badan
 */
public class ProductManager {

    List<Product> products;
    private static PreparedStatement getAllStatement;
    private static PreparedStatement searchByNameStatement;
    private static PreparedStatement searchByIdStatement;
    private static PreparedStatement addProductStatement;
    private static PreparedStatement deleteProductStatement;
    private static PreparedStatement editProductStatement;

    public boolean addProduct(String name, float price, String description) throws SQLException {
        Connection connection = DBConnection.getConnection();

        addProductStatement = connection.prepareStatement("insert into product(name, price, description) values( ?, ?, ?)");
        addProductStatement.setString(1, name);
        addProductStatement.setFloat(2, price);
        addProductStatement.setString(3, description);
        return addProductStatement.executeUpdate() > 0;
    }

    public boolean editProduct(int id, String name, float price, String description) throws SQLException {
        Connection connection = DBConnection.getConnection();

        editProductStatement = connection.prepareStatement("update product set name = ?, price = ?, description = ? where id = ?");
        editProductStatement.setString(1, name);
        editProductStatement.setFloat(2, price);
        editProductStatement.setString(3, description);
        editProductStatement.setInt(4, id);
        return editProductStatement.executeUpdate() > 0;
    }

    public boolean deleteProduct(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();

        deleteProductStatement = connection.prepareStatement("delete from product where id = ?");
        deleteProductStatement.setInt(1, id);
        return deleteProductStatement.executeUpdate() > 0;
    }

    private PreparedStatement getSearchByNameStatement() throws SQLException {
        if (searchByNameStatement == null) {
            Connection connection = DBConnection.getConnection();

            searchByNameStatement = connection.prepareStatement("select id, name, price, description from product where name like ?");
        }
        return searchByNameStatement;
    }

    private PreparedStatement getSearchByIdStatement() throws SQLException {
        if (searchByIdStatement == null) {
            Connection connection = DBConnection.getConnection();

            searchByIdStatement = connection.prepareStatement("select id, name, price, description from product where id = ?");
        }
        return searchByIdStatement;
    }
    
    private PreparedStatement getAllStatement() throws SQLException{
        if (getAllStatement == null) {
            Connection connection = DBConnection.getConnection();

            getAllStatement = connection.prepareStatement("select id, name, price, description from product");
        }
        return getAllStatement;
    }
    
    public List<Product> getAllProduct(){
        try {
            PreparedStatement statement = getAllStatement();
            ResultSet rs = statement.executeQuery();
            products = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                products.add(new Product(id, name, price, description));
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Product>();
        }
    }

    public List<Product> getProductsByName(String keyword) {
        try {
            PreparedStatement statement = getSearchByNameStatement();
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            products = new LinkedList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                products.add(new Product(id, name, price, description));
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
            return new LinkedList<Product>();
        }
    }

    public Product getProductById(int id) {
        System.out.println("GET RPODUCT ID = " + id);
        try {
            PreparedStatement statement = getSearchByIdStatement();
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                return new Product(id, name, price, description);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Product(0, "", 0, "");
    }

}
