/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author badan
 */
public class DBConnection {
    public static Connection connection;
    
    public static Connection  getConnection() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=ecommerce", "sa", "123456");
        }
        return connection;
    }
}
