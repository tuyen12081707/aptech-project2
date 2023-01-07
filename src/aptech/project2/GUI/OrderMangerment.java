/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.GUI;

import aptech.project2.common.ValidateCommon;
import aptech.project2.dao.Orders;
import aptech.project2.dao.Product;
import aptech.project2.dao.Transaction;
import aptech.project2.dao.User;
import aptech.project2.service.OrdersJpaController;
import aptech.project2.service.ProductJpaController;
import aptech.project2.service.ProductServices;
import aptech.project2.service.TransactionJpaController;
import aptech.project2.service.UserJpaController;
import aptech.project2.service.exceptions.NonexistentEntityException;
import aptech.project2.utilities.JPAUtil;
import com.mysql.jdbc.RowData;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class OrderMangerment extends javax.swing.JFrame {

    /**
     * Creates new form UserManager
     */
    private Orders order = null;

    public OrderMangerment() {
        initComponents();
        showComboProduct();
        loadData();
        this.txttransaction.setEnabled(false);
        this.txtprice.setEnabled(false);
        this.txtthanhtien.setEnabled(false);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        lbTransaction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxproduct = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        Transaction = new javax.swing.JLabel();
        txttransaction = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblorder = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtghichu = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        lbmessage = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

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

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_product.png"))); // NOI18N
        jLabel11.setText("Product ");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/logout.png"))); // NOI18N
        jLabel17.setText("Log Out");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.lightGray);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_orders.png"))); // NOI18N
        jLabel12.setText("Orders");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.lightGray);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_user.png"))); // NOI18N
        jLabel13.setText("Profile");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.lightGray);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_catalog.png"))); // NOI18N
        jLabel14.setText("Catagories");

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
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lbTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OrderMangerment");

        jLabel2.setText("Product");

        cbxproduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxproductActionPerformed(evt);
            }
        });

        jLabel3.setText("Price");

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        jLabel4.setText("Số lượng");

        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });
        txtsoluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsoluongKeyReleased(evt);
            }
        });

        jLabel5.setText("Thành tiền");

        txtthanhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthanhtienActionPerformed(evt);
            }
        });

        Transaction.setText("Transaction");

        txttransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttransactionActionPerformed(evt);
            }
        });

        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        tblorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Transaction_ID", "Sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        tblorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblorderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblorder);

        jLabel6.setText("Ghi chú");

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        lbmessage.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbmessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbxproduct, 0, 182, Short.MAX_VALUE)
                                        .addComponent(txttransaction))
                                    .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(487, 487, 487)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(350, 350, 350))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbmessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void lbTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTransactionMouseClicked
        // TODO add your handling code here:
        OrderMangerment mf = new OrderMangerment();
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbTransactionMouseClicked

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtsoluongActionPerformed

    private void txtthanhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthanhtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtthanhtienActionPerformed

    private void cbxproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxproductActionPerformed
        // TODO add your handling code here:
        String item = (String) cbxproduct.getSelectedItem();

        Product pro = ProductServices.getInstance().findProductByName(item);

        BigDecimal getPriceOut = pro.getPrice();

        txtprice.setText(pro.getPrice().toString());

        long getSoLuongOut = 1;
        String getSoLuongIn = String.valueOf(getSoLuongOut);
        txtsoluong.setText(getSoLuongIn);

        long getThanhTienOut = getSoLuongOut * getPriceOut.longValue();
        String getThanhTienIn = String.valueOf(getThanhTienOut);
        txtthanhtien.setText(getThanhTienIn);

        System.out.println("Ban chon: " + item);
        System.out.println("product: " + pro);


    }//GEN-LAST:event_cbxproductActionPerformed

    private void txttransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttransactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttransactionActionPerformed

    private void tblorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblorderMouseClicked

        int orderId = Integer.parseInt(tblorder.getModel().getValueAt(tblorder.getSelectedRow(), 0).toString());
        System.out.println("-----------------------userId: " + orderId);
        this.displayDetail(orderId);

    }//GEN-LAST:event_tblorderMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        Orders order = new Orders();
        String newTransactionId = txttransaction.getText();
        Transaction transac = TransactionJpaController.getInstance().findTransaction(Long.valueOf(newTransactionId));

        String newProductName = (String) cbxproduct.getSelectedItem();
        Product pro = ProductServices.getInstance().findProductByName(newProductName);
        String newProductID = String.valueOf(pro.getId());

        String newQuantity = txtsoluong.getText();
        Long newAmount = Long.valueOf(txtthanhtien.getText());
        String newData = txtghichu.getText();

        order.setTransactionId(transac);
        order.setProductId(pro);
        order.setQuantity(Integer.parseInt(newQuantity));
        order.setAmount(BigDecimal.valueOf(newAmount));
        order.setData(newData);
        try {
            OrdersJpaController.getInstance().edit(order);
            loadData();
            lbmessage.setText("Cập nhập thành công " + newProductName + " vào giỏ hàng!");
        } catch (Exception ex) {
            Logger.getLogger(OrderMangerment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int orderId = Integer.parseInt(tblorder.getModel().getValueAt(tblorder.getSelectedRow(), 0).toString());

        String check = "Bạn có chắc chắn muốn xóa order với id " + orderId + " không ?";
        int choose = JOptionPane.showConfirmDialog(null, check,
                "Xác Nhận Xoá", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        if (choose == 0) {
            try {
                OrdersJpaController.getInstance().destroy(orderId);
                lbmessage.setText("Xóa thành công order có id " + orderId + " !");
                this.loadData();
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        Orders order = new Orders();
        String newTransactionId = txttransaction.getText();
        Transaction transac = TransactionJpaController.getInstance().findTransaction(Long.valueOf(newTransactionId));

        String newProductName = (String) cbxproduct.getSelectedItem();
        Product pro = ProductServices.getInstance().findProductByName(newProductName);
        String newProductID = String.valueOf(pro.getId());

        String newQuantity = txtsoluong.getText();
        Long newAmount = Long.valueOf(txtthanhtien.getText());
        String newData = txtghichu.getText();

        order.setTransactionId(transac);
        order.setProductId(pro);
        order.setQuantity(Integer.parseInt(newQuantity));
        order.setAmount(BigDecimal.valueOf(newAmount));
        order.setData(newData);
        OrdersJpaController.getInstance().create(order);
        loadData();
        lbmessage.setText("Thêm thành công " + newProductName + " vào giỏ hàng!");

    }//GEN-LAST:event_btnaddActionPerformed

    private void txtsoluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsoluongKeyReleased
        int ThanhTien = 0;
        txtthanhtien.setText("0");
//        DecimalFormat df = new DecimalFormat("0000");
//        long a = txtprice.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();

        BigDecimal layPrice = new BigDecimal(txtprice.getText());

        if (txtsoluong.getText() == 0 + "" || txtsoluong.getText().equals("")) {
            ThanhTien = 0;
            txtthanhtien.setText(ThanhTien + "");
            System.out.println("alo price: " + txtprice.getText());

        } else {
            if (txtsoluong.getText().chars().allMatch(Character::isDigit)) {
                System.out.println("price: " + txtprice.getText());
                long getSoLuongOut = Long.parseLong(txtsoluong.getText());
                long getThanhTienOut = getSoLuongOut * layPrice.longValue();
                txtthanhtien.setText(getThanhTienOut + ".0000");
            }
        }

//        Long getSoLuongOut = Long.parseLong(txtsoluong.getText());
//        Long getPriceOut = Long.parseLong(txtprice.getText());
//        long getThanhTienOut = getSoLuongOut * getPriceOut;
//        String getThanhTienIn = String.valueOf(getThanhTienOut);
//        System.out.println("alo: " + getThanhTienIn);
//                
//        txtthanhtien.setText(getThanhTienIn);

    }//GEN-LAST:event_txtsoluongKeyReleased

    private void showComboProduct() {
        List<Product> list = ProductJpaController.getInstance().findProductEntities();

        List<String> listProductname = new ArrayList<>();
        list.stream().map(Product::getName).forEach(t -> {
            listProductname.add(t);
        });
        System.out.println(listProductname.toString());
        listProductname.stream().forEach(p -> {
            cbxproduct.addItem(p);

        });

    }

    private void loadData() {
        List<Orders> order = OrdersJpaController.getInstance().findOrdersEntities();

        DefaultTableModel tableModel = (DefaultTableModel) tblorder.getModel();

        tableModel.setRowCount(0);
        order.stream().forEach(o -> {
            long thanhTien = o.getProductId().getPrice().longValue() * o.getQuantity();

            Object[] rowData = new Object[]{
                o.getId(), o.getTransactionId().getId(), o.getProductId().getName(), o.getProductId().getPrice(), o.getQuantity(), thanhTien

            };
            tableModel.addRow(rowData);
        });
    }

    private void displayDetail(int orderId) {
        this.order = OrdersJpaController.getInstance().findOrders(orderId);
        txttransaction.setText(String.valueOf(order.getTransactionId().getId()));
        Product p = order.getProductId();
//        cbxproduct.set

        long price = p.getPrice().longValue();
        int quantity = order.getQuantity();
        long thanhTien = price * quantity;
        String layThanhTien = String.valueOf(thanhTien);

        txtprice.setText(p.getPrice().toString());
        txtsoluong.setText(String.valueOf(order.getQuantity()));
        txtthanhtien.setText(layThanhTien+".0000");
        txtghichu.setText(order.getData());

        cbxproduct.setSelectedItem(p.getName());

    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderMangerment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderMangerment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderMangerment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderMangerment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderMangerment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Transaction;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbxproduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbTransaction;
    private javax.swing.JLabel lbmessage;
    private javax.swing.JTable tblorder;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtthanhtien;
    private javax.swing.JTextField txttransaction;
    // End of variables declaration//GEN-END:variables

}