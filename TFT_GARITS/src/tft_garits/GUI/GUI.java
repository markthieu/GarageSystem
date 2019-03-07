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

    
    enum CurrentFrame{
        LOGIN(), MAINMENU()
    }
    
    CurrentFrame currentFrame = CurrentFrame.LOGIN;

    void run() {
        switch (currentFrame){
            case LOGIN: new LoginForm(this).setVisible(true);
                        break;
                        
            case MAINMENU: new MainMenuForm(this).setVisible(true);
                        break;
        }
    }
    
    void displayMenu(){
        currentFrame = CurrentFrame.MAINMENU;
        run();
    }
    
    void displayLogin() {
        currentFrame = CurrentFrame.LOGIN;
        run();
    }
    
}
