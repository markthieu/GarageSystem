/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George Kemp
 */
public class MOTReminderPrinter extends Printer {
    
    String customer;
    String[] customerAddress;
    LocalDateTime now;
    LocalDateTime test_date;
    String reg_no;
    LocalDateTime invoicePosted;
    float amount;

    public MOTReminderPrinter(String customer, String[] customerAddress, String reg_no, LocalDateTime test_date){
        super();
        this.customer = customer;
        this.customerAddress = customerAddress;
        this.reg_no = reg_no;
        this.test_date = test_date.plusYears(1);
        
        now = LocalDateTime.now();
        
        name = "documents/reminders/MOTreminder" + reg_no + ".pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            document.open();
            formatAddress(customerAddress, qffAddress, doc);
            document.add(new Paragraph(now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            document.add(new Paragraph("Dear " + customer + ",\n\n"));
            Paragraph bold = new Paragraph("REMINDER - MoT TEST DUE\n" +
                                           "Vehicle Registration No.: " + reg_no + "    Renewal Test Date: " + test_date.format(DateTimeFormatter.ofPattern("d MMMM uuuu")), boldFont);
            bold.setAlignment(Element.ALIGN_CENTER);
            document.add(bold);
            document.add(new Paragraph("\nAccording to our records, the above vehicle is due to have its MoT certificate renewed on the date shown. \n\n" +
                                       "Account Holders customers such as yourself are assured of our prompt attention, and we hope that you will use our " +
                                       "services on this occasion in order to have the necessary test carried out on your vehicle. \n\n\n" +
                                       "Yours sincerely,\n\n" +
                                       "G. Lancaster "));
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(MOTReminderPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
