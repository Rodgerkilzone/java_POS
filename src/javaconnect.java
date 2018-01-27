/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author RODGER
 */
public class javaconnect {

    public static Connection getConnection() throws Exception {
        try {
 String driver="com.mysql.jdbc.Driver";
   String username_d="root";
   String password_d="";
   String url="jdbc:mysql://localhost:3306/pharmacy";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username_d, password_d);

            //state=conn.PrepareStatement();
           // JOptionPane.showMessageDialog(null, "Connected");
            //System.out.println("connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }



}
