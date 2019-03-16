/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Database;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gk
 */
public class ConnectionHandler {
    
    private final String url;
    private final String user;
    private final String password;
    
    public ConnectionHandler(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public java.sql.Connection connect() {
        // SQLite connection string
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
