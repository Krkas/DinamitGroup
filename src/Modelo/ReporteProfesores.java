import Modelo.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ReporteProfesores extends Reporte {
    private boolean ord;        
    private ArrayList<Profesor> ListaProf = new ArrayList<>();
    //----------Constructor-------------------------
    public ReporteProfesores() throws ParseException
    {
        super();
        ord = false;
    }
    //-----------Metodos---------------------------
    public void Listar(ArrayList<Profesor> list_prof)
    {
        String ci_tt;
        int j;
        for(int i = 0 ; i < Lista.size() ; i++)//Lista es la lista de trabajos
        {                                     //Que posee esta Subclase de Reporte
            ci_tt = Lista.get(i).getCi_t();  //ListaProf es la lista de profesores que posee
                                            // y list_prof la lista de profesores totales en el programa.
            if(existeProf(ci_tt))ListaProf.get(Index(ci_tt)).SumarTrab();
            else
            {
                j = 0;
                while(!list_prof.get(j).getCi().equalsIgnoreCase(ci_tt) && j < list_prof.size()) 
                    j++;
                ListaProf.add(list_prof.get(j));
                ListaProf.get(Index(ci_tt)).SumarTrab();
            }
            if(!Lista.get(i).getCi_t2().isEmpty())
            {//Aqui se chequea si, en tal caso de poseer un segundo tutor, este esta agregado ya
                ci_tt = Lista.get(i).getCi_t2();  
                if(existeProf(ci_tt))ListaProf.get(Index(ci_tt)).SumarTrab();
                else
                {
                    j = 0;
                    while(!list_prof.get(j).getCi().equalsIgnoreCase(ci_tt) && j < list_prof.size()) 
                       j++;
                    ListaProf.add(list_prof.get(j));
                    ListaProf.get(Index(ci_tt)).SumarTrab();
                }                
            }
        }
    }
    public int Index(String ci)
    {
        for(int index = 0; index < ListaProf.size(); index++)
        {
            if(ListaProf.get(index).getCi().equalsIgnoreCase(ci)) 
                return index;
        }
        return -1;
    }
    public boolean existeProf(String ci_t1o2)
    {
        for(int index = 0; index < ListaProf.size() ; index++)
        {
            if(ListaProf.get(index).getCi().equalsIgnoreCase(ci_t1o2))
                return true;            
        }
        return false;
    }
    public void ordenar(){
     
        Profesor aux = new Profesor();
        if(ord)
            { 
            for(int i=ListaProf.size()-1; i>0 ;i--){      
                for(int j=0; j<i ;j++){
                    if(ListaProf.get(j).getApellido().compareTo(ListaProf.get(j+1).getApellido())==0){ 

                        if(ListaProf.get(j).getNombre().compareTo(ListaProf.get(j+1).getNombre())<0){ //pasa al nombre
                           aux = ListaProf.get(j);
                           ListaProf.set(j, ListaProf.get(j+1));
                           ListaProf.set(j+1, aux);
                        }
                    }
                    else if(ListaProf.get(j).getApellido().compareTo(ListaProf.get(j+1).getApellido()) < 0){
                           aux = ListaProf.get(j);
                           ListaProf.set(j, ListaProf.get(j+1));
                           ListaProf.set(j+1, aux);
                    }
                }
            }
        }
        else
        {
         
            for(int i=ListaProf.size()-1; i>0 ;i--){      
                for(int j=0; j<i ;j++){
                    if(ListaProf.get(j).getCantTrab() < ListaProf.get(j+1).getCantTrab()){ 
                           aux = ListaProf.get(j);
                           ListaProf.set(j, ListaProf.get(j+1));
                           ListaProf.set(j+1, aux);                        
                    }
                }
            }
        }
    }
}
