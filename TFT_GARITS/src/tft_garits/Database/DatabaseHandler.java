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
import java.util.ArrayList;

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
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql);
        }
    }
    
    public void executeStatement(String sql, String value){
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, value);
            pstmt.execute();
            pstmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql);
        }
    }
    
    public void executeStatement(String sql, String value1, String value2){
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, value1);
            pstmt.setString(2, value2);
            pstmt.execute();
            pstmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql);
        }
    }
    
    public void executeArrayInsert(String sql, ArrayList<ValueObject> values){
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            for (int i = 0; i < values.size(); i++){
                ValueObject v = values.get(i);
                switch(v.getType()){
                    case "String":
                        pstmt.setString(i+1, v.toString());
                        break;
                    case "int":
                        pstmt.setInt(i+1, v.toInt());
                        break;
                    case "double":
                        pstmt.setDouble(i+1, v.toDouble());
                        break;
                }
            }
            pstmt.execute();
            pstmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql);
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
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return "sql error";
    }
    
    public String executeStringQuery(String sql, ValueObject value, String search){
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            switch(value.getType()){
                case "String":
                    pstmt.setString(1, value.toString());
                    break;
                case "int":
                    pstmt.setInt(1, value.toInt());
                    break;
                case "double":
                    pstmt.setDouble(1, value.toDouble());
                    break;
            }
        
            ResultSet rs = pstmt.executeQuery();
            
            //return string found
            while (rs.next()){
                return rs.getString(search);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return "sql error";
    }
    
    public double executeDoubleQuery(String sql, String value, String search){
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, value);
        
            ResultSet rs = pstmt.executeQuery();
            
            //return string found
            while (rs.next()){
                return rs.getDouble(search);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    }
    
    public int executeIntQuery(String sql, String value, String search){
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, value);
        
            ResultSet rs = pstmt.executeQuery();
            
            //return string found
            while (rs.next()){
                return rs.getInt(search);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    }
    
    public int executeIntQuery(String sql, ValueObject value, String search){
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            switch(value.getType()){
                case "String":
                    pstmt.setString(1, value.toString());
                    break;
                case "int":
                    pstmt.setInt(1, value.toInt());
                    break;
                case "double":
                    pstmt.setDouble(1, value.toDouble());
                    break;
            }
        
            ResultSet rs = pstmt.executeQuery();
            
            //return string found
            while (rs.next()){
                return rs.getInt(search);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    }
    
    public void createNewTable() {
        // SQL statement for creating a new table
        // each sql statement is executed on its own
        // this could be simplified with multistatement execution
        executeStatement("CREATE TABLE IF NOT EXISTS Customer (\n"
                            + "customer_no int NOT NULL,\n"
                            + "customer_name varchar NOT NULL,\n"
                            + "address varchar NOT NULL,\n"
                            + "tel int NOT NULL,\n"
                            + "post_code varchar NOT NULL,\n"
                            + "email varchar NOT NULL,\n"
                            + "fax varchar NOT NULL,\n"
                            + "PRIMARY KEY (customer_no)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS Job (\n"
                            + "job_no int NOT NULL,\n"
                            + "customer_no int NOT NULL,\n"
                            + "status varchar NOT NULL,\n"
                            + "date_booked DATE NOT NULL,\n"
                            + "reg_no int NOT NULL,\n"
                            + "staff_no int NOT NULL,\n"
                            + "task_no int NOT NULL,\n"
                            + "totalAmount FLOAT NOT NULL,\n"
                            + "estimated_time TIME NOT NULL,\n"
                            + "completion_date DATE NOT NULL,\n"
                            + "PRIMARY KEY (job_no)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS Staff (\n"
                            + "staff_no SERIAL NOT NULL,\n"
                            + "staff_name varchar NOT NULL,\n"
                            + "user_name varchar NOT NULL,\n"
                            + "hourly_rate NUMERIC(6, 2), \n" //NUMERIC(6,2) is a value with precision 6 & scale 2 (e.g, 4587.89, 321.11, 30.60)
                            + "PRIMARY KEY (staff_no)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS Task (\n"
                            + "task_no int NOT NULL,\n"
                            + "task_desc varchar NOT NULL,\n"
                            + "part_no int NOT NULL,\n"
                            + "PRIMARY KEY (task_no)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS Part (\n"
                            + "part_no int NOT NULL,\n"
                            + "part_name varchar NOT NULL,\n"
                            + "description varchar NOT NULL,\n"
                            + "price FLOAT NOT NULL,\n"
                            + "PRIMARY KEY (part_no)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS Vehicle (\n"
                            + "reg_no int NOT NULL,\n"
                            + "customer_no int NOT NULL,\n"
                            + "make varchar NOT NULL,\n"
                            + "model varchar NOT NULL,\n"
                            + "colour varchar NOT NULL,\n"
                            + "eng_serial varchar NOT NULL,\n"
                            + "chassis_no varchar NOT NULL,\n"
                            + "PRIMARY KEY (reg_no)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS Stock (\n"
                            + "qty int NOT NULL,\n"
                            + "part_no int NOT NULL\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS AccountHolder (\n"
                            + "accountId INT NOT NULL,\n"
                            + "customer_no INT NOT NULL,\n"
                            + "discount varchar NOT NULL,\n"
                            + "amountSpent FLOAT NOT NULL,\n"
                            + "PRIMARY KEY (accountId)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS login (\n"
                            + "id SERIAL NOT NULL,\n"
                            + "user_name varchar NOT NULL,\n"
                            + "password varchar NOT NULL,\n"
                            + "account_type varchar NOT NULL,\n"
                            + "PRIMARY KEY (user_name)\n"
                        + ");");
          
        executeStatement("ALTER TABLE Job DROP CONSTRAINT IF EXISTS Job_fk0;");
        executeStatement("ALTER TABLE Job ADD CONSTRAINT Job_fk0 FOREIGN KEY (customer_no) REFERENCES Customer(customer_no);");
                
        executeStatement("ALTER TABLE Job DROP CONSTRAINT IF EXISTS Job_fk1;");
        executeStatement("ALTER TABLE Job ADD CONSTRAINT Job_fk1 FOREIGN KEY (reg_no) REFERENCES Vehicle(reg_no);");
              
        executeStatement("ALTER TABLE Job DROP CONSTRAINT IF EXISTS Job_fk2;");
        executeStatement("ALTER TABLE Job ADD CONSTRAINT Job_fk2 FOREIGN KEY (staff_no) REFERENCES Staff(staff_no);");
                
        executeStatement("ALTER TABLE Job DROP CONSTRAINT IF EXISTS Job_fk3;");
        executeStatement("ALTER TABLE Job ADD CONSTRAINT Job_fk3 FOREIGN KEY (task_no) REFERENCES Task(task_no);");
                
        executeStatement("ALTER TABLE Staff DROP CONSTRAINT IF EXISTS Staff_fk0;");
        executeStatement("ALTER TABLE Staff ADD CONSTRAINT Staff_fk0 FOREIGN KEY (user_name) REFERENCES login(user_name);");
                
        executeStatement("ALTER TABLE Task DROP CONSTRAINT IF EXISTS Task_fk0;");
        executeStatement("ALTER TABLE Task ADD CONSTRAINT Task_fk0 FOREIGN KEY (part_no) REFERENCES Part(part_no);");
                
        executeStatement("ALTER TABLE Vehicle DROP CONSTRAINT IF EXISTS Vehicle_fk0;");
        executeStatement("ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_fk0 FOREIGN KEY (customer_no) REFERENCES Customer(customer_no);");
                
        executeStatement("ALTER TABLE Stock DROP CONSTRAINT IF EXISTS Stock_fk0;");
        executeStatement("ALTER TABLE Stock ADD CONSTRAINT Stock_fk0 FOREIGN KEY (part_no) REFERENCES Part(part_no);");
                
        executeStatement("ALTER TABLE AccountHolder DROP CONSTRAINT IF EXISTS AccountHolder_fk0;");
        executeStatement("ALTER TABLE AccountHolder ADD CONSTRAINT AccountHolder_fk0 FOREIGN KEY (customer_no) REFERENCES Customer(customer_no);");
        
    }

    public void insertUser(String user_name, String password, String account_type, String full_name) {
        String sql ="INSERT INTO login(user_name, password, account_type) \n" +
                    "    SELECT ?, ?, ?\n" +
                    "WHERE NOT EXISTS (\n" +
                    "    SELECT 1 FROM login WHERE user_name=?\n" +
                    ");";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, user_name);
            pstmt.setString(2, password);
            pstmt.setString(3, account_type);
            pstmt.setString(4, user_name);
            pstmt.execute();
            
            pstmt.close();
            
            System.out.println("INSERT " + user_name + " into login.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        //prevents admin being added to staff table
        if (full_name != null){
            sql =       "INSERT INTO staff(user_name, staff_name) \n" +
                        "    SELECT ?, ?\n" +
                        "WHERE NOT EXISTS (\n" +
                        "    SELECT 1 FROM staff WHERE user_name=?\n" +
                        ");";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                //set values of ? in sql statement
                pstmt.setString(1, user_name);
                pstmt.setString(2, full_name);
                pstmt.setString(3, user_name);
                pstmt.execute();
                
                pstmt.close();
                
                System.out.println("INSERT " + full_name + " into staff.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
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
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public boolean checkQuery(String sql, ValueObject compare, String search){
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            switch(compare.getType()){
                case "String":
                    pstmt.setString(1, compare.toString());
                    break;
                case "int":
                    pstmt.setInt(1, compare.toInt());
                    break;
                case "double":
                    pstmt.setDouble(1, compare.toDouble());
                    break;
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                switch(compare.getType()){
                    case "String":
                        return rs.getString(search).equals(compare.toString());
                    case "int":
                        return rs.getInt(search) == (compare.toInt());
                    case "double":
                        return rs.getDouble(search) == (compare.toDouble());
                }
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    public ArrayList<String> getUsernames() {
        String sql = "SELECT user_name FROM staff;";
        String search = "user_name";
        return getNameArray(sql, search);
    }
    
    public ArrayList<String> getMechanics() {
        String sql = "SELECT staff_name FROM staff WHERE user_name in "
                +    "(SELECT user_name FROM login WHERE account_type='Mechanic');";
        String search = "staff_name";
        return getNameArray(sql, search);
    }
    
    public ArrayList<String> getCustomers() {
        String sql = "SELECT customer_name FROM customer;";
        String search = "customer_name";
        return getNameArray(sql, search);
    }
    
    public ArrayList<String> getNameArray(String sql, String search) {
        ArrayList<String> names = new ArrayList<>();
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                names.add(rs.getString(search));
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        assert(names.size() > 0);
        return names;
    }
}
