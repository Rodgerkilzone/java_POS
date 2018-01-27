



import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*import java.sql.SQLException;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RODGER
 */

public class insert_database {
    public static void main(String[] args){
      //  initComponents();
     insert ins=new insert();
     ins.insert();
    }

   }

class insert{
        
void insert(){   

        try{
      String driver = "org.sqlite.JDBC";
            String url = "jdbc:sqlite:pharmacy.db";
            Connection conn=DriverManager.getConnection(url);
                    ResultSet rs=null;
        Statement stmt=null;
        Statement st=null;
        PreparedStatement pst=null;
        Class.forName(driver);
        
        /*
String sells2="drop table sells;"
        + "drop table product;"
        + "drop table accounts;"
        + "drop table login_time;"
        + "drop table cart";
    st=conn.createStatement();
    st.executeUpdate(sells2);*/
    //sells table
     String sells="CREATE TABLE `sells` (\n" +
"  `id` int(30) NOT NULL,\n" +
"  `name` varchar(30) NOT NULL,\n" +
"  `detail` varchar(200) NOT NULL,\n" +
"  `quantity` int(30) NOT NULL,\n" +
"  `total_cost` int(11) NOT NULL,\n" +
"  `profit` double NOT NULL,\n" +
"  `date_sold` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
"  `sold_by` varchar(30) NOT NULL,\n" +
"  `date_only` date DEFAULT NULL\n" +
")" ;
st=conn.createStatement();
    st.executeUpdate(sells);
    //cart table
    String cart="CREATE TABLE `cart` (\n" +
"  `id` int(30) NOT NULL,\n" +
"  `name` varchar(30) NOT NULL,\n" +
"  `detail` varchar(200) NOT NULL,\n" +
"  `quantity` int(30) NOT NULL,\n" +
"  `total_cost` int(11) NOT NULL,\n" +
"  `profit` double NOT NULL\n" +
")";
    st=conn.createStatement();
    st.executeUpdate(cart);
    //product table
        String product="CREATE TABLE `product` (\n" +
"  `id` INTEGER PRIMARY KEY AUTOINCREMENT  ,\n" +//AUTO_INCREMENT
"  `name` varchar(30) NOT NULL,\n" +
"  `detail` varchar(200) NOT NULL,\n" +
"  `price` int(30) NOT NULL,\n" +
"  `quantity` int(30) NOT NULL,\n" +
"  `buying_price` float NOT NULL,\n" +
"  `supplier` varchar(30) NOT NULL,\n" +
"  `Date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
")";
    st=conn.createStatement();
    st.executeUpdate(product);
    
    //account
        String accounts="CREATE TABLE `accounts` (\n" +
"  `id` INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +//AUTO_INCREMENT
"  `username` varchar(50) NOT NULL,\n" +
"  `password` varchar(50) NOT NULL,\n" +
"  `account_type` varchar(30) NOT NULL,\n" +
"  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
")";
    st=conn.createStatement();
    st.executeUpdate(accounts);
    
   // login_time table
       String login_time="CREATE TABLE `login_time` (\n" +
"  `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"  `username` varchar(30) NOT NULL,\n" +
"  `password` varchar(30) NOT NULL,\n" +
"  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
")";
    st=conn.createStatement();
    st.executeUpdate(login_time);
    
  
    }catch(Exception e){
    


JOptionPane.showMessageDialog(null,e);    
    }
}
}

