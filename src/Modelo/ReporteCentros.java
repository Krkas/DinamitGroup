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
public class ReporteCentros extends Reporte{
    private String centro;

    //-----------Constructor---------------------
    public ReporteCentros(String Centro)throws ParseException{ 
        super();
        centro=Centro;
    }
    //-------------------------------------------
    public void setCentro(String C){
        centro=C;
    }
    
    public String getcentro(){
        return centro;   
    }
    
    public void listarCentro(String c){// agrega los trabajos pertenecientes al Centro
        
        for(int j=0;j<ConjuntoProfesores.getTotal();j++){ //agrega los profesores del centro seleccionado a la lista de Prof
            if(ConjuntoProfesores.getListado().get(j).getCentro().equals(centro)){
                ListaProf.add(ConjuntoProfesores.getListado().get(j));
            }            
        }
        
        for(int i=0; i < ConjuntoTrabajos.getTotal() ; i++){   //agrega el trabajo del centro a la a la listaTrab de este reporte
            for(int k=0; k < ListaProf.size() ; k++){
                if(ConjuntoTrabajos.getListado().get(i).getCi_t().equals(ListaProf.get(k).getCi())){ //si el tutor_1 pertenece a este centro
                    ListaTrab.add(ConjuntoTrabajos.getListado().get(i)); 
                }else if(ConjuntoTrabajos.getListado().get(i).getCi_t2().equals(ListaProf.get(k).getCi())){ //si no, se revisa el tutor 2, ya que si fueran los 2, se contabiliza como uno solo
                    ListaTrab.add(ConjuntoTrabajos.getListado().get(i)); 
                }
            }//ahora solo queda mostrar toda la listaTrab luego de desto
         }
    }
}
