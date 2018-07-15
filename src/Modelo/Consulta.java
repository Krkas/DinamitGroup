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
     private int numTrab;
     private String ci_profe;
    //--------------Constructor-------------------
    public Consulta()throws ParseException{ 
        super();
    }
    //-------------------------------------
     public void setNumTrab(int N){
        numTrab=N;
    }
     public int getNumTrab(){
        return numTrab;
    }
    
    //ahora el resto le queda el metodo de la clase control
    /* sería agregar a listaTrab de esta clase TODOS los trabajos donde aparezca
    la ci_profe sea de autor o de tutor
    */
}
