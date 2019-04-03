/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import tft_garits.Database.ConnectionHandler;
import tft_garits.Database.DatabaseHandler;

/**
 *
 * @author George Kemp
 */
public class GARITS { //GUI handler & main class
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //database parameters
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "root";
        
        ConnectionHandler connectionHandler = new ConnectionHandler(url, user, password);
        DatabaseHandler databaseHandler = new DatabaseHandler(connectionHandler.connect(), url);
        
        
        try {
            Path reminder = Paths.get("documents/reminders");
            Path stockOrder = Paths.get("documents/stockOrder");
            Path invoice = Paths.get("documents/invoices");
            Path stockReport = Paths.get("documents/stockReports");
            Path db = Paths.get("db");
            Files.createDirectories(reminder);
            Files.createDirectories(invoice);
            Files.createDirectories(stockOrder);
            Files.createDirectories(stockReport);
            Files.createDirectories(db);
        } catch (IOException ex) {
            Logger.getLogger(GARITS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //creates account table and initialises with admin account
        try {
            databaseHandler.createNewTable();
            databaseHandler.insertUser("admin", "tft", "Admin", null);
            
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GUI(databaseHandler).run("LOGIN");
                }
            });
        } catch (NullPointerException e){
            ErrorNotification form = new ErrorNotification("Cannot connect to server.");
            form.setLocationRelativeTo(null); //centres the window on the screen
            form.setVisible(true);
        }
    }
}
