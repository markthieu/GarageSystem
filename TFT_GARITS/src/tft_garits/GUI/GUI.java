/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

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
                
            default: 
                showForm(new ErrorForm(this));
        }
    }
    
    void showForm(Form form){
        form.setLocationRelativeTo(null); //centres the window on the screen
        form.setVisible(true);
    }
}
