/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author George Kemp
 */
public abstract class Printer {
    
    Document document;
    String name;
    String[] qffAddress = {"Quick Fix Fitters,", "19 High St.,", "Ashford,", "Kent CT16 8YY"};
    Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
    
    public Printer(){
        document = new Document();
    }
    
    public void print(){
        try {
           PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(name));
           writeContent(document);
           writer.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        }
    }

    abstract void writeContent(Document doc);
    
    protected void formatAddress(String[] a, String[] b, Document doc) throws DocumentException{
        PdfPTable table = new PdfPTable(new float[] {3, 1});
        table.setWidthPercentage(100);
        int length = a.length > b.length ? a.length : b.length;
        PdfPCell[][] cells = new PdfPCell[length][];
        for (int i = 0; i < length; i++){
            PdfPCell[] row = new PdfPCell[2];
            
            row[0] = new PdfPCell();
            row[0].setBorder(Rectangle.NO_BORDER);
            row[0].setPadding(0);
            row[0].setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            row[1] = new PdfPCell();
            row[1].setBorder(Rectangle.NO_BORDER);
            row[1].setPadding(0);
            row[1].setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            //create cells
            if (i < a.length){
                row[0].addElement(new Paragraph(a[i]));
            }
            
            if (i < b.length){
                row[1].addElement(new Paragraph(b[i]));
            }
            
            cells[i] = row;
        }
        
        for (int i = 0; i < length; i++){
            table.addCell(cells[i][0]);
            table.addCell(cells[i][1]);
            table.completeRow();
        }
        
        doc.add(table);
    }
}
