/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountprototype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gk
 */
public class DatabaseHandler {
    
    Connection conn;
    String url;
    
    public DatabaseHandler(Connection conn, String url){
        this.conn = conn;
        this.url = url;
    }
    
    public void createNewTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS accounts (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	account_name text NOT NULL,\n"
                + "	password text NOT NULL\n"
                + ");";
        
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        sql = "CREATE TABLE IF NOT EXISTS beep (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	account_name text NOT NULL,\n"
                + "	password text NOT NULL\n"
                + ");";
        
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name, String password) {
        String sql = "SELECT 1 FROM accounts WHERE account_name=?";
        boolean accountNameFound = true;
        
        //find whether the account name is in the database already
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, name);
        
            ResultSet rs = pstmt.executeQuery();
            
            //rs is closed if the name is not found
            accountNameFound = !rs.isClosed();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        //add account if the account name is not in the database
        if(!accountNameFound){
            sql = "INSERT INTO accounts(account_name,password) VALUES(?,?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                //set values of ? in sql statement
                pstmt.setString(1, name);
                pstmt.setString(2, password);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println(name + " account added");
        } else {
            System.out.println("account '" + name + "' already in database");
        }
    }

    boolean checkPassword(String name, String password) {
        String sql = "SELECT password FROM accounts WHERE account_name=?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            //set ? value in sql statement to the account name
            pstmt.setString(1, name);
            
            ResultSet rs = pstmt.executeQuery();
            
            //loop through result set (there is only one result) and return true if password input matches db result
            while(rs.next()){
                return password.equals(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    String tableToString() {
        String sql = "SELECT * FROM accounts";
        String out = "";
        
        try(Statement stmt = conn.createStatement()){
            //select all
            ResultSet rs = stmt.executeQuery(sql);
            
            //loop through result set and add to string the account details
            while(rs.next()){
                out = out + rs.getString("account_name") + ", " + rs.getString("password") + "\n";
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return out;
    }
}
