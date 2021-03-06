/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import tft_garits.Database.ValueObject;
import tft_garits.Documents.InvoicePrinter;
import tft_garits.Documents.Printer;

/**
 *
 * @author George Kemp
 */
public class VehiclesEditForm extends Form {
    
    ValueObject number;
    Object[][] data;
    /**
     * Creates new form CustomerForm
     */
    public VehiclesEditForm(int customer_no, GUI gui) {
        super(gui);
        initComponents();
        number = new ValueObject("int", customer_no);
        jLabel2.setText(gui.databaseHandler.executeStringQuery("SELECT customer_name FROM customer WHERE customer_no=?", number, "customer_name"));
        
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
        saveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Vehicles");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Number", "Vehicle Reg", "Mechanic ID", "Mechanic Name", "Job Status", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(256, 256, 256)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
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
        // TODO add your handling code here:
        DefaultTableModel dataModel = (DefaultTableModel) table.getModel();
        Vector vector = dataModel.getDataVector();
        for (int a = 0; a < vector.size(); a++){
            Vector row = (Vector) vector.elementAt(a);
            try {
                ValueObject reg_no = new ValueObject("String", (String) row.elementAt(0));
                ValueObject make = new ValueObject("String", (String) row.elementAt(1));
                ValueObject model = new ValueObject("String", (String) row.elementAt(2));
                ValueObject colour = new ValueObject("String", (String) row.elementAt(3));
                ValueObject eng_serial = new ValueObject("String", (String) row.elementAt(4));
                ValueObject chassis_no = new ValueObject("String", (String) row.elementAt(5));
                String last_mot = (String) row.elementAt(6);
                
                ArrayList<ValueObject> values = new ArrayList<>();
                try {
                    
                    LocalDate date = LocalDate.parse(last_mot, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    //System.out.println(last_mot);
                    
                    values.add(make);
                    values.add(model);
                    values.add(colour);
                    values.add(eng_serial);
                    values.add(chassis_no);
                    values.add(new ValueObject("date", last_mot));
                    values.add(reg_no);
                    String sql = "UPDATE vehicle SET make = ?, model = ?, colour = ?, eng_serial = ?, chassis_no = ?, last_mot = ? WHERE reg_no =?";
                    gui.databaseHandler.executeArrayInsert(sql, values);
                    
                } catch (DateTimeParseException e){
                    //System.out.println(last_mot + " fail :" + e);
                    values.add(make);
                    values.add(model);
                    values.add(colour);
                    values.add(eng_serial);
                    values.add(chassis_no);
                    values.add(reg_no);
                    String sql = "UPDATE vehicle SET make = ?, model = ?, colour = ?, eng_serial = ?, chassis_no = ? WHERE reg_no =?";
                    gui.databaseHandler.executeArrayInsert(sql, values);
                }
                
                
            } catch (ClassCastException e){
                gui.throwErrorForm("Values must be whole numbers.");
                System.out.println(e);
            }
        }
        updateTable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateTable(){
        //job_no int, vehicle_reg string, mech id int, mech name string, job status
        String[] columns = {"Vehicle Registration", "Make", "Model", "Colour", "Engine Serial #", "Chassis Number", "Last MOT Date"};
                
        //get data for each job
        data = gui.databaseHandler.getVehicleDetails(number);
        
        DefaultTableModel dataModel = new DefaultTableModel(data, columns){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex >= 1;
            }
        };
        table.setModel(dataModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
