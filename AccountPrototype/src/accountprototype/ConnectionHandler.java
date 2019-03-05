/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountprototype;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gk
 */
public class ConnectionHandler {
    
    private final String url;
    
    public ConnectionHandler(String url){
        this.url = url;
    }
    
    public java.sql.Connection connect() {
        // SQLite connection string
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
