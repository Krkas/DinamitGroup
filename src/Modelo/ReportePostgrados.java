/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.*;
import java.util.ArrayList;
/**
 *
 * @author Ugueto
 */


public class ReportePostgrados extends Reporte{
    
    
    private Ctrl_Reportes Aux = Ctrl_Reportes.getInstance();
        
    private ConjuntoProfesores ConjuntoProf = Aux.get_Instance_ConjuntoProfesores();
    
    private ArrayList <Profesor> ListaProf = Aux.get_Instance_ConjuntoProfesores().getListado();
        
    private int Tamano = ListaProf.size();
        
    public void ordenar(){
        
        Profesor aux = new Profesor();
                
        for(int i = Tamano -1; i > 0 ; i--){      
            for(int j = 0; j < i ; j++){
                if(ListaProf.get(j).getApellido().compareTo(ListaProf.get(j+1).getApellido())==0){ 
                    
                    if(ListaProf.get(j).getNombre().compareTo(ListaProf.get(j+1).getNombre())<0){ //pasa al nombre
                        aux.setApellido(ListaProf.get(j).getApellido());
                        aux.setNombre(ListaProf.get(j).getNombre());
                        aux.setCentro(ListaProf.get(j).getCentro());
                        aux.setci(ListaProf.get(j).getCi());

                        ListaProf.get(j).setApellido(ListaProf.get(j+1).getApellido());
                        ListaProf.get(j).setNombre(ListaProf.get(j+1).getNombre());
                        ListaProf.get(j).setCentro(ListaProf.get(j+1).getCentro());
                        ListaProf.get(j).setci(ListaProf.get(j+1).getCi());

                        ListaProf.get(j+1).setApellido(aux.getApellido());
                        ListaProf.get(j+1).setNombre(aux.getNombre());
                        ListaProf.get(j+1).setCentro(aux.getCentro());
                        ListaProf.get(j+1).setci(aux.getCi());
                    }
                }
                if(ListaProf.get(j).getApellido().compareTo(ListaProf.get(j+1).getApellido()) < 0){
                    
                    aux.setApellido(ListaProf.get(j).getApellido());
                    aux.setNombre(ListaProf.get(j).getNombre());
                    aux.setCentro(ListaProf.get(j).getCentro());
                    aux.setci(ListaProf.get(j).getCi());
                    
                    ListaProf.get(j).setApellido(ListaProf.get(j+1).getApellido());
                    ListaProf.get(j).setNombre(ListaProf.get(j+1).getNombre());
                    ListaProf.get(j).setCentro(ListaProf.get(j+1).getCentro());
                    ListaProf.get(j).setci(ListaProf.get(j+1).getCi());
                    
                    ListaProf.get(j+1).setApellido(aux.getApellido());
                    ListaProf.get(j+1).setNombre(aux.getNombre());
                    ListaProf.get(j+1).setCentro(aux.getCentro());
                    ListaProf.get(j+1).setci(aux.getCi());
                }
            }
        } 
    }
       
    public void listarProf(String ci_t){
        ListaProf.add(ConjuntoProf.encontrarProf(ci_t));
    }
        
    
}
