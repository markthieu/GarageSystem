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
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tft_garits.GUI.GUI;
import tft_garits.Job.Task;
import tft_garits.Stock.Part;

/**
 *
 * @author George Kemp
 */
public class CheckPrinter extends Printer{
    int job_no;
    LocalDateTime now;
    String customer_name;
    String[] customer_address;
    float amount;
    
    public CheckPrinter(Object[] data){
        now = LocalDateTime.now();
        customer_name = (String) data[0];
        customer_address = (String[]) data[1];
        amount = (float) data[2];
        
        name = "documents/letters/" + customer_name + "cheque.pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            doc.open();
            formatAddress(customer_address, qffAddress, doc);
            doc.add(new Paragraph(now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            doc.add(new Paragraph("Dear " + customer_name + ",\n\n"));
            
            doc.add(new Paragraph("For being such a valued customer we are discounting your payments from the last month. \n"));
            
            doc.add(new Paragraph("Please find a cheque for £" + String.format("%.2f", amount) + " enclosed. \n"));
            
            doc.add(new Paragraph("\nThank you for your valued custom. We look forward to receiving your payment in due course.\n\n\n" +
                                        "Yours sincerely,\n\n" +
                                        "G. Lancaster "));
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(CheckPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
