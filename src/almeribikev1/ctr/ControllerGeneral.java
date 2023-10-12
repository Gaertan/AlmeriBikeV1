package almeribikev1.ctr;

import almeribikev1.gui.login.JFrameLogin;
import almeribikev1.dto.Usuario;
import almeribikev1.gui.JFramePrincipal;

public class ControllerGeneral {

    private static ControllerGeneral instance = null;
    private Usuario usuario;

    private ControllerGeneral() {
        // Constructor privado para prevenir instanciación externa,singleton
    }

    public static ControllerGeneral getInstance() {
        if (instance == null) {
            instance = new ControllerGeneral();
        }
        return instance;
    }
    public void setUsuario(Usuario usuario){if(usuario!=null)this.usuario=usuario;}
    
    
    public void iniciarApp() {
        if (usuario == null) {
            mostrarVentanaLogin();
        } else {
            mostrarVentanaPrincipal();
        }
    }

    public void iniciarSesion(Usuario usuario) {
        this.usuario = usuario;
        mostrarVentanaPrincipal();
    }

    private void mostrarVentanaLogin() {
        JFrameLogin loginFrame = new JFrameLogin();
//        loginFrame.setModal();
        loginFrame.setVisible(true);
    }

    private void mostrarVentanaPrincipal() {
        JFramePrincipal principalFrame = new JFramePrincipal();
        principalFrame.setVisible(true);
    }
}
