package Controlador;
import Modelo.ConjuntoProfesores;
import Modelo.ConjuntoTrabajos;
import Modelo.Profesor;
import Modelo.Trabajo;
import java.io.*;
import Vista.*;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JFrame;

import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class Ctrl_Reportes {
    
    private static final Ctrl_Reportes INSTANCE = new Ctrl_Reportes(); //Clase Singleton
    
    public static Ctrl_Reportes getInstance() {
        return INSTANCE;
    }
    
    private ConjuntoProfesores cp; //Por ahora, esto se pone aqui para hacer las pruebas, luego se decide donde se guardan estas instancias
    private ConjuntoTrabajos ct;
    
    //atributos de interfaces graficas
    private final IMenu IMen;  //Instancia de Imenu
    private final ISelectUser ISelectUs; //Instancia de seleccion de usuario
    private ICargarProfesores ICargarProf; // Instancia de Cargar Profesores
    private final ICargarTrabajos ICargarTrab; //Instancia de Cargar trabajos
    private IConsultarTrabajos IConsultarTrab; //Instancia de Iconsultar
    private I_Profesores_Postgrado IReportarPost;  //Instacia de Reportar Postrgrado
    private I_Reportar_Profesores IReportarProf; //Instancia de IReportarProf
    private JFrame ventanaAnterior; //Te permite retroceder la ventana
    
    public void ocultarTodo() {
        IMen.setVisible(false);
        ISelectUs.setVisible(false);
        
        ICargarProf.setVisible(false);
        IConsultarTrab.setVisible(false);
    }
    
    //MENU e ISelectUser
    public void i_Menu() {
        ocultarTodo();
        IMen.setVisible(true);
    }
    
    public void ventanaAnterior(int tipoUser) { //1 es comision
        if(tipoUser == 1) {
            ventanaAnterior = IMen;
        } else if(tipoUser == 0 ) {
            ventanaAnterior = ISelectUs;
        }
    }
    
    public ConjuntoTrabajos get_Instance_ConjuntoTrabajos (){
        return ct;
    }
    
    public ConjuntoProfesores get_Instance_ConjuntoProfesores (){
        return cp;
    }
    
    public void volver() {
        ocultarTodo();
        ventanaAnterior.setVisible(true);   
    }
    
    public void i_SelectUser() {
        ocultarTodo();
        ISelectUs.setVisible(true);
    }
    
    public boolean Hay_Conjuntos (){ //Identifica si ya fueron cargados los trabajos y los profesores
        if(ct == null || cp == null) {
            return false;
        } 
        return (ct.getListado() != null) && (cp.getListado() != null);
    }
        
    
    
    //METODOS DE LA CLASE CONTROLADORA
    public int i_copiar_archivo_prof(String dir) {
        String linea;
        cp = new ConjuntoProfesores();  //Prueba de carga de profesores en esta estructura
        Profesor P;
        
       try {
            FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr);
                   
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                P = new Profesor();
                P.llenarCampos(linea);
                cp.agregar(P);              
            }    
        } catch(Exception e) {
            return 0;
        } finally {} 
        return cp.getTotal();
    }
    
     public int i_copiar_archivo_trab(String dir) {
        String linea;
        ct = new ConjuntoTrabajos();        
        try {
            FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                Trabajo T = new Trabajo();
                if (T.llenarCampos(linea) == -1) {
                  throw new IOException();  
                }
                ct.agregar(T);
            }
            
        } catch(IOException e) {
             return 0;
        } finally {} 
        return ct.getTotal();
}
    
        private Ctrl_Reportes() {                                       //Constructor
        ICargarProf = new ICargarProfesores(this);
        ICargarTrab = new ICargarTrabajos(this);
        IReportarPost = null;
        IMen = new IMenu(this);
        ISelectUs = new ISelectUser(this);
        IConsultarTrab = new IConsultarTrabajos(this);
        activarOpcionesReportesDeMenu(false);
    } 
        
    //METODOS DE INTERFACES
    public void i_CargarProfesores() {
        if(ICargarProf == null) {
            ICargarProf = new ICargarProfesores(this);
        }   
        ICargarProf.setVisible(true);
    }
    
    public void i_CargarTrabajos() {
        ICargarTrab.setVisible(true);
    }
    
    public void i_ReportePostgrados() {
        if(IReportarPost == null) {
            IReportarPost = new I_Profesores_Postgrado(this);
        }
        IReportarPost.setVisible(true);
    }
    
    //uc6
    public void i_ConsultarTrabajos() {
        if(IConsultarTrab == null) {
            IConsultarTrab = new IConsultarTrabajos(this);
        }
        
        //preparar lista de opciones (comboProfesores) para el cliente
        DefaultListModel modelo = new DefaultListModel();
         
        Iterator<Profesor> I = cp.getListado().iterator();
        Profesor p;
         p = I.next();
        while(I.hasNext()) {
          
            modelo.addElement(p.getNombre()+" "+p.getApellido()+" /"+p.getCi()+".");
              p = I.next();
        }
        
        
        IConsultarTrab.iniciarOpciones(modelo);
        IConsultarTrab.setVisible(true);
    }
    
    public void activarOpcionesReportesDeMenu(boolean f){ // Activa/Desactiva botones de Imenu
        
        IMen.activarPostgrados(f);
        IMen.activarRepProfesor(f);
        IMen.activarConsultar(f); 
        IMen.activarCentro(f);
        
    }
    
    //METODOS DE REPORTES
    public void i_Consultar_Prof() throws ParseException{
    
        Date Inicial = new Date();
        return;
        
    }
    
    /*
    
        //Reportar Trabajos Profesores
    public void i_Consultar_Prof(Date fech_li, Date fech_ls, int ord) {
        for (int i=0;i< Size(ConjuntoTrabajos); i++){
            if(ConjuntoTrabajos.listado[i].getFechaDefensa() <= fech_ls ^ ConjuntoTrabajos.listado[i].getFechaDefensa() >= fecha_li){ 
                if(ExisteProf(ConjuntoTrabajos.listado[i].getCi_t1)){
                    ReporteProfesores.Lista.ci_t1.cant_trab++;
                }
                if(ExisteProf(ConjuntoTrabajos.listado[i].getCi_t2)){
                    ReporteProfesores.Lista.ci_t2.cant_trab++;
                }
            }
        }
 ReporteProfesores.Ordenar(ord)
 desplegar(ReporteProfesores);
    }
    
        //Reportar Trabajos Centros
    public void i_Consultar_Cent(String centro, Date fech_li, Date fech_ls) {
           
        for(int i=0;i<Size(ConjuntoTrabajos);i++){
        if(Trabajo.getfechaDefensa() <= fech_ls ^ Trabajo.getFechaDefensa() >= fech_li)
            if(PerteneceMismoCentro(centro, ConjuntoTrabajos.listado[i].getCi_t1,ConjuntoTrabajos.listado[i].getCi_t2)){ 
                ReporteCentros.lista.Centro.add();
            }else{
                ReporteCentros.lista.Centro1.add();
                ReporteCentros.lista.Centro2.add()
            }
                    
        }
        desplegar(ReporteCentros)
    }
    
    public boolean PerteneceMismoCentro(String centro,int c1, int c2){
        for(int i=0; i<co.getSize(); i++){
            if (cp[i].getCi()== c1 || cp[i].getCi()== c2){
                if(cp[i].getCentro()==centro)
                    return true;
            }
        }
        return false;
     }
    }
    
        //
    
       //Conusltar Postgrados
    */
     public void i_Consultar_Post(String fecha_li, String fecha_ls) {
         
         
     }
    
        //Consultar Trabajos profesores
    public void i_Consultar_Trab(String ci_prof) {
      
        Trabajo t;
        Iterator<Trabajo> Ind = ct.getListado().iterator();
        t = Ind.next();
        while(Ind.hasNext()) {      
            System.out.println(ci_prof+" es igual a"+t.getCi_t()+" o"+t.getCi_t2()+"?");
            if(ci_prof.equals(t.getCi_t()) || ci_prof.equals(t.getCi_t2()) ||ci_prof.equals(t.getCi())) {
                  IConsultarTrab.agregarFila(t.getTitulo(), t.getNivel(), t.getAutor1()+" - " +t.getAutor2(), t.getFechaDefensa());
            }
            t = Ind.next();
        }
      
       
    }
      
}
