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
public class Administrator extends User {
    
    public Administrator() {
        super("admin", "admin", 0, "admin");
    }
    
    public User addAccount(int id, String name, String jobTitle, double rate){
        throw new UnsupportedOperationException("addAccount not implemented yet");
    }
    
    public void removeUser(int id){
        throw new UnsupportedOperationException("removeUser not implemented yet");
    }
    
    public void changeUser(int id){
        throw new UnsupportedOperationException("changeUser not implemented yet");
    }
    
    public void backUpDatabase(){
        throw new UnsupportedOperationException("backUpDatabase not implemented yet");
    }
    
    public void restoreDatabase(){
        throw new UnsupportedOperationException("restoreDatabase not implemented yet");
    }
    
    public void changeRate(int staffId){ //must also take in rate maybe?
        throw new UnsupportedOperationException("changeRate not implemented yet");
    }
}
