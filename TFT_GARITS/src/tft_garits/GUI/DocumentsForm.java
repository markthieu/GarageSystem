/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.time.LocalDateTime;
import tft_garits.Database.ValueObject;
import tft_garits.Documents.Printer;
import tft_garits.Documents.ReminderPrinter;

/**
 *
 * @author George Kemp
 */
public class DocumentsForm extends Form {

    /**
     * Creates new form CustomerForm
     */
    public DocumentsForm(GUI gui) {
        super(gui);
        initComponents();
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
        stockButton = new javax.swing.JButton();
        oustandingButton = new javax.swing.JButton();
        motButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Documents");

        stockButton.setText("Stock Report");
        stockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockButtonActionPerformed(evt);
            }
        });

        oustandingButton.setText("Oustanding Payments");
        oustandingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oustandingButtonActionPerformed(evt);
            }
        });

        motButton.setText("MoT Reminders");
        motButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motButtonActionPerformed(evt);
            }
        });

        printButton.setText("Printing");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stockButton)
                            .addComponent(oustandingButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motButton)
                            .addComponent(printButton))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockButton)
                    .addComponent(motButton))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oustandingButton)
                    .addComponent(printButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        gui.run("MAINMENU");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void stockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockButtonActionPerformed
        gui.run("STOCKREPORT");
        this.dispose();
    }//GEN-LAST:event_stockButtonActionPerformed

    private void oustandingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oustandingButtonActionPerformed
        OutstandingListForm form3 = new OutstandingListForm(gui);
        this.dispose();
        form3.setLocationRelativeTo(null); //centres the window on the screen
        form3.setVisible(true);
    }//GEN-LAST:event_oustandingButtonActionPerformed

    private void motButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motButtonActionPerformed
        MOTReminderForm form3 = new MOTReminderForm(gui);
        this.dispose();
        form3.setLocationRelativeTo(null); //centres the window on the screen
        form3.setVisible(true);
    }//GEN-LAST:event_motButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        PrintForm form3 = new PrintForm(gui);
        this.dispose();
        form3.setLocationRelativeTo(null); //centres the window on the screen
        form3.setVisible(true);
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton motButton;
    private javax.swing.JButton oustandingButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton stockButton;
    // End of variables declaration//GEN-END:variables

    private void printReminders(int type) {
        //needs to check whether this needs doing
        Integer[] job_nos = gui.databaseHandler.getIntArray("SELECT job_no FROM job WHERE completion_date IS NOT NULL AND reminder_state = " + type, "job_no");
        for (Integer i : job_nos){
            ValueObject no = new ValueObject("int", i);
            String name = gui.databaseHandler.executeStringQuery("SELECT customer_name, job_no FROM customer INNER JOIN job ON customer.customer_no = job.customer_no WHERE job_no = ?", no, "customer_name");
            String[] address = gui.databaseHandler.getCustomerAddress(no, "job_no");
            String reg_no = gui.databaseHandler.executeStringQuery("SELECT reg_no FROM job WHERE job_no = ?", no, "reg_no");
            LocalDateTime invoice_date = gui.databaseHandler.executeLDTQuery("SELECT invoice_date FROM job WHERE job_no = ?", no, "invoice_date");
            float amount = gui.databaseHandler.executeFloatQuery("SELECT totalamount FROM job WHERE job_no = ?", no, "totalamount");
            
            //increment reminder state
            gui.databaseHandler.executeStatement("UPDATE job SET reminder_state = reminder_state + 1 WHERE job_no = " + i);
            
            Printer printer;
            printer = new ReminderPrinter(type, i, name, address, reg_no, invoice_date, amount);
            printer.print();
        }
    }
}
