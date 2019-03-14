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
public class Franchisee extends User{
    /* extends multiple classes... 
    --need to look into multiple inheritance, 
    maybe switch to interfaces? */
    public Franchisee(String name, String emailAddress, double hourlyRate, String jobTitle) {
        super(name, emailAddress, hourlyRate, jobTitle);
    }
}
