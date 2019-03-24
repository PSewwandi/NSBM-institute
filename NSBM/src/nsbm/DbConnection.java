/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbConnection{
    static Connection con=null;
      Statement st=null;
    //create mysql databse connection
public static Connection con(){
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/nsbm?","root","");
           // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
     
       }catch(ClassNotFoundException | SQLException e){
    }
       return con;
    }
public void retriew() throws SQLException{
     String query = "SELECT t_name FROM teacher";

      // create the java statement
      st = con.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String name=rs.getString("t_name");
        System.out.println(name);
      }
      st.close(); 
}
public static void main(String args[]){
    
}

}



/**
 *
 * @author piyumika
 */
