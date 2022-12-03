package com.emergentes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJ
 */
public class ConexionDB {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_chat?serverTimezone=UTC&enabledTLSProtocols=TLSv1.2";
    static String user = "root";
    static String password = "";

    protected Connection conn = null;
    
    public ConexionDB() {
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion OK: " + conn);
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
