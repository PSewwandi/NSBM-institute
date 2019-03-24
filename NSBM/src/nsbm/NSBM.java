/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author piyumika
 */
public class NSBM {
    
    public static Connection con = null;//class variables 
    //public static Statement st = null;
    public static Connection con(){//databse connection method creation
       try{
           Class.forName("com.mysql.jdbc.Driver");//jdbc driver
           con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/nsbm?","root","");//nsbm databse connect to jdbc driver
         
           }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, "Connection Failed!!!");
       }
     return con;
    }
    
   public static void Disconnect() {
       // disconnection
       try
       {
         con.close();
       }catch(SQLException e){ 
       }
        
   }
  
    
    public static void main (String args[]) throws SQLException{
        //con();
        LoginForm l;
        l = new LoginForm();
        l.setVisible(true);
    }
}


   
    

