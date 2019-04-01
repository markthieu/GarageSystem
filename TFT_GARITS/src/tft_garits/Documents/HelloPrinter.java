/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George Kemp
 */
public class HelloPrinter extends Printer {

    public HelloPrinter(){
        super();
        name = "HelloWorld.pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            document.open();
            document.add(new Paragraph("A Hello World PDF document."));
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(HelloPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
