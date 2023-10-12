/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almeribikev1.gui.login;

import almeribikev1.ctr.ControllerGeneral;
import almeribikev1.ctr.utilidades.MySQL;
import almeribikev1.ctr.utilidades.MySQLQueries;
import almeribikev1.dto.Usuario;
import almeribikev1.gui.AvisoDialog;
import almeribikev1.gui.login.JFrameLogin;
import com.mysql.cj.x.protobuf.MysqlxSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

/**
 *
 * @author Gaertan
 */
public class ControllerLogin implements ActionListener {
//public class ControllerLogin{
    
    
      String packageName = getClass().getPackage().getName();
      String nodePath = "/" + packageName.replace('.', '/');
    private Usuario usuario = null;
    private JFrameConexion vistaConexion;
    private JFrameLogin vistaLogin;
    private ControllerGeneral controllergeneral;


    private static ControllerLogin instance = null;
    
    protected void setControllerGeneral(){this.controllergeneral = ControllerGeneral.getInstance();}
    protected void setJFrameLogin(JFrameLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }
    private ControllerLogin() {
        setControllerGeneral();
    }

    public static ControllerLogin getInstance() {
        if (instance == null) {
            instance = new ControllerLogin();
        }
        return instance;
    }

    
        public static void aviso(String texto){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AvisoDialog dialog = new AvisoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setText(texto);
                dialog.setVisible(true);
            }
        });}

    @Override
    public void actionPerformed(ActionEvent e) {
   
    
            if (e.getSource() == vistaLogin.getjButtonIniciarSesion()) {
                iniciarSesion();
            
             }
            
            
            
             if (e.getSource() == vistaLogin.getjButtonSalir()) {

              }   
            
            
            
            
    }
    protected void iniciarSesion(){ 
            String usuarioNombre = vistaLogin.getJTFUsuario().getText();
            String password = new String(vistaLogin.getJPFLogin().getPassword());

            boolean recordar = vistaLogin.getjCheckBox1().isSelected();

            
            
            if(recordar) {
                guardarPreferencias(usuarioNombre, password);
            } else {
                borrarPreferencias();
            }
            
            Usuario usuario = new Usuario(usuarioNombre,password);
            if(MySQLQueries.checkLogin(usuario)){
            this.usuario = usuario;
            controllergeneral.setUsuario(usuario);
            vistaLogin.dispose();
            controllergeneral.iniciarApp();
            
            }}    
    
    
    protected void guardarPreferencias(String usuario, String password) {

        
        Preferences prefs = Preferences.userRoot().node(nodePath);
        prefs.put("usuario", usuario);
        prefs.put("password", password);
    }

    protected void borrarPreferencias() {

        
        Preferences prefs = Preferences.userRoot().node(nodePath);
        prefs.remove("usuario");
        prefs.remove("password");
    }
    protected void cargarPreferencias() {
    Preferences prefs = Preferences.userRoot().node(nodePath);
    
    String usuarioGuardado = prefs.get("usuario", "");
    String passwordGuardada = prefs.get("password", "");
    boolean recordar = !usuarioGuardado.isEmpty() && !passwordGuardada.isEmpty();
    
    vistaLogin.getJTFUsuario().setText(usuarioGuardado);
    vistaLogin.getJPFLogin().setText(passwordGuardada);
    vistaLogin.getjCheckBox1().setSelected(recordar);
}


    protected void guardarPreferenciasDb(String direccion,String usuario, String password) {

        
        Preferences prefs = Preferences.userRoot().node(nodePath);
        prefs.put("direcciondb", direccion);
        prefs.put("usuariodb", usuario);
        prefs.put("passworddb", password);
    }

    protected void borrarPreferenciasDb() {

        
        Preferences prefs = Preferences.userRoot().node(nodePath);
        prefs.remove("direcciondb");
        prefs.remove("usuariodb");
        prefs.remove("passworddb");
    }
    
    protected void cargarPreferenciasDb() {
        
    Preferences prefs = Preferences.userRoot().node(nodePath);
    String direccionGuardada = prefs.get("direcciondb", "");
    String usuarioGuardado = prefs.get("usuariodb", "");
    String passwordGuardada = prefs.get("passworddb", "");
    boolean recordar = !usuarioGuardado.isEmpty() && !passwordGuardada.isEmpty();
    vistaConexion.getJTFUrl().setText(direccionGuardada);
    vistaConexion.getJTFUsuario().setText(usuarioGuardado);
    vistaConexion.getJPFPassword().setText(passwordGuardada);
    vistaConexion.getjCheckBox1().setSelected(recordar);
    
} 
    
   protected void reestablecerPreferenciasDb(){
   
   
     vistaConexion.getJTFUrl().setText(MySQL.getHOST());
   vistaConexion.getJTFUsuario().setText(MySQL.getUSUARIO());
     vistaConexion.getJPFPassword().setText(MySQL.getCONTRASENA());
   
   
   } 
    
    
    
}
    
    
    

    
  

