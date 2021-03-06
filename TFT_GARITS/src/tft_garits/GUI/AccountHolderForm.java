/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tft_garits.Database.ValueObject;
import tft_garits.Documents.CheckPrinter;
import tft_garits.Documents.Printer;

/**
 *
 * @author George Kemp
 */
public class AccountHolderForm extends Form {
    
    private int customer_no;
    ValueObject id ;
    /**
     * Creates new form CustomerForm
     */
    public AccountHolderForm(int customer_no, GUI gui) {
        super(gui);
        initComponents();
        this.customer_no = customer_no;
        id = new ValueObject("int", customer_no);
        flexPrintButton.setEnabled(false);
        idNoTextField.setText(customer_no + "");
        idNoTextField.setEditable(false);
        fullNameTextField.setText(gui.databaseHandler.executeStringQuery("SELECT customer_name FROM customer WHERE customer_no=?", id, "customer_name"));
        fullNameTextField.setEditable(false);
        //buttonGroup1.
        
        gui.databaseHandler.executeStatement("INSERT INTO AccountHolder (customer_no)\n" +
                                            "VALUES\n" +
                                            " (" + customer_no + ") \n" +
                                            "ON CONFLICT (customer_no) DO NOTHING;");
        //limitField.setEditable(false);
        amountField.setEditable(false);

        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idNoTextField = new javax.swing.JTextField();
        fullNameTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        fixedRadioButton = new javax.swing.JRadioButton();
        variableRadioButton = new javax.swing.JRadioButton();
        flexibleRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        percentageField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        flexPrintButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        flexTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Account Holder");

        jLabel2.setText("ID no:");

        jLabel3.setText("Full Name:");

        idNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNoTextFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(fixedRadioButton);
        fixedRadioButton.setText("Fixed");
        fixedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(variableRadioButton);
        variableRadioButton.setText("Variable");
        variableRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                variableRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(flexibleRadioButton);
        flexibleRadioButton.setText("Flexible");
        flexibleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flexibleRadioButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Discounts:");

        percentageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentageFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Discount %:");

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Amount Spent This Month:");

        flexPrintButton.setText("Print Letter");
        flexPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flexPrintButtonActionPerformed(evt);
            }
        });

        flexTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amount", "Discount"
            }
        ));
        jScrollPane3.setViewportView(flexTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(90, 90, 90)
                                .addComponent(fixedRadioButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(idNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(variableRadioButton)
                                    .addComponent(flexibleRadioButton)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(flexPrintButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 28, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel5))
                                            .addComponent(percentageField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fixedRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(percentageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(variableRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(flexibleRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(flexPrintButton))
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int type = 0;
        try {
            if (fixedRadioButton.isSelected()){
                type = 1;
                float percentage = Float.parseFloat(percentageField.getText());
                gui.databaseHandler.executeStatement("UPDATE AccountHolder SET discount_type = 1, discount_amount = " + percentage + " WHERE customer_no = " + customer_no);
            } else if (variableRadioButton.isSelected()){
                type = 2;
                float percentage = Float.parseFloat(percentageField.getText());
                gui.databaseHandler.executeStatement("UPDATE AccountHolder SET discount_type = 2, discount_amount = " + percentage + " WHERE customer_no = " + customer_no);
                //needs work
            } else if (flexibleRadioButton.isSelected()){
                type = 3;
                gui.databaseHandler.executeStatement("UPDATE AccountHolder SET discount_type = 3 WHERE customer_no = " + customer_no);
                
                DefaultTableModel dtm = (DefaultTableModel) flexTable.getModel();
                Vector vector = dtm.getDataVector();
                
                float[] amount = new float[vector.size()];
                float[] discount = new float[vector.size()];
                
                for (int i = 0; i < vector.size(); i++){
                    if (((Vector) vector.get(i)).get(0) == null){
                        amount[i] = 0;
                    } else {
                        Object o = ((Vector) vector.get(i)).get(0);
                        if (o instanceof Double){
                            amount[i] = (float) ((Double) o).floatValue();
                        } else {
                            amount[i] = Float.parseFloat((String) o);
                        }
                    }
                    
                    if (((Vector) vector.get(i)).get(1) == null){
                        discount[i] = 0;
                    } else {
                        Object o = ((Vector) vector.get(i)).get(1);
                        if (o instanceof Double){
                            discount[i] = (float) ((Double) o).floatValue();
                        } else {
                            discount[i] = Float.parseFloat((String) o);
                        }
                    }
                }
                
                /*
                for (int i = 0; i < amount.length; i++){
                    System.out.println(amount[i] + " " + discount[i]);
                }*/
                gui.databaseHandler.setFlexDetails(amount, discount, customer_no);
            }
        } catch (NumberFormatException | ClassCastException e){
            gui.throwErrorForm("Values must be a number.");
            System.out.println(e);
        }
        setTableEditable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void idNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idNoTextFieldActionPerformed

    private void percentageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_percentageFieldActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void flexPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flexPrintButtonActionPerformed
        // TODO add your handling code here:
        float paid = gui.databaseHandler.executeFloatQuery("SELECT monthly_spending FROM accountholder WHERE customer_no = ?", id, "monthly_spending");
        if (paid <= 0){
            gui.throwErrorForm("Client is not owed any money.");
        } else {
            Object[][] data = gui.databaseHandler.getFlexDiscountValues(customer_no);
            if (data[0][0] == null){
                gui.throwErrorForm("Discount not set.");
            } else {
                Object[] details = new Object[3];
                details[0] = fullNameTextField.getText();
                details[1] = gui.databaseHandler.getAddress(customer_no);
                float owed = 0;
                
                int i = 0;
                System.out.println(paid + " " + owed);
                while(data[i][0] != null && paid != 0){
                    if (paid > ((Double) data[i][0]).floatValue()){
                        owed = owed + (((Double) data[i][0]).floatValue() * (((Double) data[i][1]).floatValue())/100);
                        paid = paid - ((Double) data[i][0]).floatValue();
                    } else {
                        owed = owed + (paid * (((Double) data[i][1]).floatValue()/100));
                        paid = 0;
                    }
                    System.out.println(paid + " " + owed);
                    i++;
                }
                details[2] = owed;
                
                Printer cp = new CheckPrinter(details);
                cp.print();
                
                gui.databaseHandler.executeStatement("UPDATE accountholder SET monthly_spending = 0 WHERE customer_no = " + customer_no);
                gui.throwErrorForm("Letter printed.");
                update();
            }
        }
    }//GEN-LAST:event_flexPrintButtonActionPerformed

    private void fixedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedRadioButtonActionPerformed
        // TODO add your handling code here:
        setTableUneditable();
        flexPrintButton.setEnabled(false);
    }//GEN-LAST:event_fixedRadioButtonActionPerformed

    private void variableRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_variableRadioButtonActionPerformed
        // TODO add your handling code here:
        setTableUneditable();
        flexPrintButton.setEnabled(false);
    }//GEN-LAST:event_variableRadioButtonActionPerformed

    private void flexibleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flexibleRadioButtonActionPerformed
        // TODO add your handling code here:
        setTableEditable();
        flexPrintButton.setEnabled(true);
    }//GEN-LAST:event_flexibleRadioButtonActionPerformed

    private void clearFields(){
        idNoTextField.setText("");
        fullNameTextField.setText("");
        
        /*
        vehiclesTextField
        fixedCheck
        flexibleCheck
        variableCheck
        payLaterCheck
        */
    }
    
    private void setTableEditable(){
        String[] columns = {"Amount", "Discount"};
                
        //get data for each job
        Object[][] data = gui.databaseHandler.getFlexDiscountValues(customer_no);
        
        DefaultTableModel dataModel = new DefaultTableModel(data, columns){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }
        };
        flexTable.setModel(dataModel);
    }
    
    private void setTableUneditable(){
        flexTable.removeEditor();
        DefaultTableModel dtm = (DefaultTableModel) flexTable.getModel();
        for (int i = 0 ; i < dtm.getRowCount(); i++){
            dtm.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton fixedRadioButton;
    private javax.swing.JButton flexPrintButton;
    private javax.swing.JTable flexTable;
    private javax.swing.JRadioButton flexibleRadioButton;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JTextField idNoTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField percentageField;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton variableRadioButton;
    // End of variables declaration//GEN-END:variables

    private void update(){
        Object[] data = gui.databaseHandler.getDiscountInfo(id);
        switch ((int) data[0]){
            case 1:
                fixedRadioButton.doClick();
                break;
            case 2:
                variableRadioButton.doClick();
                break;
            case 3:
                flexibleRadioButton.doClick();
                //limitField.setText((float) data[2] + "");
                break;
            default:
                return;
        }
        
        amountField.setText("£" + (float) data[2]);
        percentageField.setText((float) data[1] + "");
    }
}
