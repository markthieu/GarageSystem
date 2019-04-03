/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.util.ArrayList;
import tft_garits.Database.ValueObject;

/**
 *
 * @author George Kemp
 */
public class AccountHolderForm extends Form {
    
    private int customer_no;
    /**
     * Creates new form CustomerForm
     */
    public AccountHolderForm(int customer_no, GUI gui) {
        super(gui);
        initComponents();
        this.customer_no = customer_no;
        ValueObject id = new ValueObject("int", customer_no);
        fullNameTextField.setText(gui.databaseHandler.executeStringQuery("SELECT customer_name FROM customer WHERE customer_no=?", id, "customer_name"));
        
        //buttonGroup1.
        
        gui.databaseHandler.executeStatement("INSERT INTO AccountHolder (customer_no)\n" +
                                            "VALUES\n" +
                                            " (" + customer_no + ") \n" +
                                            "ON CONFLICT (customer_no) \n" +
                                            "DO NOTHING;");
        limitField.setEditable(false);
        amountField.setEditable(false);

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
                limitField.setText((float) data[2] + "");
                break;
            default:
                return;
        }
        
        amountField.setText("£" + (float) data[3]);
        
        percentageField.setText((float) data[1] + "");
        
        
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idNoTextField = new javax.swing.JTextField();
        fullNameTextField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        fixedRadioButton = new javax.swing.JRadioButton();
        variableRadioButton = new javax.swing.JRadioButton();
        flexibleRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        percentageField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        limitField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

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

        editButton.setText("Save");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
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

        jLabel8.setText("Discount paid when > £");

        jButton2.setText("Print Letter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(218, 218, 218))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(flexibleRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limitField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(variableRadioButton)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(percentageField)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(amountField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fixedRadioButton)
                                    .addComponent(jLabel4))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fixedRadioButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(percentageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(variableRadioButton))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flexibleRadioButton)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(limitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(jButton2)))
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

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int type = 0;
        try {
            float percentage = Float.parseFloat(percentageField.getText());
            if (fixedRadioButton.isSelected()){
                type = 1;
                gui.databaseHandler.executeStatement("UPDATE AccountHolder SET discount_type = 1, discount_amount = " + percentage + " WHERE customer_no = " + customer_no);
            } else if (variableRadioButton.isSelected()){
                type = 2;
                gui.databaseHandler.executeStatement("UPDATE AccountHolder SET discount_type = 2, discount_amount = " + percentage + " WHERE customer_no = " + customer_no);
                //needs work
            } else if (flexibleRadioButton.isSelected()){
                type = 3;
                float limit = Float.parseFloat(limitField.getText());
                gui.databaseHandler.executeStatement("UPDATE AccountHolder SET discount_type = 3, discount_amount = " + percentage + ", check_limit = " + limit + " WHERE customer_no = " + customer_no);
            }
        } catch (NumberFormatException e){
            gui.throwErrorForm("Values must be a number.");
        }
        
        this.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    private void idNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNoTextFieldActionPerformed
        // TODO add your handling code here:
        editButton.setEnabled(true);
    }//GEN-LAST:event_idNoTextFieldActionPerformed

    private void percentageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_percentageFieldActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fixedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedRadioButtonActionPerformed
        // TODO add your handling code here:
        limitField.setEditable(false);
    }//GEN-LAST:event_fixedRadioButtonActionPerformed

    private void variableRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_variableRadioButtonActionPerformed
        // TODO add your handling code here:
        limitField.setEditable(false);
    }//GEN-LAST:event_variableRadioButtonActionPerformed

    private void flexibleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flexibleRadioButtonActionPerformed
        // TODO add your handling code here:
        limitField.setEditable(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton editButton;
    private javax.swing.JRadioButton fixedRadioButton;
    private javax.swing.JRadioButton flexibleRadioButton;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JTextField idNoTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField limitField;
    private javax.swing.JTextField percentageField;
    private javax.swing.JRadioButton variableRadioButton;
    // End of variables declaration//GEN-END:variables


}
