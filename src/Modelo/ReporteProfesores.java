package Modelo;

import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReporteProfesores extends Reporte {
    private boolean ord;
    
    private int Tamano; //para el size de ListaProf
    
    //----------Constructor-------------------------
    public ReporteProfesores()throws ParseException{ 
        super();
        ord = false;
    }
    //-----------Metodos---------------------------
      public void ordenar(boolean ord){
        Tamano = ListaProf.size();
        Profesor aux = new Profesor();
        if(ord){ //numero de trabajos
            // esta funcion mejor se la pasamos a la clase control, hay q usar un atributo numtrab
        }
        else{      //ordenamiento Apellido-Nombre--------------------------------------------------
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
        
    }
    public boolean existeProf(String ci_t1o2, ArrayList<Profesor> listado){
        for(int index = 0; index < listado.size() ; index++){
            if(listado.get(index).getCi().equalsIgnoreCase(ci_t1o2))
                return true;            
        }
        return false;
    }
}
