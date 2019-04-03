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
public class ReminderPrinter extends Printer {
    
    int job_no;
    String customer;
    String[] customerAddress;
    LocalDateTime now;
    String reg_no;
    LocalDateTime invoicePosted;
    float amount;
    int type; //1: first, 2: second, 3: final
    String title;
    String body;

    public ReminderPrinter(int type, int job_no, String customer, String[] customerAddress, String reg_no, LocalDateTime invoicePosted, float amount){
        super();
        this.job_no = job_no;
        this.customer = customer;
        this.customerAddress = customerAddress;
        this.reg_no = reg_no;
        this.invoicePosted = invoicePosted;
        this.amount = amount;
        
        now = LocalDateTime.now();
        
        switch (type){
            case 1:
                title = "REMINDER - INVOICE: " + job_no;
                body = "\nAccording to our records, it appears that we have not yet received payment of the above invoice, which was posted " +
                        "to you on " + invoicePosted.format(DateTimeFormatter.ofPattern("d MMMM uuuu")) + ", for work done on the vehicle(s) listed above.\n" +
                        "We would appreciate payment at your earliest convenience.\n\n" +
                        "If you have already sent a payment to us recently, please accept our apologies.\n\n\n";
                break;
            case 2:
                title = "SECOND REMINDER - INVOICE: " + job_no;
                body = "\nIt appears that we still have not yet received payment of the above invoice, which was posted " +
                        "to you on " + invoicePosted.format(DateTimeFormatter.ofPattern("d MMMM uuuu")) + ", for work done on the vehicle(s) listed above, despite a reminder letter posted to you 1 month later.\n" +
                        "We would appreciate payment it if you would settle this invoice in full by return\n\n" +
                        "If you have already sent a payment to us recently, please accept our apologies.\n\n\n";
                break;
            case 3:
            default:
                title = "FINAL REMINDER - INVOICE: " + job_no;
                body = "\nDespite two reminders, it appears that we still have not yet received payment of the above invoice, which was posted " +
                        "to you on " + invoicePosted.format(DateTimeFormatter.ofPattern("d MMMM uuuu")) + ", for work done on the vehicle(s) listed above.\n" +
                        "Unless you pay the outstanding amount in full within SEVEN DAYS, or contact us with proposals for repayment, we " +
                        "will have no option but to refer the matter to our solicitor.\n\n" +
                        "Please send payment immediately to avoid further action.\n\n\n";
        }
        
        name = "documents/reminders/Reminder" + type + customer + ".pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            document.open();
            formatAddress(customerAddress, qffAddress, doc);
            document.add(new Paragraph(now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            document.add(new Paragraph("Dear " + customer + ",\n\n"));
            Paragraph bold = new Paragraph(title + "\n" +
                                           "Vehicle Registration No.: " + reg_no + "    Total Amount: £" + amount, boldFont);
            bold.setAlignment(Element.ALIGN_CENTER);
            document.add(bold);
            document.add(new Paragraph(body +
                                       "Yours sincerely,\n\n" +
                                       "G. Lancaster "));
            document.close();
        } catch (DocumentException ex) {
            //gui.throwErrorForm(ex);
            //Logger.getLogger(ReminderPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
