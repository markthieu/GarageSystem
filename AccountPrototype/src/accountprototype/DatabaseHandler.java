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
        String sql = "CREATE TABLE accounts (\n"
                + "     id SERIAL NOT NULL PRIMARY KEY,\n"
                + "	account_name VARCHAR(10) NOT NULL,\n"
                + "	password VARCHAR(10) NOT NULL\n"
                + ");";
        
        try (Statement pstmt = conn.createStatement()) {
            // create a new table
            pstmt.executeUpdate(sql);
            pstmt.close();
            System.out.println("create table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name, String password) {
        String sql ="INSERT INTO accounts(account_name, password) \n" +
                    "    SELECT ?, ?\n" +
                    "WHERE NOT EXISTS (\n" +
                    "    SELECT 1 FROM accounts WHERE account_name=?\n" +
                    ");";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.execute();
            
            //rs is closed if the name is not found
            pstmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        /*
        String sql = "SELECT 1 FROM accounts WHERE account_name=?";
        boolean accountNameFound = true;
        
        //find whether the account name is in the database already
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, name);
        
            ResultSet rs = pstmt.executeQuery();
            
            //rs is closed if the name is not found
            accountNameFound = !rs.isClosed();
            pstmt.close();
            
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
                pstmt.close();
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println(name + " account added");
        } else {
            System.out.println("account '" + name + "' already in database");
        }
        */
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
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return out;
    }
}
