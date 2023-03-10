/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.GUI;

import aptech.project2.model.Orders;
import aptech.project2.model.Product;
import aptech.project2.service.OrdersJpaController;
import aptech.project2.service.ProductJpaController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author Admin
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
        showBarChart();
        showPieChart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jDashBoard = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Profile = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbTransaction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelPieChart2 = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(35, 46, 66));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_settings.png"))); // NOI18N
        jLabel9.setText("Setting");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 500, 95, 47));

        jDashBoard.setBackground(new java.awt.Color(255, 255, 255));
        jDashBoard.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jDashBoard.setForeground(java.awt.Color.lightGray);
        jDashBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_home.png"))); // NOI18N
        jDashBoard.setText("DashBoard");
        jDashBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDashBoardMouseClicked(evt);
            }
        });
        jPanel2.add(jDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 109, 127, 46));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_product.png"))); // NOI18N
        jLabel11.setText("Product ");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 173, 113, 47));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/logout.png"))); // NOI18N
        jLabel17.setText("Log Out");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 133, 47));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.lightGray);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_orders.png"))); // NOI18N
        jLabel12.setText("Orders");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 307, 113, 47));

        Profile.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Profile.setForeground(java.awt.Color.lightGray);
        Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_user.png"))); // NOI18N
        Profile.setText("Profile");
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileMouseClicked(evt);
            }
        });
        jPanel2.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 435, 95, 47));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.lightGray);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptech/project2/image/ic_catalog.png"))); // NOI18N
        jLabel14.setText("Catagories");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 370, 113, 47));

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
        jPanel2.add(lbTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 242, 138, 47));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SHOWROOM CAR");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 169, 103));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 830));

        panelPieChart.setBackground(new java.awt.Color(255, 255, 255));
        panelPieChart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dash Board\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPieChart2.setBackground(new java.awt.Color(255, 255, 255));
        panelPieChart2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelPieChart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 500, 250));

        panelBarChart.setBackground(new java.awt.Color(255, 255, 255));
        panelBarChart.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        panelBarChart.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 830, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1170, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        ProductManagement productManagement = new ProductManagement();
        productManagement.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void lbTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTransactionMouseClicked
        TransactionMangerment transactionMangerment = new TransactionMangerment();
        transactionMangerment.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbTransactionMouseClicked

    private void jDashBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDashBoardMouseClicked
        // TODO add your handling code here:
        DashBoard dashBoard = new DashBoard();
        dashBoard.setVisible(true);
        dispose();
    }//GEN-LAST:event_jDashBoardMouseClicked

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        // TODO add your handling code here:
        UserManager userManager = new UserManager();
         userManager.setVisible(true);
        dispose();
    }//GEN-LAST:event_ProfileMouseClicked

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();

        List<Orders> order = OrdersJpaController.getInstance().findOrdersEntities();

//        barDataset.setValue("IPhone 5s", new Double(20));
//        barDataset.setValue("SamSung Grand", new Double(20));
//        barDataset.setValue("MotoG", new Double(40));
//        barDataset.setValue("Nokia Lumia", new Double(10));
        order.forEach(s -> {
            barDataset.setValue(s.getProductId().getName(), new Double(s.getQuantity()));
        });
        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Orders Chart", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
//        piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
//        piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));
        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart2.removeAll();
        panelPieChart2.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart2.validate();
    }

    /*========================================================================================*/
    public void showBarChart() {
        // product
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Product> products = ProductJpaController.getInstance().findProductEntities();

        products.forEach(s -> {
            dataset.setValue(s.getQuantity(), "Quantity", s.getName());
        });

        JFreeChart chart = ChartFactory.createBarChart("Product", "Product Name", "Quantity",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        panelBarChart.removeAll();
        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Profile;
    private javax.swing.JLabel jDashBoard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbTransaction;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelPieChart;
    private javax.swing.JPanel panelPieChart2;
    // End of variables declaration//GEN-END:variables
}
