package view;

import controller.CustomerController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import model.CustomerModel;

public class Dashboard extends javax.swing.JFrame {
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
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

        lbl_title = new javax.swing.JLabel();
        btn_add_credit = new javax.swing.JButton();
        btn_edit_credit = new javax.swing.JButton();
        btn_remove_credit = new javax.swing.JButton();
        btn_view_all_credit = new javax.swing.JButton();
        btn_view_credit = new javax.swing.JButton();
        scroll_pane = new javax.swing.JScrollPane();
        tbl_credits = new javax.swing.JTable();
        lbl_copyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("DASHBOARD | Credit Manager");

        btn_add_credit.setText("Add Credit Request");
        btn_add_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_creditActionPerformed(evt);
            }
        });

        btn_edit_credit.setText("Edit Credit");
        btn_edit_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_creditActionPerformed(evt);
            }
        });

        btn_remove_credit.setText("Remove Request");

        btn_view_all_credit.setText("View All Credit");
        btn_view_all_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_all_creditActionPerformed(evt);
            }
        });

        btn_view_credit.setText("View Credit");

        tbl_credits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "Credit ID", "Customer Name", "Credit Request At", "Credit Status"
            }
        ));
        scroll_pane.setViewportView(tbl_credits);

        lbl_copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_copyright.setText("Copyright 2024 @ Credit Manager | Developed by DAV Sixth Semester");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll_pane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add_credit)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_remove_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_view_all_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_view_credit, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_copyright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_credit)
                    .addComponent(btn_edit_credit)
                    .addComponent(btn_remove_credit)
                    .addComponent(btn_view_all_credit)
                    .addComponent(btn_view_credit))
                .addGap(30, 30, 30)
                .addComponent(scroll_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lbl_copyright)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_creditActionPerformed
        // TODO add your handling code here:
        CreditRequest cr = new CreditRequest();
        cr.setVisible(true);
    }//GEN-LAST:event_btn_add_creditActionPerformed

    private void btn_view_all_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_all_creditActionPerformed
        // TODO add your handling code here:
        CustomerController cc = new CustomerController();
        HashMap<Integer, CustomerModel> customers = cc.showAllCustomerCreditRequest();
        
        DefaultTableModel dtm = (DefaultTableModel) tbl_credits.getModel();
        dtm.setRowCount(0);
        int counter = 1;
        for(Map.Entry m:customers.entrySet()){
            CustomerModel cm = (CustomerModel) m.getValue();
            Object customer[] = {counter, cm.getCustomerId(), 
                cm.getFullName(), cm.getAppliedAt(), cm.getCreditStatus()};
            dtm.addRow(customer);
            counter++;
        }
        
    }//GEN-LAST:event_btn_view_all_creditActionPerformed

    private void btn_edit_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_creditActionPerformed
        // TODO add your handling code here:
        int row_id = tbl_credits.getSelectedRow();
        int customer_id = Integer.parseInt(tbl_credits.getValueAt(row_id, 1) + "");
                
        CustomerController cc = new CustomerController();
        cc.customer_id = customer_id;
        EditCredit ec = new EditCredit();
        ec.setCustomerCreditRequest(cc.getCustomerCreditRequest(cc));
        ec.setVisible(true);
    }//GEN-LAST:event_btn_edit_creditActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_credit;
    private javax.swing.JButton btn_edit_credit;
    private javax.swing.JButton btn_remove_credit;
    private javax.swing.JButton btn_view_all_credit;
    private javax.swing.JButton btn_view_credit;
    private javax.swing.JLabel lbl_copyright;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JScrollPane scroll_pane;
    private javax.swing.JTable tbl_credits;
    // End of variables declaration//GEN-END:variables
}
