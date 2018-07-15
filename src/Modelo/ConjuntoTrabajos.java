/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author Ugueto
 */
public class ConjuntoTrabajos{
    private ArrayList<Trabajo> listado;
     
    public ConjuntoTrabajos() {
        listado = new ArrayList<>();
    }
    
    public void agregar(Trabajo T){
        listado.add(T);
    }
    
    public ArrayList<Trabajo> getListado(){
        return listado;
    }
    public int getTotal() {
        return listado.size();
    }
}
