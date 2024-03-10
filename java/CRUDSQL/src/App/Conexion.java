/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author j2a0a
 */
public class Conexion {
    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "RegistroEstudiantes";
    private final String USER = "postgres";
    private final String PASSWORD = "password";
    
    public Connection getConexion(){
        Connection conexion = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
            conexion = DriverManager.getConnection(url,USER,PASSWORD);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return conexion;
    }
}
