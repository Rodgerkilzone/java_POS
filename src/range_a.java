/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RODGER
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.Date;
public class range_a extends javax.swing.JFrame {

    /**
     * Creates new form daily_a
     */
    public range_a() {
        initComponents();
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/pharmacy";
            String username_d = "root";
            String password_d = "";
        //Connection conn=null;
        ResultSet rs=null;
        Statement stmt=null;
        PreparedStatement pst=null;
        Class.forName(driver);
        Connection conn=DriverManager.getConnection(url,username_d,password_d);
/*DateFormat dtf2=new SimpleDateFormat("yyyy-MM");
            Date date2=new Date();
            sell_date.setDate(date2);
      
            JOptionPane.showMessageDialog(null,dtf2.format(sell_date.getDate()));
            
//Date date=new Date();
          sell_date.setDate(null);
          //  sell_date2.setDate(date);
      //  DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     DateFormat dtf2=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
           sell_date2.setDate(date);
            dtf2.format(sell_date2.getDate());*/
            //dtf2.format(sell_date2.getDate());
           // String date_s=String.valueOf(date);
          //  Date date1=dtf2.parse(date_s);
          //  Date date2=dtf2.parse(date_s);
          // sell_date2.setDate(dtf2.format(date));
          
         // sell_date.setDate(date);
          // String s=dtf2.format(sell_date2.getDate())+" 00:00:00";
           DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            sell_date2.setDate(date);
            sell_date.setDate(date);
            dtf.format(sell_date2.getDate());
          /*    // DateFormat dtf=new SimpleDateFormat("yyyy-MM");
            dtf.format(s)
          /*   
         //  Date date=new Date();
           String s2=dtf2.format(sell_date2.getDate())+" 23:59:59";
           // DateFormat dtf=new SimpleDateFormat("yyyy-MM");
            Date date2=dtf.parse(s2);
              // JOptionPane.showMessageDialog(null,s);    
          //  dtf.format(startDate);
           dtf.format(date1);*/
           
            //dtf.format(sell_date.getDate());
          // JOptionPane.showMessageDialog(null,dtf.format(sell_date2.getDate()));
               String sql="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_only='"+dtf.format(sell_date2.getDate())+"' group by  id,name order by name";
         
       pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        daily_t.setModel(DbUtils.resultSetToTableModel(rs));
               // TableColumnModel tcm=daily_t.getColumnModel();
                            TableColumnModel tcm2=daily_t.getColumnModel();
            tcm2.removeColumn(tcm2.getColumn(0));
        ResultSet rs2=null;
         PreparedStatement pst2=null;
        String sql4="select SUM(total_cost) from sells where date_sold like '%"+dtf.format(sell_date.getDate())+"%'";
        pst2=conn.prepareStatement(sql4);
        
        rs2=pst2.executeQuery();
        while (rs2.next()) 
{
    int std = rs2.getInt(1);
    total.setText(String.valueOf(std));
   // JOptionPane.showMessageDialog(null,"Enter date to filter");
}
                String sql5="select SUM(profit) from sells where date_sold like '%"+dtf.format(sell_date.getDate())+"%'";
        pst2=conn.prepareStatement(sql5);
        
        rs2=pst2.executeQuery();
        while (rs2.next()) 
{
     String std = rs2.getString(1);
   profits.setText(String.valueOf(std));
        if(profits.getText().equals("null")){
    profits.setText("0");
   //  profits.setText(String.valueOf(std));
     }
   // JOptionPane.showMessageDialog(null,"Enter date to filter");
}
        
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        daily_t = new javax.swing.JTable();
        sell_date = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        total_l1 = new javax.swing.JLabel();
        total_l2 = new javax.swing.JLabel();
        profits = new javax.swing.JLabel();
        sell_date2 = new com.toedter.calendar.JDateChooser();
        total_l3 = new javax.swing.JLabel();
        total_l4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        daily_t.setModel(new javax.swing.table.DefaultTableModel(
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
        daily_t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                daily_tMouseReleased(evt);
            }
        });
        daily_t.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                daily_tKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(daily_t);

        sell_date.setDateFormatString("yyyy-MM-dd");

        jButton6.setText("Filter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RANGE SALES ANALYSIS");

        total.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("0");

        total_l1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        total_l1.setForeground(new java.awt.Color(255, 255, 255));
        total_l1.setText("From");

        total_l2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l2.setForeground(new java.awt.Color(255, 255, 255));
        total_l2.setText("Total profit (Ksh) =");

        profits.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        profits.setForeground(new java.awt.Color(255, 255, 255));
        profits.setText("0");

        sell_date2.setDateFormatString("yyyy-MM-dd");

        total_l3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l3.setForeground(new java.awt.Color(255, 255, 255));
        total_l3.setText("Total sell (Ksh)    =");

