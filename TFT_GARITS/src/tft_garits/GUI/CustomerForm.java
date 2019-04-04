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
public class CustomerForm extends Form {
    
    private int currentID;
    /**
     * Creates new form CustomerForm
     */
    public CustomerForm(GUI gui) {
        super(gui);
        initComponents();
        
        editButton.setEnabled(false);
        removeButton.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idNoTextField = new javax.swing.JTextField();
        fullNameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        postcodeTextField = new javax.swing.JTextField();
        contactNoTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vehiclesList = new javax.swing.JList<>();
        vehicleButton = new javax.swing.JButton();
        accountHolderButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer");

        jLabel2.setText("ID no:");

        jLabel3.setText("Full Name:");

        jLabel4.setText("Address:");

        jLabel5.setText("Post code:");

        jLabel6.setText("Contact no:");

        jLabel7.setText("Email:");

        idNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNoTextFieldActionPerformed(evt);
            }
        });

        postcodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postcodeTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Vehicles:");

        addButton.setText("Add New");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Save");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Fields");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        vehiclesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(vehiclesList);

        vehicleButton.setText("Edit Vehicles");
        vehicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleButtonActionPerformed(evt);
            }
        });

        accountHolderButton.setText("Manage Account");
        accountHolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountHolderButtonActionPerformed(evt);
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
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accountHolderButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeButton)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(218, 218, 218))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(postcodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                            .addComponent(addressTextField)
                                            .addComponent(fullNameTextField)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(53, 53, 53)
                                            .addComponent(emailTextField))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(contactNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(idNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vehicleButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(clearButton))
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(postcodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(contactNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vehicleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(removeButton)
                    .addComponent(accountHolderButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void postcodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postcodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postcodeTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        int customer_ID = gui.databaseHandler.getNextVal("customer", "customer_no");
        
        currentID = customer_ID;
        idNoTextField.setText("" + currentID);
        
        //disable search, add
        idNoTextField.setEditable(false);
        addButton.setEnabled(false);
        //enable remove & edit
        removeButton.setEnabled(true);
        editButton.setEnabled(true);
        editButton.setText("Save");
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (someFieldsEmpty()){
            gui.throwErrorForm("Not all fields complete.");
        } else {
            gui.databaseHandler.executeStatement("DELETE FROM customer WHERE customer_no='" + currentID + "'");
            String sql = "INSERT INTO customer "
                    + "(customer_no, customer_name, address, tel, post_code, email, fax)"
                    + "values (?, ?, ?, ?, ?, ?, ?);";
            
            ArrayList<ValueObject> values = new ArrayList<>();
            values.add(new ValueObject("int", currentID)); //add customer_no
            values.add(new ValueObject("String", fullNameTextField.getText())); //add customer_name
            values.add(new ValueObject("String", addressTextField.getText())); //add address
            values.add(new ValueObject("int", contactNoTextField.getText())); //add tel
            values.add(new ValueObject("String", postcodeTextField.getText())); //add post_code
            values.add(new ValueObject("String", emailTextField.getText())); //add email
            values.add(new ValueObject("int", "-1")); //add fax
            
            gui.databaseHandler.executeArrayInsert(sql, values);
            
            editButton.setText("Changes saved");
            
            clearFields();
            gui.throwErrorForm("Added/Updated customer.");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        int customer_ID = -1;
        try {
            customer_ID = Integer.parseInt(idNoTextField.getText());
            
            if (customer_ID != -1){
                if (gui.databaseHandler.checkQuery("SELECT customer_no FROM customer WHERE customer_no=?", new ValueObject("int", customer_ID), "customer_no")) {
                    String full_name = gui.databaseHandler.executeStringQuery("SELECT customer_name FROM customer WHERE customer_no=?", 
                                                                                new ValueObject("int", customer_ID), "customer_name");
                    String address = gui.databaseHandler.executeStringQuery("SELECT address FROM customer WHERE customer_no=?", 
                                                                                new ValueObject("int", customer_ID), "address");
                    String contact_no = "" + gui.databaseHandler.executeIntQuery("SELECT tel FROM customer WHERE customer_no=?", 
                                                                                new ValueObject("int", customer_ID), "tel");
                    String post_code = gui.databaseHandler.executeStringQuery("SELECT post_code FROM customer WHERE customer_no=?", 
                                                                                new ValueObject("int", customer_ID), "post_code");
                    String email = gui.databaseHandler.executeStringQuery("SELECT email FROM customer WHERE customer_no=?", 
                                                                                new ValueObject("int", customer_ID), "email");

                    fullNameTextField.setText(full_name);
                    addressTextField.setText(address);
                    contactNoTextField.setText(contact_no);
                    postcodeTextField.setText(post_code);
                    emailTextField.setText(email);
                    
                    updateVehicles(customer_ID);
                    
                    //disable search, add
                    idNoTextField.setEditable(false);
                    addButton.setEnabled(false);
                    //enable remove & edit
                    removeButton.setEnabled(true);
                    editButton.setEnabled(true);
                    editButton.setText("Save");
                } else {
                    gui.throwErrorForm("ID not found in database.");
                }
            }
        } catch (NumberFormatException e){
            gui.throwErrorForm("ID must be a number.");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void idNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNoTextFieldActionPerformed
        // TODO add your handling code here:
        editButton.setEnabled(true);
    }//GEN-LAST:event_idNoTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
        
        //enable search, add
        idNoTextField.setEditable(true);
        addButton.setEnabled(true);
        searchButton.setEnabled(true);
        //disable remove & edit
        removeButton.setEnabled(false);
        editButton.setEnabled(false);
        editButton.setText("Save");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        int customerID = Integer.parseInt(idNoTextField.getText());
        if (gui.databaseHandler.checkCustomerPaid(customerID)){
            clearFields();
            gui.databaseHandler.executeStatement("DELETE FROM customer CASCADE WHERE customer_no='" + customerID + "'");

            gui.throwErrorForm("Removed customer " + customerID);

            //enable search, add
            idNoTextField.setEditable(true);
            addButton.setEnabled(true);
            searchButton.setEnabled(true);
            //disable remove & edit
            removeButton.setEnabled(false);
            editButton.setEnabled(false);
            editButton.setText("Save");
        } else {
            gui.throwErrorForm("Customer has unpaid jobs.");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void vehicleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleButtonActionPerformed
        try {
            currentID = Integer.parseInt(idNoTextField.getText());
            if (vehiclesList.getModel().getSize() > 0){
                gui.showForm(new VehiclesEditForm(currentID, gui));
            } else {
                gui.throwErrorForm("Customer has no vehicles to edit.");
            }
        } catch (NumberFormatException e) {
            gui.throwErrorForm("ID must be a Number.");
        }
    }//GEN-LAST:event_vehicleButtonActionPerformed

    private void accountHolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountHolderButtonActionPerformed
        // TODO add your handling code here:
        try {
            currentID = Integer.parseInt(idNoTextField.getText());
            gui.showForm(new AccountHolderForm(currentID, gui));
        } catch (NumberFormatException e) {
            gui.throwErrorForm("ID must be a Number.");
        }
    }//GEN-LAST:event_accountHolderButtonActionPerformed

    private void clearFields(){
        idNoTextField.setText("");
        fullNameTextField.setText("");
        addressTextField.setText("");
        postcodeTextField.setText("");
        contactNoTextField.setText("");
        emailTextField.setText("");
        vehiclesList.setListData(new String[0]);
        
        /*
        vehiclesTextField
        fixedCheck
        flexibleCheck
        variableCheck
        payLaterCheck
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountHolderButton;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField contactNoTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTextField;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField postcodeTextField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton vehicleButton;
    private javax.swing.JList<String> vehiclesList;
    // End of variables declaration//GEN-END:variables

    private boolean someFieldsEmpty() {
        if (addressTextField.getText().isEmpty()) return true;
        if (contactNoTextField.getText().isEmpty()) return true;
        if (emailTextField.getText().isEmpty()) return true;
        if (fullNameTextField.getText().isEmpty()) return true;
        if (idNoTextField.getText().isEmpty()) return true;
        if (postcodeTextField.getText().isEmpty()) return true;
        return false;
    }

    private void updateVehicles(int customer_ID) {
        String[] vehicles = gui.databaseHandler.getVehicleDetails(customer_ID);
        vehiclesList.setListData(vehicles);
    }
}
