/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.GUI;

import java.util.ArrayList;
import java.util.List;
import tft_garits.Database.ValueObject;
import tft_garits.Documents.HelloPrinter;
import tft_garits.Documents.StockOrderPrinter;
import tft_garits.Stock.Stock;

/**
 *
 * @author George Kemp
 */
public class StockForm extends Form {
    
    String[] part_descs;
    Integer[] part_nos;
    
    ArrayList<Stock> stockEntries;
    /**
     * Creates new form CustomerForm
     */
    public StockForm(GUI gui) {
        super(gui);
        initComponents();
        
        updatePartsList();
        stockEntries = new ArrayList<>();
    }

    public StockForm(ArrayList<Stock> lowStock, GUI gui) {
        super(gui);
        initComponents();
        
        updatePartsList();
        stockEntries = lowStock;
        updateOrderList();
        
        jButton1.setText("Close");
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
        addButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        partsList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Stock Order");

        jLabel2.setText("Parts:");

        addButton.setText(">");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        orderButton.setText("Order Parts");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        removeButton.setText("<");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(partsList);

        jScrollPane1.setViewportView(orderList);

        jLabel3.setText("Parts to order:");

        totalField.setEditable(false);

        jLabel4.setText("Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton)
                            .addComponent(removeButton)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeButton))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderButton)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        //closes window if started through notification
        if (!jButton1.getText().equals("Close")){
            gui.run("STOCK");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // REMOVE
        int[] selections = orderList.getSelectedIndices();
        
        for (int i = 0; i < selections.length; i++){
            int index = selections[i];
            stockEntries.get(index).sub();
        }
        
        ArrayList<Stock> remove = new ArrayList<>();
        stockEntries.stream().filter((s) -> (s.getAmount() <= 0)).forEachOrdered((s) -> {
            remove.add(s);
        });
        
        orderList.setSelectedIndices(selections);
        stockEntries.removeAll(remove);
        updateOrderList();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // ADD
        List<String> selections = partsList.getSelectedValuesList();
        if (!selections.isEmpty()){
            selections.forEach((description) -> {
                int index = 0;
                for (int i = 0; i < part_descs.length; i++){
                    if (description.equals(part_descs[i])){
                        index = i;
                        break;
                    }
                }
                int part_no = part_nos[index];
                boolean found = false;
                for (Stock s : stockEntries){
                    if (s.getNo() == part_no){
                        s.add();
                        found = true;
                        break;
                    }
                }
                if (!found){
                    String name = description;
                    String desc = gui.databaseHandler.executeStringQuery("SELECT description FROM part WHERE part_no=?", new ValueObject("int", part_no), "description");
                    float price = gui.databaseHandler.executeFloatQuery("SELECT price FROM part WHERE part_no=?", new ValueObject("int", part_no), "price");
                    stockEntries.add(new Stock(part_no, name, desc, price));
                }
            });
        }           
        updateOrderList();
    }//GEN-LAST:event_addButtonActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        // ORDER
        StockOrderPrinter printer = new StockOrderPrinter(stockEntries);
        printer.print();
        
        gui.throwErrorForm("PDF generated.");
    }//GEN-LAST:event_orderButtonActionPerformed

    private void updatePartsList() {
        part_nos = gui.databaseHandler.getIntArray("SELECT part_no FROM part ORDER BY part_no", "part_no");
        part_descs = gui.databaseHandler.getStringArray("SELECT part_name FROM part ORDER BY part_no", "part_name");

        partsList.setListData(part_descs);
    }
    
    private void updateOrderList(){
        String[] orders = new String[stockEntries.size()];
        float total = 0;
        
        for (int i = 0; i < stockEntries.size(); i++){
            orders[i] = stockEntries.get(i).toString();
            total = total + stockEntries.get(i).getTotal();
        }
        
        orderList.setListData(orders);
        totalField.setText(total + "");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orderButton;
    private javax.swing.JList<String> orderList;
    private javax.swing.JList<String> partsList;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
