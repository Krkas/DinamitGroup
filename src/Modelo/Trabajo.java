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
public class Trabajo{
    private String nivel;
    private String titulo;
    private int ci;
    private String Apellido1;
    private String Nombre1;
    private int ci_2;
    private String Apellido_2;
    private String Nombre_2;
    private String sem1erainsc;
    private String fechaDefensa;
    private int ci_t;
    private String Apellido_t1;
    private String Nombre_t1;
    private int ci_t2;
    private String Apellido_t2;
    private String Nombre_t2;
    
    
    //metodos
    public String getTitulo() {
        return titulo;
    }
    public String getFechaDefensa() {
        return fechaDefensa;
    }
    public int getCi_t() {
        return ci_t;
    }
    public int getCi_t2(){
        return ci_t2;
    }
//---------------------LLenarcampos---------------------------------
//------Asigna el valor de los atributos de la clase Trabajo
//------dado un String que sigue el siguiente formato
//------nivel#titulo#ci#[Apellido1#Nombre1#][ci_2#Apellido2#Nombre2#]
//------sem1erainsc#dd“/”mm“/”aa#ci_t[#Apellido_t1#Nombre_t1][#ci_t2][#Apellido_t2#Nombre_t2]“;”
    public void llenarCampos(String lineas)
    {
        int ls_substr = 0;
        int li_substr = 0;
        while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
            ls_substr++;
        nivel = lineas.substring(li_substr, ls_substr);
        ls_substr++;
        li_substr = ls_substr;
        while(lineas.charAt(ls_substr) != '#') 
            ls_substr++;
        titulo = lineas.substring(li_substr, ls_substr);
        ls_substr++;
        li_substr = ls_substr;
        while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
            ls_substr++;
        ci = lineas.substring(li_substr, ls_substr);
        ls_substr++;
        li_substr = ls_substr;
        if(lineas.charAt(ls_substr) == '#')
        {
            ls_substr += 2;
            li_substr = ls_substr;
        }
        else
        {
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Apellido1 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Nombre1 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        }
        if(lineas.charAt(ls_substr) == '#')
        {
            ls_substr += 3;
            li_substr = ls_substr;
        }
        else
        {
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            ci_2 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Apellido2 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Nombre2 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        }
        while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            sem1erainsc = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            fechaDefensa = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            ci_t = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        if(lineas.charAt(ls_substr) == '#')
        {
            ls_substr += 2;
            li_substr = ls_substr;
        }
        else
        {
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Apellido_t1 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Nombre_t1 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        }
        if(lineas.charAt(ls_substr) == '#')
        {
            ls_substr++;
            li_substr = ls_substr;
        }
        else
        {
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            ci_t2 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
        }
        if(lineas.charAt(ls_substr) == '#')
        {
            ls_substr += 2;
            li_substr = ls_substr;
        }
        else
        {
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Apellido_t2 = lineas.substring(li_substr, ls_substr);
            ls_substr++;
            li_substr = ls_substr;
            while(lineas.charAt(ls_substr) != '#' && lineas.charAt(ls_substr) != ';') 
                ls_substr++;
            Nombre_t2 = lineas.substring(li_substr, ls_substr);
         }
    }
}
