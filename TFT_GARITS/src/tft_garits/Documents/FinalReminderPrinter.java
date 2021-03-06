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
public class FinalReminderPrinter extends Printer {
    
    String customer;
    String[] customerAddress;
    LocalDateTime now;
    String reg_no;
    LocalDateTime invoicePosted;
    float amount;

    public FinalReminderPrinter(String customer, String[] customerAddress, String reg_no, /*LocalDateTime invoicePosted,*/ float amount){
        super();
        this.customer = customer;
        this.customerAddress = customerAddress;
        this.reg_no = reg_no;
        this.invoicePosted = LocalDateTime.now();//= invoicePosted;
        this.amount = amount;
        
        now = LocalDateTime.now();
        
        name = "documents/reminders/Reminder3" + customer + ".pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            document.open();
            formatAddress(customerAddress, qffAddress, doc);
            document.add(new Paragraph(now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            document.add(new Paragraph("Dear " + customer + ",\n\n"));
            Paragraph bold = new Paragraph("FINAL REMINDER - INVOICE\n" +
                                           "Vehicle Registration No.: " + reg_no + "    Total Amount: £" + amount, boldFont);
            bold.setAlignment(Element.ALIGN_CENTER);
            document.add(bold);
            document.add(new Paragraph("\nDespite two reminders, it appears that we still have not yet received payment of the above invoice, which was posted " +
                                       "to you on " + invoicePosted.format(DateTimeFormatter.ofPattern("d MMMM uuuu")) + ", for work done on the vehicle(s) listed above.\n" +
                                       "Unless you pay the outstanding amount in full within SEVEN DAYS, or contact us with proposals for repayment, we " +
                                       "will have no option but to refer the matter to our solicitor.\n\n" +
                                       "Please send payment immediately to avoid further action.\n\n\n" +
                                       "Yours sincerely,\n\n" +
                                       "G. Lancaster "));
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(FinalReminderPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
