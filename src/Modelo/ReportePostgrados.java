/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author Ugueto
 */
public class ReportePostgrados extends Reporte{    
    
    public void ordenar(){
        Profesor aux = new Profesor();
        for(int i=ListaProf.size()-1; i>0 ;i--){      
            for(int j=0; j<i ;j++){
                if(ListaProf.get(j).getApellido().compareTo(ListaProf.get(j+1).getApellido())==0){ 
                    
                    if(ListaProf.get(j).getNombre().compareTo(ListaProf.get(j+1).getNombre())<0){ //pasa al nombre
                       aux = ListaProf.get(j);
                       ListaProf.set(j, ListaProf.get(j+1));
                       ListaProf.set(j+1, aux);
                    }
                }
                if(ListaProf.get(j).getApellido().compareTo(ListaProf.get(j+1).getApellido()) < 0){
                       aux = ListaProf.get(j);
                       ListaProf.set(j, ListaProf.get(j+1));
                       ListaProf.set(j+1, aux);
                }
            }
        } 
    }
       
    public void listarProf(String ci_t){
        ListaProf.add(ConjuntoProfesores.encontrarProf(ci_t));
    }
}
