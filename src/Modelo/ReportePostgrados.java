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
        
/*    Codigo de Christian
   //METODOS DE CONSULTAR
    public boolean Es_Valido(Date Fecha) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date Fecha_Minima = sdf.parse("01/01/2014"); //Fecha Tope
        Date Fecha_Actual = new Date(); //Fecha Actual
        
        if( Fecha.after(Fecha_Minima) && Fecha.before(Fecha_Actual) ) //Si esta en el rango
            return true;
        
        else if( Fecha.equals(Fecha_Minima) )
            return true;
        
        else if( Fecha.equals(Fecha_Actual) )
            return true;
        
        return false;
        
    }
    
    public void i_Consultar_Prof(Date fech_li,Date fech_ls,int ord) throws ParseException{
       /* 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date Fecha_Minima = sdf.parse("01/01/2014"); //Fecha Tope
        Date Fecha_Actual = new Date(); //Fecha Actual
        
        Date Fecha_Inicial = null;
        Date Fecha_Final = null;
        
        if( fech_li == null)
            fech_li = Fecha_Minima;
        
        if( fech_ls == null)
            fech_ls = Fecha_Actual;
        
        if( !Es_Valido(fech_li) ){
            
            if( fech_li.before(Fecha_Minima) )
                Fecha_Inicial = Fecha_Minima;
            
            else if( fech_li.after(Fecha_Actual) )
                Fecha_Inicial = Fecha_Actual;
        }
        else
            Fecha_Inicial = fech_li;
        
        if( !Es_Valido(fech_ls) ){
            
            if( fech_ls.before(Fecha_Minima) )
                Fecha_Final = Fecha_Minima;
            
            else if( fech_ls.after(Fecha_Actual))
                Fecha_Final = Fecha_Actual;
        }
        
        else
            Fecha_Final = fech_ls;
        
        if( !Fecha_Inicial.before(Fecha_Final) || !Fecha_Inicial.equals(Fecha_Final) ){
            return;
        } // Saida no exitosa
        
        //Buscar Profesores
        */
    /*
        ConjuntoTrabajos A = new ConjuntoTrabajos();
        System.out.println ("Hola");
        ArrayList <Trabajo> Profesores = A.getListado();

        int Tamano = A.getTotal();

        Iterator aux = Profesores.iterator();
        
        Trabajo Existentes;
        
        for(int i = 0; i < Tamano; i++){
            Existentes = (Trabajo) aux.next();
            System.out.println(Existentes.getTitulo());
        }
        
    }


 */
}
