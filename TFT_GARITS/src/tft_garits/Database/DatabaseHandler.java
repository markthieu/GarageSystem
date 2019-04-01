/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

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
                v.set(pstmt, i+1);
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
            System.out.println(sql);
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
            System.out.println(sql);
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
            System.out.println(sql);
        }
        
        return -1;
    }
    
    public float executeFloatQuery(String sql, String value, String search) {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //set values of ? in sql statement
            pstmt.setString(1, value);
        
            ResultSet rs = pstmt.executeQuery();
            
            //return string found
            while (rs.next()){
                return rs.getFloat(search);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        return -1;
    }
    
    public float executeFloatQuery(String sql, ValueObject value, String search) {
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
                return rs.getFloat(search);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
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
            System.out.println(sql);
        }
        
        return -1;
    }
    
    public String executeDateQuery(String sql, ValueObject value, String search){
        
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
                LocalDateTime date = rs.getTimestamp(search).toLocalDateTime();
                return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return "sql error";
    }
    
    public void createNewTable() {
        // SQL statement for creating a new table
        // each sql statement is executed on its own
        // this could be simplified with multistatement execution
        executeStatement("CREATE TABLE IF NOT EXISTS Customer (\n"
                            + "customer_no SERIAL NOT NULL,\n"
                            + "customer_name varchar NOT NULL,\n"
                            + "address varchar NOT NULL,\n"
                            + "tel int,\n"
                            + "post_code varchar NOT NULL,\n"
                            + "email varchar,\n"
                            + "fax varchar,\n"
                            + "PRIMARY KEY (customer_no)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS Job (\n"
                            + "job_no SERIAL NOT NULL,\n"
                            + "customer_no int NOT NULL,\n"
                            + "status varchar NOT NULL default 'Pending',\n"
                            + "date_booked DATE NOT NULL,\n"
                            + "reg_no varchar NOT NULL,\n"
                            + "staff_no int,\n"
                            + "totalAmount FLOAT NOT NULL,\n"
                            + "estimated_time FLOAT NOT NULL,\n"
                            + "completion_date DATE,\n"
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
                            + "task_no SERIAL NOT NULL,\n"
                            + "job_no int NOT NULL,\n"
                            + "task_desc varchar NOT NULL,\n"
                            + "PRIMARY KEY (task_no)\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS Part (\n"
                            + "part_no SERIAL NOT NULL,\n"
                            + "part_name varchar NOT NULL,\n"
                            + "description varchar NOT NULL,\n"
                            + "price FLOAT NOT NULL,\n"
                            + "stock_amount int NOT NULL,\n"
                            + "threshold int NOT NULL DEFAULT 10,\n"
                            + "PRIMARY KEY (part_no)\n"
                        + ");");
        
        executeStatement("CREATE TABLE IF NOT EXISTS Task_Part (\n"
                            + "task_no int REFERENCES Task (task_no) ON UPDATE CASCADE ON DELETE CASCADE,\n"
                            + "part_no int REFERENCES Part (part_no) ON UPDATE CASCADE,\n"
                            + "amount int NOT NULL DEFAULT 1\n"
                        + ");");
                
        executeStatement("CREATE TABLE IF NOT EXISTS Vehicle (\n"
                            + "reg_no varchar NOT NULL,\n"
                            + "customer_no int NOT NULL,\n"
                            + "make varchar NOT NULL,\n"
                            + "model varchar NOT NULL,\n"
                            + "colour varchar,\n"
                            + "eng_serial varchar,\n"
                            + "chassis_no varchar,\n"
                            + "PRIMARY KEY (reg_no)\n"
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
                
        executeStatement("ALTER TABLE Staff DROP CONSTRAINT IF EXISTS Staff_fk0;");
        executeStatement("ALTER TABLE Staff ADD CONSTRAINT Staff_fk0 FOREIGN KEY (user_name) REFERENCES login(user_name);");
                
        executeStatement("ALTER TABLE Task DROP CONSTRAINT IF EXISTS Task_fk0;");
        executeStatement("ALTER TABLE Task ADD CONSTRAINT Task_fk0 FOREIGN KEY (job_no) REFERENCES Job(job_no);");
        
        executeStatement("ALTER TABLE Vehicle DROP CONSTRAINT IF EXISTS Vehicle_fk0;");
        executeStatement("ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_fk0 FOREIGN KEY (customer_no) REFERENCES Customer(customer_no);");
                
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
            System.out.println(sql);
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
                System.out.println(sql);
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
            System.out.println(e.getMessage());            System.out.println(sql);
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
    
    public ArrayList<Integer> getIdNos(String table, String column){
        ArrayList<Integer> ids = new ArrayList<>();
        String sql = "SELECT " + column + " FROM " + table;
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            //pstmt.setString(1, column);
            //pstmt.setString(2, table);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                ids.add(rs.getInt(column));
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        assert(ids.size() > 0);
        return ids;
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
            System.out.println(sql);
        }
        
        assert(names.size() > 0);
        return names;
    }

    public int getNextVal(String table, String column) {
        String sql = "SELECT nextval(pg_get_serial_sequence(?,?)) AS id";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, table);
            pstmt.setString(2, column);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                return rs.getInt("id");
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    }

    public HashMap<Integer, String> getIntStringDict(String table, String intColumn, String stringColumn, ValueObject condition) {
        HashMap<Integer, String> dict = new HashMap<>();
        
        String sql = "SELECT * FROM ? WHERE ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, table);
            pstmt.setString(2, condition.toString());
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                dict.put(rs.getInt(intColumn), rs.getString(stringColumn));
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        return dict;
    }

    public Integer[] getIntArray(String sql, String search) {
        ArrayList<Integer> ints = new ArrayList<>();
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                ints.add(rs.getInt(search));
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        assert(ints.size() > 0);
        Integer[] type = new Integer[ints.size()];
        return ints.toArray(type);
    }

    public String[] getStringArray(String sql, String search) {
        ArrayList<String> strings = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                strings.add(rs.getString(search));
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        assert(strings.size() > 0);
        String[] type = new String[strings.size()];
        return strings.toArray(type);
    }

    public String[] getPartDetails(int task_no) {
        String sql = "SELECT * FROM task_part INNER JOIN part ON task_part.part_no = part.part_no WHERE task_no=? ORDER BY task_part.part_no ASC";
        ArrayList<String> strings = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, task_no);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                String detail = rs.getString("part_name");
                detail = detail + ", " + rs.getInt("amount");
                strings.add(detail);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        assert(strings.size() > 0);
        String[] type = new String[strings.size()];
        return strings.toArray(type);
    }

    public String[] getPartsForJob(int job_no) {
        String sql = "SELECT * FROM task_part INNER JOIN part " 
                +    "ON task_part.part_no = part.part_no "
                +    "WHERE task_no IN (SELECT task_no FROM task WHERE job_no=?) "
                +    "ORDER BY task_part.part_no ASC";
        ArrayList<String> strings = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, job_no);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                String detail = rs.getString("part_name");
                detail = detail + ", " + rs.getInt("amount");
                strings.add(detail);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        assert(strings.size() > 0);
        String[] type = new String[strings.size()];
        return strings.toArray(type);
    }

    public Object[][] getJobDetails(String condition1, String condition2) {
        String sql = "SELECT * FROM job LEFT JOIN staff ON job.staff_no = staff.staff_no WHERE " + condition1 + condition2;
        ArrayList<Object[]> output = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Object[] out = new Object[5];
                out[0] = rs.getInt("job_no");
                out[1] = rs.getString("reg_no");
                out[2] = 0 == rs.getInt("staff_no") ? null : rs.getInt("staff_no");
                out[3] = rs.getString("staff_name");
                out[4] = rs.getString("status");
                output.add(out);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        Object[][] out = new Object[output.size()][];
        out = output.toArray(out);
        return out;
    }

    public boolean checkReg(String reg_no, String customer_name) {
        String sql = "SELECT EXISTS(SELECT 1 FROM vehicle WHERE reg_no=?)";
        
        //check if reg doesnt exist
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, reg_no);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                //returns true if reg not found
                boolean b = !rs.getBoolean(1);
                if (b){
                    System.out.println("reg not found");
                    return b;
                }
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        //check if reg has correct customer
        sql = "SELECT customer_name FROM customer FULL JOIN vehicle ON customer.customer_no = vehicle.customer_no WHERE reg_no = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, reg_no);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                //returns true if customer_name matches
                boolean b = customer_name.equals(rs.getString("customer_name"));
                if (b){
                    System.out.println("reg_no matches customer_name");
                    return b;
                }
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        return false;
    }

    public String[] getVehicleDetails(int customer_ID) {
        String sql = "SELECT * FROM vehicle WHERE customer_no=?";
        ArrayList<String> strings = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, customer_ID);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                String detail = rs.getString("reg_no");
                detail = detail + ": " + rs.getString("make") + " " + rs.getString("model");
                strings.add(detail);
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        assert(strings.size() > 0);
        String[] type = new String[strings.size()];
        return strings.toArray(type);
    }

    public String[] getCustomerAddress(ValueObject value, String valueColumn) {
        String sql = "";
        if (valueColumn.equals("job_no")) sql = "SELECT address, post_code FROM customer INNER JOIN job ON customer.customer_no = job.customer_no WHERE job_no = ?";
        if (valueColumn.equals("customer_no")) sql = "SELECT address, post_code FROM customer WHERE customer_no = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            value.set(pstmt, 1);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                String address = rs.getString("address");
                String post_code = rs.getString("post_code");
                String[] output = address.split(", ");
                
                for (int i = 0; i < output.length; i++){
                    if (i < output.length-1){
                        output[i] = output[i] + ", ";
                    } else {
                        output[i] = output[i] + " " + post_code;
                    }
                }
                
                return output;
            }
            
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());            
            System.out.println(sql);
        }
        
        return null;
    }

    
}
