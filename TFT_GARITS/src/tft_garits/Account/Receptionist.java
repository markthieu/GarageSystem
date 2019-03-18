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
public class Receptionist extends User {
    
    public Receptionist(String username, String name, double hourlyRate, String jobTitle) {
        super(username, name, hourlyRate, jobTitle);
    }
    
    /* Job needs definition
    public Job addJob(int jobId){
        throw new UnsupportedOperationException("addJob() not implemented");
    }
    
    public boolean checkProgress(){
        throw new UnsupportedOperationException("checkProgress() not implemented");
    }
    
    public Job searchJob(int jobId){
        throw new UnsupportedOperationException("searchJob() not implemented");
    }
    */
    
    /* Invoice needs definition
    public Invoice generateInvoice(String[] data){
        throw new UnsupportedOperationException("generateInvoice() not implemented");
    }
    */
    
    public void orderPart(int partId){
        throw new UnsupportedOperationException("orderPart() not implemented");
    }
    
    public void updateStock(int stockId, int quantity){
        throw new UnsupportedOperationException("updateStock() not implemented");
    }
    
    /* class Part needs definition
    public Part searchPart(int partId){
        throw new UnsupportedOperationException("searchPart() not implemented");
    }
    */
    
    public void changeThreshold(int quantity){
        throw new UnsupportedOperationException("changeThreshold() not implemented");
    }
    
    /* class Report needs definition
    public Report generateReport(String[] data){
        throw new UnsupportedOperationException("generateReport() not implemented");
    }
    */
}
