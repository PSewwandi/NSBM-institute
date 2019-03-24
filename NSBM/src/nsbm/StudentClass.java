/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author piyumika
 */
public class StudentClass extends NSBM {
     Statement st=null;
    ResultSet retriew(String sql) {
        //this gives result set for query for details button action method
       ResultSet rs = null;
       try{
            Statement st = con.createStatement();//string of query converted into a sql query
            rs = st.executeQuery(sql);//result set of the query
        }catch(SQLException ex){
          javax.swing.JOptionPane.showMessageDialog(null,"statement failed");
        }
        return rs; 
    }
    
    
   /* void insertData(String q) throws SQLException {
         Statement st=con.createStatement();
         st.executeUpdate(q);
     }*/
    
    
   /* public static void main(String args[]){
         NSBM n=new NSBM();
         Connection con1 = NSBM.con();
    }*/
    
}
