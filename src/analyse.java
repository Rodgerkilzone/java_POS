/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RODGER
 */
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.table.*;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
public class analyse extends javax.swing.JFrame {

    /**
     * Creates new form analyse
     */
    public analyse() {
        initComponents();
              try{
          javaconnect connect=new javaconnect();
          Connection conn=javaconnect.getConnection();
        //Connection conn=null;
        ResultSet rs=null;
        Statement stmt=null;
        PreparedStatement pst=null;

/*DateFormat dtf2=new SimpleDateFormat("yyyy-MM");
            Date date2=new Date();
            sell_date.setDate(date2);
      
            JOptionPane.showMessageDialog(null,dtf2.format(sell_date.getDate()));
            */
        DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            sell_date.setDate(date);
            dtf.format(sell_date.getDate());
               String sql="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_sold like '%"+dtf.format(sell_date.getDate())+"%' group by  id,name order by name";
         
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
              
              try{
          javaconnect connect=new javaconnect();
          Connection conn=javaconnect.getConnection();
        //Connection conn=null;
        ResultSet rs=null;
        Statement stmt=null;
        PreparedStatement pst=null;
        
        
/*DateFormat dtf2=new SimpleDateFormat("yyyy-MM");
            Date date2=new Date();
            sell_date.setDate(date2);
      
            JOptionPane.showMessageDialog(null,dtf2.format(sell_date.getDate()));
            */
      String s=year.getYear()+"-"+(month.getMonth()+1);
            DateFormat dtf=new SimpleDateFormat("yyyy-MM");
            Date startDate=dtf.parse(s);
         //  Date date=new Date();

              // JOptionPane.showMessageDialog(null,s);    
            dtf.format(startDate);
            
              String sql="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_sold like '%"+dtf.format(startDate)+"%' group by  id,name order by name";
         
       pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        daily_t1.setModel(DbUtils.resultSetToTableModel(rs));
               // TableColumnModel tcm=daily_t.getColumnModel();
                            TableColumnModel tcm2=daily_t1.getColumnModel();
            tcm2.removeColumn(tcm2.getColumn(0));
        ResultSet rs2=null;
         PreparedStatement pst2=null;
        String sql4="select SUM(total_cost) from sells where date_sold like '%"+dtf.format(startDate)+"%'";
        pst2=conn.prepareStatement(sql4);
        
        rs2=pst2.executeQuery();
        while (rs2.next()) 
{
    int std = rs2.getInt(1);
    total_m.setText(String.valueOf(std));
   // JOptionPane.showMessageDialog(null,"Enter date to filter");
}
                String sql5="select SUM(profit) from sells where date_sold like '%"+dtf.format(startDate)+"%'";
        pst2=conn.prepareStatement(sql5);
        
        rs2=pst2.executeQuery();
        while (rs2.next()) 
{
     String std = rs2.getString(1);
   profits_m.setText(String.valueOf(std));
        if(profits_m.getText().equals("null")){
    profits_m.setText("0");
   //  profits.setText(String.valueOf(std));
     }
   // JOptionPane.showMessageDialog(null,"Enter date to filter");
}
        
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
                }
              try{
           javaconnect connect=new javaconnect();
          Connection conn=javaconnect.getConnection();
        //Connection conn=null;
        ResultSet rs=null;
        Statement stmt=null;
        PreparedStatement pst=null;
       
/*DateFormat dtf2=new SimpleDateFormat("yyyy-MM");
            Date date2=new Date();
            sell_date.setDate(date2);
      
            JOptionPane.showMessageDialog(null,dtf2.format(sell_date.getDate()));
            */
        DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            sell_date2.setDate(date);
             sell_date1.setDate(date);
            dtf.format(sell_date2.getDate());
               String sql="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_sold like '%"+dtf.format(sell_date2.getDate())+"%' group by  id,name order by name";
         
       pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        daily_t2.setModel(DbUtils.resultSetToTableModel(rs));
               // TableColumnModel tcm=daily_t.getColumnModel();
                            TableColumnModel tcm2=daily_t2.getColumnModel();
            tcm2.removeColumn(tcm2.getColumn(0));
        ResultSet rs2=null;
         PreparedStatement pst2=null;
        String sql4="select SUM(total_cost) from sells where date_sold like '%"+dtf.format(sell_date1.getDate())+"%'";
        pst2=conn.prepareStatement(sql4);
        
        rs2=pst2.executeQuery();
        while (rs2.next()) 
{
    int std = rs2.getInt(1);
    total_r.setText(String.valueOf(std));
   // JOptionPane.showMessageDialog(null,"Enter date to filter");
}
                String sql5="select SUM(profit) from sells where date_sold like '%"+dtf.format(sell_date1.getDate())+"%'";
        pst2=conn.prepareStatement(sql5);
        
        rs2=pst2.executeQuery();
        while (rs2.next()) 
{
     String std = rs2.getString(1);
     profits_r.setText(String.valueOf(std));
     
     if(profits_r.getText().equals("null")){
    profits_r.setText("0");
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
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        daily_t = new javax.swing.JTable();
        total = new javax.swing.JLabel();
        profits = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        sell_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        total_l9 = new javax.swing.JLabel();
        total_l10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        daily_t1 = new javax.swing.JTable();
        filter_m = new javax.swing.JButton();
        month = new com.toedter.calendar.JMonthChooser();
        year = new com.toedter.calendar.JYearChooser();
        total_l3 = new javax.swing.JLabel();
        total_l4 = new javax.swing.JLabel();
        profits_m = new javax.swing.JLabel();
        total_m = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        sell_date1 = new com.toedter.calendar.JDateChooser();
        sell_date2 = new com.toedter.calendar.JDateChooser();
        total_l5 = new javax.swing.JLabel();
        total_l6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        daily_t2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        profits_r = new javax.swing.JLabel();
        total_r = new javax.swing.JLabel();
        total_l11 = new javax.swing.JLabel();
        total_l12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SALES ANALYSIS");

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

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

        total.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("0");

        profits.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        profits.setForeground(new java.awt.Color(255, 255, 255));
        profits.setText("0");

        jButton6.setText("Filter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        sell_date.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Quantitty chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Total sells chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        total_l9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l9.setForeground(new java.awt.Color(255, 255, 255));
        total_l9.setText("Total sell    = Ksh");

        total_l10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l10.setForeground(new java.awt.Color(255, 255, 255));
        total_l10.setText("Total profit = Ksh");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(sell_date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(71, 71, 71)
                        .addComponent(jButton2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_l10)
                            .addComponent(total_l9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profits, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sell_date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_l9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profits, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_l10))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Daily", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        daily_t1.setModel(new javax.swing.table.DefaultTableModel(
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
        daily_t1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                daily_t1MouseReleased(evt);
            }
        });
        daily_t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                daily_t1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(daily_t1);

        filter_m.setText("Filter");
        filter_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_mActionPerformed(evt);
            }
        });

