/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.ParseException;

/**
 *
 * @author Ugueto
 */
public class Consulta extends Reporte{
    static private int numTrab;
    static private String ci_profe;
    //--------------Constructor-------------------
    public Consulta()throws ParseException{ 
        super();
    }
    //-------------------------------------
    static public void setNumTrab(int N){
        numTrab=N;
    }
    static public int getNumTrab(){
        return numTrab;
    }
    
    //ahora el resto le queda el metodo de la clase control
    /* sería agregar a listaTrab de esta clase TODOS los trabajos donde aparezca
    la ci_profe sea de autor o de tutor
    */
}
