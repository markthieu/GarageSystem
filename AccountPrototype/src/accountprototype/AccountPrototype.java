/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountprototype;
 
import java.util.Scanner;

/**
 *
 * @author gk
 */
public class AccountPrototype {

    ConnectionHandler connectionHandler;
    DatabaseHandler databaseHandler;
    static boolean running = true;
    static boolean loggedIn = false;
    
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "root";
        
        ConnectionHandler connectionHandler = new ConnectionHandler(url, user, password);
        DatabaseHandler databaseHandler = new DatabaseHandler(connectionHandler.connect(), url);
        
        //creates account table and initialises with admin account
        databaseHandler.createNewTable();
        databaseHandler.insert("admin", "tft");
        
        //for reading text input
        Scanner reader = new Scanner(System.in);
        
        //main loop of application
        do {
            
            System.out.print(">");
            //gets text input string
            String input = reader.nextLine();

            if ("login".equals(input)){
                //take in account details
                System.out.print(">Account name: ");
                String account_name = reader.nextLine();
                System.out.print(">Password: ");
                String pword = reader.nextLine();
                
                if (databaseHandler.checkPassword(account_name, pword)){
                    loggedIn = true;
                    System.out.println("logged in as: " + account_name);
                } else {
                    System.out.println("incorrect details");
                }
                
            } else if ("add".equals(input) && loggedIn){
                //take in account details
                System.out.print(">Account name: ");
                String account_name = reader.nextLine();
                System.out.print(">Password: ");
                String pword = reader.nextLine();
                
                //add account to db with those details
                databaseHandler.insert(account_name, pword);
                
            } else if ("print".equals(input)){// && loggedIn){
                //prints all accounts and passwords
                System.out.print(databaseHandler.tableToString());
                
            }else if ("exit".equals(input)){
                running = false;
                
            } else {
                //print out options
                if (loggedIn){
                    System.out.println("error, 'login', 'add', 'print or 'exit'");
                } else {
                    System.out.println("error, 'login' or 'exit'");
                }
            }
            
        } while (running);
        
        System.out.println("program terminated");
    }
 
}