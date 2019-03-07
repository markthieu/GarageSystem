/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;


/**
 *
 * @author George Kemp
 */
public class GUI {

    //private Point location;
    
    void run(String form) {
        switch (form){
            case "LOGIN": 
                showForm(new LoginForm(this));
                break;
                        
            case "MAINMENU": 
                showForm(new MainMenuForm(this));
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
                
            case "SETTINGS":
                showForm(new SettingsForm(this));
                break;
                
            default: 
                showForm(new ErrorForm(this));
        }
    }
    
    void showForm(Form form){
        form.setLocationRelativeTo(null); //centres the window on the screen
        form.setVisible(true);
    }
}
