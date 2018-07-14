/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author krlos
 */
public class Profesor {
    private String ci;
    private String Apellido;
    private String Nombre; 
    private String centro;
    private int cant_trab;
    public Profesor() //constructor
    {
        centro = "";
        Nombre = "";
        Apellido = "";
        ci = "";
        cant_trab=0;
    }
    public String getCentro(){
        return centro;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public String getCi(){
        return ci;
    }
    public int getCantTrab()
     {
         return cant_trab;
     }
    public void SumarTrab()
    {
        cant_trab ++;
    }
    public void setNombre(String Name)
    {
        Nombre = Name;
    }
    public void setApellido(String Second_Name)
    {
        Apellido = Second_Name;
    }
    public void setCentro(String Centro)
    {
        centro = Centro;
    }
    public void setci(String Ci)
    {
        ci = Ci;
    }
    public void setCant_Trab(int Cant_Jobs)
    {
        cant_trab = Cant_Jobs;
    }
    
    public void llenarCampos(String linea) {
        int li_str=0, ls_str=1;
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                this.ci = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                this.Apellido = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                this.Nombre = linea.substring(li_str, ls_str);
                li_str = ls_str +=1;
                
                while(linea.charAt(ls_str) != ';') {ls_str++;}
                this.centro = linea.substring(li_str, ls_str);
                //System.out.println("\nci:"+ci+"\nNombre:"+Nombre+"\nApellido:"+Apellido+"\ncentro:"+centro);
    }
}
