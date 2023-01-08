/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.GUI;

import aptech.project2.common.DateCommon;
import aptech.project2.constant.Constant;
import aptech.project2.dao.Transaction;
import aptech.project2.dao.User;
import aptech.project2.service.UserService;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class TransactionGroupByUserId extends javax.swing.JFrame {

    private int userId = -1;
    private Long transactionId = null;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    /**
     * Creates new form TransactionGroupByUserId
     */
    public TransactionGroupByUserId() {
        initComponents();
        if (userId != -1) {
            this.loadData();
        }
    }

    public void loadData() {
        DefaultTableModel tableModel = (DefaultTableModel) tblTransactionDetail.getModel();
        tableModel.setRowCount(0);
        System.out.println("getUserId : " + this.getUserId());
        User u = UserService.getInstace().find(this.getUserId());
        for (Transaction t : u.getTransactionCollection()) {
            String status = selectStatus(t.getStatus());
            String createDate = DateCommon.convertDateToString(t.getCreatedAt(), Constant.DATE_FORMAT);
            String updateDate = new DateCommon().convertDateToString(t.getUpdateAt(), Constant.DATE_FORMAT);

            Object[] rowData = new Object[]{
                t.getId(), t.getUserId().getName(), status, t.getAmount(), t.getPayment(), t.getPaymentInfo(), t.getMessage(), createDate,updateDate
            };
            tableModel.addRow(rowData);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleUser = new javax.swing.JTextField();
        titleUser1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransactionDetail = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        it_product = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        it_orders = new javax.swing.JLabel();
        it_profile = new javax.swing.JLabel();
        it_catalog = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        lbTransaction = new javax.swing.JLabel();

        titleUser.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        titleUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        titleUser.setText("Transaction Managerment");
        titleUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleUserActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleUser1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        titleUser1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleUser1.setText("Transaction Detail");
        titleUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleUser1ActionPerformed(evt);
            }
        });

        tblTransactionDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Status", "Amount", "Payment", "PaymentInfo", "Message", "Create At"
            }
        ));
        tblTransactionDetail.setColumnSelectionAllowed(true);
        tblTransactionDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransactionDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransactionDetail);
        tblTransactionDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/btn_loading.png"))); // NOI18N
        btnLoad.setText("Loading Data");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(35, 46, 66));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_settings.png"))); // NOI18N
        jLabel9.setText("Setting");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.lightGray);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_home.png"))); // NOI18N
        jLabel10.setText("DashBoard");

        it_product.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        it_product.setForeground(java.awt.Color.lightGray);
        it_product.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        it_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_product.png"))); // NOI18N
        it_product.setText("Product ");
        it_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                it_productMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/logout.png"))); // NOI18N
        jLabel17.setText("Log Out");

        it_orders.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        it_orders.setForeground(java.awt.Color.lightGray);
        it_orders.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        it_orders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_orders.png"))); // NOI18N
        it_orders.setText("Orders");
        it_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                it_ordersMouseClicked(evt);
            }
        });

        it_profile.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        it_profile.setForeground(java.awt.Color.lightGray);
        it_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_user.png"))); // NOI18N
        it_profile.setText("Profile");
        it_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                it_profileMouseClicked(evt);
            }
        });

        it_catalog.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        it_catalog.setForeground(java.awt.Color.lightGray);
        it_catalog.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        it_catalog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_catalog.png"))); // NOI18N
        it_catalog.setText("Catagories");
        it_catalog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                it_catalogMouseClicked(evt);
            }
        });

        jTextField6.setBackground(new java.awt.Color(84, 104, 255));
        jTextField6.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jTextField6.setText("Shopping Car");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        lbTransaction.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTransaction.setForeground(java.awt.Color.lightGray);
        lbTransaction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_transaction.png"))); // NOI18N
        lbTransaction.setText("Transaction");
        lbTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTransactionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(it_product, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(it_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(it_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(it_catalog, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(it_product, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lbTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(it_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(it_catalog, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(it_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(titleUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(titleUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad)
                .addContainerGap(439, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void titleUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleUserActionPerformed

    private void titleUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleUser1ActionPerformed

    private void tblTransactionDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransactionDetailMouseClicked
        // TODO add your handling code here:
        transactionId = Long.parseLong(tblTransactionDetail.getModel().getValueAt(tblTransactionDetail.getSelectedRow(), 0).toString());
        System.out.println("-----------------------userId: " + transactionId);

    }//GEN-LAST:event_tblTransactionDetailMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        this.loadData();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void it_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_it_productMouseClicked
        // TODO add your handling code here:
        ProductManagement pm = new ProductManagement();
        pm.setVisible(true);
        dispose();
    }//GEN-LAST:event_it_productMouseClicked

    private void it_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_it_ordersMouseClicked
        // TODO add your handling code here:
        OrderMangerment om = new OrderMangerment();
        om.setVisible(true);
        dispose();
    }//GEN-LAST:event_it_ordersMouseClicked

    private void it_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_it_profileMouseClicked
        // TODO add your handling code here:
        UserManager um = new UserManager();
        um.setVisible(true);
        dispose();
    }//GEN-LAST:event_it_profileMouseClicked

    private void it_catalogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_it_catalogMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_it_catalogMouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void lbTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTransactionMouseClicked
        // TODO add your handling code here:
        TransactionMangerment mf = new TransactionMangerment();
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbTransactionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionGroupByUserId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionGroupByUserId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionGroupByUserId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionGroupByUserId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TransactionGroupByUserId().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JLabel it_catalog;
    private javax.swing.JLabel it_orders;
    private javax.swing.JLabel it_product;
    private javax.swing.JLabel it_profile;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbTransaction;
    private javax.swing.JTable tblTransactionDetail;
    private javax.swing.JTextField titleUser;
    private javax.swing.JTextField titleUser1;
    // End of variables declaration//GEN-END:variables

    private String selectStatus(int statusId) {
        String status = "";
        if (statusId == 0) {
            status = TransactionMangerment.CHUA_THANH_TOAN;
        } else {
            status = TransactionMangerment.DA_THANH_TOAN;
        }
        return status;
    }
}
