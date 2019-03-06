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
public class Mechanic extends User {
    
    public Mechanic(String name, String emailAddress, String jobTitle) {
        super(name, emailAddress, 105, jobTitle); //hourlyRate set to 105
    }
    
    public void allocateJob(int jobId){
        throw new UnsupportedOperationException("allocateJob() not implemented");
    }
    
    public void addTask(int taskId){
        throw new UnsupportedOperationException("addTask() not implemented");
    }
    
    public void addPart(int partId){
        throw new UnsupportedOperationException("addPart() not implemented");
    }
    
    /* Where is TaskForm class?
    public TaskForm selectTask(int taskId){
        throw new UnsupportedOperationException("selectTask() not implemented");
    } 
    */
    
    public void modifyDetails(String data){
        throw new UnsupportedOperationException("modifyDetails() not implemented");
    }
    
    public void removePart(int partId){
        throw new UnsupportedOperationException("removePart() not implemented");
    }
    
    public void changeDescription(String description){
        throw new UnsupportedOperationException("changeDescription() not implemented");
    }
    
    /* Time class needs changing
    public void setDuration(Time duration){
        throw new UnsupportedOperationException("setDuration() not implemented");
    }
    
    public void alterDuration(Time duration){
        throw new UnsupportedOperationException("alterDuration() not implemented");
    }
    */
    
    public void changeStatus(String status){
        throw new UnsupportedOperationException("changeStatus() not implemented");
    }
    
    //getHourlyRate() & setHourlyRate() are in User class
}
