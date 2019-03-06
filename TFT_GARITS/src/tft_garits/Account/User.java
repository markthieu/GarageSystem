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
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String emailAddress;
    private double hourlyRate;
    private String jobTitle;

    public User(String name, String emailAddress, double hourlyRate, String jobTitle) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.hourlyRate = hourlyRate;
        this.jobTitle = jobTitle;
    }
    
    public void logIn(){
        throw new UnsupportedOperationException("logIn() not implemented");
    }
    
    public void logOut(){
        throw new UnsupportedOperationException("logOut() not implemented");
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    
}
