/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Database;

import java.sql.Date;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author George Kemp
 */
public class ValueObject {
    private final String type;
    private final Object value;

    public ValueObject(String type, Object value) {
        this.type = type;
        this.value = value;
    }
    
    public Object getValue(){
        return value;
    }
    
    public String getType(){
        return type;
    }
    
    @Override
    public String toString(){
        return (String) value;
    }

    public Integer toInt() {
        if (value == null){
            return null;
        }
        
        if (value instanceof String){
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e){
                System.out.println("error parsing " + (String) value + " to string");
                return 0;
            }
        } //else if (value instanceof Integer){
        
        return (int) value;
    }

    public double toDouble() {
        if (value instanceof String){
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e){
                System.out.println("error parsing " + (String) value + " to string");
                return 0;
            }
        }
        
        return (double) value;
    }
    
    public float toFloat() {
        if (value instanceof String){
            try {
                return Float.parseFloat((String) value);
            } catch (NumberFormatException e){
                System.out.println("error parsing " + (String) value + " to string");
                return 0;
            }
        }
        
        return (float) value;
    }
    
    public Date toDate(){
        assert(value instanceof String);
        String v = (String) value;
        
        Date date = Date.valueOf(v);
        return date;
    }
    
    public void set(PreparedStatement pstmt, int index) throws SQLException{
        if (value == null){
            switch(type){
                case "String":
                    pstmt.setNull(index, java.sql.Types.VARCHAR);
                    break;
                case "int":
                    pstmt.setNull(index, java.sql.Types.BIGINT);
                    break;
                case "double":
                    pstmt.setNull(index, java.sql.Types.DOUBLE);
                    break;
                case "date":
                    pstmt.setNull(index, java.sql.Types.DATE);
                    break;
                case "float":
                    pstmt.setNull(index, java.sql.Types.FLOAT);
                    break;
            }
        } else {
            switch(type){
                case "String":
                    pstmt.setString(index, toString());
                    break;
                case "int":
                    pstmt.setInt(index, toInt());
                    break;
                case "double":
                    pstmt.setDouble(index, toDouble());
                    break;
                case "date":
                    pstmt.setDate(index, toDate());
                    break;
                case "float":
                    pstmt.setFloat(index, toFloat());
                    break;
            }
        }
    }
}
