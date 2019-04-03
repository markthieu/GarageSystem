/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import tft_garits.Database.ValueObject;
import tft_garits.Documents.InvoicePrinter;
import tft_garits.Documents.Printer;
import tft_garits.Documents.ReminderPrinter;

/**
 *
 * @author George Kemp
 */
public class OutstandingListForm extends Form {
    
    boolean hideComplete = false;
    boolean showUnallocated = false;
    Object[][] data;
    /**
     * Creates new form CustomerForm
     */
    public OutstandingListForm(GUI gui) {
        super(gui);
        initComponents();
        
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        paidButton = new javax.swing.JButton();
        printAllButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Outstanding Payments List");

        printButton.setText("Print Reminder");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Number", "Customer", "Vehicle Reg", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        paidButton.setText("Mark as Paid");
        paidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidButtonActionPerformed(evt);
            }
        });

        printAllButton.setText("Print All");
        printAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(printButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printAllButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paidButton)))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(paidButton)
                    .addComponent(printAllButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        gui.run("DOCUMENTS");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        int[] rows = table.getSelectedRows();
        for (int i : rows){
            int job_no = (int) data[i][0];
            LocalDateTime invoice_date = gui.databaseHandler.executeLDTQuery("SELECT invoice_date FROM job WHERE job_no = ?", new ValueObject("int", job_no), "invoice_date");
            int state = gui.databaseHandler.executeIntQuery("SELECT reminder_state FROM job WHERE job_no = ?", new ValueObject("int", job_no), "reminder_state");
            if (LocalDateTime.now().isAfter(invoice_date.plusMonths(state))){
                printReminder(job_no);
            } else {
                gui.throwErrorForm("Next reminder due: " + invoice_date.plusMonths(state).format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
        }
        
        updateTable();
    }//GEN-LAST:event_printButtonActionPerformed

    private void paidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidButtonActionPerformed
        int[] rows = table.getSelectedRows();
        for (int i : rows){
            int job_no = (int) data[i][0];
            gui.databaseHandler.executeStatement("UPDATE job SET reminder_state = 5 WHERE job_no = " + job_no);
        }
        
        updateTable();
    }//GEN-LAST:event_paidButtonActionPerformed

    private void printAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAllButtonActionPerformed
        Integer[] job_nos = gui.databaseHandler.getIntArray("SELECT job_no FROM job WHERE reminder_state = 1 OR reminder_state = 2 OR reminder_state = 3", "job_no");
        for (Integer i : job_nos){
            LocalDateTime invoice_date = gui.databaseHandler.executeLDTQuery("SELECT invoice_date FROM job WHERE job_no = ?", new ValueObject("int", i), "invoice_date");
            int state = gui.databaseHandler.executeIntQuery("SELECT reminder_state FROM job WHERE job_no = ?", new ValueObject("int", i), "reminder_state");
            if (LocalDateTime.now().isAfter(invoice_date.plusMonths(state))){
                printReminder(i);
            }
        }
        
        updateTable();
    }//GEN-LAST:event_printAllButtonActionPerformed

    private void updateTable(){
        //job_no int, vehicle_reg string, mech id int, mech name string, job status
        String[] columns = {"Job Number", "Customer Name", "Vehicle Registration", "Payment Status"};
                
        //get data for each job
        data = gui.databaseHandler.getOutstandingDetails();
        
        DefaultTableModel dataModel = new DefaultTableModel(data, columns);
        table.setDefaultEditor(Object.class, null);
        table.setModel(dataModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton paidButton;
    private javax.swing.JButton printAllButton;
    private javax.swing.JButton printButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void printReminder(int job_no) {
        ValueObject no = new ValueObject("int", job_no);
        String name = gui.databaseHandler.executeStringQuery("SELECT customer_name, job_no FROM customer INNER JOIN job ON customer.customer_no = job.customer_no WHERE job_no = ?", no, "customer_name");
        String[] address = gui.databaseHandler.getCustomerAddress(no, "job_no");
        String reg_no = gui.databaseHandler.executeStringQuery("SELECT reg_no FROM job WHERE job_no = ?", no, "reg_no");
        LocalDateTime invoice_date = gui.databaseHandler.executeLDTQuery("SELECT invoice_date FROM job WHERE job_no = ?", no, "invoice_date");
        float amount = gui.databaseHandler.executeFloatQuery("SELECT totalamount FROM job WHERE job_no = ?", no, "totalamount");
        int state = gui.databaseHandler.executeIntQuery("SELECT reminder_state FROM job WHERE job_no = ?", no, "reminder_state");

        //increment reminder state
        gui.databaseHandler.executeStatement("UPDATE job SET reminder_state = reminder_state + 1 WHERE job_no = " + job_no);

        Printer printer;
        printer = new ReminderPrinter(state, job_no, name, address, reg_no, invoice_date, amount);
        printer.print();
    }
}
