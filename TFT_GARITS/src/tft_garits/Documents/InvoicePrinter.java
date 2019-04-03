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
import tft_garits.Job.Task;
import tft_garits.Stock.Part;

/**
 *
 * @author George Kemp
 */
public class InvoicePrinter extends Printer{
    int job_no;
    LocalDateTime now;
    String customer_name;
    String[] customer_address;
    String reg_no;
    String make;
    String model;
    ArrayList<Task> tasks;
    ArrayList<Part> parts;
    float hourly_rate;
    float estimated_time;
    
    public InvoicePrinter(Object[] data){
        
        job_no = (int) data[0];
        now = LocalDateTime.now();
        customer_name = (String) data[1];
        customer_address = (String[]) data[2];
        reg_no = (String) data[3];
        make = (String) data[4];
        model = (String) data[5];
        
        tasks = (ArrayList<Task>) data[6];
        parts = (ArrayList<Part>) data[7];
        
        hourly_rate = (float) data[8];
        estimated_time = (float) data[9];
        
        name = "documents/invoices/" + job_no + "invoice.pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            doc.open();
            formatAddress(customer_address, qffAddress, doc);
            doc.add(new Paragraph(now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            doc.add(new Paragraph("Dear " + customer_name + ",\n\n"));
            
            Paragraph bold = new Paragraph("INVOICE NO.: " + job_no, boldFont);
            bold.setAlignment(Element.ALIGN_CENTER);
            doc.add(bold);
            
            doc.add(new Paragraph("Vehicle Registration No.: " + reg_no + " \n"));
            doc.add(new Paragraph("Make: " + make + " \n"));
            doc.add(new Paragraph("Model: " + model + " \n\n\n"));
            
            Paragraph work = new Paragraph();
            work.add("Description of work: \n\n");
            for (Task t : tasks){
                work.add("- " + t.getDescription() + "\n");
            }
            work.add("\n\n");
            doc.add(work); //add each task
            
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            
            makeTable(table);
            
            doc.add(table);
            
            doc.add(new Paragraph("\nThank you for your valued custom. We look forward to receiving your payment in due course.\n\n\n" +
                                        "Yours sincerely,\n\n" +
                                        "G. Lancaster "));
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(InvoicePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void makeTable(PdfPTable table) {
        table.addCell(createCell("Item"));
        table.addCell(createCell("Part Description"));
        table.addCell(createCell("Unit Cost"));
        table.addCell(createCell("Qty"));
        table.addCell(createCell("Cost"));
        table.completeRow();
        
        blankRow(table);
        
        float partsTotal = 0;
        
        for (Part p : parts){
            table.addCell(createBlankCell(p.getPart_name()));
            table.addCell(createBlankCell(p.getDescription()));
            table.addCell(createBlankCell("£" + String.format("%.2f", p.getPrice())));
            table.addCell(createBlankCell("" + p.getQuantity()));
            float sum = p.getQuantity() * p.getPrice();
            table.addCell(createBlankCell("£" + String.format("%.2f", sum)));
            
            partsTotal = partsTotal + sum;
            table.completeRow();
        }
        
        blankRow(table);
        
        //labour row
        table.addCell(createBlankCell("Labour"));
        table.addCell(createBlankCell(""));
        table.addCell(createCell("£" + String.format("%.2f", hourly_rate)));
        table.addCell(createCell(estimated_time + "hrs"));
        float labourTotal = hourly_rate * estimated_time;
        table.addCell(createCell("£" + String.format("%.2f", labourTotal)));
        table.completeRow();
        
        blankRow(table);
        
        //total
        float total = partsTotal + labourTotal;
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell("Total: "));
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell("£" + String.format("%.2f", total)));
        table.completeRow();
        
        //VAT total
        float VATtotal = (float) (total * 0.2);
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell(""));
        table.addCell(createCell("VAT: "));
        table.addCell(createCell(""));
        table.addCell(createCell("£" + String.format("%.2f", VATtotal)));
        table.completeRow();
        
        //VAT total
        float grandTotal = total + VATtotal;
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell("Grand Total: "));
        table.addCell(createBlankCell(""));
        table.addCell(createBlankCell("£" + String.format("%.2f", grandTotal)));
        table.completeRow();
    }
}
