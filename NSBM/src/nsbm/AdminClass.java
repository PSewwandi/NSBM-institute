/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author piyumika
 */
public class AdminClass extends NSBM {
    public static String reg_no;
    Statement st=null;
    ResultSet retriew(String sql) {
        //this gives result set for query for details button action method
       ResultSet rs = null;
       try{
            Statement st = con.createStatement();//string of query converted into a sql query
            rs = st.executeQuery(sql);//result set of the query
        }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"statement failed");
        }
        return rs; 
    }
    
      String lastRegNo(String q) throws SQLException{
         //to get the last registration number of undergraduates
         //registration numbers of students are auto incremented and have two types of reg_no for undergraduates and postgraduates
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);
    //until point to last registration number
            while(rs.next()){
                reg_no=rs.getString("std_reg_no");
        }
    //new reg_no shuld be one more than last reg_no
    reg_no=Integer.toString(Integer.parseInt(reg_no)+1);//convert the reg_no to a string
    return reg_no;
}
    
    
     void insertData(String q) throws SQLException {
         Statement st=con.createStatement();
         st.executeUpdate(q);
     }
     void updateData(String q) throws SQLException{
         Statement st=con.createStatement();
         st.executeUpdate(q);
     }
     void deleteData(String q) throws SQLException{
         Statement st=con.createStatement();
         st.executeUpdate(q);
     }
      public int calTotalFee(String q1,String q2,String q3,String q4) throws SQLException{
      // calculate total fee for selected subjects in changePostStdGUI and changeUnderStdGui
       int fee=0;
       int sub1Fee,sub2Fee,sub3Fee,sub4Fee;
    
      Statement st=con.createStatement();
      if(!"".equals(q1)){
       ResultSet rs1=st.executeQuery(q1);
       rs1.next();
       sub1Fee=Integer.parseInt(rs1.getString("fee"));
      }else{
           sub1Fee=0;
      }
      if(!"".equals(q2)){
       ResultSet rs2=st.executeQuery(q2);
       rs2.next();
       sub2Fee=Integer.parseInt(rs2.getString("fee"));
      }else{
            sub2Fee=0;
      }
      if(!"".equals(q3)){
       ResultSet rs3=st.executeQuery(q3);
       rs3.next();
       sub3Fee=Integer.parseInt(rs3.getString("fee"));
      }else{
           sub3Fee=0;
      }
      if(!"".equals(q4)){
       ResultSet rs4=st.executeQuery(q4);
       rs4.next();
       sub4Fee=Integer.parseInt(rs4.getString("fee"));
      }else{
           sub4Fee=0;
      }
       fee=sub1Fee+sub2Fee+sub3Fee+sub4Fee;
       return fee;
     }
    
    
   
}
