/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author moral
 */
public class ConexionBD {
   
      private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
    private static final String USER = "sys as sysdba ";
    private static final String PASSWORD = "1234";

    public static Connection conectar() throws SQLException {
try {
        Class.forName("oracle.jdbc.OracleDriver"); 
    } catch (ClassNotFoundException e) {
        System.err.println("Error: No se encontró el driver de Oracle en las dependencias.");
    }
    return DriverManager.getConnection(URL, USER, PASSWORD);
}  
}
