/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Database;

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
    
    public void backupDatabase() {
        // TODO - implement MySQLite.backupDatabase
        throw new UnsupportedOperationException("MySQLite.backupDatabase() needs implementation");
    }

    public void restoreDatabase() {
        // TODO - implement MySQLite.restoreDatabase
        throw new UnsupportedOperationException("MySQLite.restoreDatabase() needs implementation");
    }
    
    public void executeStatement(String sql){
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String executeStringQuery(String sql, String value, String search){
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, value);
        
            ResultSet rs = pstmt.executeQuery();
            
            //return string found
            while (rs.next()){
                return rs.getString(search);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return "sql error";
    }
    
    public void createNewTable() {
        // SQL statement for creating a new table
        // each sql statement is executed on its own
        // this could be simplified with multistatement execution
        executeStatement("CREATE TABLE IF NOT EXISTS `Customer` (\n"
                            + "`customer_no` int NOT NULL,\n"
                            + "`customer_name` varchar NOT NULL,\n"
                            + "`address` varchar NOT NULL,\n"
                            + "`tel` int NOT NULL,\n"
                            + "`post_code` varchar NOT NULL,\n"
                            + "`email` varchar NOT NULL,\n"
                            + "`fax` varchar NOT NULL,\n"
                            + "PRIMARY KEY (`customer_no`)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS `Job` (\n"
                            + "`job_no` int NOT NULL,\n"
                            + "`customer_no` int NOT NULL,\n"
                            + "`status` varchar NOT NULL,\n"
                            + "`date_booked` DATE NOT NULL,\n"
                            + "`reg_no` int NOT NULL,\n"
                            + "`staff_no`  NOT NULL,\n"
                            + "`task_no` int NOT NULL,\n"
                            + "`totalAmount` FLOAT NOT NULL,\n"
                            + "`estimated_time` TIME NOT NULL,\n"
                            + "`completion_date` DATE NOT NULL,\n"
                            + "PRIMARY KEY (`job_no`)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS `Staff` (\n"
                            + "`staff_no` INT NOT NULL,\n"
                            + "`staff_name` varchar NOT NULL,\n"
                            + "`user_name` varchar NOT NULL,\n"
                            + "PRIMARY KEY (`staff_no`)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS `Task` (\n"
                            + "`task_no` int NOT NULL,\n"
                            + "`task_desc` varchar NOT NULL,\n"
                            + "`part_no` varchar NOT NULL,\n"
                            + "PRIMARY KEY (`task_no`)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS `Part` (\n"
                            + "`part_no` int NOT NULL,\n"
                            + "`part_name` varchar NOT NULL,\n"
                            + "`description` varchar NOT NULL,\n"
                            + "`price` FLOAT NOT NULL,\n"
                            + "PRIMARY KEY (`part_no`)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS `Vehicle` (\n"
                            + "`reg_no` int NOT NULL,\n"
                            + "`customer_no` int NOT NULL,\n"
                            + "`make` varchar NOT NULL,\n"
                            + "`model` varchar NOT NULL,\n"
                            + "`colour` varchar NOT NULL,\n"
                            + "`eng_serial` varchar NOT NULL,\n"
                            + "`chassis_no` varchar NOT NULL,\n"
                            + "PRIMARY KEY (`reg_no`)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS `Stock` (\n"
                            + "`qty` int NOT NULL,\n"
                            + "`part_no` int NOT NULL\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS `AccountHolder` (\n"
                            + "`accountId` INT NOT NULL,\n"
                            + "`customer_no` INT NOT NULL,\n"
                            + "`discount` varchar NOT NULL,\n"
                            + "`amountSpent` FLOAT NOT NULL,\n"
                            + "PRIMARY KEY (`accountId`)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS `login` (\n"
                            + "`user_name` varchar NOT NULL,\n"
                            + "`password` varchar NOT NULL,\n"
                            + "`account_type` varchar NOT NULL,\n"
                            + "PRIMARY KEY (`user_name`)\n"
                        + ");");
        /*        
        executeStatement("ALTER TABLE `Job` ADD CONSTRAINT `Job_fk0` FOREIGN KEY (`customer_no`) REFERENCES `Customer`(`customer_no`);");
                
        executeStatement("ALTER TABLE `Job` ADD CONSTRAINT `Job_fk1` FOREIGN KEY (`reg_no`) REFERENCES `Vehicle`(`reg_no`);");
              
        executeStatement("ALTER TABLE `Job` ADD CONSTRAINT `Job_fk2` FOREIGN KEY (`staff_no`) REFERENCES `Staff`(`staff_no`);");
                
        executeStatement("ALTER TABLE `Job` ADD CONSTRAINT `Job_fk3` FOREIGN KEY (`task_no`) REFERENCES `Task`(`task_no`);");
                
        executeStatement("ALTER TABLE `Staff` ADD CONSTRAINT `Staff_fk0` FOREIGN KEY (`user_name`) REFERENCES `login`(`user_name`);");
                
        executeStatement("ALTER TABLE `Task` ADD CONSTRAINT `Task_fk0` FOREIGN KEY (`part_no`) REFERENCES `Part`(`part_no`);");
                
        executeStatement("ALTER TABLE `Vehicle` ADD CONSTRAINT `Vehicle_fk0` FOREIGN KEY (`customer_no`) REFERENCES `Customer`(`customer_no`);");
                
        executeStatement("ALTER TABLE `Stock` ADD CONSTRAINT `Stock_fk0` FOREIGN KEY (`part_no`) REFERENCES `Part`(`part_no`);");
                
        executeStatement("ALTER TABLE `AccountHolder` ADD CONSTRAINT `AccountHolder_fk0` FOREIGN KEY (`customer_no`) REFERENCES `Customer`(`customer_no`);");
        */
    }

    public void insertUser(String name, String password, String account_type) {
        String sql = "SELECT 1 FROM login WHERE user_name=?";
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
            sql = "INSERT INTO login(user_name,password,account_type) VALUES(?,?,?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                //set values of ? in sql statement
                pstmt.setString(1, name);
                pstmt.setString(2, password);
                pstmt.setString(3, account_type);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println(name + " account added");
        } else {
            System.out.println("account '" + name + "' already in database");
        }
    }

    public boolean checkPassword(String name, String password) {
        String sql = "SELECT password FROM login WHERE user_name=?";
        
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

    String userTableToString() {
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
