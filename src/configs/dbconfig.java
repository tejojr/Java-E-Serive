/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Zeref
 */
public class dbconfig {
    public static Connection con;
    public static Connection Con()throws SQLException{
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost/faztservice","root","");
            System.out.println("Koneksi Sukses");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
//    public static void main(String[] args) throws SQLException {
//        System.out.println(Con());
//    }
    
}
