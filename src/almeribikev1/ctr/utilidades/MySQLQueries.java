/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almeribikev1.ctr.utilidades;
import almeribikev1.gui.login.ControllerLogin;
import almeribikev1.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gaertan
 */
public class MySQLQueries {
    private Connection conexion ;
    
//    private void getConexion(){conexion = MySQL.establecerConexion();}
    static public boolean checkLogin(Usuario usuario){
     
           Connection con = MySQL.establecerConexion();

        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuarios WHERE usuario=?";
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            rs = ps.executeQuery();
            if (rs.next()){
                Usuario usuarioReturned = new Usuario(rs.getString("usuario"),rs.getString("password"));
                
                
               if(usuario.equals(usuarioReturned)) {return true;}
            }
            else return false;
        } catch (SQLException e) {ControllerLogin.aviso(e.getMessage());
            return false;
        } 
//        finally {
//            try {
//                con.close();
//            } catch (SQLException e) {ControllerLogin.aviso(e.getMessage());
//                System.err.print(e);
// 
//            }
//        }
        return false;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
