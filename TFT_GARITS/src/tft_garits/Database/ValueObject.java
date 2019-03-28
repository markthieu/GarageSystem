/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Database;

import java.sql.Date;
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

    public int toInt() {
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
}
