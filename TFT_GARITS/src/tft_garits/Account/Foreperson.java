/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Account;

/**
 *
 * @author George Kemp
 */
public class Foreperson extends User {
    /* extends User, mechanic and receptionist 
    --need to look into multiple inheritance, 
    maybe switch to interfaces? */
    public Foreperson(String name, String emailAddress, double hourlyRate, String jobTitle) {
        super(name, emailAddress, hourlyRate, jobTitle);
    }
}
