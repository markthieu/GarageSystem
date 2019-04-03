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

/**
 *
 * @author George Kemp
 */
public class StockReportPrinter extends Printer{
    
    Object[][] data;
    LocalDateTime now;
    LocalDateTime from;
    LocalDateTime to;
    float boldWidth = 1.5f;
    Object[] emptyRow = {"", "", "", "", "", "", "", "", "", ""};
    float initialTotal = 0;
    float nowTotal = 0;
    
    public StockReportPrinter(Object[][] data, LocalDateTime from, LocalDateTime to){
        //"part name", "Description", "Price", "Initial Stock", "Initial Cost", "Used", "Delivery", "New Stock", "Stock Cost", "Threshold"
        this.data = data;
        now = LocalDateTime.now();
        this.from = from;
        this.to = to;
        
        for (Object[] row : data){
            float initCost = (float) row[4];
            float nowCost = (float) row[8];
            
            initialTotal = initialTotal + initCost;
            nowTotal = nowTotal + nowCost;
            
            row[2] = "£" + String.format("%.2f", row[2]);
            row[4] = String.format("%.2f", row[4]);
            row[8] = String.format("%.2f", row[8]);
        }
        
        this.name = "documents/stockReports/" + now.format(DateTimeFormatter.ofPattern("uuuu-LL-dd-HH-mm-ss")) + "stocklevels.pdf";
    }
    
    @Override
    void writeContent(Document doc) {
        try {
            doc.open();
            formatAddress(qffAddress, new String[0], doc);
            doc.add(new Paragraph("Spare Parts / Stock Level Report\n\n", boldFont));
            
            doc.add(new Paragraph("Report Period: " + from.format(DateTimeFormatter.ofPattern("dd/LL/uuuu")) + 
                                                   " - " + to.format(DateTimeFormatter.ofPattern("dd/LL/uuuu")) + "\n\n"));
            
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
            
            makeTable(table);
            
            doc.add(table);
            
            doc.add(new Paragraph("Report date: " + now.format(DateTimeFormatter.ofPattern("d MMMM uuuu"))));
            
            doc.add(new Paragraph("\nSenior Storekeeper.\n\n\n" +
                                        "Ms E. Kournikova"));
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(StockReportPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void makeTable(PdfPTable table) {
        //"part name", "Description", "Price", "Initial Stock", "Initial Cost", "Used", "Delivery", "New Stock", "Stock Cost", "Threshold"
        table.addCell(createTitleCell("Part Name"));
        table.addCell(createTitleCell("Description"));
        table.addCell(createTitleCell("Price"));
        table.addCell(createTitleCell("Initial Stock"));
        table.addCell(createTitleCell("Initial Cost, £"));
        table.addCell(createTitleCell("Used"));
        table.addCell(createTitleCell("Delivery"));
        table.addCell(createTitleCell("New Stock"));
        table.addCell(createTitleCell("Stock Cost, £"));
        table.addCell(createTitleCell("Threshold"));
        table.completeRow();
        
        addRow(table, emptyRow);
        
        for (Object[] row : data) addRow(table, row);
        
        addRow(table, emptyRow);
        
        PdfPCell c = createBottomCell("Total");
        c.enableBorderSide(Rectangle.LEFT);
        table.addCell(c);
        table.addCell(createBottomCell(""));
        table.addCell(createBottomCell(""));
        table.addCell(createBottomCell(""));
        table.addCell(createBottomCell(String.format("%.2f", initialTotal)));
        table.addCell(createBottomCell(""));
        table.addCell(createBottomCell(""));
        table.addCell(createBottomCell(""));
        PdfPCell l = createBottomCell(String.format("%.2f", nowTotal));
        l.enableBorderSide(Rectangle.RIGHT);
        table.addCell(l);
        table.addCell(createBlankCell(""));
        table.completeRow();
    }
    
    protected PdfPCell createTitleCell(String text){
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Paragraph(text, smallBoldFont));
        cell.setRotation(90);
        cell.setBorderWidth(boldWidth);
        return cell;
    }

    private void addRow(PdfPTable table, Object[] row) {
        table.addCell(createLeftCell(row[0].toString()));
        for (int i = 1; i < row.length-1; i++){
            PdfPCell cell = new PdfPCell();
            cell.addElement(new Paragraph(row[i].toString(), smallFont));
            table.addCell(cell);
        }
        table.addCell(createRightCell(row[9].toString()));
        table.completeRow();
    }
    
    private PdfPCell createLeftCell(String text){
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Paragraph(text, smallFont));
        cell.setBorderWidthLeft(boldWidth);
        cell.setMinimumHeight(10f);
        return cell;
    }
    
    private PdfPCell createRightCell(String text){
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Paragraph(text, smallFont));
        cell.setBorderWidthRight(boldWidth);
        cell.setMinimumHeight(10f);
        return cell;
    }
    
    private PdfPCell createBottomCell(String text){
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Paragraph(text, smallBoldFont));
        cell.setBorderWidth(boldWidth);
        cell.disableBorderSide(Rectangle.LEFT);
        cell.disableBorderSide(Rectangle.RIGHT);
        return cell;
    }
}
