/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Trabajo{
    private String nivel;
    private String titulo;
    private String ci;
    private String Apellido1;
    private String Nombre1;
    private String ci_2;
    private String Apellido_2;
    private String Nombre_2;
    private String sem1erainsc;
    private String fechaDefensa;
    private String ci_t;
    private String Apellido_t1;
    private String Nombre_t1;
    private String ci_t2;
    private String Apellido_t2;
    private String Nombre_t2;
    
    
    //metodos
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor1() {
        return Apellido1 +" "+ Nombre1;
    }
    public String getAutor2() {
        return Apellido_2+" "+Nombre_2;
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public String getFechaDefensa() {
        return fechaDefensa;
    }
    public String getCi() {
        return ci;
    }
    public String getCi_2(){
        return ci_2;
    }
    public String getCi_t() {
        return ci_t;
    }
    public String getCi_t2(){
        return ci_t2;
    }
    //---------------------LLenarcampos---------------------------------
//------Asigna el valor de los atributos de la clase Trabajo
//------dado un String que sigue el siguiente formato
//------nivel#titulo#ci#[Apellido1#Nombre1#][ci_2#Apellido2#Nombre2#]
//------sem1erainsc#dd“/”mm“/”aa#ci_t[#Apellido_t1#Nombre_t1][#ci_t2][#Apellido_t2#Nombre_t2]“;”
    public int llenarCampos(String linea)
    {
       int ls_str=4, li_str=4;
       //asignar a campos OBLIGATORIOS 1
               nivel = linea.substring(0, 3);
                if(!nivel.equalsIgnoreCase("TEG") && !nivel.equalsIgnoreCase("TGM") && !nivel.equalsIgnoreCase("TDR")){
                    return -1;
                }
                                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                titulo = linea.substring(li_str, ls_str);
                
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
             
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                ci = linea.substring(li_str, ls_str);
                     
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                //campos opcionales:
                
                //campos opcionales:
                //[apellido y nombre 1]
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                Apellido1 = linea.substring(li_str, ls_str);
                
                 li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
               
                
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                Nombre1 = linea.substring(li_str, ls_str);
                
                li_str = ls_str;
                    ++ls_str; 
                    ++li_str;
                
                    
                if(nivel.equalsIgnoreCase("TEG")) {
                    //[ci_2, nombre2 y apellido2]
                    
                    if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                      while(linea.charAt(ls_str) != '#') {ls_str++;}
                         ci_2 = linea.substring(li_str, ls_str);
                    } else {
                          ci_2 = " ";
                    }
                    
                    
                    
                    li_str = ls_str;
                    ++ls_str; 
                    ++li_str;
                
                    if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != '#') {ls_str++;}
                        Apellido_2 = linea.substring(li_str, ls_str);
                   } else {
                         Apellido_2 = " ";
                     }
                     li_str = ls_str;
                    ++ls_str; 
                    ++li_str;
                    
                    
                    if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != '#') {ls_str++;}
                        Nombre_2 = linea.substring(li_str, ls_str);
                    } else {
                         Nombre_2 =" ";
                    }
                    li_str = ls_str;
                ++ls_str; 
                ++li_str;
                } else {
                    Apellido_2 = Nombre_2 = " ";
                    ci_2 = " ";
                }
                //sem1erains
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                sem1erainsc = linea.substring(li_str, ls_str);
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                //fechaDefensa 
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                fechaDefensa = linea.substring(li_str, ls_str);
                li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                //ci t
                while(linea.charAt(ls_str) != '#') {ls_str++;}
                ci_t = linea.substring(li_str, ls_str);
                 
                //NUEVO:
                li_str = ls_str;
                    --ls_str; 
                    --li_str;
                
                    if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != '#') {ls_str++;}
                       Apellido_t1 = linea.substring(li_str, ls_str);
                   } else {
                         Apellido_t1 = " ";
                     }
                    System.out.println("Listo at1"+Apellido_t1);
                     li_str = ls_str;
                    ++ls_str; 
                    ++li_str;
                    
                    
                    if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != '#') {ls_str++;}
                        Nombre_t1 = linea.substring(li_str, ls_str);
                    } else {
                        Nombre_t1 =" ";
                    }
                    System.out.println("Listo nt1"+Nombre_t1);
                    li_str = ls_str;
                ++ls_str; 
                ++li_str;
                    
                if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != '#') {ls_str++;}
                        ci_t2 = linea.substring(li_str, ls_str);
                    } else {
                         ci_t2 =" ";
                    }
                System.out.println("Listo ci_t2"+ci_t2);
                    li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != '#') {ls_str++;}
                        Apellido_t2 = linea.substring(li_str, ls_str);
                    } else {
                         Apellido_t2 =" ";
                    }
                System.out.println("Listo at2"+Apellido_t2);
                    li_str = ls_str;
                ++ls_str; 
                ++li_str;
                
                if(linea.charAt(li_str) != linea.charAt(li_str+1)) {
                         while(linea.charAt(ls_str) != ';') {ls_str++;}
                        Nombre_t2 = linea.substring(li_str, ls_str);
                    } else {
                         Nombre_t2 =" ";
                    }
                    System.out.println("Listo nt1"+Nombre_t2);
                
                //esto es pa verificar que se este haciendo lo correcto
                System.out.println("ci:"+ci);    
                 System.out.println("apellido1: "+Apellido1);
                System.out.println("nombre1: "+Nombre1);
                System.out.println("ci_2:"+ci_2);             
                 System.out.println("apellido2: "+Apellido_2);       
                System.out.println("nombre2: "+Nombre_2);
                System.out.println("sem1erainsc:"+sem1erainsc);
                System.out.println("fechaDefensa:"+fechaDefensa);
                System.out.println("ci_t: "+ci_t);
                
             
             return 1;
   }  
} 
