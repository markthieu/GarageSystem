/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

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
        
        //creates account table and initialises with admin account
        databaseHandler.createNewTable();
        databaseHandler.insertUser("admin", "tft", "Admin", null);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI(databaseHandler).run("LOGIN");
            }
        });
    }
}
