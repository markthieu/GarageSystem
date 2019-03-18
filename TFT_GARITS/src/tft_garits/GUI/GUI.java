/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import tft_garits.Account.Administrator;
import tft_garits.Account.Foreperson;
import tft_garits.Account.Franchisee;
import tft_garits.Account.Mechanic;
import tft_garits.Account.Receptionist;
import tft_garits.Account.User;
import tft_garits.Database.DatabaseHandler;


/**
 *
 * @author George Kemp
 */
public class GUI {
    
    public DatabaseHandler databaseHandler;
    public User currentUser; 

    public GUI(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }
    
    void run(String form) {
        switch (form){
            case "LOGIN": 
                showForm(new LoginForm(this));
                currentUser = null;
                break;
                        
            case "MAINMENU": 
                if (currentUser instanceof Administrator){
                    showForm(new SettingsForm(this));
                } else if (currentUser instanceof Franchisee){
                    showForm(new FranchiseeMenu(this));
                } else if (currentUser instanceof Foreperson){
                    showForm(new ForepersonMenu(this));
                } else if (currentUser instanceof Mechanic){
                    showForm(new MechanicMenu(this));
                } else if (currentUser instanceof Receptionist){
                    showForm(new ReceptionistMenu(this));
                }
                break;
            
            case "CUSTOMERS":
                showForm(new CustomerForm(this));
                break;
                
            case "STOCK":
                showForm(new StockForm(this));
                break;
                
            case "TASKS":
                showForm(new TaskForm(this));
                break;
                
            case "JOBSHEET":
                showForm(new JobsForm(this));
                break;
                
            case "DOCUMENTS":
                showForm(new DocumentsForm(this));
                break;
                
            case "JOBLIST":
                showForm(new JobListForm(this));
                break;
                
            case "ADDUSER":
                showForm(new AddUserForm(this));
                break;
                
            case "EXISTINGUSER":
                showForm(new EditUserForm(this));
                break;
                
            case "BOOKINGREPORT":
                showForm(new BookingReportForm(this));
                break;
                
            case "JOBREPORT":
                showForm(new JobReportForm(this));
                break;
                
            case "STOCKREPORT":
                showForm(new StockReportForm(this));
                break;
                
            default: 
                showForm(new ErrorForm(this));
        }
    }
    
    void showForm(Form form){
        form.setLocationRelativeTo(null); //centres the window on the screen
        form.setVisible(true);
    }

    void setCurrentUser(User user) {
        currentUser = user;
    }
}
