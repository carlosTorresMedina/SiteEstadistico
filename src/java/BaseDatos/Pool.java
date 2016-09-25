/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.DriverManager;

/**
 *
 * @author carlos
 */
public class Pool {
    
 private static  DataSource dataSource;
 private static final  String driver = "org.postgresql.Driver";
 private static final  String url = "jdbc:postgresql://sandbox2.ufps.edu.co:5432/site";
 private static final  String contrasena = "ufps_29";
 private static final  String usuario = "ufps_36";
     
 
   public static DataSource  getDataSource(){
       if(Pool.dataSource==null){
        BasicDataSource basic=new BasicDataSource();
               basic.setDriverClassName(driver);
               basic.setUsername(usuario);
               basic.setPassword(contrasena);
               basic.setUrl(url);
               basic.setMaxActive(100);         
               dataSource=basic;
       }
       return Pool.dataSource;
    }

   public static void main(String ar[]){
     try {
         Connection con = Pool.getDataSource().getConnection();
         System.out.println("Conectado");
     } catch (SQLException ex) {
         System.err.println("No conectado");
         Logger.getLogger(Pool.class.getName()).log(Level.SEVERE, null, ex);
     }
   }

    
}
