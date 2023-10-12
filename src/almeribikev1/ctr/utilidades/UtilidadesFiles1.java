/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almeribikev1.ctr.utilidades;

import static almeribikev1.gui.login.ControllerLogin.aviso;
import java.io.File;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Gaertan
 */
public class UtilidadesFiles1 {
    
    public static boolean checkDirectorio(String ruta) throws OperationNotSupportedException {
    //con el texto dado intenta crear un directorio, si no existe, mediante mkdirs, que devuelve true si logra crearlo y false si no
    File rutaSinArchivo = new File(ruta);

    if (!rutaSinArchivo.exists() || !rutaSinArchivo.isDirectory()) {
        if (!rutaSinArchivo.mkdirs()) {         //   throw new OperationNotSupportedException("No se pudo crear la carpeta en la ruta especificada.");
            aviso("No se pudo crear la carpeta en la ruta especificada.");


            return false;
        }
    }

    return true;
}
    
    
    
    
    
    
    
}