        total_l3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l3.setForeground(new java.awt.Color(255, 255, 255));
        total_l3.setText("Total sell    = Ksh");

        total_l4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l4.setForeground(new java.awt.Color(255, 255, 255));
        total_l4.setText("Total profit = Ksh");

        profits_m.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        profits_m.setForeground(new java.awt.Color(255, 255, 255));
        profits_m.setText("0");

        total_m.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_m.setForeground(new java.awt.Color(255, 255, 255));
        total_m.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter_m))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(total_l3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(total_l4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(profits_m, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(total_m, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(month, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(year, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filter_m))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_l3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_m, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_l4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profits_m, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Monthly", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));

        sell_date1.setDateFormatString("yyyy-MM-dd");

        sell_date2.setDateFormatString("yyyy-MM-dd");

        total_l5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        total_l5.setForeground(new java.awt.Color(255, 255, 255));
        total_l5.setText("To");

        total_l6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        total_l6.setForeground(new java.awt.Color(255, 255, 255));
        total_l6.setText("From");

        daily_t2.setModel(new javax.swing.table.DefaultTableModel(
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
        daily_t2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                daily_t2MouseReleased(evt);
            }
        });
        daily_t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                daily_t2KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(daily_t2);

        jButton8.setText("Filter");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        profits_r.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        profits_r.setForeground(new java.awt.Color(255, 255, 255));
        profits_r.setText("0");

        total_r.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_r.setForeground(new java.awt.Color(255, 255, 255));
        total_r.setText("0");

        total_l11.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l11.setForeground(new java.awt.Color(255, 255, 255));
        total_l11.setText("Total sell    = Ksh");

        total_l12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        total_l12.setForeground(new java.awt.Color(255, 255, 255));
        total_l12.setText("Total profit = Ksh");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(total_l6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sell_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(total_l5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sell_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jButton8))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total_l12)
                                    .addComponent(total_l11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total_r, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profits_r, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 353, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8)
                    .addComponent(sell_date2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_l6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell_date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_l5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_r, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_l11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profits_r, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_l12))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Range", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(967, 656));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
            ResultSet rs=null;
            Statement stmt=null;
            PreparedStatement pst=null;
           javaconnect connect=new javaconnect();
          Connection conn=javaconnect.getConnection();
            DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            // Date date=new Date();
            dtf.format(sell_date.getDate());
            String sql_ps="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_sold like '%"+dtf.format(sell_date.getDate())+"%' group by  id,name order by name";
            pst=conn.prepareStatement(sql_ps);
            rs=pst.executeQuery();
            daily_t.setModel(DbUtils.resultSetToTableModel(rs));
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
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Enter date to filter");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void daily_t1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daily_t1MouseReleased

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
    }//GEN-LAST:event_daily_t1MouseReleased

    private void daily_t1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daily_t1KeyReleased
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
    }//GEN-LAST:event_daily_t1KeyReleased

    private void filter_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_mActionPerformed
        try{
            ResultSet rs=null;
            Statement stmt=null;
            PreparedStatement pst=null;
          javaconnect connect=new javaconnect();
          Connection conn=javaconnect.getConnection();
            String s=year.getYear()+"-"+(month.getMonth()+1);
            DateFormat dtf=new SimpleDateFormat("yyyy-MM");
            Date startDate=dtf.parse(s);
            //  Date date=new Date();

            // JOptionPane.showMessageDialog(null,s);
            dtf.format(startDate);

            String sql_ps="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_sold like '%"+dtf.format(startDate)+"%' group by  id,name order by name";
            pst=conn.prepareStatement(sql_ps);
            rs=pst.executeQuery();
            daily_t1.setModel(DbUtils.resultSetToTableModel(rs));
            TableColumnModel tcm2=daily_t1.getColumnModel();
            tcm2.removeColumn(tcm2.getColumn(0));

            ResultSet rs2=null;
            PreparedStatement pst2=null;
            String sql4="select SUM(total_cost) from sells where date_sold like '%"+dtf.format(dtf.format(startDate))+"%'";
            pst2=conn.prepareStatement(sql4);

            rs2=pst2.executeQuery();
            while (rs2.next())
            {
                int std = rs2.getInt(1);
                total_m.setText(String.valueOf(std));
                if(profits_m.getText().equals("null")){
                    profits_m.setText("0");
                    //  profits.setText(String.valueOf(std));
                }
                // JOptionPane.showMessageDialog(null,"Enter date to filter");
            }
            String sql5="select SUM(profit) from sells where date_sold like '%"+dtf.format(startDate)+"%'";
            pst2=conn.prepareStatement(sql5);

            rs2=pst2.executeQuery();
            while (rs2.next())
            {
                String std = rs2.getString(1);
                profits_m.setText(String.valueOf(std));
                if(profits_m.getText().equals("null")){
                    profits_m.setText("0");
                    //  profits.setText(String.valueOf(std));
                }
                // JOptionPane.showMessageDialog(null,"Enter date to filter");
            }
        }
        catch(Exception e){
            // JOptionPane.showMessageDialog(null,"Enter a valid date to filter");
        }
    }//GEN-LAST:event_filter_mActionPerformed

    private void daily_t2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daily_t2MouseReleased

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
    }//GEN-LAST:event_daily_t2MouseReleased

    private void daily_t2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daily_t2KeyReleased
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
    }//GEN-LAST:event_daily_t2KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try{
            ResultSet rs=null;
            Statement stmt=null;
            PreparedStatement pst=null;
          javaconnect connect=new javaconnect();
          Connection conn=javaconnect.getConnection();
            DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            // sell_date2.setDate(date);
            //sell_date.setDate(date);
            // dtf.format(sell_date2.getDate());
            String sql_ps="select id,name,sum(quantity) as Quantity,sum(total_cost) as 'Total cost',sum(profit) as 'Total Profit' from sells where date_only>='"+dtf.format(sell_date1.getDate())+"' and date_only<='"+dtf.format(sell_date2.getDate())+"' group by  id,name order by name";
            pst=conn.prepareStatement(sql_ps);
            rs=pst.executeQuery();
            daily_t2.setModel(DbUtils.resultSetToTableModel(rs));
            TableColumnModel tcm2=daily_t2.getColumnModel();
            tcm2.removeColumn(tcm2.getColumn(0));

            ResultSet rs2=null;
            PreparedStatement pst2=null;
            String sql4="select SUM(total_cost) from sells where date_only>='"+dtf.format(sell_date1.getDate())+"' and date_only<='"+dtf.format(sell_date2.getDate())+"' ";
            pst2=conn.prepareStatement(sql4);

            rs2=pst2.executeQuery();
            while (rs2.next())
            {
                int std = rs2.getInt(1);
                total_r.setText(String.valueOf(std));
                // JOptionPane.showMessageDialog(null,"Enter date to filter");
            }
            String sql5="select SUM(profit) from sells where date_only>='"+dtf.format(sell_date1.getDate())+"' and date_only<='"+dtf.format(sell_date2.getDate())+"' ";
            pst2=conn.prepareStatement(sql5);

            rs2=pst2.executeQuery();
            while (rs2.next())
            {
                String std = rs2.getString(1);
                profits_r.setText(String.valueOf(std));
                if(profits_r.getText().equals("null")){
                    profits_r.setText("0");
                    //  profits.setText(String.valueOf(std));
                }
                // JOptionPane.showMessageDialog(null,"Enter date to filter");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Enter date to filter");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            // Date date=new Date();
            dtf.format(sell_date.getDate());
            javaconnect connect=new javaconnect();
            Connection conn=javaconnect.getConnection();
            //Connection conn=null;
            ResultSet rs=null;
            Statement stmt=null;
            // PreparedStatement pst=null;

            String query="select name,sum(quantity) as Quantity from sells where date_sold like '%"+dtf.format(sell_date.getDate())+"%' group by  id,name order by name";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset(conn,query);
            JFreeChart chart=ChartFactory.createBarChart3D("Quantity chart","Name","Quantity",dataset, PlotOrientation.VERTICAL,false,true,true);
            chart.setBackgroundPaint(Color.green);
            BarRenderer renderer=null;
            CategoryPlot plot=null;
            renderer=new BarRenderer();

            ChartFrame frame=new ChartFrame ("Quantity chart",chart);
            frame.setVisible(true);
            frame.setSize(850,600);
            // TODO add your handling code here:}
        }catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            DateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
            // Date date=new Date();
            dtf.format(sell_date.getDate());
            javaconnect connect=new javaconnect();
            Connection conn=javaconnect.getConnection();
            //Connection conn=null;
            ResultSet rs=null;
            Statement stmt=null;
            // PreparedStatement pst=null;

            String query="select name,sum(total_cost) as 'Total cost' from sells where date_sold like '%"+dtf.format(sell_date.getDate())+"%' group by  id,name order by name";
            JDBCPieDataset dataset = new JDBCPieDataset(conn,query);

            dataset.executeQuery(query);

            JFreeChart chart = ChartFactory.createPieChart3D(
                "Sales Chart", dataset, true, true, false);
            chart.setBackgroundPaint(Color.gray);
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLegendLabelGenerator(
                new StandardPieSectionLabelGenerator("{0} {2}"));

            final ChartRenderingInfo info = new ChartRenderingInfo(
                new StandardEntityCollection());
            final File file1 = new File("Chart5.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 850,600, info);
            ChartFrame frame=new ChartFrame("Sales Chart",chart);
            frame.setVisible(true);
            frame.setSize(850,600);

            // log exception

            // TODO add your handling code here:}
        }catch(Exception e){}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(analyse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analyse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable daily_t;
    private javax.swing.JTable daily_t1;
    private javax.swing.JTable daily_t2;
    private javax.swing.JButton filter_m;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JLabel profits;
    private javax.swing.JLabel profits_m;
    private javax.swing.JLabel profits_r;
    private com.toedter.calendar.JDateChooser sell_date;
    private com.toedter.calendar.JDateChooser sell_date1;
    private com.toedter.calendar.JDateChooser sell_date2;
    private javax.swing.JLabel total;
    private javax.swing.JLabel total_l10;
    private javax.swing.JLabel total_l11;
    private javax.swing.JLabel total_l12;
    private javax.swing.JLabel total_l3;
    private javax.swing.JLabel total_l4;
    private javax.swing.JLabel total_l5;
    private javax.swing.JLabel total_l6;
    private javax.swing.JLabel total_l9;
    private javax.swing.JLabel total_m;
    private javax.swing.JLabel total_r;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
