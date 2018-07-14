/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
/**
 *
 * @author krlos
 */
public class Ctrl_Acceso {
    private static Ctrl_Reportes CTRL;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CTRL = Ctrl_Reportes.getInstance();                    //Inicia ejecucion de aplicacion
        CTRL.i_SelectUser();
    }
    
}
