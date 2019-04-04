/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import static com.itextpdf.text.Element.RECTANGLE;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tft_garits.Stock.Stock;

/**
 *
 * @author George Kemp
 */
public class StockOrderPrinter extends Printer {
    
    LocalDateTime now;
    ArrayList<Stock> data;

    public StockOrderPrinter(ArrayList<Stock> data){
        super();
        now = LocalDateTime.now();
        this.data = data;
        name = "documents/stockOrder/StockOrder" + now.format(DateTimeFormatter.ofPattern("uuuuMMddHHmmss")) + ".pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            doc.open();
            formatAddress(qffAddress, new String[0], doc);
            doc.add(new Paragraph("Date: " + now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            doc.add(new Paragraph("\n\nCompany: Fjord Supplies \n" +
                                  "Address: 10 Largeunits, Trade Estate, Reading, RG10 4PT\n\n\n"));
            doc.add(new Paragraph("Tel: 01895 453 857\n" +
                                  "\n"));
            
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            
            table.addCell(createCell("Part Name"));
            table.addCell(createCell("Part Desc"));
            table.addCell(createCell("Amount"));
            table.addCell(createCell("Price"));
            
            table.completeRow();
            
            blankRow(table);
            
            float total = 0;
            for (Stock s : data){
                table.addCell(createBlankCell(s.getName()));
                table.addCell(createBlankCell(s.getDesc()));
                
                int amount = s.getAmount();
                float cost = s.getCost();
                total = total + amount*cost;
                
                table.addCell(createBlankCell(amount + ""));
                table.addCell(createBlankCell("£" + cost));
                
                table.completeRow();
            }
            
            table.addCell(createBlankCell(""));
            table.addCell(createBlankCell(""));
            table.addCell(createBlankCell("Total"));
            table.addCell(createBlankCell("£" + total));
            
            doc.add(table);
            
            doc.add(new Paragraph("\n\n\nSigned:"));
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(StockOrderPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