        total_l4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        total_l4.setForeground(new java.awt.Color(255, 255, 255));
        total_l4.setText("To");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(total_l1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(sell_date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total_l4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sell_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jButton6)
                        .addGap(0, 290, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(total_l3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(total_l2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profits, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell_date2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_l1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_l4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_l3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profits, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_l2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(853, 594));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
try{
        ResultSet rs=null;
            Statement stmt=null;
            PreparedStatement pst=null;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/pharmacy";
            String username_d = "root";
            String password_d = "";
            Connection conn = DriverManager.getConnection(url, username_d, password_d);
           DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
           // sell_date2.setDate(date);
            //sell_date.setDate(date);
           // dtf.format(sell_date2.getDate());
            String sql_ps="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_only>='"+dtf.format(sell_date.getDate())+"' and date_only<='"+dtf.format(sell_date2.getDate())+"' group by  id,name order by name";
            pst=conn.prepareStatement(sql_ps);
            rs=pst.executeQuery();
            daily_t.setModel(DbUtils.resultSetToTableModel(rs));
            TableColumnModel tcm2=daily_t.getColumnModel();
            tcm2.removeColumn(tcm2.getColumn(0));

            ResultSet rs2=null;
            PreparedStatement pst2=null;
            String sql4="select SUM(total_cost) from sells where date_only>='"+dtf.format(sell_date.getDate())+"' and date_only<='"+dtf.format(sell_date2.getDate())+"' ";
            pst2=conn.prepareStatement(sql4);

            rs2=pst2.executeQuery();
            while (rs2.next())
            {
                int std = rs2.getInt(1);
                total.setText(String.valueOf(std));
                // JOptionPane.showMessageDialog(null,"Enter date to filter");
            }
            String sql5="select SUM(profit) from sells where date_only>='"+dtf.format(sell_date.getDate())+"' and date_only<='"+dtf.format(sell_date2.getDate())+"' ";
            pst2=conn.prepareStatement(sql5);

            rs2=pst2.executeQuery();
            while (rs2.next())
            {
                String std = rs2.getString(1);
                profits.setText(String.valueOf(std));
                     if(profits.getText().equals("null")){
    profits.setText("0");
   //  profits.setText(String.valueOf(std));
     }
                // JOptionPane.showMessageDialog(null,"Enter date to filter");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Enter date to filter");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void daily_tKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daily_tKeyReleased
        int index=daily_t.getSelectedRow();
        TableModel model=daily_t.getModel();

        String name_e = model.getValueAt(index, 1).toString();
        String detail_e = model.getValueAt(index, 2).toString();
        String price_e = model.getValueAt(index, 5).toString();
        String quantity_e = model.getValueAt(index, 3).toString();
        String supplier_e = model.getValueAt(index, 4).toString();
        //pack();
        /*
        name.setText(name_e);
        detail.setText(detail_e);
        price.setText(price_e);
        quantity.setText("1");
        //total.setText(supplier_e);

        String sum;
        sum=String.valueOf(Integer.parseInt(quantity.getText())*Integer.parseInt(price.getText()));
        total.setText(sum);
        if(!(paid.getText()).equals("")){
            int change;
            change=Integer.parseInt(paid.getText())-Integer.parseInt(total.getText());
            String change2=String.valueOf(change);
            balance.setText(change2);
        }else{
            balance.setText("0");
        }*/
        // TODO add your handling code here:
    }//GEN-LAST:event_daily_tKeyReleased

    private void daily_tMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daily_tMouseReleased

        /* int index=jTable1.getSelectedRow();
        TableModel model=jTable1. getModel();
        // this.setExtendedState(this.getExtendedState()| this.MAXIMIZED_BOTH);
        String name_e = model.getValueAt(index, 1).toString();
        String detail_e = model.getValueAt(index, 2).toString();
        String price_e = model.getValueAt(index, 5).toString();
        String quantity_e = model.getValueAt(index, 3).toString();
        String supplier_e = model.getValueAt(index, 4).toString();

        name.setText(name_e);
        detail.setText(detail_e);
        price.setText(price_e);
        quantity.setText("1");
        //total.setText(supplier_e);
        String sum;
        sum=String.valueOf(Integer.parseInt(quantity.getText())*Integer.parseInt(price.getText()));
        total.setText(sum);
        // TODO add your handling code here:
        if(!(paid.getText()).equals("")){
            int change;
            change=Integer.parseInt(paid.getText())-Integer.parseInt(total.getText());
            String change2=String.valueOf(change);
            balance.setText(change2);
        }else{
            balance.setText("0");
        }*/
    }//GEN-LAST:event_daily_tMouseReleased

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
            java.util.logging.Logger.getLogger(range_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(range_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(range_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(range_a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new range_a().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable daily_t;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel profits;
    private com.toedter.calendar.JDateChooser sell_date;
    private com.toedter.calendar.JDateChooser sell_date2;
    private javax.swing.JLabel total;
    private javax.swing.JLabel total_l1;
    private javax.swing.JLabel total_l2;
    private javax.swing.JLabel total_l3;
    private javax.swing.JLabel total_l4;
    // End of variables declaration//GEN-END:variables
}
